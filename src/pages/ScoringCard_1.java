package com.yahtzee.pages;

import com.yahtzee.state.*;
import com.yahtzee.components.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.*;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ScoringCard_1 extends JPanel {
    static final long serialVersionUID = 0; // JFFrame requires a unique number.

    public ScoringCard_1() {
         JLabel label1 = new JLabel(
                "<html><div style='padding-bottom: 5; border-bottom: 2px solid #585b5e; width: 500; text-align: center;'><strong>Here's you Scorecard after round #1:</strong>");
        label1.setForeground(Color.decode("#414446"));
        label1.setLocation(315, 10);
        label1.setSize(500, 60);
        label1.setFont(new Font("_", Font.PLAIN, 20));
       
         JTable table1 = new JTable(
                new Object[][] { { "", "ROOSEVELT(sum of all USA dice, less axis)" ,""}, 
               { "", "STALIN(sum of all USSR dice, less axis )" ,""}, { "","CHURCHILL(sum of all UK dice, less axis)" ,""},
               { "", "KAI SHAK(sum of all China dice, less axis)" ,""}, { "", "Daladier(sum of all France dice, less axis)" ,""},
               { "", "SUBTOTAL" ,""},{ "50", "ENOLA GAY(bonus more than 65 in upper section" ,""}
                },
                new Object[] { "LowerSection", "Points", "Description" }) {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
      
        table1.setFont(new Font("_", Font.PLAIN, 14));
        table1.setForeground(Color.decode("#585b5e"));
        table1.setBackground(Color.WHITE);
        table1.setSize(550,350);
        table1.setRowHeight(50);
        table1.setLocation(10, 100);
        table1.setRowSelectionAllowed(false);
        table1.setColumnSelectionAllowed(false);
        table1.setCellSelectionEnabled(false);
        table1.setFocusable(false);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table1.getColumnModel().getColumn(0).setPreferredWidth(100);
        table1.getColumnModel().getColumn(1).setPreferredWidth(400);
        table1.getColumnModel().getColumn(2).setPreferredWidth(50);
        
        
       

        
        JTable table = new JTable(
                new Object[][] { { "LowerSection", "Points", "Description" },{ "CEASE-FIRE", "" ,"all one AXIS and one ALLY"},
                        { "TREATY OF FRIENDSHIP", "", "all AXIS members" }, { "BIG THREE", "", "all US, UK, and USSR" },
                        { "AROUND THE WORLD", "", "One of each" }, { "UNITED NATIONS", "", "all allies" },
                        { "TRIPARTITE PACT", "", "all axis" }, { "PEAL HARBOR", "", "all axis or allies" },{ "D-Day", "", "chance of all allies, no axis" },
                        { "LOWER TOTAL", "", "" }, { "UPPER TOTAL", "", "" } },
                new Object[] { "LowerSection", "Points", "Description" }) {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };

        table.setFont(new Font("_", Font.PLAIN, 14));
        table.setForeground(Color.decode("#585b5e"));
        table.setBackground(Color.WHITE);
        table.setSize(550, 350);
        table.setRowHeight(35);
        table.setLocation(580, 100);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);
        table.setFocusable(true);
        
       
       


        

        Button nextButton = new Button("NEXT MISSION", 22, Color.WHITE, Color.decode("#585a5d"),
                Color.decode("#ed7c31"), new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        StateManager.changeState(StateManager.CHANGE_PANEL, new ScoringCard_2());
                    }
                });
        nextButton.setBounds(500, 600, 200, 50);

        setBackground(Color.decode("#e7e6e6"));
        setLayout(null);
        add(label1);
        add(table);
        add(table1);
        add(nextButton);
    }
}

    
