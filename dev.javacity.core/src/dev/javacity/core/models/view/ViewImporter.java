/***************************************************************************
 * This file is part of Synchrovis - A prototypical implementation of the
 * visualization approach described in the author's master's thesis titled
 *
 * 							 Visualisierung von
 * 					Synchronisationspunkten in Kombination
 * 						  mit der Statik und Dynamik
 *							 eines Softwaresystems
 *
 * written at Software Engineering Group, Department of Computer Science at
 * Christian-Albrechts-University of Kiel.
 *
 * Author: Philipp D�hring, October 2012
 ***************************************************************************/

/************************
 * 8月12日　佐々木改定
 * dynamicsLoad関連の削除
 */


package dev.javacity.core.models.view;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import data.VisualizableElement;
import dev.javacity.core.configuration.VisualProperties;
import dev.javacity.core.models.metaphor.MetaphorUtils;
import dev.javacity.core.observer.AbstractObservable;
import dev.javacity.core.observer.IObserver;
import dev.javacity.core.observer.ObservableAction;
import dev.javacity.core.visual.metaphor.BendableArrow;
import dev.javacity.core.visual.metaphor.BorderedBox;
import dev.javacity.core.visual.metaphor.DashedArrow;
import dev.javacity.core.visual.metaphor.PosterBorderedBox;
import dev.javacity.core.visual.metaphor.utils.TransformUtils;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import metaphor.entities.Cable;
import metaphor.entities.Floor;
import metaphor.entities.RegularBase;
import metaphor.entities.RegularBuilding;
import metaphor.entities.RegularDistrict;
import metaphor.entities.RegularFloor;
import metaphor.entities.Status;
import metaphor.entities.Street;
import metaphor.types.VisualEntity;


/**
 * A view importer to convert given metaphor model objects into Java3D objects and import them into a {@link ViewModel} instance.
 *
 * @author pdo
 *
 */
public class ViewImporter implements IObserver {

	// ============================= Attributes ===============================

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(ViewImporter.class);

	/** The diameter of all street and cable representing arrows in the final visualization. */
	private float lineDiameter = VisualProperties.getInstance().getLineDiameter();

	/** The horizontal and vertical size difference between two consecutive districts. */
	private float districtBorder = VisualProperties.getInstance().getDistrictBorder();

	/** The minimal horizontal distance from a street's bendpoint to a floor's wall. */
	private float streetOffset = Math.max(Math.min(VisualProperties.getInstance().getLineArrowheadDiameter(), VisualProperties.getInstance()
			.getBuildingInterspace()), VisualProperties.getInstance().getBuildingInterspace()) / 2 - 0.01f;

	/** The horizontal distance between two streets having the same source and target floor. */
	private float parallelStreetOffset = VisualProperties.getInstance().getLineArrowheadDiameter() + 0.01f;

	/** The minimal vertical distance from a cable's bendpoint to a floor's roof. */
	private float cableOffset = Math.max(0.1f, VisualProperties.getInstance().getLineArrowheadHeight() * 1.5f);

	/** The {@link ViewModel} instance to add all imported objects to. */
	private final ViewModel viewModel;

	/** A list of all {@link Cable} instances currently visible in the visualization, i.e. as well imported by this view importer. */
	private List<Cable> cables = new LinkedList<Cable>();

	// ========================== Constructor =================================

	/**
	 * Creates a new {@link ViewImporter} instance importing converting received metaphor model instances into Java3D objects and adding them to the given scene
	 * model.
	 *
	 * @param viewModel
	 *            The view model to import all Java3d objects into.
	 * @throws IllegalArgumentException
	 *             If the view model passed in is {@code null}.
	 */
	public ViewImporter(final ViewModel viewModel) throws IllegalArgumentException {

		if (viewModel == null) {
			throw new IllegalArgumentException("You cannot pass in a null scene model.");
		}

		this.viewModel = viewModel;
	}

	// ============================ Methods ===================================

