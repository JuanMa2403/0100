import java.awt.Color;
import java.util.Random;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numeroDeBolas)
    {
        Random aleatorio=new Random();
        int ground = 400;   // position of the ground line
        BouncingBall[] bolas=new BouncingBall[numeroDeBolas];
        Color[] colores={Color.BLUE,Color.RED,Color.GREEN,Color.GRAY,Color.MAGENTA,Color.CYAN,Color.CYAN};
        int colorDeBola=0;
        int PosicionBolaEnX=0;
        int PosicionBolaEnY=0;
        int diametro=0;
        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        
        //dibuja las bolas
            for(int i=0;i<numeroDeBolas;i++)
        {
            diametro=5+ aleatorio.nextInt(30);
            colorDeBola=aleatorio.nextInt(7);
            PosicionBolaEnX=aleatorio.nextInt(600-diametro);
            PosicionBolaEnY=diametro+aleatorio.nextInt(100);
            bolas[i]=new BouncingBall(PosicionBolaEnX, PosicionBolaEnY, diametro,colores[colorDeBola] , ground, myCanvas);
            bolas[i].draw();
        }


    }
}