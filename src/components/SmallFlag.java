package com.yahtzee.components;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SmallFlag extends JComponent {
    static final long serialVersionUID = 0;

    static final int width = 50;
    static final int height = 50;

    public SmallFlag(FlagDice flagDice, int x, int y) {

        Image flag = new Image(flagDice.pathName.path, 0.35f, 4, 12);

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

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getBackground());
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
}