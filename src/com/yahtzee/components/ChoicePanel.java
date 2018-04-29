package com.yahtzee.components;

import com.yahtzee.state.*;
import com.yahtzee.components.*;
import com.yahtzee.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComponent;

public class ChoicePanel extends JComponent {
	static final long serialVersionUID = 0;
	
	public ChoicePanel () {
		String score = "HELOW WORL";
		
        JLabel label2 = new JLabel(score);
        label2.setForeground(Color.decode("#585b5e"));
        label2.setLocation(590, 200);
        label2.setSize(100, 100);
        label2.setFont(new Font("_", Font.PLAIN, 50));
        
        add(label2);
		
	}
}
