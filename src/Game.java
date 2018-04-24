package com.yahtzee;

import com.yahtzee.pages.*;
import com.yahtzee.state.*;
import com.yahtzee.components.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game {

    static JFrame frame = new JFrame("Game");

    public static void main(String[] args) {

        StateManager.addStateChangedListener(new StateChangedListener() {
            @Override
            public void onChange(String key, Object state) {
                if (key == StateManager.CHANGE_PANEL && state instanceof JPanel) {
                    JPanel panel = (JPanel) state;
                    frame.getContentPane().removeAll();
                    frame.getContentPane().add(new BackgroundPanel(1200, 800, panel));
                    frame.revalidate();
                    frame.pack();
                    frame.setSize(1200, 800);
                }

                if (key == StateManager.EXIT && state instanceof Integer) {
                    System.exit((Integer) state);
                }
            }
        });

        StateManager.changeState(StateManager.CHANGE_PANEL, new StartPage());

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
