package Brick;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.Random;

public class DiamondBrick extends Brick {

    private static final String NAME = "Diamond Brick";
    private static final Color DEF_INNER = makeTransparent(Color.BLACK,1);
    private static final Color DEF_BORDER = new Color(62, 227, 227);
    private static final int DIAMOND_STRENGTH = 2;
    private static final double DIAMOND_PROBABILITY = 0.7;

    private Crack crack;
    private Random rnd;
    private Shape brickFace;


    public static Color makeTransparent(Color source, int alpha){               // method to make diamond brick transparent
        return new Color(source.getRed(), source.getGreen(), source.getBlue(), alpha);
    }


    public DiamondBrick(Point point, Dimension size) {
        super(NAME, point, size, DEF_BORDER, DEF_INNER, DIAMOND_STRENGTH);
        brickFace = super.brickFace;
        crack = new Crack(DEF_CRACK_DEPTH, DEF_STEPS,brickFace);
        rnd = new Random();

    }

    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) {

        return new Rectangle(pos, size);
    }

    @Override
    public Shape getBrick() {
        return brickFace;
    }

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


    public void impact() {
        if (rnd.nextDouble() < DIAMOND_PROBABILITY) {
            super.impact();
        }
    }


    private void updateBrick(){
        if(!super.isBroken()){
            GeneralPath gp = crack.draw();
            gp.append(super.brickFace,false);
            brickFace = gp;
        }
    }

    public void repair(){
        super.repair();
        crack.reset();
        brickFace = super.brickFace;
    }
}
