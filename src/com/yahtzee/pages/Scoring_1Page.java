/* 
 * Scoring_1Page is a the UI for the Game's Scoring 1 Page
 * 
 * CPSC 224-02, Spring 2018
 * Final Project
 * 
 * @author Maxwell Chehab 
 *
 * @version v1.0 5/02/18 
 */

package com.yahtzee.pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.yahtzee.components.Button;
import com.yahtzee.components.Image;
import com.yahtzee.state.StateManager;

public class Scoring_1Page extends JPanel {
    static final long serialVersionUID = 0; // JFFrame requires a unique number.

    /*
     * Scoring_1Page initializes all UI elements for the Scoring Page 1
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    public Scoring_1Page() {
        JLabel label1 = new JLabel("<html>Welcome to the war! We’re glad to have your help on this one, commandant.");
        label1.setForeground(Color.decode("#585b5e"));
        label1.setLocation(10, 0);
        label1.setSize(1000, 60);
        label1.setFont(new Font("_", Font.PLAIN, 22));

        JLabel label2 = new JLabel(
                "<html><strong>THE DICE</strong>: The game is played with eight eight-sided dice. On three sides, there are flags of the <strong>AXIS</strong> powers alliance, and the other five are the <strong>ALLIES</strong>. You may roll the dice up to three times, each time choosing which of the dice you would like to keep and which you would like to re-roll. The values of each country are listed in the table below.");
        label2.setForeground(Color.decode("#585b5e"));
        label2.setLocation(10, 60);
        label2.setSize(1100, 100);
        label2.setFont(new Font("_", Font.PLAIN, 22));

        Image diceValuesImage = new Image("src/assets/images/dice_values.png");
        diceValuesImage.setLocation(350, 180);

        JLabel label3 = new JLabel(
                "<html>How are we going to win this thing? Keep going to find out! Or, select previous to return to the main menu.");
        label3.setForeground(Color.decode("#585b5e"));
        label3.setLocation(10, 410);
        label3.setSize(1100, 60);
        label3.setFont(new Font("_", Font.PLAIN, 22));

        Button previousButton = new Button("PREVIOUS", 22, Color.WHITE, Color.decode("#585a5d"),
                Color.decode("#ed7c31"), new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        StateManager.changeState(StateManager.CHANGE_PANEL, new StartPage());
                    }
                });
        previousButton.setBounds(100, 500, 200, 50);

        Button nextButton = new Button("NEXT", 22, Color.WHITE, Color.decode("#585a5d"), Color.decode("#bb0056"),
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        StateManager.changeState(StateManager.CHANGE_PANEL, new Scoring_2Page());
                    }
                });
        nextButton.setBounds(830, 500, 200, 50);

        setBackground(Color.decode("#e7e6e6"));
        setLayout(null);
        add(label1);
        add(label2);
        add(label3);
        add(diceValuesImage);
        add(previousButton);
        add(nextButton);
    }
}