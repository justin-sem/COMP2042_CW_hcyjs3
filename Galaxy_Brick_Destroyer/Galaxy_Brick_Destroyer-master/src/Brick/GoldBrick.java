package Brick;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.Random;


/**
 * This is the gold brick class
 *  which include the all the details for gold brick
 */
public class GoldBrick extends Brick {

    private static final String NAME = "Gold Brick";
    private static final Color DEF_INNER = new Color(199, 167, 7);
    private static final Color DEF_BORDER = Color.yellow;
    private static final int GOLD_STRENGTH = 1;
    private static final double GOLD_PROBABILITY = 0.7;        // probability for gold brick to break

    private Random rnd;
    private Crack crack;
    private Shape brickFace;

    /**
     * @param point
     * @param size
     * Gold Brick constructor
     */
    public GoldBrick(Point point, Dimension size){
        super(NAME,point,size,DEF_BORDER,DEF_INNER, GOLD_STRENGTH);
        brickFace = super.brickFace;
        crack = new Crack(DEF_CRACK_DEPTH, DEF_STEPS,brickFace);
        rnd = new Random();

    }


    /**
     * @param pos
     * @param size
     * @return
     * method which used to make gold bricks face
     */
    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) {

        return new Rectangle(pos,size);
    }

    @Override
    public Shape getBrick() {
        return brickFace;
    }


    /**
     * @param point
     * @param dir
     * @return
     * method which used when the ball impact the gold bricks
     */
   @Override
   public boolean setImpact(Point2D point, int dir) {
       if (super.isBroken())
           return false;
       impact();
       if (!super.isBroken()) {
           crack.makeCrack(point, dir);
           updateBrick();
           return false;
       }
       return true;
   }

    /**
     * method which used to impact the gold bricks based on probability
     */
    public void impact(){
        if(rnd.nextDouble() < GOLD_PROBABILITY){
            super.impact();
        }
    }

    /**
     * method which update the gold brick condition
     */
    private void updateBrick(){
        if(!super.isBroken()){
            GeneralPath gp = crack.draw();
            gp.append(super.brickFace,false);
            brickFace = gp;
        }
    }

    /**
     * method which repair the gold bricks to original state
     */
    public void repair(){
        super.repair();
        crack.reset();
        brickFace = super.brickFace;
    }

}
