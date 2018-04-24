package com.yahtzee.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComponent;

public class FlagDice extends JComponent {
    static final long serialVersionUID = 0;
    static final int width = 100;
    static final int height = 130;

    public FlagDice(PathName pathName, int x, int y) {

        Flag flag = new Flag(pathName.path, pathName.name, 0, 0);

        JCheckBox checkbox = new JCheckBox();
        checkbox.setBounds(37, height - 30, 30, 30);
        checkbox.setSize(30, 30);
        checkbox.setBackground(Color.decode("#aeabab"));

        try {
            Image selectedImage = ImageIO.read(new File("src/assets/images/selected.png"));
            checkbox.setSelectedIcon(new ImageIcon(selectedImage));

            Image unselectedImage = ImageIO.read(new File("src/assets/images/unselected.png"));
            checkbox.setIcon(new ImageIcon(unselectedImage));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        add(flag);
        add(checkbox);
        setLocation(x, y);
    }

    @Override
    public void setLocation(int x, int y) {
        setBounds(x, y, width, height);
        setSize(width, height);
    }
}