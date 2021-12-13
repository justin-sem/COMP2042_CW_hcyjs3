package Brick;

import java.awt.*;
import java.awt.Point;


/**
 * This is the lead brick class
 * which include the all the details for lead brick
 */
public class LeadBrick extends Brick {

    private static final String NAME = "Lead Brick";
    private static final Color DEF_INNER = new Color(101, 99, 97).darker();
    private static final Color DEF_BORDER = Color.BLACK;
    private static final int LEAD_STRENGTH = 1;


    /**
     * @param point
     * @param size
     * Lead Brick constructor
     */
    public LeadBrick(Point point, Dimension size){

        super(NAME,point,size,DEF_BORDER,DEF_INNER, LEAD_STRENGTH);
    }

    /**
     * @param pos
     * @param size
     * @return
     * method which used to make lead bricks face
     */
    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) {

        return new Rectangle(pos,size);
    }

    @Override
    public Shape getBrick() {

        return super.brickFace;
    }


}
