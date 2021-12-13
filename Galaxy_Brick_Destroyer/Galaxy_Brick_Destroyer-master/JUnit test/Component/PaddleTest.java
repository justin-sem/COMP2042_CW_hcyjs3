package Component;

import Ball.RubberBall;
import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

class PaddleTest {

    Rectangle containerObj = new Rectangle(10,20,20 , 10);
    Point ballPointObj = new Point(10,10 );
    Paddle paddleObj = new Paddle(ballPointObj,20,10,containerObj);

    @Test
    void impact() {
        RubberBall ballObj = new RubberBall(ballPointObj);
        paddleObj.impact(ballObj);
        assertTrue(paddleObj.getPaddleFace().contains(ballPointObj));
    }

    @Test
    void move() {
        paddleObj.move();
        assertEquals(new Point(0,10 ), paddleObj.getPaddleFace().getBounds().getLocation());
    }


    @Test
    void moveTo() {
        Point newPointObj = new Point(20,20);
        Point actualPointObj = new Point(10, 20);
        paddleObj.moveTo(newPointObj);
        assertEquals(actualPointObj,paddleObj.getPaddleFace().getBounds().getLocation());
    }
}