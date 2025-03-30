package com.example.finalproject;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class SoundManager {
    private static Media buttonClickSound;
    private static MediaPlayer buttonClickPlayer;
    private static boolean isSoundOn = true;

    static {
        File soundFile = new File("Music/sounds/camera-flash-204151.mp3"); // Replace with your actual file
        if (soundFile.exists()) {
            buttonClickSound = new Media(soundFile.toURI().toString());
        }
    }

    public static void playButtonClickSound() {
        if (isSoundOn && buttonClickSound != null) {
            buttonClickPlayer = new MediaPlayer(buttonClickSound);
            buttonClickPlayer.play();
        }
    }

    public static void toggleSound() {
        isSoundOn = !isSoundOn;
    }

    public static boolean isSoundEnabled() {
        return isSoundOn;
    }
}

