package Component;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * This is the Music class for the music in the game
 */
public class Music  {

        /**
         * @param musicLocation
         * method which read music file and start to play the music
         */
        public void playMusic(String musicLocation){
                try{
                        File musicPath = new File(musicLocation);
                        if (musicPath.exists()){
                                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                                Clip clip  = AudioSystem.getClip();
                                clip.open(audioInput);
                                clip.start();
                                clip.loop(Clip.LOOP_CONTINUOUSLY);                      // will keep re-plying until program stop

                        }
                        else{
                                System.out.println("Invalid File");
                        }

                }catch (Exception ex){
                        ex.printStackTrace();
                }
        }

}



