/**
 * a small flag image meant to be displayed on a Scoring_OptionsPage.
 * 
 * @author afellger
 */
package com.yahtzee.components;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

public class FinalDie extends JComponent {
    static final long serialVersionUID = 0;

    static final int width = 50;
    static final int height = 50;

    public FinalDie(String path, int x, int y) {

        Image flag = new Image(path, 0.35f, 4, 10);

        setBackground(Color.decode("#585a5d"));
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        setLocation(x, y);

        add(flag);
    }

    @Override
    public void setLocation(int x, int y) {
        setBounds(x, y, width, height);
        setSize(width, height);
    }

}
