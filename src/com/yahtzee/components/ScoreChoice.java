package com.yahtzee.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JLabel;

import com.yahtzee.Game;
import com.yahtzee.pages.ScoringCard_1;
import com.yahtzee.pages.AlternateCard;
import com.yahtzee.pages.ScoringCard_2;
import com.yahtzee.state.StateManager;

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

        Button choiceButton = new Button("                                              " + points, 22, Color.BLACK, Color.GRAY, Color.BLACK,
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    		Game.play.score[index] = points;
                    		Game.play.usable[index] = false;
                    		if(Game.round < 12)
                    			StateManager.changeState(StateManager.CHANGE_PANEL, new AlternateCard());
                    		else
                    			StateManager.changeState(StateManager.CHANGE_PANEL, new ScoringCard_2());
                    }
                });

        choiceButton.setBounds(0, 0, 423, 42);
        choiceButton.setOpaque(false);
        choiceButton.setContentAreaFilled(false);
        choiceButton.setBorderPainted(false);
        
        add(choiceButton);
        add(Score);
        setLocation(x, y);

    }

    @Override
    public void setLocation(int x, int y) {
        setBounds(x, y, width, height);
        setSize(width, height);
    }
}