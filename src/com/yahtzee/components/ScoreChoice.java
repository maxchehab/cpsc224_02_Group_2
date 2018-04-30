/**
 * Creates a button that displays a) the category to be scored and b) the number of points that will be obtained
 * if that category is chosen.
 * 
 * @author afellger
 */
package com.yahtzee.components;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import com.yahtzee.Game;
import com.yahtzee.pages.ScoringCard_1;
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

    /**
     * creates a ScoreChoice
     * @param String path: address of the image associated with the scoring option index
     * @param int points: the number of points that will be obtained by selecting the ScoreChoice
     * @param int index: the index of the category associated with path and points
     * @param int x: the desired horizontal location of placement
     * @param int y: the desired vertical location of placement
     */
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
                    		if(Game.round < Card.CARD_SIZE)
                    			StateManager.changeState(StateManager.CHANGE_PANEL, new ScoringCard_1());
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
