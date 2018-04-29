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

public class Flag extends JComponent {
    static final long serialVersionUID = 0;

    static final int width = 100;
    static final int height = 100;

    public Flag(String path, String name, int x, int y) {

        Image flag = new Image(path, 0.6f, 14, 10);

        JLabel nameLabel = new JLabel(name, SwingConstants.CENTER);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setLocation(0, 60);
        nameLabel.setSize(width, 30);
        nameLabel.setFont(new Font("_", Font.PLAIN, limit(18 * 6 / name.length(), 12, 18)));

        setBackground(Color.decode("#585a5d"));
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        setLocation(x, y);
        
        add(flag);
        add(nameLabel);
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

    public int limit(int value, int min, int max) {
        return Math.max(min, Math.min(value, max));
    }
}