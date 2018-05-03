/* 
 * Scoring_3Page is a the UI for the Game's Scoring 3 Page
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
import javax.swing.JTable;

import com.yahtzee.components.Button;
import com.yahtzee.state.StateManager;

public class Scoring_3Page extends JPanel {
    static final long serialVersionUID = 0; // JFFrame requires a unique number.

    /*
     * Scoring_3Page initializes all UI elements for the Scoring Page 3
     * 
     * @param null
     * 
     * @returns void
     * 
     * @throw null
     */
    public Scoring_3Page() {
        JLabel label1 = new JLabel(
                "<html>The most important part of your job is to score in the <strong>LOWER SECTION</strong>. It is made up of seven different special missions that will get you a specified number of points for completing them. There’s also <strong>D-DAY:</strong> your chance to get points when all else fails.  It allows you to earn points by summing up all of the <strong>ALLY</strong> dice in your hand, and ignoring any deductions from <strong>AXIS</strong> dice.");
        label1.setForeground(Color.decode("#585b5e"));
        label1.setLocation(10, 10);
        label1.setSize(1000, 90);
        label1.setFont(new Font("_", Font.PLAIN, 20));

        JLabel label2 = new JLabel("<html>The missions are scored and completed as follows:");
        label2.setForeground(Color.decode("#585b5e"));
        label2.setLocation(10, 130);
        label2.setSize(1000, 30);
        label2.setFont(new Font("_", Font.PLAIN, 20));

        JLabel label3 = new JLabel(
                "<html><div style='text-align: center;'>If you’re ready to start the war, select <strong>PLAY</strong>. If you’d like to review the <strong>UPPER SECTION</strong> instructions, select <strong>PREVIOUS</strong>.");
        label3.setForeground(Color.decode("#585b5e"));
        label3.setLocation(10, 500);
        label3.setSize(1100, 100);
        label3.setFont(new Font("_", Font.PLAIN, 20));

        JTable table = new JTable(new Object[][] { { "CEASE-FIRE", "30", "4 AXIS and 4 ALLIES" },
                { "TREATY OF FRIENDSHIP", "30", "3 Germany and 3 Soviet Union" },
                { "BIG THREE", "50", "2 US, 2 UK, 2 Soviet Union" },
                { "AROUND THE WORLD", "60", "one of each country" }, { "UNITED NATIONS", "70", "all ALLIES" },
                { "TRIPARTITE PACT", "70", "all AXIS  members" }, { "PEAL HARBOR", "100", "all one country" }, },
                new Object[] { "Name", "Points", "Description" }) {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };

        table.setFont(new Font("_", Font.PLAIN, 18));
        table.setForeground(Color.decode("#585b5e"));
        table.setBackground(Color.decode("#e7e6e6"));
        table.setSize(1000, 200);
        table.setRowHeight(25);
        table.setLocation(40, 200);
        table.setRowSelectionAllowed(false);
        table.setColumnSelectionAllowed(false);
        table.setCellSelectionEnabled(false);
        table.setFocusable(false);

        Button previousButton = new Button("PREVIOUS", 22, Color.WHITE, Color.decode("#585a5d"),
                Color.decode("#ed7c31"), new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        StateManager.changeState(StateManager.CHANGE_PANEL, new Scoring_2Page());
                    }
                });
        previousButton.setBounds(100, 600, 200, 50);

        Button nextButton = new Button("PLAY", 22, Color.WHITE, Color.decode("#585a5d"), Color.decode("#bb0056"),
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        StateManager.changeState(StateManager.CHANGE_PANEL, new Roll_1Page());
                    }
                });
        nextButton.setBounds(830, 600, 200, 50);

        setBackground(Color.decode("#e7e6e6"));
        setLayout(null);
        add(label1);
        add(label2);
        add(label3);
        add(table);
        add(previousButton);
        add(nextButton);
    }
}