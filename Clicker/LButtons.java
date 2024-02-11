package Clicker;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LButtons extends JPanel implements ActionListener {
    private JButton b;    
    private JLabel score;
    private JLabel incrementLabel;
    private int count = 0;
    private JPanel scorePanel;
    private JPanel incrementPanel;
    private int increment = 1;
   // private int highScore=0;
    private Highscore HighPanelScore;
    
    public LButtons(Highscore HighPanelScore){
        //point to the Highscore class
        this.HighPanelScore = HighPanelScore;
        // setting some settings
        this.setPreferredSize(new Dimension(300, 300));
        this.setBackground(Color.red);
    
        // create two panels to display our clicks and increment values
        this.scorePanel = new JPanel();
        this.scorePanel.setPreferredSize(new Dimension(300, 50));
        score = new JLabel("Clicks: 0");
        this.scorePanel.add(score);
    
        this.incrementPanel = new JPanel();
        this.incrementPanel.setPreferredSize(new Dimension(300, 50));
        incrementLabel = new JLabel("Increment: 1");
        this.incrementPanel.add(incrementLabel);
        
        // create a button and add an actionlistener to it
        // this is why we needed to implements ActionListener
        this.b = new JButton("Click me!");
        this.b.setPreferredSize(new Dimension(250, 150));
        this.b.addActionListener(this);
    
        // add the two panels and button to LButtons
        this.add(scorePanel);
        this.add(incrementPanel);
        this.add(b);
    }

    public int getIncrement(){
        return this.increment;
    }
    
    public int getCount(){
        return this.count;
    }



    public void updateCount(int n, int cost){
    if(count - cost >= 0){
        this.count += n;
        score.setText("Clicks: " + count);
        //update the high score 
        HighPanelScore.checkHighScore(count);
    }
    else{
        JOptionPane.showMessageDialog(null, "Not enough clicks to buy!");
    }

    
    }

    public void upgradeButton(){
        if(this.count >= increment*10){
            this.count -= increment * 10;
            this.increment++;
    
            incrementLabel.setText("Increment: " + increment);
            score.setText("Clicks: " + count);
        }
        else{
            JOptionPane.showMessageDialog(null, "Not enough clicks to buy!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        count += increment;
        score.setText("Clicks: " + count);
        //update the high score
        HighPanelScore.checkHighScore(count);
        
    }


}

