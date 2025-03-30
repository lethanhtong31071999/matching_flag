package com.example.finalproject.scenes;

import com.example.finalproject.Const;
import com.example.finalproject.panes.IntroPane;
import com.example.finalproject.panes.OverlayPane;

import static com.example.finalproject.MainApplication.mainStage;

public class IntroScene extends MyScene {
    public IntroScene() {
//        super(new OverlayPane(new IntroPane(), Const.BACKGROUND_INTRO), mainStage.getWidth(), mainStage.getHeight());
        super(new IntroPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
        mainStage.setTitle("Matching Flag Game - Introduction");
    }
}
