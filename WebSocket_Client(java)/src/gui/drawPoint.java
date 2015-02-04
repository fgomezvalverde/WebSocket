package gui;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class contains the method that draws the blue and red dots on the
 * screen.
 *
 * 
 */
public class drawPoint {

    public static void draw_RedPoint(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(pX, pY, 15, 15);
    }

    /**
     * The method drawBluePoint takes a switch that draw the dots on the
     * clients, receiving the following parameters:
     *
     * @param pGraphics graphic where we will draw the points,
     * @param pCoordinate coordinate sent by the server that locate the blue dot
     * towards the red point
     * @param pDir the cardinal int sent by the server may be an int from 0 to 3
     * (0 = west, 1 = east, south 2 =, 3 = north)
     */
    public static void drawBluePoint(Graphics pGraphics, int pCoordinate, int pDir) {
        switch (pDir) {
            //west
            case 0:
                pGraphics.setColor(Color.BLUE);
                pGraphics.fillOval(pX - pCoordinate, pY, 10, 10);
                break;
            //east
            case 1:
                pGraphics.setColor(Color.BLUE);
                pGraphics.fillOval(pX + pCoordinate, pY, 10, 10);
                break;
            //south
            case 2:
                pGraphics.setColor(Color.BLUE);
                pGraphics.fillOval(pX, pY + pCoordinate, 10, 10);
                break;

            case 3:
                //nort
                pGraphics.setColor(Color.BLUE);
                pGraphics.fillOval(pX, pY - pCoordinate, 10, 10);
                break;
            default:
                System.err.println("CARDINAL POINT UNBOUND");
                break;
        }
    }
    static int pX = 255;
    static int pY = 255;
}
