
package simonsays;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class SimonSays implements ActionListener
{

    public static SimonSays simonSays;
    
    public SimonPanel simonPanel;
    
    public static final int WIDTH = 815, HEIGHT = 835;

    public SimonSays() 
    {
        JFrame frame = new JFrame();
        Timer timer = new Timer(20, this);
        
        simonPanel = new SimonPanel();
        
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.add(simonPanel);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
    public static void main(String[] args) 
    {
        simonSays = new SimonSays();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
    }
    
}
