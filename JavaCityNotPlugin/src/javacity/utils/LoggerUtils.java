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

package javacity.utils;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.ecore.EObject;

import data.VisualizableElement;
import javafx.scene.Node;
import metaphor.types.VisualEntity;

/**
 * A class offering common logging related utility methods, such as a custom {@code toString()} method for the {@link EObject} instances used in this application.
 *
 * @author pdo
 *
 */
public final class LoggerUtils {

	// ========================== Constructor =================================

	/**
	 * This class is not intended for instantiation since it contains static methods only.
	 */
	private LoggerUtils() {}

	// ============================ Methods ===================================

	/**
	 * Returns the string representation of the specified {@link EObject} instance as supposed to be created by the object's {@code toString()} method. Due
	 * to a deficient implementation of that method in ECore, a direct call of the {@code toString()} method will cause an {@link StackOverflowError}, since we
	 * mapped two such objects to each other by attributes and the {@code toString()} method is recursively invoked on all ECore objects' attributes.
	 *
	 * @param eObject
	 *            The object to get its string representation.
	 * @return The string representation of the given object.
	 */
	public static String toLogString(final EObject eObject) {

		String loggerString = null;

		if (eObject == null) {
			loggerString = "null";

		} else if (eObject instanceof VisualizableElement) {
			final VisualizableElement element = (VisualizableElement) eObject;
			final Object metaphor = element.getMetaphorObject();
			element.setMetaphorObject(null);
			loggerString = eObject.toString();
			element.setMetaphorObject(metaphor);

		} else if (eObject instanceof VisualEntity) {
			final VisualEntity element = (VisualEntity) eObject;
			final Object data = element.getDataObject();
			final Node java3d = element.getJava3dObject();
			element.setDataObject(null);
			element.setJava3dObject(null);
			loggerString = toLogStringHelper(eObject) + " matching data object " + toLogString((EObject) data);
			element.setDataObject(data);
			element.setJava3dObject(java3d);

		} else {
			loggerString = eObject.toString();
		}

		return loggerString;
	}

	/**
	 * Helper method to {@link #toLogString(EObject)}. It returns the String representation of the specified {@link EObject} as returned by {@code toString()}
	 * invoked in the actual class of the given object using Java reflections. Note that this method will return {@code null} not only if {@code toString()} returns
	 * {@code null}, but also if any error occurred while accessing that method.
	 *
	 * @param eObject
	 *            The object to get its string representation.
	 * @return The string representation of the specified object
	 */
	private static String toLogStringHelper(final EObject eObject) {

		try {
			return (String) eObject.getClass().getMethod("toString").invoke(eObject.getClass().cast(eObject), new Object[0]);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			return "null";
		}
	}

}
