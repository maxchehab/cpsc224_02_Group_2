package com.yahtzee.pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.yahtzee.Game;
import com.yahtzee.components.Button;
import com.yahtzee.components.Card;
import com.yahtzee.components.Image;
import com.yahtzee.components.ScoreChoice;
import com.yahtzee.state.StateManager;

public class AlternateCard extends JPanel{
	
	static final long serialVersionUID = 0; // JFFrame requires a unique number.
	
	public static int upperTotal;
	public static int enolaGay;
	public static int lowerTotal;
	public static int grandTotal;
	
	public AlternateCard() {
		
        JLabel label1 = new JLabel("<html><div style='margin-left:10'><strong>ROUND #1");
        label1.setForeground(Color.decode("#585b5e"));
        label1.setBorder(BorderFactory.createLineBorder(Color.decode("#585b5e"), 3));
        label1.setLocation(10, 10);
        label1.setSize(145, 60);
        label1.setFont(new Font("_", Font.PLAIN, 20));
        
		Image flag = new Image("src/assets/images/upperScores.png", 0.45f, 10, 70);
		Image egg = new Image("src/assets/images/lowerScores.png", 0.45f, 600, 70);
		Image bar = new Image("src/assets/images/totalBar.png", 0.45f, 400, 500);
		
		
	    Button nextButton = new Button("NEXT MISSION", 22, Color.WHITE, Color.decode("#585a5d"),
	            Color.decode("#ed7c31"), new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    StateManager.changeState(StateManager.CHANGE_PANEL, new Roll_1Page());
	                }
	            });
	    
	    nextButton.setBounds(500, 600, 200, 50);
	    
	    updateTotals();
	    
		int horizontal = 400;
		int vertical = 102;
		
		setLayout(null);
	    JLabel [] scores = {new JLabel(Game.play.getScore(0)), new JLabel(Game.play.getScore(1)),
	    		new JLabel(Game.play.getScore(2)), new JLabel(Game.play.getScore(3)), new JLabel(Game.play.getScore(4)),
	    		new JLabel(getString(enolaGay)), new JLabel(getString(upperTotal)), new JLabel(Game.play.getScore(5)), 
	    		new JLabel(Game.play.getScore(6)), new JLabel(Game.play.getScore(7)), new JLabel(Game.play.getScore(8)), 
	    		new JLabel(Game.play.getScore(9)), new JLabel(Game.play.getScore(10)), new JLabel(Game.play.getScore(11)), 
	    		new JLabel(Game.play.getScore(12)), new JLabel(getString(lowerTotal)), new JLabel(getString(grandTotal))};

	    for(int k = 0; k < 7; k++) {
	    	
		    	scores[k].setForeground(Color.BLACK);
		    	scores[k].setLocation(horizontal, vertical);
		    	scores[k].setSize(50, 40);
		    	scores[k].setFont(new Font("_", Font.PLAIN, 20)); 
		    	
		    	add(scores[k]);
		    	
		    	vertical += 43; 
	    }
	    
	    System.out.println(getString(lowerTotal));
	    
	    vertical = 90;
        horizontal = 1000;
        
	    for(int k = 7; k < Card.CARD_SIZE + 4; k++) {
            
		    	scores[k].setForeground(Color.BLACK);
		    	scores[k].setLocation(horizontal, vertical);
		    	scores[k].setSize(50, 40);
		    	scores[k].setFont(new Font("_", Font.PLAIN, 14));  
		    	
		    	add(scores[k]);
		    	
		    	vertical += 27; 
		    	if (k == 14) {
		    		
		    		vertical += 12;
		    	}
	    }
	    
	    	scores[16].setForeground(Color.BLACK);
	    	scores[16].setLocation(750, 500);
	    	scores[16].setSize(50, 40);
	    	scores[16].setFont(new Font("_", Font.PLAIN, 20));
	    	
	    	add(scores[16]);
	    
	    add(flag);
	    add(egg);
	    add(nextButton);
	    add(bar);
	    
	    Game.round++;
	    
        setBackground(Color.decode("#e7e6e6"));
    }
	
	public static void updateTotals() {
		upperTotal = 0;
		enolaGay = 0;
		lowerTotal = 0;
		grandTotal = 0;
		
		for(int k = 0; k < 5; k++) {
			upperTotal += Game.play.score[k];
		}
		
		if(upperTotal > 65) {
			enolaGay = 50;
		}
		
		for(int k = 5; k < Card.CARD_SIZE; k++) {
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
