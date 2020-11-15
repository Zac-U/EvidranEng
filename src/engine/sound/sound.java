package engine.sound;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;

public class sound extends Thread{

    Clip clip;
    boolean loop = false;

    static String directory;

    public sound(String directory, boolean loop){
        File soundFile = new File(directory).getAbsoluteFile();
        AudioInputStream stream;
        AudioFormat format;
        DataLine.Info info;

        this.directory = directory;
        try {
            stream = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(stream);
            this.loop = loop;
            if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        }catch (Exception e){}
    }

    public void play() {
       start();
    }

    @Override
    public synchronized void run() {
        clip.start();
        try {
            while(loop) {
                Thread.sleep(clip.getMicrosecondLength() / 1000);
            }
            Thread.sleep(clip.getMicrosecondLength() / 1000);
            clip.close();
        }catch(Exception e){}
    }

    @Override
    public void interrupt() {
        super.interrupt();
        clip.close();
    }


}
