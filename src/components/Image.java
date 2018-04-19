package com.yahtzee.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Dimension;

import java.io.File;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Image extends JComponent {

    static final long serialVersionUID = 0;

    private BufferedImage image;
    private float scale = 1.0f;

    public Image(String path) {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException ex) {
            System.out.println("Could not find the image: " + path);
        }
    }

    public Image(String path, float scale) {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException ex) {
            System.out.println("Could not find the image: " + path);
        }
        this.scale = scale;
    }

    public Image(String path, float scale, int x, int y) {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException ex) {
            System.out.println("Could not find the image: " + path);
        }

        this.scale = scale;
        setLocation(x, y);
    }

    public void setScale(float s) {
        scale = s;
    }

    @Override
    public void setLocation(int x, int y) {
        setBounds(x, y, Math.round(getWidth() * scale), Math.round(getHeight() * scale));
        setSize(Math.round(getWidth() * scale), Math.round(getHeight() * scale));
    }

    @Override
    public int getWidth() {
        return image.getWidth();
    }

    @Override
    public int getHeight() {
        return image.getHeight();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, Math.round(getWidth() * scale), Math.round(getHeight() * scale), null);
    }

}