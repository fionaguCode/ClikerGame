package Clicker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Highscore extends JPanel{
    // some private instance variables
    // how do you create and display text?
    
    private JLabel HighScoreLabel;
    private int score = 0;
    
    public Highscore(){
        
        

        this.setPreferredSize(new Dimension(300, 300));
        this.setBackground(Color.blue);
        
        // add the highscore instace variable to this
        HighScoreLabel = new JLabel();
        HighScoreLabel.setText("The highest score: "+score);
        this.add(HighScoreLabel);

    }

    public void checkHighScore(int count){
        if(count > score){
          score = count;
          HighScoreLabel.setText("The highest score: "+score);
        }
    }
}
