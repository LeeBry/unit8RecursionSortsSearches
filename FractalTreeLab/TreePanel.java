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
    private double branchLength=100;
    private double branchAngle = 0; 
    private double factorLength;
    /**
     * Constructor for objects of class TreePanel
     */
    public TreePanel()
    {
        this.branchLength = branchLength;
        this.branchAngle= branchAngle;
        this.factorLength= 0.75;
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
            double angle1 = angle-15;
            double angle2= angle+15;
            // 1. should create the vShape
            branchLength= (int)this.branchLength*factorLength;
            this.branchLength= (int)branchLength;
            System.out.println("This is BranchLength " +this.branchLength);
            // 2. this sets the new branch Length

            int endX1 = (int)(x1 - branchLength*Math.sin(Math.toRadians(angle1)));
            int endY1 = (int)(y1 - branchLength*Math.cos(Math.toRadians(angle1)));
            // points for first line.
            int endX2 = (int)(x1 - branchLength*Math.sin(Math.toRadians(angle2)));
            int endY2 = (int)(y1 - branchLength*Math.cos(Math.toRadians(angle2)));
            // points for second line
            page.draw(new Line2D.Double(x1,y1, endX1, endY1)); 
            page.draw(new Line2D.Double(x1,y1, endX2, endY2)); 
            drawFractal(endX2,endY2,(int) branchLength,angle2, page);
            drawFractal(endX1,endY1,(int) branchLength,angle2, page);
        }
    }

    public void paintComponent(Graphics page)
    {
        Graphics2D g2= (Graphics2D) page;
        super.paintComponent(page);
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(PANEL_WIDTH/2, PANEL_HEIGHT, startX, startY); //draws the trunk of the tree
        branchColor = new Color(0,255,255);
        drawFractal(PANEL_WIDTH/2, startY, (int)branchLength, branchAngle, g2);
    }

}