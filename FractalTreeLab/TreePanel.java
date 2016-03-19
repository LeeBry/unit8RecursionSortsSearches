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
    private double branchLength;
    // This is the branch level
    private double branchAngle = 50;
    private double rAngle, lAngle;
    // angle
    private double factorLength;
    /**
     * Constructor for objects of class TreePanel
     */
    public TreePanel(double branch)
    {
        System.out.println("This is inside the TreePanel");
        this.branchLength = branch;
        System.out.println("branchLength: "+ branch);
        this.branchAngle= branchAngle;
        System.out.println("branchAngle: "+branchAngle);
        this.factorLength= 0.8;
        System.out.println("FactorLength: "+factorLength);
        this.rAngle= 10;
        this.lAngle= 10;
        System.out.println("rAngle and lAngle"+ rAngle+""+lAngle);
        setBackground (Color.white);
        setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));   
    }

    public void drawFractal (int x1, int y1, int length,double angle, Graphics2D page)
    {
        // int lengthSin, lengthCos;
        // Dont use instance variables. Use the parameter values
         lAngle = branchAngle+ this.lAngle;
         rAngle = branchAngle- this.rAngle;
        // something is wrong with the angle. *******
        if (true && branchLength<15)
        {
            page.draw(new Line2D.Double (x1,y1,x2,y2));
        }
        else
        {
            this.branchLength = (int)this.branchLength*factorLength;
            System.out.println("branchLength inside draw:"+branchLength);
            System.out.println("lAngle and rAngle :"+ lAngle+" "+rAngle);
            int x2= x1-length*(int)Math.sin(lAngle);
            int y2= y1-length*(int)Math.cos(lAngle);

            System.out.println("x2 y2 inside draw:"+ x2+" "+y2);

            page.draw(new Line2D.Double (x1,y1,x2,y2));

            drawFractal(x2, y2, (int)branchLength, lAngle, page);

            int x3= x1+length*(int)Math.sin(rAngle*Math.PI/180);
            int y3= y2-length*(int)Math.cos(rAngle*Math.PI/180);

            page.draw(new Line2D.Double (x1,y1,x3,y3));
            drawFractal(x3, y3, (int)branchLength, rAngle, page);

        }
    }

    public void paintComponent(Graphics page)
    {
        Graphics2D g2= (Graphics2D) page;
        super.paintComponent(page);
        g2.drawLine(x1, y1, x1, y1+100); //draws the trunk of the tree

        drawFractal(x1, y1, (int)branchLength, rAngle, g2);

    }

}
