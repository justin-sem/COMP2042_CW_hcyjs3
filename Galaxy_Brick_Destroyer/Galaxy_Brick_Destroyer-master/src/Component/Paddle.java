package Component;

import Ball.Ball;

import java.awt.*;


/**
 * This is the paddle class which build the paddle in the game
 */
public class Paddle {

    public static final Color BORDER_COLOR = new Color(98, 82, 4);
    public static final Color INNER_COLOR = new Color(166, 141, 16).brighter();
    private static final int DEF_MOVE_AMOUNT = 5;

    private Rectangle paddleFace;
    private Point ballPoint;
    private int moveAmount;
    private int min;
    private int max;


    /**
     * @param ballPoint
     * @param width
     * @param height
     * @param container
     * Paddle constructor define and create the paddle
     */
    public Paddle(Point ballPoint, int width, int height, Rectangle container) {

        this.ballPoint = ballPoint;
        moveAmount = 0;
        paddleFace = makeRectangle(width, height);
        min = container.x + (width / 2);
        max = min + container.width - width;

    }

    /**
     * @param width
     * @param height
     * @return
     * method to set the location of the ball on paddle
     */
    private Rectangle makeRectangle(int width,int height){
        Point p = new Point((int)(ballPoint.getX() - (width / 2)),(int)ballPoint.getY());
        return  new Rectangle(p,new Dimension(width,height));
    }

    /**
     * @param b
     * @return
     * method which define after the ball impact with the paddle
     */
    public boolean impact(Ball b){

        return paddleFace.contains(b.getPosition()) && paddleFace.contains(b.down) ;
    }

    /**
     * method which set the ball movement on the paddle
     */
    public void move(){

        double x = ballPoint.getX() + moveAmount;
        if(x < min || x > max)
            return;
        ballPoint.setLocation(x,ballPoint.getY());
        paddleFace.setLocation(ballPoint.x - (int) paddleFace.getWidth()/2,ballPoint.y);
    }

    /**
     * method which define the direction of movement for paddle
     */
    public void moveLeft(){
        moveAmount = -DEF_MOVE_AMOUNT;
    }


    /**
     * method which define the direction of movement for paddle
     */
    public void movRight(){
        moveAmount = DEF_MOVE_AMOUNT;
    }

    /**
     * method which define when the paddle stop
     */
    public void stop(){
        moveAmount = 0;
    }

    /**
     * @return
     * method which return the paddle face
     */
    public Shape getPaddleFace(){
        return paddleFace;
    }

    /**
     * @param p
     * method which set the ball location on the paddle face for movement
     */
    public void moveTo(Point p){
        ballPoint.setLocation(p);
        paddleFace.setLocation(ballPoint.x - (int) paddleFace.getWidth()/2,ballPoint.y);
    }
}
