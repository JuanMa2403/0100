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
            PosicionBolaEnX=aleatorio.nextInt(300-diametro);
            PosicionBolaEnY=diametro+aleatorio.nextInt(100);
            bolas[i]=new BouncingBall(PosicionBolaEnX, PosicionBolaEnY, diametro,colores[colorDeBola] , ground, myCanvas);
            bolas[i].draw();
        }

        
        boolean finished =  false;
        int numDeBola=0;
        while(!finished) {
            if(numDeBola==numeroDeBolas) {
                numDeBola=0;
            }
            bolas[numDeBola].move();
            myCanvas.wait(10);            
            // stop once ball has travelled a certain distance on x axis

            if(bolas[numDeBola].getXPosition() >= 550) {
                finished = true;

            }        

            numDeBola++;
        }

    }

    /**
     * Dibuja un rectangulo en funcion de los parametros
     * @param valorReiterativo1: determina el origen partiendo de la esquina superior irquierda. Dibuja dos lineas perpendiculares
     * @param valorReiterativo2: indica la posicion en Y de la base
     * @param valorReiterativo3: indica la posicion en X del lado derecho
     * @return un array que puede ser utilizado en para determinar limites 
     */
    private int[] drawRectanble(int valorReiterativo1,int valorReiterativo2,int valorReiterativo3)
    {   
        // Ejemplo:
        // int valorReiterativo1=50;
        //int valorReiterativo2=200;
        // int valorReiterativo3=250;
        int[] parametros={valorReiterativo1,valorReiterativo2,valorReiterativo3};

        myCanvas.drawLine(valorReiterativo1, valorReiterativo1, valorReiterativo3, valorReiterativo1);
        myCanvas.drawLine(valorReiterativo1, valorReiterativo1, valorReiterativo1, valorReiterativo2);
        myCanvas.drawLine(valorReiterativo1, valorReiterativo2, valorReiterativo3, valorReiterativo2);
        myCanvas.drawLine(valorReiterativo3, valorReiterativo2, valorReiterativo3, valorReiterativo1);

        return parametros;

    }

    /**
    Delimita la zona rectangular donde se mueven las bolas
    @param numeroDeBolas determina el numero de bolas
     * 
     */
    public void boxBounce(int numeroDeBolas){
        Random aleatorio=new Random();
        int ground = 450;   // posicion en Y de la base
        BoxBall[] bolas=new BoxBall[numeroDeBolas];
        Color[] colores={Color.BLUE,Color.RED,Color.GREEN,Color.GRAY,Color.MAGENTA,Color.CYAN,Color.CYAN};
        int colorDeBola=0;
        int PosicionBolaEnX=0;
        int PosicionBolaEnY=0;
        int diametro=0;
        int top=50;//origen en Y
        int right=50;//origen en X
        int left=525;//posision en X del lado izquierdo
        myCanvas.setVisible(true);
        int azar1=aleatorio.nextInt(20);
        int azar2=aleatorio.nextInt(20);
        //dibuja el rectangulo
        drawRectanble(50 ,450,525);
        //dibuja las bolas con diametro posicion y color aleatorios
        for(int i=0;i<numeroDeBolas;i++)
        {
            diametro=5+ aleatorio.nextInt(30);
            colorDeBola=aleatorio.nextInt(7);
            PosicionBolaEnX=51+diametro+aleatorio.nextInt(100);
            PosicionBolaEnY=51+diametro+aleatorio.nextInt(100);

            bolas[i]=new BoxBall(PosicionBolaEnX, PosicionBolaEnY, diametro,colores[colorDeBola] , ground,top,right,left, myCanvas);
            bolas[i].draw();
        }

        // make them bounce
        boolean finished =  false;
        int numDeBola=0;
        int numeroDEColisionesIzqda=0;
        while(!finished) {
            if(numDeBola==numeroDeBolas) {
                numDeBola=0;
            }
            bolas[numDeBola].move(azar1,azar2);
            myCanvas.wait(2);        

            if(bolas[numDeBola].getXPosition() >= 550) {

                numeroDEColisionesIzqda++;
                if(numeroDEColisionesIzqda==7){ finished = true;}

            }        
            numDeBola++;
        }
    }
  

}