package com.example.finalproject.panes;
import com.example.finalproject.Const;
import com.example.finalproject.SoundManager;
import com.example.finalproject.components.Type;
import com.example.finalproject.components.buttons.ButtonBase;
import com.example.finalproject.models.FlagContainer;
import javafx.geometry.Pos;
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

        TextField bestScore = new TextField();
        bestScore.setEditable(false);
        bestScore.setText(this.readScoreFile() + "");

        scoreTxt = new TextField();
        scoreTxt.setEditable(false);
        VBox scoreContainer = new VBox(10);
        scoreContainer.getChildren().addAll(scoreTxt, bestScore);
        this.setBottom(scoreContainer);
        BorderPane.setAlignment(scoreTxt, Pos.BOTTOM_CENTER);

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
                return 0;
            }
            return score;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
