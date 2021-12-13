package Component;

import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
import java.util.stream.*;

import GameMain.GameBoard;


/**
 * This is Write To File class
 * which to write the score of each round to the file
 */
public class WriteToFile {

    private Wall wall;
    private static final int DEF_WIDTH = 600;
    private static final int DEF_HEIGHT = 450;


    /**
     * Write To File constructor which open and write to the file
     */
    public void WriteToFile () {

        wall = new Wall(new Rectangle(0, 0, DEF_WIDTH, DEF_HEIGHT), 30, 3, 6 / 2, new Point(300, 430));

        try {

            FileWriter myWriter = new FileWriter("Galaxy_Brick_Destroyer/Galaxy_Brick_Destroyer-master/Others/HighScore", true);
            myWriter.write(String.valueOf(GameBoard.temp) + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {

            System.out.println("An error occurred.");
            e.printStackTrace();

        }
    }

}

