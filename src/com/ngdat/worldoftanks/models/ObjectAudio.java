package com.ngdat.worldoftanks.models;

import javax.sound.sampled.*;
import java.io.IOException;

/**
 * Created by HDT
 */
public class ObjectAudio {
    private String pathAudio;
    private Clip clip;

    public ObjectAudio(String pathAudio) {
        this.pathAudio = pathAudio;
    }

    public void loop() {
        if (clip != null) {
            clip.stop();
        }
        initAudio();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void play() {
        if (clip != null) {
            clip.stop();
        }
        initAudio();
        clip.start();
    }

    private void initAudio() {
        try {
            AudioInputStream in = AudioSystem.
                    getAudioInputStream(getClass().getResource(pathAudio));
            clip = AudioSystem.getClip();
            clip.open(in);
        } catch (IOException | UnsupportedAudioFileException |
                LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}