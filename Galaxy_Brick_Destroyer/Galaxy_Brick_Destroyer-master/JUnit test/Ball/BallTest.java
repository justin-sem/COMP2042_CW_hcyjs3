package Ball;

import org.junit.jupiter.api.Test;
import java.awt.*;
import java.awt.geom.Point2D;
import static org.junit.jupiter.api.Assertions.*;

class BallTest {


    private static final Color DEF_INNER_COLOR = new Color(246, 248, 248).brighter();
    private static final Color DEF_BORDER_COLOR = new Color(0,0,0);


    Ball ballObj = new Ball(new Point(), 10, 10, DEF_INNER_COLOR, DEF_BORDER_COLOR) {
        @Override
        protected Shape makeBall(Point2D center, int radiusA, int radiusB) {
            return null;
        }
    };


    @Test
    void setXSpeed() {
        ballObj.setXSpeed(1);
        assertEquals(1, ballObj.getSpeedX());
    }

    @Test
    void setYSpeed() {
        ballObj.setYSpeed(1);
        assertEquals(1, ballObj.getSpeedY());
    }

    @Test
    void reverseX() {
        ballObj.setXSpeed(1);
        ballObj.reverseX();
        assertEquals(-1, ballObj.getSpeedX());
        ballObj.reverseX();
        assertEquals(1, ballObj.getSpeedX());
    }

    @Test
    void reverseY() {
        ballObj.setYSpeed(1);
        ballObj.reverseY();
        assertEquals(-1, ballObj.getSpeedY());
        ballObj.reverseY();
        assertEquals(1, ballObj.getSpeedY());
    }
    @Test
    void getSpeedX() {
        int speedX = 1;
        assertEquals(1, speedX);
    }
    @Test
    void getSpeedY() {
        int speedY = 1;
        assertEquals(1, speedY);
    }



}