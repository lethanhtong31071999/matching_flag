package com.example.finalproject.models;

import com.example.finalproject.MainApplication;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;
import java.io.InputStream;

public class FlagItem extends Button {
    private FlagContainer parentContainer;
    private final String placeholderImgPath = "/com/example/finalproject/placeholder.png";
    private String imagePath;
    private String flagName;
    private boolean isOpening;
    private boolean isMatch;

    public FlagItem(String flagName, String imagePath, FlagContainer parentContainer) {
        super(" ");
        this.parentContainer = parentContainer;
        this.flagName = flagName;
        this.imagePath = imagePath;
        this.isOpening = false;
        this.isMatch = false;
        this.setOpacity(1);
        this.setPrefSize(200, 100);

        this.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.setBackgroundFlagItem(placeholderImgPath);
        this.setOnAction(e -> this.handleClick(e));
    }

    private void handleClick(ActionEvent e) {
        if(this.isOpening) return;

        flagItemAnimation(true);
        this.isOpening = true;
        this.setBackgroundFlagItem(imagePath);
        parentContainer.handleFlagClick(this);
        if(isMatch) {
            this.setOpacity(0);
        }
    }

    private void flagItemAnimation(boolean isHidden) {
        FadeTransition fade = new FadeTransition(Duration.seconds(0.5), this);
        if(isHidden) {
            fade.setFromValue(1);
            fade.setToValue(0);
        } else {
            fade.setFromValue(0);
            fade.setToValue(1);
        }
        fade.play();
    }

    public void setAfterMatch() {
        this.isMatch = true;
        this.setOpacity(0);
    }

    public void reset() {
        this.isOpening = false;
        this.setOpacity(1);
        this.setBackgroundFlagItem(placeholderImgPath);
        flagItemAnimation(false);
    }

    private void setBackgroundFlagItem(String imagePath) {
        InputStream stream = getClass().getResourceAsStream(imagePath);
        if (stream != null) {
            BackgroundImage backgroundImage = new BackgroundImage(
                    new Image(stream),
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    new BackgroundSize(100, 100, true, true, true, false)
            );
            this.setBackground(new Background(backgroundImage));
        } else {
            System.err.println("Image not found: " + imagePath);
        }
    }

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
