/*
 * AppleCommander - An Apple ][ image utility.
 * Copyright (C) 2002-2003 by Robert Greene
 * robgreene at users.sourceforge.net
 *
 * This program is free software; you can redistribute it and/or modify it 
 * under the terms of the GNU General Public License as published by the 
 * Free Software Foundation; either version 2 of the License, or (at your 
 * option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License 
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along 
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package com.webcodepro.applecommander.storage.filters.imagehandlers;

import com.sun.image.codec.jpeg.JPEGCodec;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * SunJpegImage is a specific implementation of AppleImage that handles all
 * SUN JPEG codec related coding surrounding image manipulation.  This is 
 * available only on SUN JVMs.
 * <p>
 * Date Created: Mar 25, 2003
 * @author Rob Greene
 */
public class SunJpegImage extends AppleImage {
	private BufferedImage image;
	/**
	 * Create SunJpegImage.  Verifies all (known) required classes are available
	 * as well as sets up the class.
	 */
	public SunJpegImage(int width, int height) throws ClassNotFoundException {
		super(new String[] { "JPEG" });
		Class.forName("com.sun.image.codec.jpeg.JPEGCodec");
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	}
	/**
	 * Set a color point.
	 */
	public void setPoint(int x, int y, int color) {
		image.setRGB(x, y, color);
	}
	/**
	 * Save the image.
	 */
	public void save(OutputStream outputStream) throws IOException {
		JPEGCodec.createJPEGEncoder(outputStream).encode(image);
	}
}
