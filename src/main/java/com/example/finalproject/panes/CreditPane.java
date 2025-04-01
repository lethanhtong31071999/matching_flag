package com.example.finalproject.panes;

import com.example.finalproject.components.Type;
import com.example.finalproject.components.buttons.ButtonBase;
import com.example.finalproject.components.texts.HeadingText;
import com.example.finalproject.components.texts.SubTitleText;
import com.example.finalproject.components.texts.TextBase;
import com.example.finalproject.scenes.IntroScene;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import static com.example.finalproject.MainApplication.mainStage;

public class CreditPane extends VBox {
    public CreditPane() {
        // Set VBox properties (spacing, alignment)
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);

        // Title
        HeadingText title = new HeadingText("Game Credits");
        HeadingText projectName = new HeadingText("Matching Flag Game!");

        // Sections with subtitles and names
        HBox devBox = createCreditSection("Developers", "Lukas Lynch, Munashe Hokonya, Thanh Tong Le");
        HBox musicBox = createCreditSection("Music", "Munashe Hokonya");
        HBox imageBox = createCreditSection("Image Assets", "Munashe Hokonya, Thanh Tong Le");
        HBox designBox = createCreditSection("Game Design", "Thanh Tong Le, Lukas Lynch");

        ButtonBase btnBack = new ButtonBase("Back to Home", Type.TEXT_BUTTON);
        btnBack.setOnAction(e -> {
            mainStage.setScene(new IntroScene());
        });
        // Add everything to the VBox
        this.getChildren().addAll(title, projectName, devBox, musicBox, imageBox, designBox, btnBack);

        // Start the credits animation
        startAnimation();
    }

    private HBox createCreditSection(String category, String names) {
        // Subtitle for the category
        SubTitleText subTitle = new SubTitleText(category);

        // Names of contributors
        TextBase nameText = new TextBase(names);

        HBox hbox = new HBox(20, subTitle, nameText);
        hbox.setAlignment(Pos.CENTER);

        return hbox;
    }

    private void startAnimation() {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(10), this);
        transition.setFromY(400);
        transition.setToY(-200);
        transition.setCycleCount(1);
        transition.play();
    }
}
