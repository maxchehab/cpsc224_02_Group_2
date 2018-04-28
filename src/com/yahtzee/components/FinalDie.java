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


public class FinalDie extends JComponent{
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
