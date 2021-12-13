package Brick;

import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

class LeadBrickTest {

    Rectangle brickObj = new Rectangle(new Point(0,0),new Dimension(20,10));
    LeadBrick leadBrickObj = new LeadBrick(new Point(0,0),new Dimension(20,10));


    @Test
    void makeBrickFace() {
        Point pos = new Point(0,0);
        Dimension size = new Dimension(20,10);
        assertEquals(brickObj,leadBrickObj.makeBrickFace(pos,size));

    }

    @Test
    void getBrick() {
        assertEquals(brickObj,leadBrickObj.getBrick());
    }
}