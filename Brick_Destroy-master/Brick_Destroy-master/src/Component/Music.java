package Component;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Music  {

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



