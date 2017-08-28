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

package javacity.importer.kdm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import data.statics.SPackage;
import data.statics.impl.StaticsFactoryImpl;
import javacity.importer.exception.KDMImportException;
import javacity.models.data.DataModel;
import javacity.utils.StringUtils;

/**
 * An abstract class defining common methods all KDM importer classes may use and declaring abstract methods all extending classes should implement.
 *
 * @author pdo
 *
 */
public abstract class AbstractKDMImporter {

	// =========================== Attributes =================================

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(AbstractKDMImporter.class);

	/** The data model into which the parsed relevant static information will be written. */
	protected final DataModel dataModel;

	// ========================== Constructor =================================

	/**
	 * Protected constructor usable from subclasses.
	 *
	 * @param dataModel
	 *            The data model to add all imported static elements to.
	 * @throws IllegalArgumentException
	 *             If the data model passed in is {@code null}.
	 */
	protected AbstractKDMImporter(final DataModel dataModel) throws IllegalArgumentException {

		if (dataModel == null) {
			throw new IllegalArgumentException("The data model passed in is null.");
		}

		this.dataModel = dataModel;
	}

	// ============================ Methods ===================================

	/**
	 * Build the package hierarchy of the given packages, i.e. set the correct values of the{@code superPackage} and {@code subPackages} attributes of each package.
	 */
	protected final void buildPackageHierarchy() {

		for (SPackage sPackage : this.dataModel.getPackages()) {
			final List<SPackage> path = new ArrayList<SPackage>(10);
			// determine all imported (i.e. non empty) packages in the package path beginning with the current package going upwards in the hierarchy
			path.add(sPackage);
			for (String packName : StringUtils.getSubstringsFromLast(sPackage.getName(), '.')) {
				SPackage sPack = this.dataModel.getPackageByName(packName);
				if (sPack == null) {
					// add empty package to data model
					sPack = StaticsFactoryImpl.eINSTANCE.createSPackage();
					sPack.setKdmId("<n/a>");
					sPack.setName(packName);
					this.dataModel.addPackage(sPack);
				} else {
					if (sPack.getSuperPackage() != null) {
						// package has already been visited before, just skip after this one
						path.add(0, sPack);
						break;
					}
				}
				path.add(0, sPack);
			}

			// set level and sub- / super-package attribute of each package in the path
			if (path.get(0).getLevel() < 0) {
				// level has not been assigned jet
				path.get(0).setLevel(0);
			}

			int i = 0;
			int level = path.get(0).getLevel() + 1;
			for (int j = 1; j < path.size(); j++) {
				path.get(i).getSubPackages().add(path.get(j));
				path.get(j).setSuperPackage(path.get(i++));
				path.get(j).setLevel(level++);

				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("The sub package of package " + path.get(i - 1).getName() + " is " + path.get(j).getName() + ".");
					LOGGER.debug("The super package of " + path.get(j).getName() + "(level: " + (level - 1) + ") is " + path.get(i - 1).getName() + ".");
				}
			}
		}
	}

	/**
	 * Add a common base package (a {@link SPackage} instance) to all lowest packages (i.e. those with an {@code level} attribute value of {@code 0}).
	 */
	protected final void addBasePackage() {

		// determine all lowest packages
		final List<SPackage> rootPackages = new LinkedList<SPackage>();
		for (SPackage sPackage : this.dataModel.getPackages()) {
			if (sPackage.getLevel() == 0) {
				rootPackages.add(sPackage);
			}
		}

		// create the base package. It will represent the regular base area of the city in our visualization
		final SPackage base = StaticsFactoryImpl.eINSTANCE.createSPackage();
		base.setName("<regular_base>");
		base.setLevel(-1); // identifier
		base.setKdmId(null);
		base.setSuperPackage(null);
		for (SPackage sPackage : rootPackages) {
			base.getSubPackages().add(sPackage);
		}
		// don't set base package as all lowest packages' common super-package, because it is no such.
		this.dataModel.setRootPackage(base);
	}

	// ======================= Abstract Methods ===============================

	/**
	 * Imports and extracts static program information from the KDM file specified by the given filename.
	 *
	 * @param filename
	 *            The filename of the KDM file.
	 * @throws KDMImportException
	 *             If an error occurred while importing the KDM file.
	 * @throws IllegalArgumentException
	 *             If the filename passed in is {@code null}.
	 */
	public abstract void importFromFile(String filename) throws KDMImportException, IllegalArgumentException;

}
