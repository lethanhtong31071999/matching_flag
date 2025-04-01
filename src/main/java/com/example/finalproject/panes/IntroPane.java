package com.example.finalproject.panes;

import com.example.finalproject.Const;
import com.example.finalproject.SoundManager;
import com.example.finalproject.components.Type;
import com.example.finalproject.components.buttons.ButtonBase;
import com.example.finalproject.components.texts.HeadingText;
import com.example.finalproject.scenes.CreditScene;
import com.example.finalproject.scenes.PlayingScene;
import javafx.animation.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

import java.io.InputStream;

import static com.example.finalproject.MainApplication.mainStage;

public class IntroPane extends VBox {
    public IntroPane() {
        super(10);
        this.setAlignment(Pos.BASELINE_CENTER);
        /* ======== START UI ======== */
        // Title Text
        HeadingText title = new HeadingText("Matching Flag Game");
        title.setFill(Const.PRIMARY_COLOR);
        title.setOpacity(0);
        VBox.setMargin(title, new Insets(10, 0, 0, 0));

        // Game Logo
        Circle clip = new Circle(Const.RADIUS_LOGO);
        clip.setCenterX(Const.RADIUS_LOGO);
        clip.setCenterY(Const.RADIUS_LOGO);
        InputStream stream = getClass().getResourceAsStream(Const.LOGO);
        ImageView logo = new ImageView(new Image(stream));
        logo.setFitHeight(Const.RADIUS_LOGO * 2);
        logo.setFitWidth(Const.RADIUS_LOGO * 2);
        logo.setClip(clip);
        VBox.setMargin(logo, new Insets(20, 0, 0, 0));

        // Continue Button
        ButtonBase btnContinue = new ButtonBase("Continue Game", Type.TEXT_BUTTON);
        btnContinue.setTextFill(Const.PRIMARY_COLOR);
        Font currentFont = btnContinue.getFont();
        btnContinue.setFont(Font.font(currentFont.getFamily(), FontWeight.BOLD, FontPosture.ITALIC, currentFont.getSize()));
        VBox.setMargin(btnContinue, new Insets(10, 0, 0, 0));
        btnContinue.setOpacity(0);
        if(Const.WAS_PLAY) {
            btnContinue.setOpacity(1);
            btnContinue.setOnAction(e->{
                SoundManager.playButtonClickSound();
                mainStage.setScene(Const.playingScene);
            });
        }

        // Scale continue
        ScaleTransition scaleContinueBtn = new ScaleTransition(Duration.seconds(1.5), btnContinue);
        scaleContinueBtn.setFromX(1);
        scaleContinueBtn.setFromY(1);
        scaleContinueBtn.setToX(1.1);
        scaleContinueBtn.setToY(1.1);
        scaleContinueBtn.setCycleCount(Animation.INDEFINITE);
        scaleContinueBtn.setInterpolator(Interpolator.LINEAR);
        scaleContinueBtn.setAutoReverse(true);
        scaleContinueBtn.play();
        if(1 == 0) {
            // If not exist any previous game
            btnContinue.setVisible(false);
        }

        // Settings
        ButtonBase btnSetting = new ButtonBase("Settings", Type.TEXT_BUTTON);
        btnSetting.setOpacity(0);
        VBox.setMargin(btnSetting, new Insets(10, 0, 0, 0));
        btnSetting.setOnAction(e->{
            mainStage.setScene(Const.settingScene);
            SoundManager.playButtonClickSound();
        });

        // Credit
        ButtonBase btnCredit = new ButtonBase("Credit", Type.TEXT_BUTTON);
        btnCredit.setOpacity(0);
        btnCredit.setOnAction(e -> {
            mainStage.setScene(new CreditScene());
            SoundManager.playButtonClickSound();
        });

        // Play Button
        ButtonBase btnNewGame = new ButtonBase("New Game", Type.PRIMARY);
        btnNewGame.setTranslateY(200);
        btnNewGame.setOpacity(0);
        VBox.setMargin(btnNewGame, new Insets(20, 0, 0, 0));
        btnNewGame.setOnAction(e -> {
            mainStage.setScene(new PlayingScene(new PlayingPane()));
            SoundManager.playButtonClickSound();
            Const.WAS_PLAY = true;
        });

        this.setAlignment(Pos.BASELINE_CENTER);
        this.getChildren().addAll(title, logo, btnContinue, btnSetting, btnCredit, btnNewGame);

        /* ======== END UI ======== */

        /* ======== START ANIMATION ======== */
        // Fade-in Title
        FadeTransition fadeTitle = new FadeTransition(Duration.seconds(1), title);
        fadeTitle.setFromValue(0);
        fadeTitle.setToValue(1);
        fadeTitle.play();

        // Scale-up + rotate Logo (parallel)
        RotateTransition rotateLogo = new RotateTransition(Duration.seconds(5), logo);
        rotateLogo.setByAngle(360);
        rotateLogo.setCycleCount(Animation.INDEFINITE);
        rotateLogo.setInterpolator(Interpolator.LINEAR);

        ScaleTransition scaleLogo = new ScaleTransition(Duration.seconds(2), logo);
        scaleLogo.setFromX(0);
        scaleLogo.setFromY(0);
        scaleLogo.setToX(1);
        scaleLogo.setToY(1);

        ParallelTransition parallelTransition = new ParallelTransition(rotateLogo, scaleLogo);
        parallelTransition.play();

        // Settings, Credit, History
        FadeTransition fadeSetting = new FadeTransition(Duration.seconds(1), btnSetting);
        fadeSetting.setToValue(1);
        fadeSetting.setFromValue(0);

        FadeTransition fadeCredit = new FadeTransition(Duration.seconds(1), btnCredit);
        fadeCredit.setToValue(1);
        fadeCredit.setFromValue(0);

        // Transition Y New game Button + Fade (Parallel)
        TranslateTransition slideButton = new TranslateTransition(Duration.seconds(1.5), btnNewGame);
        slideButton.setToY(100);
        slideButton.setInterpolator(Interpolator.LINEAR);
        FadeTransition fadeButton = new FadeTransition(Duration.seconds(1.5), btnNewGame);
        fadeButton.setToValue(1);
        ParallelTransition parallelButton = new ParallelTransition(slideButton, fadeButton);

        // Others Transition X (Sequential)
        SequentialTransition sequentialSettingCreditHistory = new SequentialTransition(
                fadeSetting, fadeCredit);

        // Sequential Transition: Other + New game button
        SequentialTransition sequentialTransition = new SequentialTransition(
                sequentialSettingCreditHistory, parallelButton
        );
        sequentialTransition.play();
        /* ======== END ANIMATION ======== */
    }
}
