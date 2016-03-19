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
    private int startX= 250;
    private int startY=500;
    private Color branchColor;
    private double branchLength;
    private double branchAngle = 50;
    private double angleChange= 5;
    private double factorLength;
    /**
     * Constructor for objects of class TreePanel
     */
    public TreePanel(double branch)
    {
        this.branchLength = branch;
        this.branchAngle= branchAngle;
        this.factorLength= 0.8;
        //Inside constructor: branchLength= 100, branchAngle= 50, factorLength= 0.8, l & rAngle= 0.0
        setBackground (Color.white);
        setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));   
    }

    public void drawFractal (int x1, int y1, int length,double angle, Graphics2D page)
    {
        // Dont use instance variables. Use the parameter values
        int startX=x1, startY=y1, newLength=length, deltaX, deltaY;
        double newAngle=angle;
        double lAngle, rAngle;
        // 1st run: startX= 250, startY= 500, Length= 100, angle=50
        
        if (true && branchLength<15)
        {
            //page.draw(new Line2D.Double (startX,startY,startX,startY+50));
        }
        else
        {
            this.branchLength = (int)this.branchLength*factorLength;
            this.branchLength= (int)branchLength;
            System.out.println("branchLength inside draw:"+branchLength);
            // this sets the new branch Length
            lAngle = newLength*Math.sin(Math.toRadians(newAngle)); //new X
            rAngle = newLength*Math.cos(Math.toRadians(newAngle)); // new Y
            // Then convert to int version to find the new X and Y
            deltaX = startX-(int)lAngle;
            deltaY = startY-(int)rAngle;
            System.out.println("L R"+lAngle+" "+rAngle);
            System.out.println("X  Y"+deltaX+" "+deltaY);
            page.draw(new Line2D.Double(startX,0, deltaX, deltaY));
//             deltaX= startX-(length*(int)Math.sin(newAngle));
//             deltaY= startY-(length*(int)Math.cos(newAngle));
//             System.out.println("startX startY inside draw:"+ startX+" "+startY);
//             System.out.println("deltaX Y inside draw:"+ deltaX+" "+deltaY);
//             page.draw(new Line2D.Double (x1,y1,startX,startY));
//             
//             drawFractal(startX-deltaX, startY-deltaY, (int)branchLength, newAngle, page);
        }
    }

    public void paintComponent(Graphics page)
    {
        Graphics2D g2= (Graphics2D) page;
        super.paintComponent(page);
        g2.drawLine(startX, 250, 250, startY); //draws the trunk of the tree
        branchColor = new Color(0,0,255);
        drawFractal(startX, startY, (int)branchLength, branchAngle, g2);

    }

}
