import java.awt.*;
import java.awt.geom.*;

/**
 * Class BouncingBall - a graphical ball that observes the effect of gravity. The ball
 * has the ability to move. Details of movement are determined by the ball itself. It
 * will fall downwards, accelerating with time due to the effect of gravity, and bounce
 * upward again when hitting the ground.
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Michael Kölling (mik)
 * @author David J. Barnes
 * @author Bruce Quig
 *
 * @version 2011.07.31
 */

public class BoxBall
{
    private static final int GRAVITY = 3;  // effect of gravity

    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;      // y position of ground
    private Canvas canvas;
    private int ySpeed = 1;//elocidad en y 
    private int xSpeed=1;// velocidad en x
    private int top;// margen superior
    private int right;//posicion en x del lado derecho del rectangulo
    private int left;//margen irquierdo

      /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground 
     * @param drawingCanvas  the canvas to draw this ball on
     * @param t margen superior
     * @param r posicion en x del lado derecho del rectangulo
     * @param l margen izquierdo
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
    int groundPos,int t,int r, int l, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        top=t;
        right=r;
        left=l;
        canvas = drawingCanvas;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
        
        // compute new position       
        yPosition += ySpeed;
        xPosition +=xSpeed;

        // check if it has hit the ground
        if(yPosition >= (groundPosition - diameter)  && ySpeed > 0) {
            yPosition = (int)(groundPosition - diameter);
            ySpeed = -ySpeed ;
        }
          if(xPosition >= (left - diameter) && xSpeed > 0) {
            xPosition = (int)(left - diameter);
            xSpeed = -xSpeed ;
        }
         if(yPosition <= (top)  && ySpeed < 0) {
            yPosition = (int)(top);
            ySpeed = ySpeed*(-1) ;
        }
         if(xPosition <= (right)  && xSpeed < 0) {
            xPosition = (int)(right);
            xSpeed = xSpeed*(-1) ;
        }

        // draw again at new position
        draw();
    }  

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
