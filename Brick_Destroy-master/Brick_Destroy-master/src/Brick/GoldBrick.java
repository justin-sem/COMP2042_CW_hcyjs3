package Brick;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;


public class GoldBrick extends Brick {

    private static final String NAME = "Gold Brick";
    private static final Color DEF_INNER = new Color(199, 167, 7);
    private static final Color DEF_BORDER = Color.yellow;
    private static final int GOLD_STRENGTH = 1;
    private static final double GOLD_PROBABILITY = 0.7;        // probability for gold brick to break

    private Random rnd;
    private Shape brickFace;

    public GoldBrick(Point point, Dimension size){
        super(NAME,point,size,DEF_BORDER,DEF_INNER, GOLD_STRENGTH);
        rnd = new Random();
        brickFace = super.brickFace;
    }


    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) {
        return new Rectangle(pos,size);
    }

    @Override
    public Shape getBrick() {
        return brickFace;
    }

    public  boolean setImpact(Point2D point , int dir){
        if(super.isBroken())
            return false;
        impact();
        return  super.isBroken();
    }

    public void impact(){
        if(rnd.nextDouble() < GOLD_PROBABILITY){
            super.impact();
        }
    }

}
