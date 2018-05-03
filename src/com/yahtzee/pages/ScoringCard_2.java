/* 
 * ScoringCard_2 is a the UI for the Game's Scoring card 2 page
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

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.yahtzee.Game;
import com.yahtzee.components.Button;
import com.yahtzee.components.Card;
import com.yahtzee.components.Image;
import com.yahtzee.state.StateManager;

public class ScoringCard_2 extends JPanel {
    static final long serialVersionUID = 0; // JFFrame requires a unique number.

    public static int upperTotal;
    public static int enolaGay;
    public static int lowerTotal;
    public static int grandTotal;

    /*
     * ScoringCard_2 initializes all UI elements for the Scoring Card 2
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    public ScoringCard_2() {

        JLabel label1 = new JLabel(
                "<html><div style='padding-bottom: 5; border-bottom: 2px solid #585b5e; width: 500; text-align: center;'>Here's you <strong>FINAL</strong> Scorecard");
        label1.setForeground(Color.decode("#414446"));
        label1.setLocation(315, 10);
        label1.setSize(500, 60);
        label1.setFont(new Font("_", Font.PLAIN, 20));

        updateTotals();

        JTable table1 = new JTable(
                new Object[][] { { "", "<html><div text-align: center;'><strong>UPPER SCORECARD</strong>", "Points" },
                        { "", "ROOSEVELT", Game.play.getScore(0) }, { "", "STALIN", Game.play.getScore(1) },
                        { "", "CHURCHILL", Game.play.getScore(2) }, { "", "KAI-SHAK", Game.play.getScore(3) },
                        { "", "DALADIER", Game.play.getScore(4) }, { "", "ENOLA GAY", getString(enolaGay) },
                        { "", "<html><div text-align: center;'><strong>UPPER TOTAL</strong>", getString(upperTotal) } },
                new Object[] { "LowerSection", "Points", "Description" }) {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };

        float scale = 0.4f;
        Image[] images = { new Image("src/assets/images/flags/USA.png", scale, 30, 160),
                new Image("src/assets/images/flags/SOVIET_UNION.png", scale, 30, 210),
                new Image("src/assets/images/flags/UK.png", scale, 30, 260),
                new Image("src/assets/images/flags/CHINA.png", scale, 30, 310),
                new Image("src/assets/images/flags/FRANCE.png", scale, 30, 360) };

        for (int k = 0; k < 5; k++) {
            add(images[k]);
        }

        table1.setFont(new Font("_", Font.PLAIN, 20));
        table1.setForeground(Color.decode("#585b5e"));
        table1.setBackground(Color.WHITE);
        table1.setSize(550, 400);
        table1.setRowHeight(50);
        table1.setLocation(10, 100);
        table1.setRowSelectionAllowed(false);
        table1.setColumnSelectionAllowed(false);
        table1.setCellSelectionEnabled(false);
        table1.setFocusable(false);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table1.getColumnModel().getColumn(0).setPreferredWidth(100);
        table1.getColumnModel().getColumn(1).setPreferredWidth(375);
        table1.getColumnModel().getColumn(2).setPreferredWidth(75);

        JTable table = new JTable(new Object[][] {
                { "<html><div style='margin-left: 100;'><strong>   LOWER SCORECARD</strong>", "Points" },
                { "   CEASE-FIRE", Game.play.getScore(5) }, { "   TREATY OF FRIENDSHIP", Game.play.getScore(6) },
                { "   BIG THREE", Game.play.getScore(7) }, { "   AROUND THE WORLD", Game.play.getScore(8) },
                { "   UNITED NATIONS", Game.play.getScore(9) }, { "   TRIPARTITE PACT", Game.play.getScore(10) },
                { "   PEAL HARBOR", Game.play.getScore(11) }, { "   D-DAY", Game.play.getScore(12) },
                { "<html><div style='margin-left: 100;'><strong>LOWER TOTAL</strong>", getString(lowerTotal) } },
                new Object[] { "", "" }) {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };

        table.setFont(new Font("_", Font.PLAIN, 20));
        table.setForeground(Color.decode("#585b5e"));
        table.setBackground(Color.WHITE);
        table.setSize(550, 400);
        table.setRowHeight(40);
        table.setLocation(580, 100);
        table.setRowSelectionAllowed(false);
        table.setColumnSelectionAllowed(false);
        table.setCellSelectionEnabled(false);
        table.setFocusable(false);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(475);
        table.getColumnModel().getColumn(1).setPreferredWidth(75);

        Button ExitButton = new Button("EXIT", 22, Color.WHITE, Color.decode("#585a5d"), Color.decode("#ed7c31"),
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        StateManager.changeState(StateManager.EXIT, 1);
                    }
                });
        ExitButton.setBounds(100, 600, 200, 50);

        Button NewGameButton = new Button("NEW GAME", 22, Color.WHITE, Color.decode("#585a5d"), Color.decode("#ed7c31"),
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Game.resetGame();
                        StateManager.changeState(StateManager.CHANGE_PANEL, new Roll_1Page());
                    }
                });

        NewGameButton.setBounds(830, 600, 200, 50);

        JLabel total = new JLabel(
                "<html><div style='width: 300; text-align: center;'><strong>GRAND TOTAL: </strong>" + grandTotal);
        total.setForeground(Color.decode("#414446"));
        total.setBackground(Color.WHITE);
        total.setLocation(420, 520);
        total.setSize(300, 60);
        total.setFont(new Font("_", Font.PLAIN, 20));
        total.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        setBackground(Color.decode("#e7e6e6"));
        setLayout(null);
        add(label1);
        add(table);
        add(table1);
        add(ExitButton);
        add(total);
        add(NewGameButton);
    }

    public static void updateTotals() {
        if (Game.play.score == null) {
            return;
        }
        upperTotal = 0;
        enolaGay = 0;
        lowerTotal = 0;
        grandTotal = 0;

        for (int k = 0; k < 5; k++) {
            upperTotal += Game.play.score[k];
        }

        if (upperTotal > 65) {
            enolaGay = 50;
            upperTotal += enolaGay;
        }

        for (int k = 5; k < Card.CARD_SIZE; k++) {
            lowerTotal += Game.play.score[k];
        }

        grandTotal = lowerTotal + upperTotal;
    }

    public String getString(int toConvert) {
        String scoreString = "";
        scoreString += toConvert;
        return scoreString;
    }
}
