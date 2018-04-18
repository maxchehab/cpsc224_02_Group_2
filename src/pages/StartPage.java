
package com.yahtzee.pages;

import com.yahtzee.state.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JButton;

public class StartPage extends JPanel {
    static final long serialVersionUID = 0; // JFFrame requires a unique number.

    public StartPage() {
        JLabel label1 = new JLabel("<html>Welcome to <strong>World War II Yahtzee!</strong>");
        label1.setForeground(Color.decode("#585b5e"));
        label1.setLocation(10, 0);
        label1.setSize(600, 30);
        label1.setFont(new Font("_", Font.PLAIN, 18));

        JLabel label2 = new JLabel(
                "<html>Your goal is to bring the <strong>ALLIES</strong> to victory over the <strong>AXIS POWERS</strong> alliance by scoring as many points as possible!");
        label2.setForeground(Color.decode("#585b5e"));
        label2.setLocation(10, 40);
        label2.setSize(1100, 30);
        label2.setFont(new Font("_", Font.PLAIN, 18));

        JLabel label3 = new JLabel(
                "<html>If you’ve already been briefed, click <strong>PLAY</strong> to begin now! Otherwise, select <strong>INSTRUCTIONS</strong> to learn about your mission!");
        label3.setForeground(Color.decode("#585b5e"));
        label3.setLocation(10, 80);
        label3.setSize(1100, 30);
        label3.setFont(new Font("_", Font.PLAIN, 18));

        Button playButton = new Button("PLAY", 22, Color.WHITE, Color.decode("#585a5d"), Color.decode("#bb0056"),
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Playing");
                    }
                });
        playButton.setBounds(470, 250, 200, 50);

        Button helpButton = new Button("INSTRUCTIONS", 22, Color.WHITE, Color.decode("#585a5d"),
                Color.decode("#ffc000"), new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Helping");
                    }
                });
        helpButton.setBounds(420, 325, 300, 50);

        Button exitButton = new Button("EXIT", 22, Color.WHITE, Color.decode("#585a5d"), Color.decode("#52793b"),
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Exiting");
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

class Button extends JButton {
    public Button(String label, int size, Color foreground, Color background, Color border, ActionListener listener) {
        super(label);

        setFont(new Font("_", Font.PLAIN, size));
        setForeground(foreground);
        setBackground(background);
        setFocusPainted(false);
        addActionListener(listener);
        setBorder(BorderFactory.createLineBorder(border, 2));
    }

}