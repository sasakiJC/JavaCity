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

package dev.javacity.core.models.data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import data.VisualizableElement;
import data.statics.Relation;
import data.statics.RelationType;
import data.statics.SClass;
import data.statics.SMethod;
import data.statics.SPackage;

/**
 * A utility class offering general methods to extract, manipulate, or compute certain information from data model related class instances.
 *
 * @author pdo
 *
 */
public final class DataModelUtils {

	/** A mapping from {@link VisualizableElement} instances to their metaphor objects used by all removeMapping and restoreMapping methods */
	private static Map<VisualizableElement, Object> map;

	// ========================== Constructor =================================

	/**
	 * Private constructor. This class is not intended for instantiation, since it contains static methods only.
	 */
	private DataModelUtils() {}

	// ============================ Methods ===================================

	/**
	 * Computes the length of the longest package path relative to the given package. More formally, this method will return the highest integer {@code n} with the
	 * following properties:
	 * (1) The {@code n}-value of the given package is {@code 0}.
	 * (2) If a package has a {@code n}-value of {@code m}, then all direct sub-packages have an {@code n}-value of {@code m+1}.
	 *
	 * @param root
	 *            The common (not necessarily direct) super-package of all packages to consider.
	 * @return The highest nesting level.
	 * @throws IllegalArgumentException
	 *             If the package passed in is {@code null}.
	 */
	public static int maxLevel(final SPackage root) throws IllegalArgumentException {

		if (root == null) {
			throw new IllegalArgumentException("The package passed in is null.");
		}

		int maxLevel = root.getLevel();
		for (SPackage child : root.getSubPackages()) {
			// recursive call for each sub-package
			maxLevel = Math.max(maxLevel, maxLevel(child));
		}
		return maxLevel;
	}

	/**
	 * Returns a list of all outgoing {@link Relation} objects of the specified {@link SClass} instance.
	 *
	 * @param sClass
	 *            The class to get all its outgoing relations.
	 * @return All outgoing relations of the given class.
	 * @throws IllegalArgumentException
	 *             If the class passed in is {@code null}.
	 */
	public static List<Relation> getOutgoingRelations(final SClass sClass) throws IllegalArgumentException {

		if (sClass == null) {
			throw new IllegalArgumentException("You cannot get outgoing relations from a null class.");
		}

		final List<Relation> outgoing = new LinkedList<Relation>();
		for (Relation relation : sClass.getRelations()) {
			if (relation.getSource().equals(sClass)) {
				outgoing.add(relation);
			}
		}
		return outgoing;
	}

	/**
	 * Returns a list of all incoming {@link Relation} objects of the specified {@link SClass} instance.
	 *
	 * @param sClass
	 *            The class to get all its incoming relations.
	 * @return All incoming relations of the given class.
	 * @throws IllegalArgumentException
	 *             If the class passed in is {@code null}.
	 */
	public static List<Relation> getIncomingRelations(final SClass sClass) throws IllegalArgumentException {

		if (sClass == null) {
			throw new IllegalArgumentException("You cannot get incoming relations from a null class.");
		}

		final List<Relation> incoming = new LinkedList<Relation>();
		for (Relation relation : sClass.getRelations()) {
			if (relation.getTarget().equals(sClass)) {
				incoming.add(relation);
			}
		}
		return incoming;
	}


	/**
	 * Removes all mappings from the {@link SPackage} and list of {@link STrace} instances passed in, i.e. sets their metaphor object reference to {@code null} after
	 * saving it. May be restored by {@link #restoreMappings(SPackage, List)}.
	 *
	 * @param pack
	 *            The package to remove all its mappings.
	 * @param threads
	 *            The list of threads to remove all its mappings.
	 * @throws IllegalArgumentException
	 *             If an argument passed in is {@code null}.
	 */
	public static void removeMappings(final SPackage pack) throws IllegalArgumentException {

		if (pack == null) {
			throw new IllegalArgumentException("You cannot remove the mappings of a null package.");
		}

		if (pack.getSuperPackage() == null) {
			map = new HashMap<VisualizableElement, Object>(500);
		}

		Object metaphor;

		metaphor = pack.getMetaphorObject();
		pack.setMetaphorObject(null);
		map.put(pack, metaphor);
		for (SPackage child : pack.getSubPackages()) {
			removeMappings(child);
		}

		for (SClass child : pack.getSClasses()) {
			metaphor = child.getMetaphorObject();
			child.setMetaphorObject(null);
			map.put(child, metaphor);
			for (SClassInstance instance : child.getInstances()) {
				metaphor = instance.getMetaphorObject();
				instance.setMetaphorObject(null);
				map.put(instance, metaphor);
			}
			for (Relation relation : child.getRelations()) {
				metaphor = relation.getMetaphorObject();
				relation.setMetaphorObject(null);
				map.put(relation, metaphor);
			}
			for (SMethod method : child.getSMethods()) {
				metaphor = method.getMetaphorObject();
				method.setMetaphorObject(null);
				map.put(method, metaphor);
			}
		}
	}

	/**
	 * Restores the mappings previously removed by {@link #removeMappings(SPackage, List)}, i.e. sets their metaphor objects to their original values.
	 *
	 * @param pack
	 *            The package to restore its metaphor object reference.
	 * @param threads
	 *            The list of threads to restore its members metaphor object references.
	 * @throws IllegalArgumentException
	 *             If an argument passed in is {@code null}.
	 */
	public static void restoreMappings(final SPackage pack) throws IllegalArgumentException {

		if (pack == null) {
			throw new IllegalArgumentException("You cannot restore the mappings of a null package.");
		}

		pack.setMetaphorObject(map.get(pack));
		for (SPackage child : pack.getSubPackages()) {
			restoreMappings(child);
		}

		for (SClass child : pack.getSClasses()) {
			child.setMetaphorObject(map.get(child));
			for (SClassInstance instance : child.getInstances()) {
				instance.setMetaphorObject(map.get(instance));
			}
			for (Relation relation : child.getRelations()) {
				relation.setMetaphorObject(map.get(relation));
			}
			for (SMethod method : child.getSMethods()) {
				method.setMetaphorObject(map.get(method));
			}
		}
	}


	/**
	 * Adds all methods (except constructors) of the inherited classes to the classes in the given package and all its subpackages.
	 *
	 * @param pack
	 *            The package in which all classes are contained.
	 * @throws IllegalArgumentException
	 *             If the package passed in is {@code null}.
	 */
	public static void addInheritedMethods(final SPackage pack) throws IllegalArgumentException {

		if (pack == null) {
			throw new IllegalArgumentException("This method does not accept null packages.");
		}

		// recursive call for each child
		for (SPackage child : pack.getSubPackages()) {
			addInheritedMethods(child);
		}

		for (SClass clazz : pack.getSClasses()) {
			addInheritedmethods(clazz);
		}
	}

	/**
	 * Adds all inherited methods to the given {@link SClass} instance.
	 *
	 * @param clazz
	 *            The class to add all its inherited methods to its list of methods.
	 */
	private static void addInheritedmethods(final SClass clazz) {

		for (Relation relation : clazz.getRelations()) {
			if (relation.getType() == RelationType.EXTENSION && relation.getSource() == clazz) {
				addInheritedmethods(relation.getTarget());
				for (SMethod method : relation.getTarget().getSMethods()) {
					if (!(method.getName().equals(relation.getTarget().getName()) || clazz.getSMethods().contains(method))) {
						// method is no constructor
						clazz.getSMethods().add(method);
					}
				}
			}
		}
	}


}
