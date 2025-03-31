package com.example.finalproject.panes;

import com.example.finalproject.Const;
import com.example.finalproject.MainApplication;
import com.example.finalproject.SoundManager;
import com.example.finalproject.components.Type;
import com.example.finalproject.components.buttons.ButtonBase;
import com.example.finalproject.scenes.IntroScene;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class SettingPane extends BorderPane {

    public SettingPane(){
        // Buttons in the Pause Menu
        ButtonBase back = new ButtonBase("Back", Type.SECONDARY);
        ButtonBase music = new ButtonBase("Music ON", Type.PRIMARY);
        ButtonBase background = new ButtonBase("Background Sounds ON", Type.PRIMARY);

        back.setOnAction(e->{
            MainApplication.mainStage.setScene(new IntroScene());
            SoundManager.playButtonClickSound();
        });

        music.setOnAction(e -> {
            if (Const.mediaPlayer != null) {
                if (Const.isMusicPlaying) {
                    Const.mediaPlayer.pause();
                    music.setText("Music OFF");
                    Const.isMusicPlaying = false;
                } else {
                    Const.mediaPlayer.play();
                    music.setText("Music ON");
                    Const.isMusicPlaying = true;
                }
            }
            SoundManager.playButtonClickSound();
        });


        background.setOnAction(e -> {
            SoundManager.toggleSound();
            if (SoundManager.isSoundEnabled()) {
                background.setText("Background Sounds ON");
            } else {
                background.setText("Background Sounds OFF");
            }
        });


        HBox center = new HBox(20);
        HBox top = new HBox();
        center.setAlignment(Pos.CENTER);
        top.setAlignment(Pos.TOP_LEFT);

        center.getChildren().addAll(music, background);
        top.getChildren().add(back);
        this.setCenter(center);
        this.setTop(top);
    }

}
