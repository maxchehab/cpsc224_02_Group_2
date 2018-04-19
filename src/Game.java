package com.yahtzee;

import com.yahtzee.pages.*;
import com.yahtzee.state.*;
import com.yahtzee.components.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Game {

    static JFrame frame = new JFrame("Game");

    public static void main(String[] args) {

        StateManager.addState("Start", new State(new StartPage()));
        StateManager.addState("Scoring_1", new State(new Scoring_1Page()));
        StateManager.addState("Scoring_2", new State(new Scoring_2Page()));

        StateManager.addStateChangedListener(new StateChangedListener() {
            @Override
            public void onChange(State newState, State oldState) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new BackgroundPanel(1200, 800, newState.getPanel()));
                frame.revalidate();
                frame.pack();
                frame.setSize(1200, 800);
            }
        });
        StateManager.changeState("Start");

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
