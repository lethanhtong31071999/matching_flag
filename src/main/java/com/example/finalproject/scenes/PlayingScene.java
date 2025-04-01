package com.example.finalproject.scenes;

import com.example.finalproject.Const;
import com.example.finalproject.panes.PlayingPane;

import static com.example.finalproject.MainApplication.mainStage;

public class PlayingScene extends MyScene{
    public PlayingScene(PlayingPane playingPane) {
        super(playingPane, Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
        mainStage.setTitle("Matching Flag Game - Playing");
    }
}
