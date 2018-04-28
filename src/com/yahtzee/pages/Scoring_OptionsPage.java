package com.yahtzee.pages;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.yahtzee.Card;
import com.yahtzee.Game;
import com.yahtzee.ScoreCalculator;
import com.yahtzee.components.*;
import com.yahtzee.ScoringDice;
import com.yahtzee.state.StateChangedListener;
import com.yahtzee.state.StateManager;



public class Scoring_OptionsPage extends JPanel{
    static final long serialVersionUID = 0; // JFFrame requires a unique number.
    
    
    public Scoring_OptionsPage() {
    	
    	 	FlagDice[] flags = (FlagDice[])StateManager.getState(StateManager.FLAGDICE);
         
    	 	String[] scorePaths = {"src/assets/images/scorecard/Roosevelt.png", "src/assets/images/scorecard/Stalin.png", 
    	 			"src/assets/images/scorecard/Churchill.png", "src/assets/images/scorecard/KaiShak.png", 
    	 			"src/assets/images/scorecard/Daladier.png", "src/assets/images/scorecard/CeaseFire.png", 
    	 			"src/assets/images/scorecard/TreatyOfFriendship.png", "src/assets/images/scorecard/BigThree.png", 
    	 			"src/assets/images/scorecard/AroundTheWorld.png", "src/assets/images/scorecard/UnitedNations.png",
    	 			"src/assets/images/scorecard/TripartitePact.png", "src/assets/images/scorecard/PearlHarbor.png", 
    	 			"src/assets/images/scorecard/DDay.png"};
         
         int i = 0;
         
         for(FlagDice flag : flags){
             if(!flag.keep){
                 flags[i] = new FlagDice(Game.roll(), flag);
             }
             i++;
         }
         
         StateManager.changeState(StateManager.FLAGDICE, flags);

         StateManager.addStateChangedListener(new StateChangedListener() {
             @Override
             public void onChange(String key, Object state) {
                 if (key == StateManager.UPDATE_FLAGDICE) {
                     StateManager.changeState(StateManager.FLAGDICE, flags);
                 }
             }
         });
    	
    		Game.hand = new ScoringDice [Game.HAND_SIZE];
    		
        JLabel label1 = new JLabel("<html><div style='margin-left:10'><strong>ROUND #1");
        label1.setForeground(Color.decode("#585b5e"));
        label1.setBorder(BorderFactory.createLineBorder(Color.decode("#585b5e"), 3));
        label1.setLocation(10, 10);
        label1.setSize(145, 60);
        label1.setFont(new Font("_", Font.PLAIN, 20));

        JLabel label2 = new JLabel(
                "<html><div style='padding-bottom: 5; border-bottom: 2px solid #585b5e; width: 650; text-align: left;'><strong>Your final roll:</strong>");
        label2.setForeground(Color.decode("#414446"));
        label2.setLocation(280, 10);
        label2.setSize(650, 60);
        label2.setFont(new Font("_", Font.PLAIN, 20));

        
        FinalDie[] icons = new FinalDie[] {
        		new FinalDie(flags[0].flagImage.path, 450, 2),
        		new FinalDie(flags[1].flagImage.path, 510, 2),
        		new FinalDie(flags[2].flagImage.path, 570, 2),
        		new FinalDie(flags[3].flagImage.path, 630, 2),
        		new FinalDie(flags[4].flagImage.path, 690, 2),
        		new FinalDie(flags[5].flagImage.path, 750, 2),
        		new FinalDie(flags[6].flagImage.path, 810, 2),
        		new FinalDie(flags[7].flagImage.path, 870, 2)
        };
        
        for(int k = 0 ; k < Game.HAND_SIZE; k++) {
    			Game.hand[k] = new ScoringDice(flags[k].flagImage);
    			add(icons[k]);
        }
        
        JLabel label3 = new JLabel(
                "<html><div style='padding-bottom: 5; border-bottom: 2px solid #585b5e; width: 650; text-align: left;'>UPPER SECTION");
        label3.setForeground(Color.decode("#414446"));
        label3.setLocation(50, 100);
        label3.setSize(400, 60);
        label3.setFont(new Font("_", Font.PLAIN, 17));
        
        JLabel label4 = new JLabel(
                "<html><div style='padding-bottom: 5; border-bottom: 2px solid #585b5e; width: 650; text-align: left;'>LOWER SECTION");
        label4.setForeground(Color.decode("#414446"));
        label4.setLocation(700, 100);
        label4.setSize(400, 60);
        label4.setFont(new Font("_", Font.PLAIN, 17));
        
        JLabel label5 = new JLabel(
                "<html><div style='padding-bottom: 5; width: 200; text-align: left;'>POINTS");
        label5.setForeground(Color.decode("#414446"));
        label5.setLocation(215, 100);
        label5.setSize(400, 60);
        label5.setFont(new Font("_", Font.PLAIN, 17));
        
        JLabel label6 = new JLabel(
                "<html><div style='padding-bottom: 5; width: 200; text-align: left;'>POINTS");
        label6.setForeground(Color.decode("#414446"));
        label6.setLocation(865, 100);
        label6.setSize(400, 60);
        label6.setFont(new Font("_", Font.PLAIN, 17));
        
        ScoreChoice test = new ScoreChoice("src/assets/images/scorecard/Roosevelt.png", 15, 2, 50, 150);
        
        add(label3);
        add(label4);
        add(label5);
        add(label6);
        
     
        //add(test2);
        
        ScoreChoice[] choices = new ScoreChoice [Card.CARD_SIZE];
        ScoreCalculator scores = new ScoreCalculator(Game.hand);
        
        int horizontal = 50;
        int vertical = 150;
        boolean column2 = false;
        
        //Game.play.usable[4] = false;

        for(int k = 0; k < Card.CARD_SIZE; k++) {
        		if(Game.play.usable[k]) {
        			if (k > 4 && !column2) {
        				vertical = 150;
        				horizontal = 720;
        				column2 = true;
        			}
        			choices[k] = new ScoreChoice(scorePaths[k], scores.scores[k], k, horizontal, vertical);
        			add(choices[k]);
        			vertical += 50;
        		}
        } 
        
        /*
        Button [] scoreChoose = new Button [Card.CARD_SIZE];
        int selectIndex;
        
        for(int k = 0; k < Card.CARD_SIZE; k++) {
	    		if(Game.play.usable[k]) {
	    			if (k > 3 && !column2) {
	    				vertical = 130;
	    				horizontal = 700;
	    				column2 = true;
	    			}
	    			
	    	        scoreChoose[k] = new Button("", 22, Color.WHITE, Color.decode("#585a5d"), Color.decode("#bb0056"),
	    	                new ActionListener() {
	    	                    public void actionPerformed(ActionEvent e) {
	    	                        StateManager.changeState(StateManager.CHANGE_PANEL, new Roll_1Page());
	    	                        selectIndex = k;
	    	                    }
	    	                });
	    	                
	    	       
	    	        scoreChoose[k].setBounds(horizontal, vertical, 200, 60);
	    	        add(scoreChoose[k]);
	    	        vertical += 50;
	    	        
	    		}
    		}
        */
        System.out.println(scores.scores[0]);
        
        for (int k = 0 ; k < Game.HAND_SIZE; k++) {
        		System.out.println(Game.hand[k].toString());
        }
        
        Button rerollButton = new Button("", 22, Color.WHITE, Color.decode("#585a5d"), Color.decode("#bb0056"),
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        StateManager.changeState(StateManager.CHANGE_PANEL, new Roll_1Page());
                    }
                });
        
        rerollButton.setBounds(50, 150, 420, 47);
        add(rerollButton);

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
        add(scoreButton);
        add(test);
        
        
    }
    
    public static void clearBoxes(ScoreChoice[] options) {
        for(int k = 0; k < Card.CARD_SIZE; k++) {
	    		if(Game.play.usable[k]) {
	    			options[k].picked = false;
	    		}
        }
    }
    
    public static int findChoice(ScoreChoice[] options) {
    		for(int k = 0; k < Card.CARD_SIZE; k++) {
    			if(options[k].picked) {
    				return k;
    			}
    		}
    		
    		return -1;
    }
}
