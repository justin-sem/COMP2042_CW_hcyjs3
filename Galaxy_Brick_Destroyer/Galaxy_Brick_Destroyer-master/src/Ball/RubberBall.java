package Ball;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 * This is the RubberBall class
 * which included all the details of the ball
 */
public class RubberBall extends Ball {


    private static final int DEF_RADIUS = 10;
    private static final Color DEF_INNER_COLOR = new Color(246, 248, 248).brighter();
    private static final Color DEF_BORDER_COLOR = new Color(0,0,0);

    /**
     * @param center
     * Rubber Ball constructor
     */
    public RubberBall(Point2D center){

        super(center,DEF_RADIUS,DEF_RADIUS,DEF_INNER_COLOR,DEF_BORDER_COLOR);
    }


    /**
     * @param center
     * @param radiusA
     * @param radiusB
     * @return
     * method which used to make the ball in game
     */
    @Override
    protected Shape makeBall(Point2D center, int radiusA, int radiusB) {

        double x = center.getX() - (radiusA / 2);
        double y = center.getY() - (radiusB / 2);

        return new Ellipse2D.Double(x,y,radiusA,radiusB);
    }
}
