package Component;

import Ball.Ball;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.awt.geom.Point2D;
import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    private static final Color DEF_INNER_COLOR = new Color(246, 248, 248).brighter();
    private static final Color DEF_BORDER_COLOR = new Color(0,0,0);

    Wall wallObj = new Wall(new Rectangle(0,0,200,100),10,10,10.0,new Point(100,100));
    Paddle paddleObj = new Paddle(new Point(10,10),20,10,new Rectangle(10,20,20,10));
    Ball ballObj = new Ball(new Point(), 10, 10, DEF_INNER_COLOR, DEF_BORDER_COLOR) {
        @Override
        protected Shape makeBall(Point2D center, int radiusA, int radiusB) {
            return null;
        }
    };



    @Test
    void findImpacts() {
        wallObj.findImpacts();
        assertEquals(0,ballObj.getSpeedX());
    }

    @Test
    void getBrickCount() {
        assertEquals(0,wallObj.getBrickCount());
    }

    @Test
    void getHighScore() {
        assertEquals(0,wallObj.getHighScore());
    }

    @Test
    void getBallCount() {
        assertEquals(3,wallObj.getBallCount());
    }

    @Test
    void isBallLost() {
        assertFalse(wallObj.isBallLost());
    }

    @Test
    void ballReset() {
        wallObj.ballReset();
        assertEquals(new Point(0,0),ballObj.getPosition());
    }


    @Test
    void isDone() {
        if(wallObj.getBrickCount() == 0){
            assertTrue(wallObj.isDone());
        }
    }


    @Test
    void setBallXSpeed() {
        ballObj.setXSpeed(1);
        assertEquals(1, ballObj.getSpeedX());
    }

    @Test
    void setBallYSpeed() {
        ballObj.setYSpeed(1);
        assertEquals(1, ballObj.getSpeedY());
    }

    @Test
    void resetBallCount() {
        assertEquals(3,wallObj.getBallCount());
    }
}