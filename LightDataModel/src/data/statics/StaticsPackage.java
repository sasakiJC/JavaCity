/**
 */
package data.statics;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import data.DataPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see data.statics.StaticsFactory
 * @model kind="package"
 * @generated
 */
public interface StaticsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "statics";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://pdo-masterthesis-ss12.de/dataModel/data/statics";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sta";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StaticsPackage eINSTANCE = data.statics.impl.StaticsPackageImpl.init();

	/**
	 * The meta object id for the '{@link data.statics.impl.CodeElementImpl <em>Code Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see data.statics.impl.CodeElementImpl
	 * @see data.statics.impl.StaticsPackageImpl#getCodeElement()
	 * @generated
	 */
	int CODE_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Metaphor Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_ELEMENT__METAPHOR_OBJECT = DataPackage.VISUALIZABLE_ELEMENT__METAPHOR_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_ELEMENT__NAME = DataPackage.VISUALIZABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Kdm Signature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_ELEMENT__KDM_SIGNATURE = DataPackage.VISUALIZABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Kdm Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_ELEMENT__KDM_ID = DataPackage.VISUALIZABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Code Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_ELEMENT_FEATURE_COUNT = DataPackage.VISUALIZABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link data.statics.impl.RelationImpl <em>Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see data.statics.impl.RelationImpl
	 * @see data.statics.impl.StaticsPackageImpl#getRelation()
	 * @generated
	 */
	int RELATION = 0;

	/**
	 * The feature id for the '<em><b>Metaphor Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__METAPHOR_OBJECT = CODE_ELEMENT__METAPHOR_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__NAME = CODE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Kdm Signature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__KDM_SIGNATURE = CODE_ELEMENT__KDM_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Kdm Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__KDM_ID = CODE_ELEMENT__KDM_ID;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__TYPE = CODE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__SOURCE = CODE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__TARGET = CODE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_FEATURE_COUNT = CODE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link data.statics.impl.SClassImpl <em>SClass</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see data.statics.impl.SClassImpl
	 * @see data.statics.impl.StaticsPackageImpl#getSClass()
	 * @generated
	 */
	int SCLASS = 1;

	/**
	 * The feature id for the '<em><b>Metaphor Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCLASS__METAPHOR_OBJECT = CODE_ELEMENT__METAPHOR_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCLASS__NAME = CODE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Kdm Signature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCLASS__KDM_SIGNATURE = CODE_ELEMENT__KDM_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Kdm Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCLASS__KDM_ID = CODE_ELEMENT__KDM_ID;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCLASS__RELATIONS = CODE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SPackage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCLASS__SPACKAGE = CODE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SMethods</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCLASS__SMETHODS = CODE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Num Attributes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCLASS__NUM_ATTRIBUTES = CODE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCLASS__TYPE = CODE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>SClass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCLASS_FEATURE_COUNT = CODE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link data.statics.impl.SPackageImpl <em>SPackage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see data.statics.impl.SPackageImpl
	 * @see data.statics.impl.StaticsPackageImpl#getSPackage()
	 * @generated
	 */
	int SPACKAGE = 2;

	/**
	 * The feature id for the '<em><b>Metaphor Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACKAGE__METAPHOR_OBJECT = CODE_ELEMENT__METAPHOR_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACKAGE__NAME = CODE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Kdm Signature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACKAGE__KDM_SIGNATURE = CODE_ELEMENT__KDM_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Kdm Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACKAGE__KDM_ID = CODE_ELEMENT__KDM_ID;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACKAGE__LEVEL = CODE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Packages</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACKAGE__SUB_PACKAGES = CODE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Super Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACKAGE__SUPER_PACKAGE = CODE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>SClasses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACKAGE__SCLASSES = CODE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>SPackage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACKAGE_FEATURE_COUNT = CODE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link data.statics.impl.SMethodImpl <em>SMethod</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see data.statics.impl.SMethodImpl
	 * @see data.statics.impl.StaticsPackageImpl#getSMethod()
	 * @generated
	 */
	int SMETHOD = 4;

	/**
	 * The feature id for the '<em><b>Metaphor Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMETHOD__METAPHOR_OBJECT = CODE_ELEMENT__METAPHOR_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMETHOD__NAME = CODE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Kdm Signature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMETHOD__KDM_SIGNATURE = CODE_ELEMENT__KDM_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Kdm Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMETHOD__KDM_ID = CODE_ELEMENT__KDM_ID;

	/**
	 * The feature id for the '<em><b>SClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMETHOD__SCLASS = CODE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Simple Signature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMETHOD__SIMPLE_SIGNATURE = CODE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>SMethod</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMETHOD_FEATURE_COUNT = CODE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link data.statics.RelationType <em>Relation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see data.statics.RelationType
	 * @see data.statics.impl.StaticsPackageImpl#getRelationType()
	 * @generated
	 */
	int RELATION_TYPE = 5;

	/**
	 * The meta object id for the '{@link data.statics.ClassType <em>Class Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see data.statics.ClassType
	 * @see data.statics.impl.StaticsPackageImpl#getClassType()
	 * @generated
	 */
	int CLASS_TYPE = 6;


	/**
	 * Returns the meta object for class '{@link data.statics.Relation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation</em>'.
	 * @see data.statics.Relation
	 * @generated
	 */
	EClass getRelation();

	/**
	 * Returns the meta object for the attribute '{@link data.statics.Relation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see data.statics.Relation#getType()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_Type();

	/**
	 * Returns the meta object for the reference '{@link data.statics.Relation#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see data.statics.Relation#getSource()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_Source();

	/**
	 * Returns the meta object for the reference '{@link data.statics.Relation#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see data.statics.Relation#getTarget()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_Target();

	/**
	 * Returns the meta object for class '{@link data.statics.SClass <em>SClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SClass</em>'.
	 * @see data.statics.SClass
	 * @generated
	 */
	EClass getSClass();

	/**
	 * Returns the meta object for the reference list '{@link data.statics.SClass#getRelations <em>Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Relations</em>'.
	 * @see data.statics.SClass#getRelations()
	 * @see #getSClass()
	 * @generated
	 */
	EReference getSClass_Relations();

	/**
	 * Returns the meta object for the reference '{@link data.statics.SClass#getSPackage <em>SPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SPackage</em>'.
	 * @see data.statics.SClass#getSPackage()
	 * @see #getSClass()
	 * @generated
	 */
	EReference getSClass_SPackage();

	/**
	 * Returns the meta object for the reference list '{@link data.statics.SClass#getSMethods <em>SMethods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>SMethods</em>'.
	 * @see data.statics.SClass#getSMethods()
	 * @see #getSClass()
	 * @generated
	 */
	EReference getSClass_SMethods();


	/**
	 * Returns the meta object for the attribute '{@link data.statics.SClass#getNumAttributes <em>Num Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Attributes</em>'.
	 * @see data.statics.SClass#getNumAttributes()
	 * @see #getSClass()
	 * @generated
	 */
	EAttribute getSClass_NumAttributes();

	/**
	 * Returns the meta object for the attribute '{@link data.statics.SClass#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see data.statics.SClass#getType()
	 * @see #getSClass()
	 * @generated
	 */
	EAttribute getSClass_Type();

	/**
	 * Returns the meta object for class '{@link data.statics.SPackage <em>SPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SPackage</em>'.
	 * @see data.statics.SPackage
	 * @generated
	 */
	EClass getSPackage();

	/**
	 * Returns the meta object for the attribute '{@link data.statics.SPackage#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see data.statics.SPackage#getLevel()
	 * @see #getSPackage()
	 * @generated
	 */
	EAttribute getSPackage_Level();

	/**
	 * Returns the meta object for the reference list '{@link data.statics.SPackage#getSubPackages <em>Sub Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sub Packages</em>'.
	 * @see data.statics.SPackage#getSubPackages()
	 * @see #getSPackage()
	 * @generated
	 */
	EReference getSPackage_SubPackages();

	/**
	 * Returns the meta object for the reference '{@link data.statics.SPackage#getSuperPackage <em>Super Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Super Package</em>'.
	 * @see data.statics.SPackage#getSuperPackage()
	 * @see #getSPackage()
	 * @generated
	 */
	EReference getSPackage_SuperPackage();

	/**
	 * Returns the meta object for the reference list '{@link data.statics.SPackage#getSClasses <em>SClasses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>SClasses</em>'.
	 * @see data.statics.SPackage#getSClasses()
	 * @see #getSPackage()
	 * @generated
	 */
	EReference getSPackage_SClasses();

	/**
	 * Returns the meta object for class '{@link data.statics.CodeElement <em>Code Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Element</em>'.
	 * @see data.statics.CodeElement
	 * @generated
	 */
	EClass getCodeElement();

	/**
	 * Returns the meta object for the attribute '{@link data.statics.CodeElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see data.statics.CodeElement#getName()
	 * @see #getCodeElement()
	 * @generated
	 */
	EAttribute getCodeElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link data.statics.CodeElement#getKdmSignature <em>Kdm Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kdm Signature</em>'.
	 * @see data.statics.CodeElement#getKdmSignature()
	 * @see #getCodeElement()
	 * @generated
	 */
	EAttribute getCodeElement_KdmSignature();

	/**
	 * Returns the meta object for the attribute '{@link data.statics.CodeElement#getKdmId <em>Kdm Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kdm Id</em>'.
	 * @see data.statics.CodeElement#getKdmId()
	 * @see #getCodeElement()
	 * @generated
	 */
	EAttribute getCodeElement_KdmId();

	/**
	 * Returns the meta object for class '{@link data.statics.SMethod <em>SMethod</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SMethod</em>'.
	 * @see data.statics.SMethod
	 * @generated
	 */
	EClass getSMethod();

	/**
	 * Returns the meta object for the reference '{@link data.statics.SMethod#getSClass <em>SClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SClass</em>'.
	 * @see data.statics.SMethod#getSClass()
	 * @see #getSMethod()
	 * @generated
	 */
	EReference getSMethod_SClass();

	/**
	 * Returns the meta object for the attribute '{@link data.statics.SMethod#getSimpleSignature <em>Simple Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Signature</em>'.
	 * @see data.statics.SMethod#getSimpleSignature()
	 * @see #getSMethod()
	 * @generated
	 */
	EAttribute getSMethod_SimpleSignature();

	/**
	 * Returns the meta object for enum '{@link data.statics.RelationType <em>Relation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Relation Type</em>'.
	 * @see data.statics.RelationType
	 * @generated
	 */
	EEnum getRelationType();

	/**
	 * Returns the meta object for enum '{@link data.statics.ClassType <em>Class Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Class Type</em>'.
	 * @see data.statics.ClassType
	 * @generated
	 */
	EEnum getClassType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StaticsFactory getStaticsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link data.statics.impl.RelationImpl <em>Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see data.statics.impl.RelationImpl
		 * @see data.statics.impl.StaticsPackageImpl#getRelation()
		 * @generated
		 */
		EClass RELATION = eINSTANCE.getRelation();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION__TYPE = eINSTANCE.getRelation_Type();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__SOURCE = eINSTANCE.getRelation_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__TARGET = eINSTANCE.getRelation_Target();

		/**
		 * The meta object literal for the '{@link data.statics.impl.SClassImpl <em>SClass</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see data.statics.impl.SClassImpl
		 * @see data.statics.impl.StaticsPackageImpl#getSClass()
		 * @generated
		 */
		EClass SCLASS = eINSTANCE.getSClass();

		/**
		 * The meta object literal for the '<em><b>Relations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCLASS__RELATIONS = eINSTANCE.getSClass_Relations();

		/**
		 * The meta object literal for the '<em><b>SPackage</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCLASS__SPACKAGE = eINSTANCE.getSClass_SPackage();

		/**
		 * The meta object literal for the '<em><b>SMethods</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCLASS__SMETHODS = eINSTANCE.getSClass_SMethods();

		/**
		 * The meta object literal for the '<em><b>Num Attributes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCLASS__NUM_ATTRIBUTES = eINSTANCE.getSClass_NumAttributes();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCLASS__TYPE = eINSTANCE.getSClass_Type();

		/**
		 * The meta object literal for the '{@link data.statics.impl.SPackageImpl <em>SPackage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see data.statics.impl.SPackageImpl
		 * @see data.statics.impl.StaticsPackageImpl#getSPackage()
		 * @generated
		 */
		EClass SPACKAGE = eINSTANCE.getSPackage();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPACKAGE__LEVEL = eINSTANCE.getSPackage_Level();

		/**
		 * The meta object literal for the '<em><b>Sub Packages</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPACKAGE__SUB_PACKAGES = eINSTANCE.getSPackage_SubPackages();

		/**
		 * The meta object literal for the '<em><b>Super Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPACKAGE__SUPER_PACKAGE = eINSTANCE.getSPackage_SuperPackage();

		/**
		 * The meta object literal for the '<em><b>SClasses</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPACKAGE__SCLASSES = eINSTANCE.getSPackage_SClasses();

		/**
		 * The meta object literal for the '{@link data.statics.impl.CodeElementImpl <em>Code Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see data.statics.impl.CodeElementImpl
		 * @see data.statics.impl.StaticsPackageImpl#getCodeElement()
		 * @generated
		 */
		EClass CODE_ELEMENT = eINSTANCE.getCodeElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_ELEMENT__NAME = eINSTANCE.getCodeElement_Name();

		/**
		 * The meta object literal for the '<em><b>Kdm Signature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_ELEMENT__KDM_SIGNATURE = eINSTANCE.getCodeElement_KdmSignature();

		/**
		 * The meta object literal for the '<em><b>Kdm Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_ELEMENT__KDM_ID = eINSTANCE.getCodeElement_KdmId();

		/**
		 * The meta object literal for the '{@link data.statics.impl.SMethodImpl <em>SMethod</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see data.statics.impl.SMethodImpl
		 * @see data.statics.impl.StaticsPackageImpl#getSMethod()
		 * @generated
		 */
		EClass SMETHOD = eINSTANCE.getSMethod();

		/**
		 * The meta object literal for the '<em><b>SClass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMETHOD__SCLASS = eINSTANCE.getSMethod_SClass();

		/**
		 * The meta object literal for the '<em><b>Simple Signature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMETHOD__SIMPLE_SIGNATURE = eINSTANCE.getSMethod_SimpleSignature();

		/**
		 * The meta object literal for the '{@link data.statics.RelationType <em>Relation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see data.statics.RelationType
		 * @see data.statics.impl.StaticsPackageImpl#getRelationType()
		 * @generated
		 */
		EEnum RELATION_TYPE = eINSTANCE.getRelationType();

		/**
		 * The meta object literal for the '{@link data.statics.ClassType <em>Class Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see data.statics.ClassType
		 * @see data.statics.impl.StaticsPackageImpl#getClassType()
		 * @generated
		 */
		EEnum CLASS_TYPE = eINSTANCE.getClassType();

	}

} //StaticsPackage
