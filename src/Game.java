package com.yahtzee;

import com.yahtzee.pages.*;
import com.yahtzee.state.*;
import com.yahtzee.components.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Game {

    private static JFrame frame = new JFrame("Game");

    private static final List<PathName> pathAndNames;
    private static final Random randomGenerator = new Random();

    static {
        List<PathName> p = new ArrayList<PathName>();
        p.add(new PathName("src/assets/images/flags/JAPAN.png", "JAPAN"));
        p.add(new PathName("src/assets/images/flags/FRANCE.png", "FRANCE"));
        p.add(new PathName("src/assets/images/flags/CHINA.png", "CHINA"));
        p.add(new PathName("src/assets/images/flags/SOVIET_UNION.png", "SOVIET UNION"));
        p.add(new PathName("src/assets/images/flags/ITALY.png", "ITALY"));
        p.add(new PathName("src/assets/images/flags/GERMANY.png", "GERMANY"));
        p.add(new PathName("src/assets/images/flags/UK.png", "UK"));
        p.add(new PathName("src/assets/images/flags/USA.png", "USA"));
        pathAndNames = Collections.unmodifiableList(p);
    }

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

    public static PathName roll() {
        int index = randomGenerator.nextInt(pathAndNames.size());
        return pathAndNames.get(index);
    }
}
