package Component;

import Ball.*;          // import package Ball
import Brick.*;         // import package Brick
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;


/**
 * This is the Wall Class which include the details about wall
 */
public class Wall {

    private static final int LEVELS_COUNT = 5;

    private static final int LEAD = 1;
    private static final int GOLD = 2;
    private static final int COPPER = 3;
    private static final int DIAMOND = 4;

    private Random rnd;
    private Rectangle area;

    public Brick[] bricks;
    public Ball ball;
    public Paddle paddle;

    private Brick[][] levels;
    private int level;

    private Point startPoint;
    private int brickCount;
    private int ballCount;
    private boolean ballLost;
    public int highScore = 0;


    /**
     * @param drawArea
     * @param brickCount
     * @param lineCount
     * @param brickDimensionRatio
     * @param ballPos
     * wall constructor which define the details of the components in game
     */
    public Wall(Rectangle drawArea, int brickCount, int lineCount, double brickDimensionRatio, Point ballPos){

        this.startPoint = new Point(ballPos);

        levels = makeLevels(drawArea,brickCount,lineCount,brickDimensionRatio);
        level = 0;

        ballCount = 3;
        ballLost = false;

        rnd = new Random();

        makeBall(ballPos);
        int speedX,speedY;

        do{
            speedX = rnd.nextInt(5) -4;
        }while(speedX == 0);
        do{
            speedY = -rnd.nextInt(4) -3 ;               // for Y-axis -ve will go up
        }while(speedY == 0);

        ball.setSpeed(speedX,speedY);

        paddle = new Paddle((Point) ballPos.clone(),150,10, drawArea);

        area = drawArea;


    }

    /**
     * @param drawArea
     * @param brickCnt
     * @param lineCnt
     * @param brickSizeRatio
     * @param type
     * @return
     * method which define and calculate the number of brick and line inorder to draw it in game
     * if brickCount is not divisible by line count,brickCount is adjusted to the biggest
     * multiple of lineCount smaller then brickCount
     */
    private Brick[] makeSingleTypeLevel(Rectangle drawArea, int brickCnt, int lineCnt, double brickSizeRatio, int type){

        brickCnt -= brickCnt % lineCnt;

        int brickOnLine = brickCnt / lineCnt;

        double brickLen = drawArea.getWidth() / brickOnLine;
        double brickHgt = brickLen / brickSizeRatio;

        brickCnt += lineCnt / 2;

        Brick[] tmp  = new Brick[brickCnt];

        Dimension brickSize = new Dimension((int) brickLen,(int) brickHgt);
        Point p = new Point();

        int i;
        for(i = 0; i < tmp.length; i++){
            int line = i / brickOnLine;
            if(line == lineCnt)
                break;
            double x = (i % brickOnLine) * brickLen;
            x =(line % 2 == 0) ? x : (x - (brickLen / 2));
            double y = (line) * brickHgt;
            p.setLocation(x,y);
            tmp[i] = makeBrick(p,brickSize,type);
        }

        for(double y = brickHgt;i < tmp.length;i++, y += 2*brickHgt){
            double x = (brickOnLine * brickLen) - (brickLen / 2);
            p.setLocation(x,y);
            tmp[i] = new LeadBrick(p,brickSize);
        }
        return tmp;

    }

    /**
     * @param drawArea
     * @param brickCnt
     * @param lineCnt
     * @param brickSizeRatio
     * @param typeA
     * @param typeB
     * @return
     * if brickCount is not divisible by line count,brickCount is adjusted to the biggest
     * multiple of lineCount smaller then brickCount
     */
    private Brick[] makeChessboardLevel(Rectangle drawArea, int brickCnt, int lineCnt, double brickSizeRatio, int typeA, int typeB){

        brickCnt -= brickCnt % lineCnt;

        int brickOnLine = brickCnt / lineCnt;

        int centerLeft = brickOnLine / 2 - 1;
        int centerRight = brickOnLine / 2 + 1;

        double brickLen = drawArea.getWidth() / brickOnLine;
        double brickHgt = brickLen / brickSizeRatio;

        brickCnt += lineCnt /2;

        Brick[] tmp  = new Brick[brickCnt];

        Dimension brickSize = new Dimension((int) brickLen,(int) brickHgt);
        Point p = new Point();

        int i;
        for(i = 0; i < tmp.length; i++){
            int line = i / brickOnLine;
            if(line == lineCnt)
                break;
            int posX = i % brickOnLine;
            double x = posX * brickLen;
            x =(line % 2 == 0) ? x : (x - (brickLen / 2));
            double y = (line) * brickHgt;
            p.setLocation(x,y);

            boolean b = ((line % 2 == 0 && i % 2 == 0) || (line % 2 != 0 && posX > centerLeft && posX <= centerRight));
            tmp[i] = b ?  makeBrick(p,brickSize,typeA) : makeBrick(p,brickSize,typeB);
        }

        for(double y = brickHgt;i < tmp.length;i++, y += 2*brickHgt){
            double x = (brickOnLine * brickLen) - (brickLen / 2);
            p.setLocation(x,y);
            tmp[i] = makeBrick(p,brickSize,typeA);
        }
        return tmp;
    }

