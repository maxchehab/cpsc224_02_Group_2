package com.yahtzee.components;

import com.yahtzee.pages.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.Graphics;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.yahtzee.state.StateManager;
import com.yahtzee.pages.Scoring_OptionsPage;
import com.yahtzee.components.Image;

public class ScoreChoice extends JComponent {
	
	static final long serialVersionUID = 0;
    static final int width = 500;
    static final int height = 50;

    public Boolean picked = false;
    public int x, y;
    public String option;
    public int categoryIndex;

    public ScoreChoice(String path, int points, int index, int x, int y) {

        this.x = x;
        this.y = y;
        categoryIndex = index;
        
        Image Score = new Image(path, 0.2f, 0, 0);
        
        String score = "";
        score += points;
        
        JLabel label2 = new JLabel(score);
        label2.setForeground(Color.decode("#585b5e"));
        label2.setLocation(363, 1);
        label2.setSize(60, 40);
        label2.setFont(new Font("_", Font.PLAIN, 25));
        
        Button choiceButton = new Button("HEY hey ", 22, Color.WHITE, Color.decode("#585a5d"), Color.decode("#bb0056"),
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	 	StateManager.changeState(StateManager.CHOSEN_SCORE, categoryIndex);
                        StateManager.changeState(StateManager.CHANGE_PANEL, new Roll_1Page());
                       
                    }
                });
        
        choiceButton.setBounds(0, 0, 200, 60);
        add(choiceButton);
        add(label2);
        add(Score);
        setLocation(x, y);
        
    }
   

    @Override
    public void setLocation(int x, int y) {
        setBounds(x, y, width, height);
        setSize(width, height);
    }
}
