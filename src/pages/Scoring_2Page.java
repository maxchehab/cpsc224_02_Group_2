
package com.yahtzee.pages;

import com.yahtzee.state.*;
import com.yahtzee.components.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Scoring_2Page extends JPanel {
    static final long serialVersionUID = 0; // JFFrame requires a unique number.

    public Scoring_2Page() {
        JLabel label1 = new JLabel(
                "<html>Once you’re up and rolling, we need a way to keep track of where we stand against our enemies. There are many different ways to score points, but remember that each category can only be scored once!");
        label1.setForeground(Color.decode("#585b5e"));
        label1.setLocation(10, 0);
        label1.setSize(1000, 90);
        label1.setFont(new Font("_", Font.PLAIN, 20));

        JLabel label2 = new JLabel(
                "<html>The score card is broken up into lower and upper sections. Here’s a look at the <strong>UPPER SECTION:</strong>");
        label2.setForeground(Color.decode("#585b5e"));
        label2.setLocation(10, 50);
        label2.setSize(500, 200);
        label2.setFont(new Font("_", Font.PLAIN, 20));

        Image diceValuesImage = new Image("src/assets/images/upper_scorecard.png", 0.5f, 550, 120);

        JLabel label3 = new JLabel(
                "<html>Scored according to the sum of point values of a single <strong>ALLY</strong> of their choosing. However, they will receive a five-point deduction for every <strong>AXIS</strong> member in their hand. If the player can amass 65 or more points in the upper section, they will receive the <strong>ENOLA GAY</strong> bonus of 50 points.");
        label3.setForeground(Color.decode("#585b5e"));
        label3.setLocation(10, 130);
        label3.setSize(500, 300);
        label3.setFont(new Font("_", Font.PLAIN, 20));

        JLabel label4 = new JLabel(
                "<html><div style='text-align: center;'>Want to learn how to score the big points in the <strong>LOWER SECTION</strong>? Choose <strong>NEXT</strong> to find out! Or, if you want to review the dice, select <strong>PREVIOUS</strong>.");
        label4.setForeground(Color.decode("#585b5e"));
        label4.setLocation(10, 500);
        label4.setSize(1100, 100);
        label4.setFont(new Font("_", Font.PLAIN, 20));

        Button previousButton = new Button("PREVIOUS", 22, Color.WHITE, Color.decode("#585a5d"),
                Color.decode("#ed7c31"), new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        StateManager.changeState("Scoring_1");
                    }
                });
        previousButton.setBounds(100, 600, 200, 50);

        Button nextButton = new Button("NEXT", 22, Color.WHITE, Color.decode("#585a5d"), Color.decode("#bb0056"),
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("NEXT");
                    }
                });
        nextButton.setBounds(830, 600, 200, 50);

        setBackground(Color.decode("#e7e6e6"));
        setLayout(null);
        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(diceValuesImage);
        add(previousButton);
        add(nextButton);
    }
}