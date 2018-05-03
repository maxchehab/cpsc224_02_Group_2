/* 
 * FlagDice represents an image and checkbox of dice
 * 
 * CPSC 224-02, Spring 2018
 * Final Project
 * 
 * @author Maxwell Chehab 
 *
 * @version v1.0 5/02/18 
 */

package com.yahtzee.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComponent;

import com.yahtzee.state.StateManager;

public class FlagDice extends JComponent {
    static final long serialVersionUID = 0;
    static final int width = 100;
    static final int height = 130;

    private JCheckBox checkbox = new JCheckBox();

    public Boolean keep = false;
    public int x, y;
    public PathName pathName;
    public PathName flagImage;

    /*
     * Creates a flag dice given a PathName and FlagDice (copy constructor)
     * 
     * @param PathName pathName, FlagDice flagDice
     * 
     * @returns void
     * 
     * @throw null
     */
    public FlagDice(PathName pathName, FlagDice flagDice) {
        this(pathName, flagDice.x, flagDice.y);
    }

    /*
     * Creates a FlagDice given a pathname and x and y coordinate
     * 
     * @param PathName pathName, int x, int y
     * 
     * @returns void
     * 
     * @throw null
     */
    public FlagDice(PathName pathName, int x, int y) {

        Flag flag = new Flag(pathName.path, pathName.name, 0, 0);

        flagImage = pathName;

        this.pathName = pathName;
        this.x = x;
        this.y = y;

        checkbox.setBounds(37, height - 30, 30, 30);
        checkbox.setSize(30, 30);
        checkbox.setBackground(Color.decode("#aeabab"));
        checkbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                keep = e.getStateChange() == ItemEvent.SELECTED;
                StateManager.changeState(StateManager.UPDATE_FLAGDICE, 0);
            }
        });

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

    /*
     * returns the current PathName
     * 
     * @param null
     * 
     * @returns PathName
     * 
     * @throw null
     */
    public PathName getPathName() {
        return this.pathName;
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
        setBounds(x, y, width, height);
        setSize(width, height);
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
        checkbox.setSelected(keep);
    }

    /*
     * limit, limits an integer between a min and a max (constrain)
     * 
     * @param int value, int min, int max
     * 
     * @returns int
     * 
     * @throw null
     */
    public int limit(int value, int min, int max) {
        return Math.max(min, Math.min(value, max));
    }
}