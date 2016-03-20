import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Line2D;
import java.util.Random;
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
    private double branchLength=100;
    private double branchAngle = 0; 
    private double factorLength;
    Random gen= new Random();
    /**
     * Constructor for objects of class TreePanel
     */
    public TreePanel()
    {
        this.branchLength = branchLength;
        this.branchAngle= branchAngle;
        this.factorLength= 0.8;
        setBackground (Color.black);
        setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));   
    }

    public void drawFractal (int x1, int y1, int length, double angle, Graphics2D page)
    {
        // Dont use instance variables. Use the parameter values
        if (length<15)
        {//This should make it terminate   
        }
        else
        {
            double angle1 = angle-15;
            double angle2= angle+15;
            // 1. should create the vShape
            double newBranchLength= (int)length*factorLength;
            newBranchLength= (int)newBranchLength;
            // 2. this sets the new branch Length
            //Attempt 1,2,3,4 : Reason why wrong: Using the local variable instead ot parameter variables
            //             int endX1 = (int)(x1 - branchLength*Math.sin(Math.toRadians(angle1)));
            //             int endY1 = (int)(y1 - branchLength*Math.cos(Math.toRadians(angle1)));
            //             page.draw(new Line2D.Double(x1,y1, endX1, endY1)); 
            //             drawFractal(endX1,endY1,(int) branchLength,angle1, page);
            //             System.out.println("values:"+ endX1+" "+endY1);
            //             int endX2 = (int)(x1 - branchLength*Math.sin(Math.toRadians(angle2)));
            //             int endY2 = (int)(y1 - branchLength*Math.cos(Math.toRadians(angle2)));
            //             page.draw(new Line2D.Double(x1,y1, endX2, endY2)); 
            //             drawFractal(endX2,endY2,(int) branchLength,angle2, page);
            //             System.out.println("            values2:"+ endX2+" "+endY2);
            // Attempt 5: changed all variables to parameter values, so it will not confuse the values.
            int endX1 = (int)(x1 - newBranchLength*Math.sin(Math.toRadians(angle1)));
            int endY1 = (int)(y1 - newBranchLength*Math.cos(Math.toRadians(angle1)));
            // calculating x and y value for 1st point
            int endX2 = (int)(x1 - newBranchLength*Math.sin(Math.toRadians(angle2)));
            int endY2 = (int)(y1 - newBranchLength*Math.cos(Math.toRadians(angle2)));
            // calculating x2 and y2 value for 2nd point
            page.setColor(new Color(255,255,255));
            page.draw(new Line2D.Double(x1,y1, endX1, endY1)); 
            page.draw(new Line2D.Double(x1,y1, endX2, endY2)); 

            drawFractal(endX2,endY2,(int) newBranchLength,angle2, page);
            drawFractal(endX1,endY1,(int) newBranchLength,angle1, page);


        }
    }

    public void paintComponent(Graphics page)
    {
        Graphics2D g2= (Graphics2D) page;
        super.paintComponent(page);
        g2.setStroke(new BasicStroke(2));
        g2.setColor(new Color(255,255,255));
        g2.drawLine(PANEL_WIDTH/2, PANEL_HEIGHT, startX, startY); //draws the trunk of the tree
        drawFractal(PANEL_WIDTH/2, startY, (int)branchLength, branchAngle, g2);
    }

}