
package com.yahtzee.pages;

import com.yahtzee.state.*;
import com.yahtzee.components.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartPage extends JPanel {
    static final long serialVersionUID = 0; // JFFrame requires a unique number.

    public StartPage() {
        JLabel label1 = new JLabel("<html>Welcome to <strong>World War II Yahtzee!</strong>");
        label1.setForeground(Color.decode("#585b5e"));
        label1.setLocation(10, 0);
        label1.setSize(600, 50);
        label1.setFont(new Font("_", Font.PLAIN, 22));

        JLabel label2 = new JLabel(
                "<html>Your goal is to bring the <strong>ALLIES</strong> to victory over the <strong>AXIS POWERS</strong> alliance by scoring as many points as possible!");
        label2.setForeground(Color.decode("#585b5e"));
        label2.setLocation(10, 60);
        label2.setSize(1100, 50);
        label2.setFont(new Font("_", Font.PLAIN, 22));

        JLabel label3 = new JLabel(
                "<html>If you’ve already been briefed, click <strong>PLAY</strong> to begin now! Otherwise, select <strong>INSTRUCTIONS</strong> to learn about your mission!");
        label3.setForeground(Color.decode("#585b5e"));
        label3.setLocation(10, 130);
        label3.setSize(1100, 50);
        label3.setFont(new Font("_", Font.PLAIN, 22));

        Button playButton = new Button("PLAY", 22, Color.WHITE, Color.decode("#585a5d"), Color.decode("#bb0056"),
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        StateManager.changeState("Roll_1");
                    }
                });
        playButton.setBounds(470, 250, 200, 50);

        Button helpButton = new Button("INSTRUCTIONS", 22, Color.WHITE, Color.decode("#585a5d"),
                Color.decode("#ffc000"), new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        StateManager.changeState("Scoring_1");
                    }
                });
        helpButton.setBounds(420, 325, 300, 50);

        Button exitButton = new Button("EXIT", 22, Color.WHITE, Color.decode("#585a5d"), Color.decode("#52793b"),
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        StateManager.changeState("EXIT");
                    }
                });
        exitButton.setBounds(470, 400, 200, 50);

        setBackground(Color.decode("#e7e6e6"));
        setLayout(null);
        add(label1);
        add(label2);
        add(label3);
        add(playButton);
        add(helpButton);
        add(exitButton);

    }
}