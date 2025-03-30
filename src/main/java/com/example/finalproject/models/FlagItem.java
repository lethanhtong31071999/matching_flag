package com.example.finalproject.models;

import com.example.finalproject.MainApplication;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class FlagItem extends Button {
    private FlagContainer parentContainer;
    private final String placeholderImg = "https://i.redd.it/et43sartp1671.png";
    private String imageUrl;
    private  String flagName;
    private boolean isOpening;
    private boolean isMatch; // if match = true -> this item removed

    public FlagItem (String flagName, String imgUrl, FlagContainer parentContainer) {
        super(" ");
        this.parentContainer = parentContainer;
        this.flagName = flagName;
        this.imageUrl = imgUrl;
        this.isOpening = false;
        this.isMatch = false;
        this.setOpacity(1);

        this.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.setBackgroundFlagItem(this.placeholderImg);
        this.setOnAction(e -> handleClick(e));
    }

    private void handleClick(ActionEvent e) {
        flagItemAnimation();
        this.isOpening = true;
        this.setBackgroundFlagItem(this.imageUrl);
        parentContainer.handleFlagClick(this);
    }

    private void flagItemAnimation() {
        FadeTransition fade = new FadeTransition(Duration.millis(1000), this);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.setCycleCount(2);
        fade.setAutoReverse(true);
        fade.play();
    }

    // For parent call after matching incorrect
    public void reset() {
        this.isOpening = false;
        this.setBackgroundFlagItem(this.placeholderImg);
    }

    private void setBackgroundFlagItem(String imageUrl) {
        BackgroundImage backgroundImage = new BackgroundImage(
//                MainApplication.imageList.get(0),
                new Image(imageUrl, true),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, false)
        );
        this.setBackground(new Background(backgroundImage));
    }


    // GETTER SETTER
    public String getFlagName() {
        return flagName;
    }

    public boolean isOpening() {
        return isOpening;
    }

    public void setOpening(boolean opening) {
        isOpening = opening;
    }

    public boolean isMatch() {
        return isMatch;
    }

    public void setMatch(boolean match) {
        isMatch = match;
    }
}
