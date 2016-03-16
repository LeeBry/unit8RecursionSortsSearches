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
    
    private final int R_TOPX=100;
    private final int R_TOPY=100;
    // points for the right branch
    private final int L_TOPX=100;
    private final int L_TOPY=100; 
    // points for the left branch
    private int originX;
    private int originY;
    // Origin of the original branch
    private Color branchColor;
    // Color of the branch
    private int branchLevel;
    // This is the branch level
    /**
     * Constructor for objects of class TreePanel
     */
    public TreePanel(int branch)
    {
      branchLevel = branch;
      setBackground (Color.black);
      setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));   
    }
    
    public void paintComponent(Graphics g2)
    {
        super.paintComponent(g2);

    }
    
    public void drawFractal (int branch, int originX, int originY, 
                             int x2, int y2, Graphics g2)
    {
      

      if (branch <= 10)
      {
         g2.drawLine (originX, originY, x2, y2);
     
      }
    }

}