	@Override
	public void update(final AbstractObservable observable, final ObservableAction action, final Object object) {

		switch (action) {
		case ALL_CLEARED:
			this.onAllCleared();
			break;
		case CABLE_ADDED:
			this.onCableAdded((Cable) object);
			break;
		case FLOOR_ADDED:
			this.onFloorAdded((RegularFloor) object);
			break;
		case STREET_ADDED:
			this.onStreetAdded((Street) object);
			break;
		case STATICS_LOADED:
			this.onStaticsLoaded((RegularBase) object);
			break;
		case CABLE_REMOVED:
		case FLOOR_REMOVED:
		case STREET_REMOVED:
			this.onEntityRemoved((VisualEntity) object);
			break;
		default:
			LOGGER.warn("ObservableAction '" + action + "' not supported.");
		}
	}

	/**
	 * Updates all visual settings attributes of this instance.
	 */
	private void updateAttributes() {

		this.lineDiameter = VisualProperties.getInstance().getLineDiameter();
//		this.radiusAdditive = VisualProperties.getInstance().getBuildingInterspace() / 3;
		this.districtBorder = VisualProperties.getInstance().getDistrictBorder();
		this.streetOffset = Math.max(Math.min(VisualProperties.getInstance().getLineArrowheadDiameter(), VisualProperties.getInstance()
				.getBuildingInterspace()), VisualProperties.getInstance().getBuildingInterspace()) / 2 - 0.01f;
		this.parallelStreetOffset = VisualProperties.getInstance().getLineArrowheadDiameter() + 0.01f;
		this.cableOffset = Math.max(0.1f, VisualProperties.getInstance().getLineArrowheadHeight() * 1.5f);

//		AppearanceUtils.reloadAttributes();
		PosterBorderedBox.reloadAttributes();
	}

	/**
	 * The action to be performed when a change notification with {@link ObservableAction#CABLE_REMOVED}, {@link ObservableAction#FLOOR_REMOVED} or
	 * {@link ObservableAction#STREET_REMOVED} has been received. This method removes the Java 3D object related to the specified entity from the view model.
	 *
	 * @param entity
	 *            The entity to remove its Java 3D object from the view model.
	 */
	private void onEntityRemoved(final VisualEntity entity) {

		if (entity instanceof Cable) {
			this.cables.remove((Cable) entity);
		}

		this.viewModel.removeNode(entity.getJava3dObject());
	}

	/**
	 * The action to be performed when the static data has been loaded into the metaphor model. It creates a new {@link BorderedBox} for each district and base
	 * instance in the given regular base and adds it to the view model.
	 *
	 * @param base
	 *            The regular base to be imported.
	 */
	private void onStaticsLoaded(final RegularBase base) {

		// import regular base
		final BorderedBox box = new BorderedBox(base.getLength(), base.getHeight(), base.getWidth());
		box.setColor(base.getColor());
		this.map(base, box);

		// add to model
//		final TransformGroup group = TransformUtils.createTransformGroup(base.getPosition());
//		group.addChild(box);
//		this.viewModel.addNode(group);

		box.getTransforms().addAll(TransformUtils.createTransformGroup(base.getPosition()));
		this.viewModel.addNode(box);

		// import districts
		for (RegularDistrict district : base.getDistricts()) {
			this.importRegularDistrict(district);
		}
	}

