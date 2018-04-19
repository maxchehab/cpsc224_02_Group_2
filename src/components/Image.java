package com.yahtzee.components;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Image extends JPanel {

    private BufferedImage image;

    public Image(String path) {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException ex) {
            System.out.println("Could not find the image: " + path);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

}