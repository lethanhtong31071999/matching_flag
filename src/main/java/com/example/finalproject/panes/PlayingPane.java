package com.example.finalproject.panes;
import com.example.finalproject.Const;
import com.example.finalproject.SoundManager;
import com.example.finalproject.components.Type;
import com.example.finalproject.components.buttons.ButtonBase;
import com.example.finalproject.models.FlagContainer;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import static com.example.finalproject.MainApplication.mainStage;

public class PlayingPane extends BorderPane {
    private TextField scoreTxt;
    public PlayingPane() {
        FlagContainer container = new FlagContainer(Const.SIZE_4, this);
        this.setCenter(container);
        BorderPane.setAlignment(container, Pos.CENTER);

        ButtonBase pauseButton = new ButtonBase("Pause", Type.PRIMARY);
        VBox topRight = new VBox(pauseButton);
        this.setTop(topRight);
        BorderPane.setAlignment(topRight, Pos.TOP_RIGHT);

        // Moves
        Label lbBestScore = new Label("Best move");
        Label lbCurrentScore = new Label("Current move");

        TextField bestScore = new TextField();
        bestScore.setEditable(false);
        int bestScoreFromIO = this.readScoreFile();
        if(bestScoreFromIO == -1) {
            bestScore.setText("");
        }
        else {
            bestScore.setText(bestScoreFromIO + "");
        }

        scoreTxt = new TextField();
        scoreTxt.setEditable(false);
        HBox bestMoveContainer = new HBox(10);
        bestMoveContainer.getChildren().addAll(lbBestScore, bestScore);
        HBox currentMoveContainer = new HBox(10);
        currentMoveContainer.getChildren().addAll(lbCurrentScore, scoreTxt);

        VBox sidebarContainer = new VBox(10);
        sidebarContainer.getChildren().addAll(pauseButton, bestMoveContainer, currentMoveContainer);


        this.setRight(sidebarContainer);
        BorderPane.setAlignment(sidebarContainer, Pos.TOP_LEFT);

        pauseButton.setOnAction(e->{
            SoundManager.playButtonClickSound();
            mainStage.setScene(Const.pauseScene);
        });
    }

    public TextField getScoreTxt () {
        return this.scoreTxt;
    }

    public void writeScoreFile (int bestScore) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(Const.SCORE_FILE));
            out.write(bestScore + "");
            out.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int readScoreFile() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(Const.SCORE_FILE));
            String line = "";
            int score = 0;
            if((line = in.readLine()) != null) {
                String[] scores = line.split("");
                for (String temp : scores) {
                    score = Integer.parseInt(temp);
                }
            } else {
                return -1;
            }
            return score;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
