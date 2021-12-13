package Ball;

import java.awt.*;
import java.awt.geom.Point2D;           // defines a point representing a location in (x,y) coordinate space
import java.awt.geom.RectangularShape;


/**
 * This is the Ball class
 * which include the properties of the ball
 */
abstract public class Ball {

    public Point2D up;
    public Point2D down;
    public Point2D left;
    public Point2D right;

    private Shape ballFace;
    private Point2D center;
    private Color border;
    private Color inner;
    private int speedX;
    private int speedY;

    /**
     * @param center
     * @param radiusA
     * @param radiusB
     * @param inner
     * @param border
     * Ball constructor which used to build and define the ball
     */
    public Ball(Point2D center,int radiusA,int radiusB,Color inner,Color border){
        this.center = center;

        up = new Point2D.Double();
        down = new Point2D.Double();
        left = new Point2D.Double();
        right = new Point2D.Double();

        up.setLocation(center.getX(),center.getY()-(radiusB / 2));
        down.setLocation(center.getX(),center.getY()+(radiusB / 2));
        left.setLocation(center.getX()-(radiusA /2),center.getY());
        right.setLocation(center.getX()+(radiusA /2),center.getY());                // ball movement (x,y)

        ballFace = makeBall(center,radiusA,radiusB);
        this.border = border;
        this.inner  = inner;
        speedX = 0;
        speedY = 0;
    }

    /**
     * @param center
     * @param radiusA
     * @param radiusB
     * @return
     * method to make the ball
     */
    protected abstract Shape makeBall(Point2D center,int radiusA,int radiusB);

    /**
     * method to define the movement of the ball
     */
    public void move(){
        RectangularShape tmp = (RectangularShape) ballFace;
        center.setLocation((center.getX() + speedX),(center.getY() + speedY));
        double w = tmp.getWidth();
        double h = tmp.getHeight();

        tmp.setFrame((center.getX() -(w / 2)),(center.getY() - (h / 2)),w,h);
        setPoints(w,h);

        ballFace = tmp;
    }

    /**
     * @param x
     * @param y
     * method to set the speed of the ball in both x and y- axis
     */
    public void setSpeed(int x,int y){
        speedX = x;
        speedY = y;
    }

    public void setXSpeed(int s){
        speedX = s;
    }

    public void setYSpeed(int s){
        speedY = s;
    }

    public void reverseX(){
        speedX *= -1;
    }

    public void reverseY(){
        speedY *= -1;
    }

    public Color getBorderColor(){
        return border;
    }

    public Color getInnerColor(){
        return inner;
    }

    public Point2D getPosition(){
        return center;
    }

    public Shape getBallFace(){
        return ballFace;
    }

    /**
     * @param p
     * method to set the location of the ball in frame
     */
    public void moveTo(Point p){
        center.setLocation(p);

        RectangularShape tmp = (RectangularShape) ballFace;
        double w = tmp.getWidth();
        double h = tmp.getHeight();

        tmp.setFrame((center.getX() -(w / 2)),(center.getY() - (h / 2)),w,h);
        ballFace = tmp;
    }

    /**
     * @param width
     * @param height
     * method to set ball location in game
     */
    private void setPoints(double width,double height){
        up.setLocation(center.getX(),center.getY()-(height / 2));
        down.setLocation(center.getX(),center.getY()+(height / 2));

        left.setLocation(center.getX()-(width / 2),center.getY());
        right.setLocation(center.getX()+(width / 2),center.getY());
    }

    public int getSpeedX(){
        return speedX;
    }

    public int getSpeedY(){
        return speedY;
    }


}
