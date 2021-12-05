package Component;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

import GameMain.GameBoard;

public class WriteToFile {

    private Wall wall;
    private static final int DEF_WIDTH = 600;
    private static final int DEF_HEIGHT = 450;




    public void WriteToFile(){



        wall = new Wall(new Rectangle(0,0,DEF_WIDTH, DEF_HEIGHT),30,3,6/2,new Point(300,430));
        try {
            FileWriter myWriter = new FileWriter("HighScore", true);

            myWriter.write("High Score:  " + String.valueOf(GameBoard.temp) + " points\n");

            myWriter.close();


            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
