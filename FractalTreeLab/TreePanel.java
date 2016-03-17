import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Line2D;
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
    
    private int x1;
    private int y1;
    // points for the right branch
    private int x2;
    private int y2; 
    // points for the left branch    
    private Color branchColor;
    // Color of the branch
    private int branchLength= 100;
    // This is the branch level
    private double branchAngle = 50;
    private double rAngle;
    private double lAngle;
    // angle
    private double factorLength;
    /**
     * Constructor for objects of class TreePanel
     */
    public TreePanel(int branch)
    {
      this.branchLength = branch;
      this.branchAngle= branchAngle;
      this.factorLength= 0.8;
      setBackground (Color.white);
      setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));   
    }

    public void drawFractal (int x1, int y1, int length,double angle, Graphics2D page)
    {
      int lengthSin, lengthCos;
      lAngle = branchAngle+ lAngle;
      rAngle = branchAngle- rAngle;
      
      lengthSin= length*(int)Math.sin(angle*Math.PI/180);
      lengthCos= length*(int)Math.cos(angle*Math.PI/180);
      if (true && length>15)
      {
          page.draw(new Line2D.Double (x1,y1,x2,y2));
      }
      else
      {
         // call drawFractal, and drawLine twice for left and right side
     
      }
    }
        
    public void paintComponent(Graphics page)
    {
        Graphics2D g2= (Graphics2D) page;
        super.paintComponent(page);
        g2.drawLine(250, 250, 250, 500);
        
        drawFractal(x1, y1, branchLength, rAngle, g2);
        drawFractal(x1, y1, branchLength, lAngle, g2);

    }
    

}
