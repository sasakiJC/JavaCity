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
 * dynamics関連の削除
 */
package javacity.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;

import com.sun.j3d.utils.geometry.Primitive;

import data.VisualizableElement;
import data.statics.SClass;
import data.statics.SPackage;
import javacity.models.data.DataModel;
import javacity.models.data.DataModelUtils;
import javacity.utils.LoggerUtils;
import javafx.util.Pair;
import metaphor.types.VisualEntity;

/**
 * A saves controller to save the current visualization status to disk and reload it later.
 *
 * @author pdo
 *
 */
public final class SavesController {

	// =========================== Attributes =================================

	/** The default file ending of all Synchrovis saves. */
	public static final String SAVES_ENDING = "syn";

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(SavesController.class);

	/** The {@link DataModel} instance used in Synchrovis. */
	private DataModel model;

	// ========================== Constructor =================================

	/**
	 * Protected constructor. This class is not intended for instantiation from outside of this package.
	 */
	protected SavesController() {}

	// ============================ Methods ===================================

	/**
	 * Initialize this {@link SavesController} instance with the specified {@link DataModel} object.
	 *
	 * @param dataModel
	 *            The data model to apply any loaded visualization status on.
	 * @throws IllegalArgumentException
	 *             If the data model passed in is {@code null}.
	 */
	public void init(final DataModel dataModel) throws IllegalArgumentException {

		if (dataModel == null) {
			throw new IllegalArgumentException("You cannot initialize this controller with a null data model.");
		}

		this.model = dataModel;
	}

	/**
	 * Save the current visualization to disk to be able to reload and restore it later.
	 *
	 * @param file
	 *            The file to save the visualization to.
	 * @throws IllegalArgumentException
	 *             If the file passed in is {@code null}.
	 * @throws IOException
	 *             If an error occurred while saving the current visualization.
	 */
	public void save(final File file) throws IllegalArgumentException, IOException {

		if (file == null) {
			throw new IllegalArgumentException("You cannot save the current visualization to a null file.");
		}

		final SPackage root = this.model.getRoot();
		DataModelUtils.removeMappings(root);

		// create output streams
		ObjectOutputStream objectOS = null;
		try {
			final FileOutputStream fileOS = new FileOutputStream(file);
			final ZipOutputStream zipOS = new ZipOutputStream(fileOS);

			// write objects
			zipOS.putNextEntry(new ZipEntry("statics"));
			objectOS = new ObjectOutputStream(zipOS);
			objectOS.writeObject(root);

			zipOS.putNextEntry(new ZipEntry("properties"));
			final Map<String, Object> properties = new HashMap<String, Object>();
			properties.put("relations", Logic.getInstance().getCityController().getRelationsStatus());
			final Primitive mouseSelected = Logic.getInstance().getSelectionController().getSelectedNode();
			if (mouseSelected != null) {
				properties.put("mouseSelected", ((VisualEntity) mouseSelected.getUserData()).getDataObject());
			}
			objectOS.writeObject(properties);
			DataModelUtils.restoreMappings(root);

			// flush everything
			zipOS.flush();
			fileOS.flush();
			objectOS.flush();
		} catch (NotSerializableException e) {
			DataModelUtils.restoreMappings(root);
		} finally {
			try {
				if (objectOS != null) {
					objectOS.close();
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug("Successfully saved visualization to file " + file.getAbsolutePath() + ".");
					}
				}
			} catch (IOException e) {
				LOGGER.error("An error occurred while closing the file output stream.", e);
			}
		}
	}

	/**
	 * Load the specified file and restore the current visualization as defined by the data in it.
	 *
	 * @param file
	 *            The visualization file to load.
	 * @throws IllegalArgumentException
	 *             If the file passed in is either {@code null} or dies not represent an existing file on disk.
	 * @throws IOException
	 *             If an error occurred while loading the specified file.
	 * @throws ClassNotFoundException
	 *             If the specified file could not be found on disk. This exception should never be thrown since an {@link IllegalArgumentException} is thrown in
	 *             this case before.
	 */
	@SuppressWarnings("unchecked")
	public void load(final File file) throws IllegalArgumentException, IOException, ClassNotFoundException {

		if (file == null) {
			throw new IllegalArgumentException("You cannot load the current visualization from a null file.");
		}
		if (!file.exists()) {
			throw new IllegalArgumentException("The given file does not represent an existing file on disk.");
		}

		// create input streams
		ObjectInputStream objectIS = null;
		try {
			final FileInputStream fileIS = new FileInputStream(file);
			final ZipInputStream zipIS = new ZipInputStream(fileIS);
			zipIS.getNextEntry();
			objectIS = new ObjectInputStream(zipIS);

			// read objects
			final SPackage statics = (SPackage) objectIS.readObject();
			zipIS.getNextEntry();

			zipIS.getNextEntry();
			final Map<String, Object> properties = (Map<String, Object>) objectIS.readObject();

			// apply
			this.apply(statics, properties);
		} finally {
			try {
				if (objectIS != null) {
					objectIS.close();
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug("Successfully loaded visualization file " + file.getAbsolutePath() + ".");
					}
				}
			} catch (IOException e) {
				LOGGER.error("An error occurred while closing the file output stream.", e);
				throw new IOException(e);
			}
		}
	}

	/**
	 * Applies the loaded data model elements to the visualization, i.e. performes the entire visualization restoration according to the data saved and loaded by
	 * {@link #load(File)}.
	 *
	 * @param root
	 *            The regular root district of the visualization to restore.
	 * @param traces
	 *            The list of threads of the visualization to restore.
	 * @param properties
	 *            The properties of the previously saved visualization to be restored.
	 */
	@SuppressWarnings("unchecked")
	private void apply(final SPackage root, final Map<String, Object> properties) {

		// apply statics and dynamics
		this.model.clearAll();
		if (root != null) {
			this.addPackageToDataModel(root);
			this.model.setRootPackage(root);
			this.model.setStaticsLoaded();
		}

		// display relations
		final Pair<Boolean, SClass> relations = (Pair<Boolean, SClass>) properties.get("relations");
		if (relations.getLeft()) {
			Logic.getInstance().getCityController().showGlobalRelations();
		} else if (relations.getRight() != null) {
			Logic.getInstance().getCityController().showLocalRelations(relations.getRight());
		}

		// select node
		final VisualizableElement selected = (VisualizableElement) properties.get("selected");
		if (selected != null) {
			Logic.getInstance().getSelectionController().select((Primitive) ((VisualEntity) selected.getMetaphorObject()).getJava3dObject());
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully applied loaded visualization with root package " + LoggerUtils.toLogString(root) + ".");
		}
	}

	/**
	 * Imports the {@link SPackage} passed in into the data model.
	 *
	 * @param pack
	 *            The package to be imported.
	 */
	private void addPackageToDataModel(final SPackage pack) {

		// recursive call for each child
		for (SPackage child : pack.getSubPackages()) {
			this.addPackageToDataModel(child);
		}

		this.model.addPackage(pack);
	}
}
