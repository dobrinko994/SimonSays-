
package simonsays;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;


public class SimonSays implements ActionListener
{

    public static SimonSays simonSays;
    
    public SimonPanel simonPanel;
    
    public static final int WIDTH = 520, HEIGHT = 520;

    public SimonSays() 
    {
        JFrame frame = new JFrame("SimonSays");
        Timer timer = new Timer(20, this);
        
        simonPanel = new SimonPanel();
        
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.add(simonPanel);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        timer.start();
        
    }
    
    public static void main(String[] args) 
    {
        simonSays = new SimonSays();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        simonPanel.repaint();
    }
    
    public void paint(Graphics2D g)
    {
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, WIDTH / 2, HEIGHT / 2);
        
        g.setColor(Color.RED);
        g.fillRect(WIDTH / 2, 0, WIDTH / 2, HEIGHT / 2);
        
        g.setColor(Color.YELLOW);
        g.fillRect(0, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);
        
        g.setColor(Color.BLUE);
        g.fillRect(WIDTH / 2, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);
        
        
    }
    
}
