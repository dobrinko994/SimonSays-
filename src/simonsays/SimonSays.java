
package simonsays;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.Timer;


public class SimonSays implements ActionListener, MouseListener
{

    public static SimonSays simonSays;
    
    public SimonPanel simonPanel;
    
    public static final int WIDTH = 520, HEIGHT = 530;
    
    public int light = 0;
    
    public SimonSays() 
    {
        JFrame frame = new JFrame("SimonSays");
        Timer timer = new Timer(20, this);
        
        simonPanel = new SimonPanel();
        
        frame.setSize(WIDTH, HEIGHT + 5);
        frame.setVisible(true);
        frame.add(simonPanel);
        frame.setResizable(false);
        frame.addMouseListener(this);
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
        
        if(light == 1)
        {
            g.setColor(Color.GREEN);
        }
        else
        {
            g.setColor(Color.GREEN.darker());
        
        }
        
        if(light == 2)
        {
            g.setColor(Color.RED);
        }
        else
        {
            g.setColor(Color.RED.darker());
        
        }
        
        if(light == 3)
        {
            g.setColor(Color.YELLOW);
        }
        else
        {
            g.setColor(Color.YELLOW.darker());
        
        }
        
        if(light == 4)
        {
            g.setColor(Color.BLUE);
        }
        else
        {
            g.setColor(Color.BLUE.darker());
        
        }
        
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

    @Override
    public void mouseClicked(MouseEvent me) 
    {
        
    }

    @Override
    public void mousePressed(MouseEvent me) 
    {
        
        int x = me.getX(), y = me.getY();
        
        if(x > 0 && x < WIDTH / 2 && y > 0 && y < HEIGHT / 2)
        {
            light = 1;
        }
        else if(x > WIDTH / 2 && x < WIDTH && y < 0 && y < HEIGHT / 2)
        {
            light = 2;
        }
        else if(x > 0 && x < WIDTH / 2 && y > HEIGHT / 2 && y < HEIGHT)
        {
            light = 3;
        }
        else if(x > WIDTH / 2 && x < WIDTH && y > HEIGHT / 2 && y < HEIGHT)
        {
            light = 4;
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) 
    {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) 
    {
        
    }

    @Override
    public void mouseExited(MouseEvent me) 
    {
        
    }
    
}