	/**
	 * Part of the action to be performed when the static data has been loaded into the metaphor model. It creates a new {@link BorderedBox} for the district passed
	 * in and adds it to the view model.
	 *
	 * @param district
	 *            The regular district to be imported.
	 */
	private void importRegularDistrict(final RegularDistrict district) {

		// import district
		final BorderedBox box = new BorderedBox(district.getLength(), district.getHeight(), district.getWidth());
		box.setColor(district.getColor());
		this.map(district, box);

//		final TransformGroup group = TransformUtils.createTransformGroup(district.getPosition());
//		group.addChild(box);

		box.getTransforms().addAll(TransformUtils.createTransformGroup(district.getPosition()));
		this.viewModel.addNode(box);


//		// add label
//		final TransformGroup board = TextUtils.createDistrictText(((SPackage) district.getDataObject()).getName(), new Point3f(0, 0, 0));
//		final BranchGroup branch = new BranchGroup();
//		branch.addChild(board);
//
//		// arrange label
//		final Point3d bounds = TextUtils.computeDimensions((Text3D) ((Shape3D) board.getChild(0)).getGeometry());
//		final Transform3D trans = new Transform3D();
//		trans.setScale(Math.min(1, (district.getWidth() - this.districtBorder) / (bounds.x * 0.045d))); // scale to make it fit on district width
//		trans.setScale(Math.min(trans.getScale(), this.districtBorder * 0.7f / (bounds.y * 0.045d))); // scale to make it fit on district length
//
//		trans.setTranslation(new Vector3f((float) (district.getLength() / 2 - (this.districtBorder + bounds.y) * 0.0225d), (float) (district.getHeight() / 2 - 0.008
//				* trans.getScale()), (float) district.getWidth() / 2 - this.districtBorder / 2));
//
//		final TransformGroup childGroup = new TransformGroup();
//		childGroup.setTransform(trans);
//		childGroup.addChild(branch);
//
//		group.addChild(childGroup);
//		this.viewModel.addNode(group);

		// import sub-districts
		for (RegularDistrict child : district.getChildDistricts()) {
			this.importRegularDistrict(child);
		}

		// import static class instances
		for (RegularBuilding building : district.getBuildungs()) {
			for (RegularFloor floor : building.getFloors()) {
				this.onFloorAdded(floor);
			}
		}
	}

	/**
	 * The action to be performed when a change notification with {@link ObservableAction#STREET_ADDED} has been received. This method creates a new
	 * {@link BendableArrow} or {@link DashedArrow} object (depending on the given street's characteristics) representing the specified street, sets it as the given
	 * objects associated Java 3D object (if not already existing) and adds it to the view model (i.e. makes it visible on screen).
	 *
	 * @param street
	 *            The street to import into the view model.
	 */
	private void onStreetAdded(final Street street) {

		final Floor source = street.getSource();
		final Floor target = street.getTarget();

		final Group node;
		if (source == target) {
			// street goes between the same floor
			node = this.addSelfStreet(street);
		} else if (source.getClass().equals(target.getClass())) {
			if (source instanceof RegularFloor && ((RegularFloor) source).getBuilding() == ((RegularFloor) target).getBuilding()) {
				// street goes between same building
				node = this.addVerticalStreet(street);
			} else {
				// street goes between different buildings
				if (this.numParallelStreets(street) == 0) {
					node = this.addHorizontalStreet(street);
				} else {
					node = this.addParallelHorizontalStreet(street);
				}
			}
		} else {
			// street goes between different buildings
			if (this.numParallelStreets(street) == 0) {
				node = this.addHorizontalStreet(street);
			} else {
				node = this.addParallelHorizontalStreet(street);
			}
		}
		this.viewModel.addNode(node);
	}

	/**
	 * Creates and adds a new {@link BendableArrow} to the view model (i.e. to the visualization) representing the {@link Street} instance passed in having the same
	 * {@link RegularFloor} as source and target floor.
	 *
	 * @param street
	 *            The street to be imported into the view model.
	 * @return The node to be added to the view model.
	 */
	private Group addSelfStreet(final Street street) {

		// create new bendable arrow: compute bendpoints
		final float buildingLength;
		final float buildingWidth;

		final RegularBuilding buildung = ((RegularFloor) street.getSource()).getBuilding();
		buildingLength = buildung.getLength();
		buildingWidth = buildung.getWidth();


		final Point3D temp = new Point3D(street.getSource().getPosition().getX(),street.getSource().getPosition().getY(),street.getSource().getPosition().getZ());
		final int parallel = this.numParallelStreets(street);

		double tempX=temp.getX();;
		double tempY=temp.getY();
		double tempZ=temp.getZ();

		tempX += (buildingLength / 2) + this.streetOffset;
		tempY -= parallel * this.parallelStreetOffset;
		tempZ += (buildingWidth / 2) + this.streetOffset;
		final Point3D bend1 = new Point3D(tempX,tempY,tempZ);

		tempX += this.streetOffset;
		tempZ -= this.streetOffset;
		final Point3D bend2 = new Point3D(tempX,tempY,tempZ);

		tempZ -= buildingWidth;
		final Point3D bend3 = new Point3D(tempX,tempY,tempZ);

		tempX -= this.streetOffset;
		tempZ -= this.streetOffset;
		final Point3D bend4 = new Point3D(tempX,tempY,tempZ);

		// create new arrow instance
		final BendableArrow arrow = new BendableArrow(street.getSource().getPosition(), street.getTarget().getPosition(), this.lineDiameter, bend1, bend2, bend3,
				bend4);
		arrow.setColor(street.getColor());
		this.map(street, arrow);

		return arrow;
	}

