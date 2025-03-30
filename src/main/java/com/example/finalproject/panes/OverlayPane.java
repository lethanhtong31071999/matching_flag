package com.example.finalproject.panes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import static com.example.finalproject.MainApplication.mainStage;

public class OverlayPane extends StackPane {
    public OverlayPane(Pane pane, String imgUrl) {
        Pane overlay = new Pane();
        overlay.setPrefSize(mainStage.getWidth(), mainStage.getHeight());
        overlay.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 0, 0.5), null, null)));

        BackgroundImage bgImage = new BackgroundImage(
                new Image(imgUrl),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, false, false, true, false)
        );
        this.setBackground(new Background(bgImage));

        this.setAlignment(Pos.TOP_LEFT);
        this.getChildren().addAll(overlay, pane);
    }
}
