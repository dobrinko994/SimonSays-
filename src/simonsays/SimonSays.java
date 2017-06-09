
package simonsays;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;


public class SimonSays implements ActionListener
{

    public static SimonSays simonSays;
    
    public SimonPanel simonPanel;
    
    public static final int WIDTH = 520, HEIGHT = 530;
    
    public SimonSays() 
    {
        JFrame frame = new JFrame("SimonSays");
        Timer timer = new Timer(20, this);
        
        simonPanel = new SimonPanel();
        
        frame.setSize(WIDTH, HEIGHT + 5);
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
        /*g.setColor(Color.GRAY);
        g.fillRect(0, 0, WIDTH, HEIGHT);*/
        
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g.setColor(Color.GREEN.darker());
        g.fillRect(0, 0, WIDTH / 2, HEIGHT / 2);
        
        g.setColor(Color.RED.darker());
        g.fillRect(WIDTH / 2, 0, WIDTH / 2, HEIGHT / 2);
        
        g.setColor(Color.YELLOW.darker());
        g.fillRect(0, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);
        
        g.setColor(Color.BLUE.darker());
        g.fillRect(WIDTH / 2, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);
        
        g.setColor(Color.GRAY);
        g.setStroke(new BasicStroke(200));
        g.drawOval(-100, -100, WIDTH + 194, HEIGHT + 171);
        
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(10));
        g.drawOval(0, 0, WIDTH - 5, HEIGHT - 25);
        
        g.setColor(Color.BLACK);
        g.fillRoundRect(170, 168, 180, 190, 120, 120);
        g.fillRect(WIDTH / 2 - 38, 0, 80, HEIGHT);
        g.fillRect(0, WIDTH / 2 - 38, WIDTH, 80);
        
        
    }
    
}
