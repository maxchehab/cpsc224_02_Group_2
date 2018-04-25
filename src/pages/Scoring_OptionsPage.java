
package com.yahtzee.pages;

import com.yahtzee.state.*;
import com.yahtzee.components.*;
import com.yahtzee.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Scoring_OptionsPage extends JPanel {
    static final long serialVersionUID = 0; // JFrame requires a unique number.

    public Scoring_OptionsPage() {
        JLabel label1 = new JLabel("<html><div style='margin-left:10'><strong>ROUND #1");
        label1.setForeground(Color.decode("#585b5e"));
        label1.setBorder(BorderFactory.createLineBorder(Color.decode("#585b5e"), 3));
        label1.setLocation(10, 10);
        label1.setSize(145, 60);
        label1.setFont(new Font("_", Font.PLAIN, 20));

        JLabel label2 = new JLabel(
                "<html><div style='padding-bottom: 20; border-bottom: 2px solid #585b5e; width: 500;'><strong>Your final roll:</strong>");
        label2.setForeground(Color.decode("#414446"));
        label2.setLocation(315, 10);
        label2.setSize(500, 60);
        label2.setFont(new Font("_", Font.PLAIN, 20));

        JLabel label3 = new JLabel(
                "<html><div style='padding-top: 5; border-top: 2px solid #585b5e; width: 1100; text-align: center;'>Select a mission and choose <strong>SCORE</strong> to continue.");
        label3.setForeground(Color.decode("#585b5e"));
        label3.setLocation(10, 500);
        label3.setSize(1100, 100);
        label3.setFont(new Font("_", Font.PLAIN, 20));

        FlagDice[] flags = (FlagDice[]) StateManager.getState(StateManager.FLAGDICE);

        int i = 0;
        for (FlagDice flag : flags) {
            if (!flag.keep) {
                flags[i] = new FlagDice(Game.roll(), flag);
            }
            i++;
        }

        StateManager.changeState(StateManager.FLAGDICE, flags);

        List<SmallFlag> smallFlags = new ArrayList<SmallFlag>();

        i = 0;
        for (FlagDice flag : flags) {
            smallFlags.add(new SmallFlag(flag, 500 + 80 * i, 5));
            i++;
        }

        StateManager.addStateChangedListener(new StateChangedListener() {
            @Override
            public void onChange(String key, Object state) {
                if (key == StateManager.UPDATE_FLAGDICE) {
                    StateManager.changeState(StateManager.FLAGDICE, flags);
                }
            }
        });

        Button scoreButton = new Button("SCORE", 22, Color.WHITE, Color.decode("#585a5d"), Color.decode("#bb0056"),
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        StateManager.changeState(StateManager.CHANGE_PANEL, new Roll_1Page());
                    }
                });
        scoreButton.setBounds(480, 600, 200, 50);

        setBackground(Color.decode("#aeabab"));
        setLayout(null);
        add(label1);
        add(label2);
        add(label3);

        for (SmallFlag smallFlag : smallFlags) {
            add(smallFlag);
        }

        add(scoreButton);
    }
}