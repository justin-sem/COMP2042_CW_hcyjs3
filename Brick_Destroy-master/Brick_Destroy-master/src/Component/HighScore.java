package Component;



import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;


public class HighScore extends JFrame {


    JFrame highScoreFrame = new JFrame();
    JLabel scoreLabel1 = new JLabel();
    JLabel scoreLabel2 = new JLabel();
    JTextArea scoreLabel3 = new JTextArea(10, 20);


    public HighScore(JFrame owner) {

        highScoreFrame.setUndecorated(true);
        highScoreFrame.setSize(550, 350);
        highScoreFrame.setLayout(null);
        highScoreFrame.setVisible(true);
        highScoreFrame.setFocusable(true);
        highScoreFrame.setResizable(false);
        highScoreFrame.requestFocusInWindow();
        highScoreFrame.getContentPane().setBackground(new Color(0, 0, 0));
        centreWindow(highScoreFrame);
        highScoreFrame.add(scoreLabel1);
        highScoreFrame.add(scoreLabel2);
        highScoreFrame.add(scoreLabel3);

        highScoreFrame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(166, 141, 16)));
        highScoreFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
                    highScoreFrame.dispose();
                }

            }
        });

        scoreLabel1.setText("Hall of Galaxy");
        scoreLabel1.setBounds(135, 0, 300, 50);
        scoreLabel1.setFont(new Font("Algerian", Font.BOLD, 35));
        scoreLabel1.setForeground(new Color(166, 141, 16));

        scoreLabel2.setText("press SPACE to restart the game");
        scoreLabel2.setBounds(150, 300, 400, 50);
        scoreLabel2.setFont(new Font("GEORGIA", Font.BOLD, 15));
        scoreLabel2.setForeground(new Color(111, 229, 15));

        scoreLabel3.setBounds(96, 140, 400, 100);
        scoreLabel3.setFont(new Font("GEORGIA", Font.PLAIN, 40));
        scoreLabel3.setForeground(new Color(243, 66, 72));
        scoreLabel3.setBackground(Color.BLACK);


        // read file
        try {
            File myObj = new File("HighScore");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                scoreLabel3.setText(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }


        public static void centreWindow (Window highScoreFrame)
        {            // make the high score window display at middle of screen
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((dimension.getWidth() - highScoreFrame.getWidth()) / 2);
            int y = (int) ((dimension.getHeight() - highScoreFrame.getHeight()) / 2);
            highScoreFrame.setLocation(x, y);

        }



    }






