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
    private final int PANEL_HEIGHT= 500;
    private int startX= 250;
    private int startY=350;
    private Color branchColor;
    private double branchLength;
    private double branchAngle = 45; 
    private double factorLength;
    /**
     * Constructor for objects of class TreePanel
     */
    public TreePanel(double branch)
    {
        this.branchLength = branch;
        this.branchAngle= branchAngle;
        this.factorLength= 0.75;
        //Inside constructor: branchLength= 100, branchAngle= 50, factorLength= 0.8, l & rAngle= 0.0
        setBackground (Color.white);
        setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));   
    }

    public void drawFractal (int x1, int y1, int length, double angle, Graphics2D page)
    {
        // Dont use instance variables. Use the parameter values
        if (branchLength<15)
        {//This should make it terminate   
        }
        else
        {
            branchLength= (int)this.branchLength*factorLength;
            this.branchLength= (int)branchLength;
            System.out.println("This is BL" +branchLength);
            // this sets the new branch Length
            double lAngle = branchLength * Math.sin(Math.toRadians(angle)); //new X
            double rAngle = branchLength * Math.cos(Math.toRadians(angle)); // new Y
            
            double lAngle2 = branchLength * Math.sin(Math.toRadians(angle-30)); //new X
            double rAngle2 = branchLength * Math.cos(Math.toRadians(angle-30)); // new Y
            System.out.println("L and R "+lAngle+" "+rAngle);
            // Then convert to int version to find the new X and Y
            int x2 = y1-(int)lAngle;
            int y2 = x1-(int)rAngle;
            
            int x3 = y1-(int)lAngle2;
            int y3 = x1-(int)rAngle2;
            System.out.println("x2 and y2 "+x2+" "+y2);
            // cordinates for line to be drawn  
            
            page.draw(new Line2D.Double(x1,y1, x2, y2)); 
            page.draw(new Line2D.Double(x1,y1, x3, y3));
            drawFractal(x2, y2, (int)branchLength, angle, page); 
            //drawFractal(x2, y2, (int)branchLength, angle-40, page); 
            // these two drawFractals should take care of the other 2 lines
            
        }
    }

    public void paintComponent(Graphics page)
    {
        Graphics2D g2= (Graphics2D) page;
        super.paintComponent(page);
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(PANEL_WIDTH/2, PANEL_HEIGHT, startX, startY); //draws the trunk of the tree
        branchColor = new Color(0,0,255);
        drawFractal(startX, startY, (int)branchLength, branchAngle, g2);
    }

}