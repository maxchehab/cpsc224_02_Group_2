package com.yahtzee.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Button extends JButton {
    static final long serialVersionUID = 0;

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