package com.example.finalproject.panes;

import com.example.finalproject.Const;
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

import static com.example.finalproject.MainApplication.main;
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
        ImageView logo = new ImageView(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2bFjNad56DWlMApG5Sj0eRLVsTzRTSeZwYQ&s"));
        logo.setFitHeight(Const.RADIUS_LOGO * 2);
        logo.setFitWidth(Const.RADIUS_LOGO * 2);
        logo.setClip(clip);
        VBox.setMargin(logo, new Insets(20, 0, 0, 0));

        // Play Button
        ButtonBase btnNewGame = new ButtonBase("New Game", Type.PRIMARY);
        VBox.setMargin(btnNewGame, new Insets(20, 0, 0, 0));
        btnNewGame.setOnAction(e -> {
            mainStage.setScene(new PlayingScene());
        });

        // Scale continue
        ScaleTransition scalePlayBtn = new ScaleTransition(Duration.seconds(1.5), btnNewGame);
        scalePlayBtn.setFromX(1);
        scalePlayBtn.setFromY(1);
        scalePlayBtn.setToX(1.1);
        scalePlayBtn.setToY(1.1);
        scalePlayBtn.setCycleCount(Animation.INDEFINITE);
        scalePlayBtn.setInterpolator(Interpolator.LINEAR);
        scalePlayBtn.setAutoReverse(true);
        scalePlayBtn.play();

        // Settings
        ButtonBase btnSetting = new ButtonBase("Settings", Type.TEXT_BUTTON);
        btnSetting.setOpacity(0);
        VBox.setMargin(btnSetting, new Insets(10, 0, 0, 0));

        // Credit
        ButtonBase btnCredit = new ButtonBase("Credit", Type.TEXT_BUTTON);
        btnCredit.setOpacity(0);
        btnCredit.setOnAction(e -> {
            mainStage.setScene(new CreditScene());
        });

        // History
        ButtonBase btnHistory = new ButtonBase("History", Type.TEXT_BUTTON);
        btnHistory.setOpacity(0);
        VBox.setMargin(btnHistory, new Insets(10, 0, 0, 0));

        this.setAlignment(Pos.BASELINE_CENTER);
        this.getChildren().addAll(title, logo, btnNewGame, btnSetting, btnCredit, btnHistory);

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

        FadeTransition fadeHistory = new FadeTransition(Duration.seconds(1), btnHistory);
        fadeHistory.setToValue(1);
        fadeHistory.setFromValue(0);

        // Others Transition X (Sequential)
        SequentialTransition sequentialSettingCreditHistory = new SequentialTransition(
                fadeSetting, fadeCredit, fadeHistory);
        sequentialSettingCreditHistory.play();
        /* ======== END ANIMATION ======== */
    }
}
