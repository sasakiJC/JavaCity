/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package metaphor.types.impl;



import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import metaphor.types.TypesPackage;
import metaphor.types.VisualEntity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Visual Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link metaphor.types.impl.VisualEntityImpl#getId <em>Id</em>}</li>
 * <li>{@link metaphor.types.impl.VisualEntityImpl#getColor <em>Color</em>}</li>
 * <li>{@link metaphor.types.impl.VisualEntityImpl#getPosition <em>Position</em>}</li>
 * <li>{@link metaphor.types.impl.VisualEntityImpl#getDataObject <em>Data Object</em>}</li>
 * <li>{@link metaphor.types.impl.VisualEntityImpl#getJava3dObject <em>Java3d Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class VisualEntityImpl extends EObjectImpl implements VisualEntity {

	/** The {@code serialVersionUID} for serialization. */
	protected static final long serialVersionUID = 6411407895721980751L;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final long ID_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected long id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected static final Color COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected Color color = COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected static final Point3D POSITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected Point3D position = POSITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDataObject() <em>Data Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDataObject()
	 * @generated
	 * @ordered
	 */
	protected static final Object DATA_OBJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataObject() <em>Data Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDataObject()
	 * @generated
	 * @ordered
	 */
	protected Object dataObject = DATA_OBJECT_EDEFAULT;

	/**
	 * The default value of the '{@link #getJava3dObject() <em>Java3d Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getJava3dObject()
	 * @generated
	 * @ordered
	 */
	protected static final Node JAVA3D_OBJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJava3dObject() <em>Java3d Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getJava3dObject()
	 * @generated
	 * @ordered
	 */
	protected Node java3dObject = JAVA3D_OBJECT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected VisualEntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.VISUAL_ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public long getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setId(long newId) {
		long oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.VISUAL_ENTITY__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setColor(Color newColor) {
		Color oldColor = color;
		color = newColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.VISUAL_ENTITY__COLOR, oldColor, color));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Point3D getPosition() {
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setPosition(Point3D newPosition) {
		Point3D oldPosition = position;
		position = newPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.VISUAL_ENTITY__POSITION, oldPosition, position));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Object getDataObject() {
		return dataObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setDataObject(Object newDataObject) {
		Object oldDataObject = dataObject;
		dataObject = newDataObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.VISUAL_ENTITY__DATA_OBJECT, oldDataObject, dataObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Node getJava3dObject() {
		return java3dObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setJava3dObject(Node newJava3dObject) {
		Node oldJava3dObject = java3dObject;
		java3dObject = newJava3dObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.VISUAL_ENTITY__JAVA3D_OBJECT, oldJava3dObject, java3dObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case TypesPackage.VISUAL_ENTITY__ID:
			return getId();
		case TypesPackage.VISUAL_ENTITY__COLOR:
			return getColor();
		case TypesPackage.VISUAL_ENTITY__POSITION:
			return getPosition();
		case TypesPackage.VISUAL_ENTITY__DATA_OBJECT:
			return getDataObject();
		case TypesPackage.VISUAL_ENTITY__JAVA3D_OBJECT:
			return getJava3dObject();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case TypesPackage.VISUAL_ENTITY__ID:
			setId((Long) newValue);
			return;
		case TypesPackage.VISUAL_ENTITY__COLOR:
			setColor((Color) newValue);
			return;
		case TypesPackage.VISUAL_ENTITY__POSITION:
			setPosition((Point3D) newValue);
			return;
		case TypesPackage.VISUAL_ENTITY__DATA_OBJECT:
			setDataObject(newValue);
			return;
		case TypesPackage.VISUAL_ENTITY__JAVA3D_OBJECT:
			setJava3dObject((Node) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case TypesPackage.VISUAL_ENTITY__ID:
			setId(ID_EDEFAULT);
			return;
		case TypesPackage.VISUAL_ENTITY__COLOR:
			setColor(COLOR_EDEFAULT);
			return;
		case TypesPackage.VISUAL_ENTITY__POSITION:
			setPosition(POSITION_EDEFAULT);
			return;
		case TypesPackage.VISUAL_ENTITY__DATA_OBJECT:
			setDataObject(DATA_OBJECT_EDEFAULT);
			return;
		case TypesPackage.VISUAL_ENTITY__JAVA3D_OBJECT:
			setJava3dObject(JAVA3D_OBJECT_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case TypesPackage.VISUAL_ENTITY__ID:
			return id != ID_EDEFAULT;
		case TypesPackage.VISUAL_ENTITY__COLOR:
			return COLOR_EDEFAULT == null ? color != null : !COLOR_EDEFAULT.equals(color);
		case TypesPackage.VISUAL_ENTITY__POSITION:
			return POSITION_EDEFAULT == null ? position != null : !POSITION_EDEFAULT.equals(position);
		case TypesPackage.VISUAL_ENTITY__DATA_OBJECT:
			return DATA_OBJECT_EDEFAULT == null ? dataObject != null : !DATA_OBJECT_EDEFAULT.equals(dataObject);
		case TypesPackage.VISUAL_ENTITY__JAVA3D_OBJECT:
			return JAVA3D_OBJECT_EDEFAULT == null ? java3dObject != null : !JAVA3D_OBJECT_EDEFAULT.equals(java3dObject);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", color: ");
		result.append(color);
		result.append(", position: ");
		result.append(position);
		result.append(", dataObject: ");
		result.append(dataObject);
		result.append(", java3dObject: ");
		result.append(java3dObject);
		result.append(')');
		return result.toString();
	}

} // VisualEntityImpl