	/**
	 * Creates and adds a new {@link BendableArrow} to the view model (i.e. to the visualization) representing the {@link Street} instance passed in having the same
	 * {@link RegularBuilding} as source and target building, but not the same floor.
	 *
	 * @param street
	 *            The street to be imported into the view model.
	 * @return The node to be added to the view model.
	 */
	private Group addVerticalStreet(final Street street) {

		// create new bendable arrow: compute bendpoints
		final float buildingLength;
		buildingLength = ((RegularFloor) street.getSource()).getBuilding().getLength();

		final Point3D temp = new Point3D(street.getSource().getPosition().getX(),street.getSource().getPosition().getY(),street.getSource().getPosition().getZ());
		final int parallel = this.numParallelStreets(street);

		double tempX=temp.getX();;
		double tempY=temp.getY();
		double tempZ=temp.getZ();

		tempX += (buildingLength / 2) + this.streetOffset;
		tempY -= parallel * this.parallelStreetOffset;
		final Point3D bend1 = new Point3D(tempX,tempY,tempZ);

		tempX = street.getTarget().getPosition().getX();
		tempY = street.getTarget().getPosition().getY();
		tempZ = street.getTarget().getPosition().getZ();
		tempX += (buildingLength / 2) + this.streetOffset;
		final Point3D bend2 = new Point3D(tempX,tempY,tempZ);

		// create new arrow instance
		final BendableArrow arrow = new BendableArrow(street.getSource().getPosition(), street.getTarget().getPosition(), this.lineDiameter, bend1, bend2);
		arrow.setColor(street.getColor());
		this.map(street, arrow);

		return arrow;
	}

	/**
	 * Creates and adds a new {@link BendableArrow} to the view model (i.e. to the visualization) representing the {@link Street} instance passed in having a
	 * different {@link RegularBuilding} (or {@link AdministrationBuilding}) as source and target building.
	 *
	 * @param street
	 *            The street to be imported into the view model.
	 * @return The node to be added to the view model.
	 */
	private Group addHorizontalStreet(final Street street) {

		final Group arrow;
		// create new arrow
		if (street.getStatus() == Status.OPENED) {
			arrow = new BendableArrow(street.getSource().getPosition(), street.getTarget().getPosition(), this.lineDiameter);
			((BendableArrow) arrow).setColor(street.getColor());
		} else if (street.getStatus() == Status.CLOSED) {
			arrow = new DashedArrow(street.getSource().getPosition(), street.getTarget().getPosition(), this.lineDiameter);
			((DashedArrow) arrow).setColor(street.getColor());
		} else {
			final String error = "The given street has an unsupported status: " + street.getStatus().getName();
			LOGGER.error(error);
			throw new IllegalStateException(error);
		}

		this.map(street, arrow);
		return arrow;
	}

