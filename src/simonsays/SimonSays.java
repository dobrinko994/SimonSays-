
package simonsays;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;



public class SimonSays implements ActionListener, MouseListener
{

    public static SimonSays simonSays;
    
    public SimonPanel simonPanel;
    
    public static final int WIDTH = 520, HEIGHT = 530;
    
    public int light = 0, ticks, stepsIndex, dark;
    
    public boolean creatingSteps = true, gameOver;
    
    public ArrayList<Integer> steps; //Korake predstavljamo kao niz int-ova 
    
    public Random random;
    
    public SimonSays() 
    {
        JFrame frame = new JFrame("SimonSays");
   
        simonPanel = new SimonPanel();
        
        Timer gameTimer = new Timer(20, this);
        
        frame.setSize(WIDTH, HEIGHT + 5);
        frame.setVisible(true);
        frame.add(simonPanel);
        frame.setResizable(false);
        frame.addMouseListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        start();
        
        gameTimer.start();
        
    }
    
    public void start()
    {
        random = new Random();
        
        steps = new ArrayList<Integer>();
        stepsIndex = 0;
        dark = 2;
        light = 0;
        ticks = 0;
    }
    
    public static void main(String[] args) 
    {
        simonSays = new SimonSays();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        ticks++;
        
        if(ticks % 20 == 0) // zbog tajmera (osvjetljenje traje sekundu ako nismo kliknuli na drugo polje)
        {
            light = 0;
           
            if(dark >= 0)//?
            {
                dark--;
            }
        }
            
        if(creatingSteps) //prilikom pokretanja polja svijetle 
        {
            if(dark <= 0)
            {
                if(stepsIndex >= steps.size())
                {
                    light = random.nextInt(40) % 4 + 1; //da bi povecali "stepen slucajnosti"
                    steps.add(light);
                    stepsIndex = 0;
                    creatingSteps = false;
                }
                else
                {
                    light = steps.get(stepsIndex);
                    stepsIndex++;
                }        
            
                dark = 2;
            }
        }
        else if(stepsIndex == steps.size())
        {
            creatingSteps = true;
            //stepsIndex = 0;
            dark = 2;
        }
               
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
        g.fillRect(0, 0, WIDTH / 2, HEIGHT / 2);
        
        
        if(light == 2)
        {
            g.setColor(Color.RED);
        }
        else
        {
            g.setColor(Color.RED.darker());
        }
        g.fillRect(WIDTH / 2, 0, WIDTH / 2, HEIGHT / 2);
        
        
        if(light == 3)
        {
            g.setColor(Color.YELLOW);
        }
        else
        {
            g.setColor(Color.YELLOW.darker());
        }
        g.fillRect(0, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);
        
        
        if(light == 4)
        {
            g.setColor(Color.BLUE);
        }
        else
        {
            g.setColor(Color.BLUE.darker());
        
        }
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
        
        /*g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", 1, 50));
        if(gameOver)
            g.drawString("GAME OVER", WIDTH / 2 - 150, HEIGHT / 2 + 27);*/   
        
        if(!gameOver)
        {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", 1, 90));
            g.drawString(stepsIndex + "/" + steps.size(), WIDTH / 2 - 55, HEIGHT / 2 + 27);
        }
        else
        {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", 1, 50));
            g.drawString("GAME OVER", WIDTH / 2 - 150, HEIGHT / 2 + 14);   
        }
        
        
    }

    @Override
    public void mouseClicked(MouseEvent me) 
    {
        
    }

    @Override
    public void mousePressed(MouseEvent me) 
    {
        int x = me.getX(), y = me.getY();
        
        if(!creatingSteps && !gameOver) // ne moze se kliknuti na polje dok se kreiraju koraci igre
        {
            if(x > 0 && x < WIDTH / 2 && y > 0 && y < HEIGHT / 2)
            {
                light = 1;
                ticks = 1;
            }
            else if(x > WIDTH / 2 && x < WIDTH && y > 0 && y < HEIGHT / 2)
            {
                light = 2;
                ticks = 1;
            }
            else if(x > 0 && x < WIDTH / 2 && y > HEIGHT / 2 && y < HEIGHT)
            {
                light = 3;
                ticks = 1;
            }
            else if(x > WIDTH / 2 && x < WIDTH && y > HEIGHT / 2 && y < HEIGHT)
            {
                light = 4;
                ticks = 1;
            }
            
            if(light != 0)
            {
                if(steps.get(stepsIndex) == light)
                {
                    stepsIndex++;
                }
                else
                {
                    gameOver = true;
                }
            }
        }
        else if(gameOver)
        {
            start();
            gameOver = false;
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
