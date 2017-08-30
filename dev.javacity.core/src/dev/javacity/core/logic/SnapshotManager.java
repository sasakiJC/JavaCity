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

package dev.javacity.core.logic;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.media.j3d.GraphicsContext3D;
import javax.media.j3d.ImageComponent2D;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.PageRanges;

import org.apache.log4j.Logger;

import dev.javacity.core.visual.gui.CityCanvas;
import javacity.logic.executors.PrintExecutor;

/**
 * A screenshot manager allowing the user to take a snapshot of the current visualization in order to save it to disk or directly print it on the default printing
 * device registered on this computer.
 *
 * @author pdo
 *
 */
public final class SnapshotManager {

	// =========================== Attributes =================================

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(SnapshotManager.class);

	/** The file format of a snapshot image to save to disk. */
	private static String imageFormat = "png";

	/** The canvas of which snapshot has to be taken. */
	private final CityCanvas canvas;

	// ========================== Constructor =================================

	/**
	 * Creates a new {@link SnapshotManager} instance with the given {@link CityCanvas} object to take snapshots of.
	 *
	 * @param cityCanvas
	 *            The canvas to take snapshots of.
	 * @throws IllegalArgumentException
	 *             If the canvas object passed in is {@code null}.
	 */
	public SnapshotManager(final CityCanvas cityCanvas) throws IllegalArgumentException {

		if (cityCanvas == null) {
			throw new IllegalArgumentException("You cannot take snapshots from a null canvas.");
		}

		this.canvas = cityCanvas;
	}

	// ============================ Methods ===================================

	/**
	 * Takes a snapshot of the current visualization and saves it to disk.
	 *
	 * @param filename
	 *            The name of the file to save the taken snapshot to.
	 * @throws IOException
	 *             If an error occurred while saving the snapshot file.
	 * @throws IllegalArgumentException
	 *             If the filename passed in is {@code null}.
	 */
	public void saveSnapshot(final String filename) throws IOException, IllegalArgumentException {

		if (filename == null) {
			throw new IllegalArgumentException("You cannot pass in a null filename.");
		}

		this.saveImage(this.takeSnapshot(), filename);
	}

	/**
	 * Takes a snapshot of the current visualization and prints it on the default printing device registered on this computer. *
	 */
	public void printSnapshot() {

		final String format = getImageFormat();

		// workaround, somehow printing a png-file changes some colors
		imageFormat = ".jpg";
		this.printImage(this.takeSnapshot());
		imageFormat = format;
	}

	/**
	 * Takes a snapshot of the current visualization and returns it as a {@link BufferedImage} instance.
	 *
	 * @return The snapshot as a buffered image object.
	 */
	private BufferedImage takeSnapshot() {

		// create image raster
		final Raster raster = new Raster();
		raster.setType(Raster.RASTER_COLOR);
		raster.setCapability(Raster.ALLOW_IMAGE_READ);

		// set image size
		final Dimension dimension = this.canvas.getSize();
		raster.setSize(dimension);
		raster.setImage(new ImageComponent2D(ImageComponent2D.FORMAT_RGB, dimension.width, dimension.height));

		// get image
		final GraphicsContext3D context = this.canvas.getGraphicsContext3D();
		context.readRaster(raster);
		final ImageComponent2D component = raster.getImage();
		return component.getImage();
	}

	/**
	 * Saves the given {@link BufferedImage} instance to disk. The extension of the file created is will be {@value #imageFormat}.
	 *
	 * @param image
	 *            The buffered image to save to disk.
	 * @param filename
	 *            The name of the file to save the taken snapshot to.
	 * @throws IOException
	 *             If an error occurred while saving the image file.
	 */
	private void saveImage(final BufferedImage image, final String filename) throws IOException {

		ImageIO.write(image, imageFormat, new File(filename));

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully took snapshot and saved it to " + filename + ".");
		}
	}

	/**
	 * Prints the given buffered image on the default printing device registered on this computer.
	 *
	 * @param image
	 *            The buffered image to print.
	 */
	private void printImage(final BufferedImage image) {

		// create printer job
		final PrinterJob job = PrinterJob.getPrinterJob();
		job.setJobName("Synchrovis Snapshot Printing");
		final PageFormat format = job.defaultPage();
		format.setOrientation(PageFormat.REVERSE_LANDSCAPE);

		// create image to be printed
		job.setPrintable(new Printable() {

			@Override
			public int print(final Graphics graphics, final PageFormat pageFormat, final int pageIndex) throws PrinterException {
				if (pageIndex > 0) {
					return NO_SUCH_PAGE;
				}
				final Graphics2D graphics2d = (Graphics2D) graphics;

				// calculate the scale factor to fit the image to the page
				final double scale = Math.min(pageFormat.getImageableWidth() / image.getWidth(), pageFormat.getImageableHeight() / image.getHeight()) * 0.9f;
				graphics2d.scale(scale, scale);

				// draw image
				graphics2d.drawImage(image, (int) Math.ceil(pageFormat.getImageableX()) * 2, (int) Math.ceil(pageFormat.getImageableY()) * 2, null);
				return PAGE_EXISTS;
			}
		}, format);

		// print image
		final PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
		aset.add(new PageRanges(1, 1));
		if (job.printDialog(aset)) {
			new PrintExecutor(job).start();
		}
	}

	/**
	 * Returns the image format in which the snapshot will be saved on disk.
	 *
	 * @return The image format.
	 */
	public static String getImageFormat() {
		return imageFormat;
	}
}
