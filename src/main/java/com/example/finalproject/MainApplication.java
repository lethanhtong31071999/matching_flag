package com.example.finalproject;

import com.example.finalproject.scenes.CreditScene;
import com.example.finalproject.scenes.IntroScene;
import com.example.finalproject.scenes.PlayingScene;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

// stage -> scenes -> panes (border, vbox, hbox)

public class MainApplication extends Application {
    public static Stage mainStage;
    public static ArrayList<Image> imageList = new ArrayList<>();
    static {
//        imageList.add(new Image("com/example/finalproject/flags/placeholder.png"));
    }

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        mainStage.setTitle("Flag Matching");
        mainStage.setMinHeight(900);
        mainStage.setMinWidth(1280);
        mainStage.setScene(new PlayingScene());
        mainStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
