/* 
 * BackgroundPanel represents the default background panel
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

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {
    private JPanel attachedPanel = new JPanel();

    static final long serialVersionUID = 0; // JFrame requires a unique number.

    /*
     * BackgroundPanel creates and initializes the default background panel
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    public BackgroundPanel(int width, int height, JPanel panel) {
        JLabel label = new JLabel("WWII Yahtzee");
        label.setFont(new Font("_", Font.BOLD, 32));
        label.setForeground(Color.WHITE);
        label.setLocation(15, 15);
        label.setSize(300, 30);

        panel.setBounds(15, 15, width - 60, height - 120);

        attachedPanel.setBackground(Color.decode("#aeabab"));
        attachedPanel.setBounds(15, 45, width - 30, height - 90);
        attachedPanel.setLayout(null);
        attachedPanel.add(panel);

        setBackground(Color.decode("#006fc0"));
        setLayout(null);
        add(label);
        add(attachedPanel);
    }
}