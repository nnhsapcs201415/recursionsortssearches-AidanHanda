//********************************************************************
//  KochPanel.java       Author: Lewis/Loftus/Cocking
//
//  Represents a drawing surface on which to paint a Koch Snowflake.
//********************************************************************

import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Line2D;

public class FractalPanel extends JPanel {
    /** The Panel Width */
    private final int PANEL_WIDTH = 1280;
    private final int PANEL_HEIGHT = 720;
    private final double LENGTH_SCALE_FACTOR = 0.8;
    private final double ANGLE_SCALE = 25;
    /** Start length of a branch --> Assigned in the constructor */
    private double length;
    private final double START_WIDTH  = 5;
    private final double WIDTH_SCALE = 0.5;

    //-----------------------------------------------------------------
    //  Sets the initial fractal order to the value specified.
    //-----------------------------------------------------------------
    public FractalPanel (double length, Graphics page)
    {
        setBackground (Color.black);
        setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.length = length;
    }

    //-----------------------------------------------------------------
    //  Draws the fractal recursively. Base case is an order of 1 for
    //  which a simple straight line is drawn. Otherwise three
    //  intermediate points are computed, and each line segment is
    //  drawn as a fractal.
    //-----------------------------------------------------------------
    public void drawFractal (double length, double x, double y, double angle, Graphics page, double width, int iter)
    {
        Graphics2D g2 = (Graphics2D) page;

        if(length <= 1) {
            return;
        }

        double x2 = x + (Math.cos(Math.toRadians(angle)) *  length);
        double y2 = y + (Math.sin(Math.toRadians(angle)) * length);
        float width2 = (float)(width * WIDTH_SCALE);
        g2.setStroke(new BasicStroke((width2)));
        g2.setColor(Color.getHSBColor(255f/360f, (42f+((iter*4 <= 68) ? iter*4 : 68))/100, 1));
        g2.draw(new Line2D.Double(x,y,x2,y2));

        drawFractal(length * LENGTH_SCALE_FACTOR, x2, y2, angle + ANGLE_SCALE, page, width2, iter + 1);
        drawFractal(length * LENGTH_SCALE_FACTOR, x2, y2, angle - ANGLE_SCALE*1/2, page, width2, iter + 1);


    }

    //-----------------------------------------------------------------
    //  Performs the initial calls to the drawFractal method.
    //-----------------------------------------------------------------
    public void paintComponent (Graphics page)
    {
        super.paintComponent (page);

        page.setColor (Color.green);
        drawFractal(length, this.getWidth() / 2, this.getHeight(), -90, page, START_WIDTH, 1);

    }

}
