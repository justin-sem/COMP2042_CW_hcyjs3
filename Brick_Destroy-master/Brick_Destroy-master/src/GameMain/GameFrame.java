package GameMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import Component.HighScore;
import Component.Music;



public class GameFrame extends JFrame implements WindowFocusListener {

    private static final String DEF_TITLE = "Galaxy Brick Destroyer";
    private GameBoard gameBoard;
    private HomeMenu homeMenu;
    private GameGuide gameGuide;
    private HighScore highScore;
    private boolean gaming;
    

    public GameFrame(){                                 // GameFrame constructor

        super();
        gaming = false;

        this.setLayout(new BorderLayout());
        gameBoard = new GameBoard(this);
        homeMenu = new HomeMenu(this,new Dimension(650,500));
        this.add(homeMenu,BorderLayout.CENTER);
        this.setUndecorated(true);
        ImageIcon galaxyLogo = new ImageIcon("galaxy.jpg");     // change icon
        this.setIconImage(galaxyLogo.getImage());
        ImageIcon universeBG = new ImageIcon("universe.jpg");     // change BG


    }



    public void initialize(){
        this.setTitle(DEF_TITLE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.autoLocate();
        this.setVisible(true);

    }

    public void enableGameBoard(){
        this.dispose();
        this.remove(homeMenu);
        this.add(gameBoard,BorderLayout.CENTER);
        this.setUndecorated(false);
        this.setResizable(false);
        initialize();
        /*to avoid problems with graphics focus controller is added here*/
        this.addWindowFocusListener(this);

    }
    
    public void enableGameGuide(){
        gameGuide = new GameGuide(this);
        this.dispose();
        this.remove(homeMenu);
        this.add(gameGuide,BorderLayout.CENTER);
        this.setUndecorated(false);

    }

    public void enableHomeMenu(){                   // used when back button from guide is clicked
        this.remove(gameGuide);
        this.add(homeMenu,BorderLayout.CENTER);
        this.dispose();
        this.setUndecorated(true);
        this.setResizable(false);
        initialize();
    }

    public void enableHighScore(){
        highScore = new HighScore(this);
        this.add(highScore,BorderLayout.CENTER);
        this.setUndecorated(true);
        this.setResizable(false);

    }

    private void remove(GameGuide gameGuide) {
    }

    private void add(GameGuide gameGuide, String center) {
    }
    private void add(HighScore highScore, String center){

    }

    private void autoLocate(){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (size.width - this.getWidth())/2 ;
        int y = (size.height - this.getHeight())/2 ;
        this.setLocation(x,y);
    }


    @Override
    public void windowGainedFocus(WindowEvent windowEvent) {
        /*
            the first time the frame loses focus is because
            it has been disposed to install the GameBoard,
            so went it regains the focus it's ready to play.
            of course calling a method such as 'onLostFocus'
            is useful only if the GameBoard as been displayed
            at least once
         */
        gaming = true;
    }

    @Override
    public void windowLostFocus(WindowEvent windowEvent) {
        if(gaming)
            gameBoard.onLostFocus();

    }

}



