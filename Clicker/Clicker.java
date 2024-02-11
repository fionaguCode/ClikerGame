package Clicker;

import java.awt.*;
import javax.swing.*;

public class Clicker extends JFrame{
    private JPanel mainContent;
    private LButtons leftPanel;
    private RStore rightPanel;
    private Highscore Highscore;

    public Clicker(){
        this.mainContent = new JPanel();
        this.Highscore = new Highscore();
        this.leftPanel = new LButtons(Highscore);
        this.rightPanel = new RStore(leftPanel);
        

        this.setSize(800,600);
        this.setVisible(true);
        this.setTitle("Cliker Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(128,50,128));

        this.mainContent.add(leftPanel);
        this.mainContent.add(rightPanel);
        this.mainContent.add(Highscore);
        
        this.add(mainContent);
        this.setVisible(true);
    }
}