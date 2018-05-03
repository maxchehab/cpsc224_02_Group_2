/* 
 * Button represents a custom button
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
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Button extends JButton {
    static final long serialVersionUID = 0;

    /*
     * Button creates a custom button
     * 
     * @param String label, int size, Color foreground, Color background, Color
     * border, ActionListener listener
     * 
     * @returns void
     * 
     * @throw null
     */
    public Button(String label, int size, Color foreground, Color background, Color border, ActionListener listener) {
        super(label);

        setFont(new Font("_", Font.PLAIN, size));
        setForeground(foreground);
        setBackground(background);
        setFocusPainted(false);
        addActionListener(listener);
        setBorder(BorderFactory.createLineBorder(border, 2));
    }
}