	/**
	 * Creates and adds a new {@link BendableArrow} to the view model (i.e. to the visualization) representing the {@link Street} instance passed in having a
	 * different {@link RegularBuilding} (or {@link AdministrationBuilding}) as source and target building and has the same source and target floor as another street
	 * currently visualized.
	 *
	 * @param street
	 *            The street to be imported into the view model.
	 * @return The node to be added to the view model.
	 */
	private Group addParallelHorizontalStreet(final Street street) {

		final Group arrow;
		final int parallel = this.numParallelStreets(street);

		// compute bendpoints
		final Point3D connector = new Point3D(street.getTarget().getPosition().getX(),street.getTarget().getPosition().getY(),street.getTarget().getPosition().getZ());


		connector.subtract(street.getSource().getPosition());
		connector.multiply(0.2f);

		final Point3D bend1 = new Point3D(street.getSource().getPosition().getX(),street.getSource().getPosition().getY()-parallel * this.parallelStreetOffset,street.getSource().getPosition().getZ());
		bend1.add(connector);

		final Point3D bend2 = new Point3D(street.getTarget().getPosition().getX(),street.getTarget().getPosition().getY()-parallel * this.parallelStreetOffset,street.getTarget().getPosition().getZ());
		bend2.subtract(connector);

		// create new arrow
		if (street.getStatus() == Status.OPENED) {
			arrow = new BendableArrow(street.getSource().getPosition(), street.getTarget().getPosition(), this.lineDiameter, bend1, bend2);
			((BendableArrow) arrow).setColor(street.getColor());
		} else if (street.getStatus() == Status.CLOSED) {
			arrow = new DashedArrow(street.getSource().getPosition(), street.getTarget().getPosition(), this.lineDiameter, bend1, bend2);
			((DashedArrow) arrow).setColor(street.getColor());
		} else {
			final String error = "The given street has an unsupported status: " + street.getStatus().getName();
			LOGGER.error(error);
			throw new IllegalStateException(error);
		}

		this.map(street, arrow);
		return arrow;
	}

	/**
	 * Computes and returns the number of parallel streets relative to the specified {@link Street} instance, which is defined as the number of streets having the
	 * same source and target {@link Floor} (or crosswise reverse) currently being visible on screen. Those might overlap if they are not handled correctly by
	 * slightly shifting them apart.
	 *
	 * @param street
	 *            The street to compute the number of its parallel streets.
	 * @return The number of parallel streets relative to the given instance.
	 */
	private int numParallelStreets(final Street street) {

		int retval = -1; // since given street is already part of the streets list
		for (Street str : street.getSource().getStreets()) {
			if (str.getTarget().equals(street.getTarget())) {
				retval++;
			}
		}

		if (street.getSource() != street.getTarget()) {
			for (Street str : street.getTarget().getStreets()) {
				if (str.getTarget().equals(street.getSource())) {
					retval++;
				}
			}
		}

		return retval;
	}

	/**
	 * The action to be performed when a change notification with {@link ObservableAction#FLOOR_ADDED} has been received. This method creates a new
	 * {@link BorderedBox} object representing the specified regular floor, sets it as the given objects associated Java 3D object (if not already existing) and adds
	 * it to the view model (i.e. makes it visible on screen).
	 *
	 * @param floor
	 *            The regular floor to import into the view model.
	 */
	private void onFloorAdded(final RegularFloor floor) {

		// create new bordered Box
		final RegularBuilding building = floor.getBuilding();
		final BorderedBox box = new BorderedBox(building.getLength(), floor.getHeight(), building.getWidth());
		box.setColor(floor.getColor());
		this.map(floor, box);

		// add to model
		box.getTransforms().addAll(TransformUtils.createTransformGroup(floor.getPosition()));
		this.viewModel.addNode(box);

	}


