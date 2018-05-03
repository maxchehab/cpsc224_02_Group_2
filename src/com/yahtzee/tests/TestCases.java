/* 
 * TestCases tests the entire project.
 * 
 * CPSC 224-02, Spring 2018
 * Final Project
 * 
 * @author Maxwell Chehab 
 *
 * @version v1.0 5/02/18 
 */

package com.yahtzee.tests;

import com.yahtzee.components.*;
import com.yahtzee.state.*;
import com.yahtzee.pages.*;
import com.yahtzee.*;

import org.junit.*;
import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Transient;

import javax.swing.JPanel;

public class TestCases {

    /*
     * testGameRoll test the Game roll function
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testGameRoll() {
        assertNotNull(Game.roll());
    }

    /*
     * testResetGame tests reseting the game
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testResetGame() {
        Game.round = 20;
        assertEquals(Game.round, 20);
        Game.resetGame();
        assertEquals(Game.round, 1);
    }

    /*
     * testStateManangerNullState tests if queuering a item that doesn't exists, a
     * null object will return
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testStateManagerNullState() {
        Object state = StateManager.getState("STATE THAT DOES NOT EXISTS");
        assertNull(state);
    }

    /*
     * testStateManagerChangeState tests if an one can change the state of an item.
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testStateManagerChangeState() {
        Integer myState = 10;
        StateManager.changeState("TEST", myState);
        Object state = StateManager.getState("TEST");
        assertTrue(myState instanceof Integer);
        assertEquals(myState, state);
    }

    /*
     * testStateChangedListener tests the StateChangedListener interface.
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testStateChangedListener() {
        Integer myState = 10;

        StateManager.addStateChangedListener(new StateChangedListener() {

            @Override
            public void onChange(String key, Object state) {
                if (key == "TEST") {
                    assertEquals(key, "TEST");
                    assertTrue(state instanceof Integer);
                    assertEquals(state, myState);
                }
            }

        });
        StateManager.changeState("TEST", myState);
    }

    /*
     * testStartPage tests the creation of the start page.
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testStartPage() {
        assertNotNull(new StartPage());
    }

    /*
     * testScoring_1Page tests the creation of a scoring page 1
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testScoring_1Page() {
        assertNotNull(new Scoring_1Page());
    }

    /*
     * testScoring_2Page tests the creation of a scoring page 2
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testScoring_2Page() {
        assertNotNull(new Scoring_2Page());
    }

    /*
     * testScoring_3Page tests the creation of a scoring page 3
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testScoring_3Page() {
        assertNotNull(new Scoring_3Page());
    }

    /*
     * testScoring_OptionsPage tests the scoring options page
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testScoring_OptionsPage() {
        assertNotNull(new Scoring_OptionsPage());
    }

    /*
     * testScoringCard_1 test the creation of the scoring card 1 page
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testScoringCard_1() {
        assertNotNull(new ScoringCard_1());
    }

    /*
     * testScoringCard_2 test the creation of the scoring card 2 page
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testScoringCard_2() {
        assertNotNull(new ScoringCard_2());
    }

    /*
     * testRoll_1Page test the creation of the roll 1 page
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testRoll_1Page() {
        assertNotNull(new Roll_1Page());
    }

    /*
     * testRoll_2Page test the creation of the roll 2 page
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testRoll_2Page() {
        assertNotNull(new Roll_2Page());
    }

    /*
     * testBackgroundPanel tests the creation of a background panel
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testBackgroundPanel() {
        assertNotNull(new BackgroundPanel(0, 0, new JPanel()));
    }

    /*
     * testButton tests the creation of a button
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testButton() {
        assertNotNull(new Button("label", 0, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0),
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                }));
    }

    /*
     * testCard test the creation of a Card
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testCard() {
        assertNotNull(new Card());
    }

    /*
     * testFinalDie tests the creation of a final die
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testFinalDie() {
        assertNotNull(new FinalDie("src/assets/images/flags/JAPAN.png", 0, 0));
    }

    /*
     * testFlag test the creation of a flag
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testFlag() {
        assertNotNull(new Flag("src/assets/images/flags/JAPAN.png", "flag", 0, 0));
    }

    /*
     * testFlagDice tests teh creation of a flag dice
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testFlagDice() {
        assertNotNull(new FlagDice(new PathName("src/assets/images/flags/JAPAN.png", "test"), 0, 0));
    }

    /*
     * testImage tests the creation of an Image
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testImage() {
        assertNotNull(new Image("src/assets/images/flags/JAPAN.png"));
    }

    /*
     * testPathName tests the creation of a PathName
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testPathName() {
        assertNotNull(new PathName("src/assets/images/flags/JAPAN.png", "test"));
    }

    /*
     * TODO testScoreCalculator tests the score calculator
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testScoreCalculator() {
        // assertNotNull(new ScoreCalculator(round));
    }

    /*
     * testScoreChoice tests the creation of score choice
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testScoreChoice() {
        assertNotNull(new ScoreChoice("src/assets/images/flags/JAPAN.png", 10, 0, 1, 1));
    }

    /*
     * testScoringDice tests the creation of a scoring dice.
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    @Test
    public void testScoringDice() {
        assertNotNull(new ScoringDice(new PathName("src/assets/images/flags/JAPAN.png", "name")));
    }
}
