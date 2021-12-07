package Brick;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;


public class CopperBrick extends Brick {

    private static final String NAME = "Copper Brick";
    private static final Color DEF_INNER = new Color(176, 99, 5);
    private static final Color DEF_BORDER = new Color(128, 41, 5);
    private static final int COPPER_STRENGTH = 2;
    private Crack crack;
    private Shape brickFace;


    public CopperBrick(Point point, Dimension size){
        super(NAME,point,size,DEF_BORDER,DEF_INNER, COPPER_STRENGTH);
        brickFace = super.brickFace;
        crack = new Crack(DEF_CRACK_DEPTH,DEF_STEPS,brickFace);

    }

    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) {
        return new Rectangle(pos,size);
    }

    @Override
    public boolean setImpact(Point2D point, int dir) {
        if(super.isBroken())
            return false;
        super.impact();
        if(!super.isBroken()){
            crack.makeCrack(point,dir);
            updateBrick();
            return false;
        }
        return true;
    }


    @Override
    public Shape getBrick() {
        return brickFace;
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
