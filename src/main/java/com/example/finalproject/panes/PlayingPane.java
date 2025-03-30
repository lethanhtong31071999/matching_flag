package com.example.finalproject.panes;
import com.example.finalproject.Const;
import com.example.finalproject.SoundManager;
import com.example.finalproject.components.Type;
import com.example.finalproject.components.buttons.ButtonBase;
import com.example.finalproject.models.FlagContainer;
import javafx.geometry.Pos;
import javafx.scene.layout.*;

import static com.example.finalproject.MainApplication.mainStage;

public class PlayingPane extends BorderPane {
    public PlayingPane() {
        FlagContainer container = new FlagContainer(Const.SIZE_4);
        this.setCenter(container);
        BorderPane.setAlignment(container, Pos.CENTER);

        ButtonBase pauseButton = new ButtonBase("Pause", Type.PRIMARY);
        VBox topRight = new VBox(pauseButton);
        this.setTop(topRight);
        BorderPane.setAlignment(topRight, Pos.TOP_RIGHT);

        pauseButton.setOnAction(e->{
            SoundManager.playButtonClickSound();
            mainStage.setScene(Const.pauseScene);
        });
    }
}
