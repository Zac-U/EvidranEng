package engine.sound;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class sound{

    Long currentFrame;
    Clip clip;
    AudioInputStream audioInputStream;

    static String directory;

    public sound(String directory, boolean loop) throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        this.directory = directory;
        audioInputStream = AudioSystem.getAudioInputStream(new File(directory).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        if(loop) {clip.loop(Clip.LOOP_CONTINUOUSLY);}

    }

    public void play() {
        clip.start();
    }
}
