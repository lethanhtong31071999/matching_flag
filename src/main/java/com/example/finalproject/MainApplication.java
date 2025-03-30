package com.example.finalproject;

import com.example.finalproject.panes.IntroPane;
import com.example.finalproject.panes.PausePane;
import com.example.finalproject.panes.PlayingPane;
import com.example.finalproject.panes.SettingPane;
import com.example.finalproject.scenes.IntroScene;
import com.example.finalproject.scenes.PauseScene;
import com.example.finalproject.scenes.PlayingScene;
import com.example.finalproject.scenes.SettingScene;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static com.example.finalproject.Const.*;

// stage -> scenes -> panes (border, vbox, hbox)

public class MainApplication extends Application {
    public static Stage mainStage;
    public static ArrayList<Image> imageList = new ArrayList<>();
    static {
        // imageList.add(new Image("com/example/finalproject/flags/placeholder.png"));
    }
    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;

        //======= Background Music as well as Background Sounds =========\\
        File backgroundMusic = new File("Music/background");
        File[] listOfMusic = backgroundMusic.listFiles();
        ArrayList<String> songNames = new ArrayList<>();
        for(File file : listOfMusic){
            if(file.isFile()){
                songNames.add(file.getName());
            }
        }

        String song = new File("Music/background/" + songNames.get(0)).toURI().toString();
        media = new Media(song);
        mediaPlayer = new MediaPlayer(Const.media);
        mediaPlayer.play();

        Const.playingPane = new PlayingPane();
        Const.settingPane = new SettingPane();
        Const.pausePane = new PausePane();

        Const.playingScene = new PlayingScene(Const.playingPane);
        Const.settingScene = new SettingScene(Const.settingPane);
        Const.pauseScene = new PauseScene(Const.pausePane);

        mainStage.setTitle("Flag Matching");
        mainStage.setMinHeight(700);
        mainStage.setMinWidth(700);
        mainStage.setScene(new IntroScene());
        mainStage.show();
    }
}
