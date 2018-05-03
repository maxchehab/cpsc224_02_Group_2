/* 
 * Image represents any Image
 * 
 * CPSC 224-02, Spring 2018
 * Final Project
 * 
 * @author Maxwell Chehab 
 *
 * @version v1.0 5/02/18 
 */

package com.yahtzee.components;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Image extends JComponent {

    static final long serialVersionUID = 0;

    private BufferedImage image;
    private float scale = 1.0f;

    /*
     * Image creates an image given a path to an image
     * 
     * @param String path
     * 
     * @returns void
     * 
     * @throw null
     */
    public Image(String path) {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /*
     * Image creates an image given a path to an image and a scale
     * 
     * @param String path, float scale
     * 
     * @returns void
     * 
     * @throw null
     */
    public Image(String path, float scale) {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        this.scale = scale;
    }

    /*
     * Image creates and places an image given a path, scale, x and y coordinate
     * 
     * @param String path, float scale, int x, int y
     * 
     * @returns void
     * 
     * @throw null
     */
    public Image(String path, float scale, int x, int y) {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        this.scale = scale;
        setLocation(x, y);
    }

    /*
     * setLocation sets the bounding box and size for the image
     * 
     * @param int x, int y
     * 
     * @returns void
     * 
     * @throw null
     */
    @Override
    public void setLocation(int x, int y) {
        setBounds(x, y, Math.round(getWidth() * scale), Math.round(getHeight() * scale));
        setSize(Math.round(getWidth() * scale), Math.round(getHeight() * scale));
    }

    /*
     * getWidth returns the width of the image
     * 
     * @param null
     * 
     * @returns int
     * 
     * @throw null
     */
    @Override
    public int getWidth() {
        if (image == null) {
            return 0;
        }
        return image.getWidth();
    }

    /*
     * getWidth returns the height of the image
     * 
     * @param null
     * 
     * @returns int
     * 
     * @throw null
     */
    @Override
    public int getHeight() {
        if (image == null) {
            return 0;
        }
        return image.getHeight();
    }

    /*
     * paintComponent paints the component with the image as the background
     * 
     * @param Graphics g
     * 
     * @returns int
     * 
     * @throw null
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, Math.round(getWidth() * scale), Math.round(getHeight() * scale), null);
    }

}