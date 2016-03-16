import java.awt.*;
import javax.swing.*;

/**
 * Write a description of class FractalTree here.
 * 
 * @author (Bryce Lee) 
 * @version (3/15/2016)
 */
public class FractalTreeViewer
{
    private final int WIDTH = 500;
    private final int HEIGHT= 500;
    // Dimensions of the frame
    private final int BRANCHING= 10;
    // Number of times the tree will branch off
    private JPanel panel;
    private TreePanel draw;
    private JFrame frame;
    /**
     * Constructor for objects of class FractalTree
     */
    public static void main(String[] args)
    {
        FractalTreeViewer view= new FractalTreeViewer();
    }
    
    public FractalTreeViewer()
    {
        draw = new TreePanel(1);
        panel = new JPanel();
        panel.add(draw);
        
        frame = new JFrame();
        frame.setTitle("Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.add(panel);
        frame.setVisible(true); 
        
    }
}