    private void makeBall(Point2D ballPos){
        ball = new RubberBall(ballPos);
    }

    /**
     * @param drawArea
     * @param brickCount
     * @param lineCount
     * @param brickDimensionRatio
     * @return
     * method which make the levels in the game
     */
    private Brick[][] makeLevels(Rectangle drawArea,int brickCount,int lineCount,double brickDimensionRatio){
        Brick[][] tmp = new Brick[LEVELS_COUNT][];
        tmp[0] = makeSingleTypeLevel(drawArea,brickCount,lineCount,brickDimensionRatio,LEAD);
        tmp[1] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio, LEAD,GOLD);
        tmp[2] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio, LEAD, COPPER);
        tmp[3] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio, GOLD, COPPER);
        tmp[4] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,COPPER,DIAMOND);
        return tmp;
    }

    /**
     * method which able the paddle and ball to move
     */
    public void move(){
        paddle.move();
        ball.move();
    }

    /**
     * for efficiency reverse is done into method impactWall
     * because for every brick program checks for horizontal and vertical impacts
     */
    public void findImpacts(){
        if(paddle.impact(ball)){
            ball.reverseY();
        }
        else if(impactWall()){

            brickCount--;
            highScore++;                            // after a brick break, score +1
        }
        else if(impactBorder()) {
            ball.reverseX();
        }
        else if(ball.getPosition().getY() < area.getY()){
            ball.reverseY();
        }
        else if(ball.getPosition().getY() > area.getY() + area.getHeight()){
            ballCount--;
            ballLost = true;
        }
    }

    /**
     * @return
     * method to define the wall impaction on vertical and horizontal
     */
    private boolean impactWall(){
        for(Brick b : bricks){
            switch(b.findImpact(ball)) {
                //Vertical Impact
                case Brick.UP_IMPACT:
                    ball.reverseY();
                    return b.setImpact(ball.down, Crack.UP);
                case Brick.DOWN_IMPACT:
                    ball.reverseY();
                    return b.setImpact(ball.up,Crack.DOWN);

                //Horizontal Impact
                case Brick.LEFT_IMPACT:
                    ball.reverseX();
                    return b.setImpact(ball.right,Crack.RIGHT);
                case Brick.RIGHT_IMPACT:
                    ball.reverseX();
                    return b.setImpact(ball.left,Crack.LEFT);
            }
        }
        return false;
    }

    /**
     * @return
     * method which return the position after the border impaction
     */
    private boolean impactBorder(){
        Point2D p = ball.getPosition();
        return ((p.getX() < area.getX()) ||(p.getX() > (area.getX() + area.getWidth())));
    }

    public int getBrickCount(){
        return brickCount;
    }

    public int getHighScore(){
        return highScore;
    }

    public int getBallCount(){
        return ballCount;
    }

    public boolean isBallLost(){
        return ballLost;
    }

    /**
     * method which used when resetting the ball
     */
    public void ballReset(){
        paddle.moveTo(startPoint);
        ball.moveTo(startPoint);
        int speedX,speedY;
        do{
            speedX = rnd.nextInt(5) - 4;
        }while(speedX == 0);
        do{
            speedY = -rnd.nextInt(4) - 3;
        }while(speedY == 0);

        ball.setSpeed(speedX,speedY);
        ballLost = false;
    }

    /**
     * method which used when resetting the wall
     */
    public void wallReset(){
        for(Brick b : bricks)
            b.repair();
        brickCount = bricks.length;
        ballCount = 3;
    }

    /**
     * @return
     * method which return when the ball finished
     */
    public boolean ballEnd(){
        return ballCount == 0;
    }

    /**
     * @return
     * method which return when the game is finished
     */
    public boolean isDone(){
        return brickCount == 0;
    }

    /**
     * method which used player complete a level and go to next
     */
    public void nextLevel(){
        bricks = levels[level++];
        this.brickCount = bricks.length;

    }

    /**
     * @return
     * method which return the level to define the total numbers of level
     */
    public boolean hasLevel(){
        return level < levels.length;
    }

    /**
     * @param s
     * method which set the ball x-coordinate speed by passing param s
     */
    public void setBallXSpeed(int s){
        ball.setXSpeed(s);
    }

    /**
     * @param s
     * method which set the ball y-coordinate speed by passing param s
     */
    public void setBallYSpeed(int s){
        ball.setYSpeed(s);
    }

    /**
     * method which return the ball num to 3 when reset
     */
    public void resetBallCount(){
        ballCount = 3;
    }

    /**
     * @param point
     * @param size
     * @param type
     * @return
     * method which used to make the different types of brick
     */
    private Brick makeBrick(Point point, Dimension size, int type){
        Brick out;
        switch(type){
            case LEAD:
                out = new LeadBrick(point,size);
                break;
            case GOLD:
                out = new GoldBrick(point,size);
                break;
            case COPPER:
                out = new CopperBrick(point, size);
                break;
            case DIAMOND:
                out = new DiamondBrick(point,size);
                break;
            default:
                throw new IllegalArgumentException(String.format("Unknown Type:%d\n",type));
        }
        return  out;
    }

}
