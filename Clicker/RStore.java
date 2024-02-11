package Clicker;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.util.Random;

public class RStore extends JPanel implements ActionListener{
    private JButton buyButton;
    private LButtons leftPanel; 
    private JButton randomButton;
    private JButton luckyRandomButton;
    
    public RStore(LButtons leftPanel){
        
        this.leftPanel = leftPanel;
        this.setPreferredSize(new Dimension(300, 300));
        this.setBackground(Color.blue);
    
        // create three buttons, set their settings 
        // also add RStore, (this), as an ActionListener
        this.buyButton = new JButton("Upgrade Button: $" + 10*leftPanel.getIncrement());
        this.buyButton.setSize(new Dimension(200, 200));
        this.buyButton.addActionListener(this);
    
        this.randomButton = new JButton("Random Effect: $" + 15 * leftPanel.getIncrement());
        this.randomButton.setSize(new Dimension(200, 200));
        this.randomButton.addActionListener(this);
    
        this.luckyRandomButton = new JButton("Lucky Random Effect: $" + 30 * leftPanel.getIncrement());
        this.luckyRandomButton.setSize(new Dimension(200, 200));
        this.luckyRandomButton.addActionListener(this);
    
        // add three buttons to the RStore, which extends JPanel
        this.add(buyButton);
        this.add(randomButton);
        this.add(luckyRandomButton);
    } 

    @Override
    public void actionPerformed(ActionEvent arg0) {
        Random rand = new Random();

        if(arg0.getSource() == buyButton){
            this.leftPanel.upgradeButton();
            this.buyButton.setText("Upgrade Button: $" + 10*leftPanel.getIncrement());
            this.randomButton.setText("Random Effect: $" + 15 * leftPanel.getIncrement());
            this.luckyRandomButton.setText("Lucky Random Effect: $" + 30 * leftPanel.getIncrement());
        }

        else if(arg0.getSource() == randomButton){
            int n = rand.nextInt(3);
            if(n == 0){
                this.leftPanel.updateCount(-50, 15 * leftPanel.getIncrement());
            }
            else if(n == 1){
                this.leftPanel.updateCount(-(leftPanel.getIncrement() * 7), 15 * leftPanel.getIncrement());
            }
            else if(n == 2){
                this.leftPanel.updateCount((leftPanel.getIncrement() * 3), 15 * leftPanel.getIncrement());
            }
        }

        else if(arg0.getSource() == luckyRandomButton){
            int n = rand.nextInt(3);
            if(n == 0){
                this.leftPanel.updateCount(20, 30 * leftPanel.getIncrement());
            }
            else if(n == 1){
                this.leftPanel.updateCount(-(leftPanel.getIncrement() * 3), 30 * leftPanel.getIncrement());
            }
            else if(n == 2){
                this.leftPanel.updateCount((leftPanel.getIncrement() * 7), 30 * leftPanel.getIncrement());
            }
        }
    }
}