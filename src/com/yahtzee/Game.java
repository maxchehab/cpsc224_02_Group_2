/* 
 * Game is a representation the higher-level Yahtzee game.
 * 
 * CPSC 224-02, Spring 2018
 * Final Project
 * 
 * @author Maxwell Chehab 
 *
 * @version v1.0 5/02/18 
 */

package com.yahtzee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.yahtzee.components.BackgroundPanel;
import com.yahtzee.components.Card;
import com.yahtzee.components.PathName;
import com.yahtzee.components.ScoringDice;
import com.yahtzee.pages.StartPage;
import com.yahtzee.state.StateChangedListener;
import com.yahtzee.state.StateManager;

public class Game {

    private static JFrame frame = new JFrame("Game");

    private static final List<PathName> pathAndNames;
    private static final Random randomGenerator = new Random();

    public final static int CARD_SIZE = 13;
    public final static int HAND_SIZE = 8;
    public final static int DIE_SIZE = 8;

    public static ScoringDice[] hand;

    enum Country {
        UK, USA, SOVIET_UNION, FRANCE, CHINA, JAPAN, ITALY, GERMANY
    };

    enum Allegiance {
        ALLIES, AXIS
    };

    public static Card play;
    public static int round;

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

    /*
     * Main resets round, creats a new card, adds an additional state listener,
     * changes the state to the initial panel.
     * 
     * @param String[] represent command line arguments
     * 
     * @returns void
     * 
     * @throw null
     */
    public static void main(String[] args) {
        round = 1;

        play = new Card();

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

    /*
     * roll returns a random pathname from the static list pathAndNames.
     * 
     * @param null
     * 
     * @returns Pathname
     * 
     * @throw null
     */
    public static PathName roll() {
        int index = randomGenerator.nextInt(pathAndNames.size());
        return pathAndNames.get(index);
    }

    /*
     * @returns void resetGame selects the round to 1 and assigns the play card to a
     * new card.
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    public static void resetGame() {
        round = 1;
        play = new Card();
    }

}
