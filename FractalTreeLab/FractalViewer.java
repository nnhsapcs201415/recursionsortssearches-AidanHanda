//********************************************************************
//  KochSnowflakeViewer.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates the use of recursion.
//  @gcschmit (19 July 2014): converted from an applet to an application
//********************************************************************

import java.awt.*;
import javax.swing.*;

public class FractalViewer
{
    private final int WIDTH = 1280;
    private final int HEIGHT = 720;

    private final int MIN = 1, MAX = 9;

    private JButton increase, decrease;
    private JLabel titleLabel, orderLabel;
    private FractalPanel drawing;
    private JPanel panel, tools;
    private JFrame frame;

    //-----------------------------------------------------------------
    //  Sets up the components for the applet.
    //-----------------------------------------------------------------

    public static void main(String[] args)
    {
        FractalViewer viewer = new FractalViewer();
    }

    public FractalViewer()
    {
        tools = new JPanel ();
        tools.setLayout (new BoxLayout(tools, BoxLayout.X_AXIS));
        tools.setBackground (Color.yellow);
        tools.setOpaque (true);

        titleLabel = new JLabel ("Fractal Tree");
        titleLabel.setForeground (Color.black);



        frame = new JFrame();
        frame.setTitle("Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        drawing = new FractalPanel(120, frame.getGraphics());
        panel = new JPanel();
        panel.add (drawing);
        frame.add(panel);
        frame.setVisible(true);
    }


}
