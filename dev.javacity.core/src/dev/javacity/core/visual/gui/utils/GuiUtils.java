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

package dev.javacity.core.visual.gui.utils;

import java.util.Locale;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

import javacity.configuration.Language.SupportedLanguages;

/**
 * A utility class for the main GUI offering two methods create a localized {@link JFileChooser} or to set the {@link JColorChooser}'s default locale.
 *
 * @author pdo
 *
 */
public final class GuiUtils {

	// =========================== Attributes =================================

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(Main.class);

	// ========================== Constructor =================================

	/**
	 * This class is not intended for instantiation since it contains static methods only.
	 */
	private GuiUtils() {}

	// ============================ Methods ===================================

	/**
	 * Sets the default locale of any {@link JFileChooser} to the GUI's current language.
	 *
	 * @throws IllegalStateException
	 *             If the GUI's current language is neither {@link SupportedLanguages#DE} nor {@link SupportedLanguages#EN}.
	 */
	public static void setJFileChooserDefaultLocale() throws IllegalStateException {

		final SupportedLanguages lang = configuration.Configuration.getInstance().getGUILanguage();
		if (lang == SupportedLanguages.DE) {
			JFileChooser.setDefaultLocale(Locale.GERMAN);
		} else if (lang == SupportedLanguages.EN) {
			JFileChooser.setDefaultLocale(Locale.ENGLISH);
		} else {
			final String error = "Unsupported GUI language detected: " + lang.name() + ".";
			LOGGER.error(error);
			throw new IllegalStateException(error);
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully set the JFileChooser default locale to " + lang.name() + ".");
		}
	}

	/**
	 * Sets the default locale of any {@link JColorChooser} to the GUI's current language.
	 *
	 * @throws IllegalStateException
	 *             If the GUI's current language is neither {@link SupportedLanguages#DE} nor {@link SupportedLanguages#EN}.
	 */
	public static void setJColorChooserDefaultLocale() throws IllegalStateException {

		final SupportedLanguages lang = configuration.Configuration.getInstance().getGUILanguage();
		if (lang == SupportedLanguages.DE) {
			JColorChooser.setDefaultLocale(Locale.GERMAN);
		} else if (lang == SupportedLanguages.EN) {
			JColorChooser.setDefaultLocale(Locale.ENGLISH);
		} else {
			final String error = "Unsupported GUI language detected: " + lang.name() + ".";
			LOGGER.error(error);
			throw new IllegalStateException(error);
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully set the JColorChooser default locale to " + lang.name() + ".");
		}
	}

}