	/**
	 * The action to be performed when a change notification with {@link ObservableAction#CABLE_ADDED} has been received. This method creates a new
	 * {@link BendableArrow} object representing the specified cable, sets it as the given object's associated Java 3D object (if not already existing) and adds it
	 * to the view model (i.e. makes it visible on screen).
	 *
	 * @param cable
	 *            The cable to import into the view model.
	 */
	private void onCableAdded(final Cable cable) {

		// create new bendable arrow: compute bendpoints
		final double sourceHeight = cable.getSource().getPosition().getY() + MetaphorUtils.computeHeigth(cable.getSource());
		final double targetHeight = cable.getTarget().getPosition().getY() + MetaphorUtils.computeHeigth(cable.getTarget());
		final double height = Math.max(sourceHeight, targetHeight);

		double bend1tempX = cable.getSource().getPosition().getX();
		double bend1tempY = height - this.computeCableOffset(cable);
		double bend1tempZ = cable.getSource().getPosition().getZ();

		final Point3D bend1 = new Point3D(bend1tempX, bend1tempY, bend1tempZ);

		double bend2tempX = cable.getTarget().getPosition().getX();
		double bend2tempY = height - this.computeCableOffset(cable);
		double bend2tempZ = cable.getTarget().getPosition().getZ();


		final Point3D bend2 = new Point3D(bend2tempX, bend2tempY, bend2tempZ);

		final Point3D diff = new Point3D(bend1tempX-bend2tempX, bend1tempY-bend2tempY, bend1tempZ-bend2tempZ);

		if (cable.getSource().equals(cable.getTarget())) {
			// self-relation
			/*bend1.x += cable.getSource().getLength() / 2;
			bend1.z += cable.getSource().getWidth() / 2;

			bend2.x -= cable.getSource().getLength() / 2;
			bend2.z -= cable.getSource().getWidth() / 2;*/

			bend1tempX += cable.getSource().getLength() / 2;
			bend1tempZ += cable.getSource().getWidth() / 2;

			bend2tempX += cable.getSource().getLength() / 2;
			bend2tempZ += cable.getSource().getWidth() / 2;
		} else {
			double length = Math.min(cable.getSource().getLength(), cable.getSource().getWidth()) / 2 / diff.magnitude();
			//bend1.x -= diff.x * length;
			//bend1.z -= diff.z * length;

			bend1tempX -= diff.getX() * length;
			bend1tempZ -= diff.getZ() * length;

			length = Math.min(cable.getTarget().getLength(), cable.getTarget().getWidth()) / 2 / diff.magnitude();
			//bend2.x += diff.x * length;
			//bend2.z += diff.z * length;

			bend2tempX += diff.getX() * length;
			bend2tempZ += diff.getZ() * length;
		}

		// create new arrow instance
		final Point3D sourcePos = new Point3D(cable.getSource().getPosition().getX(), sourceHeight, cable.getSource().getPosition().getZ());

		final Point3D targetPos = new Point3D(cable.getTarget().getPosition().getX(), targetHeight, cable.getTarget().getPosition().getZ());

		final BendableArrow arrow = new BendableArrow(sourcePos, targetPos, this.lineDiameter, bend1, bend2);
		arrow.setColor(cable.getColor());
		this.map(cable, arrow);

		// add to model
		this.cables.add(cable);
		this.viewModel.addNode(arrow);

	}

	/**
	 * The action to be performed when a change notification with {@link ObservableAction#ALL_CLEARED} has been received. This method removes all contents from the
	 * view model.
	 */
	private void onAllCleared() {

		this.cables.clear();
		this.viewModel.clearAll();
		this.updateAttributes();
	}


	/**
	 * Maps the given objects to each other. It sets the given {@code entity} as the {@code node}'s user data object and the {@code node} as {@code entity}'s
	 * Java3d object.
	 *
	 * @param entity
	 *            The visual entity to map to the given {@link VisualizableElement} object.
	 * @param node
	 *            The Java3D node to map to the given {@link VisualEntity} instance.
	 */
	private void map(final VisualEntity entity, final Group node) {

		entity.setJava3dObject(node);
		node.setUserData(entity);
	}

	/**
	 * Computes the distance of the specified cable's height to the source or target building's roof with which the cable is supposed to be drawn.
	 *
	 * @param cable
	 *            The cable to compute its vertical offset.
	 * @return The computed cable's offset.
	 */
	private double computeCableOffset(final Cable cable) {

		double offset = this.cableOffset;
		for (Cable c : this.cables) {
			if (c.getSource().equals(cable.getSource()) && c.getTarget().equals(cable.getTarget()) || c.getTarget().equals(cable.getSource())
					&& c.getSource().equals(cable.getTarget())) {
				offset += this.cableOffset;
			}
		}

		return offset;
	}


}
