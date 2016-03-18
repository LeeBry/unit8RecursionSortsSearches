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
    
    private int x1=250;
    private int y1=250;
    private int x2;
    private int y2; 
    // points for the left and right branch    
    private Color branchColor;
    // Color of the branch
    private double branchLength= 100;
    // This is the branch level
    private double branchAngle = 50;
    private double rAngle= 10, lAngle = 10;
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
      // Dont use instance variables. Use the parameter values
      lAngle = branchAngle+ lAngle;
      rAngle = branchAngle- rAngle;
      

      if (true && branchLength>15)
      {
          page.draw(new Line2D.Double (x1,y1,x2,y2));
      }
      else
      {
          this.branchLength = (double)this.branchLength*factorLength;
          lengthSin= length*(int)Math.sin(lAngle*Math.PI/180);
          lengthCos= length*(int)Math.cos(lAngle*Math.PI/180);
          x2= x1-lengthSin;
          y2= y1-lengthCos;
          page.draw(new Line2D.Double (x1,y1,x2,y2));
          drawFractal(x2, y2, (int)branchLength, lAngle, page);
          
          lengthSin= length*(int)Math.sin(rAngle*Math.PI/180);
          lengthCos= length*(int)Math.cos(rAngle*Math.PI/180);
          x2= x1+lengthSin;
          y2= y1-lengthCos;
          page.draw(new Line2D.Double (x1,y1,x2,y2));
          drawFractal(x2, y2, (int)branchLength, rAngle, page);
         
      }
    }
        
    public void paintComponent(Graphics page)
    {
        Graphics2D g2= (Graphics2D) page;
        super.paintComponent(page);
        g2.drawLine(250, 250, 250, 500); //draws the trunk of the tree
        
        drawFractal(x1, y1, (int)branchLength, rAngle, g2);

    }
    

}
