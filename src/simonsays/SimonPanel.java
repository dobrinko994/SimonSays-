
package simonsays;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class SimonPanel extends JPanel 
{

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g); 
        
        if(SimonSays.simonSays != null)
        {
            SimonSays.simonSays.paint((Graphics2D) g);
        }
        
    }
    
}
