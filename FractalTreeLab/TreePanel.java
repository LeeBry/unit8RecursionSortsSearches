import java.awt.*;
import javax.swing.JPanel;
/**
 * Write a description of class TreePanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TreePanel extends JPanel
{
    private final int PANEL_WIDTH= 500;
    private final int PANEL_HEIGHT=500;
    
    private final int x1=100;
    private final int y1=100;
    // points for the right branch
    private final int x2=100;
    private final int y3=100; 
    // points for the left branch
    private int originX;
    private int originY;
    // Origin of the original branch
    private Color branchColor;
    // Color of the branch
    private int branchLength= 100;
    // This is the branch level
    private double angle;
    // angle
    private double factor;
    /**
     * Constructor for objects of class TreePanel
     */
    public TreePanel(int branch)
    {
      branchLength = branch;
      //setBackground (Color.green);
      setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));   
    }
    
    public void paintComponent(Graphics g2)
    {
        super.paintComponent(g2);

    }
    
    public void drawFractal (int originX, int originY, int length,
                             double angle, Graphics2D g2)
    {
      int lengthSin, lengthCos;
      lengthSin= (int)Math.sin(angle*Math.PI/180);
      lengthSin= lengthSin*length;
      lengthCos= (int)Math.cos(angle*Math.PI/180);
      lengthCos= lengthCos*length;
      if (true && length>15)
      {
          g2.drawLine(originX,originY,0,length);
      }
      else
      {
         // call drawFractal, and drawLine twice for left and right side
     
      }
    }

}
