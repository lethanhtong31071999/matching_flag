package com.example.finalproject.panes;
import com.example.finalproject.Const;
import com.example.finalproject.SoundManager;
import com.example.finalproject.components.Type;
import com.example.finalproject.components.buttons.ButtonBase;
import com.example.finalproject.models.FlagContainer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;

import static com.example.finalproject.MainApplication.mainStage;

public class PlayingPane extends BorderPane {
    public PlayingPane() {
        FlagContainer container = new FlagContainer(Const.SIZE_4);
        this.setCenter(container);

        ButtonBase pauseButton = new ButtonBase("Pause", Type.PRIMARY);

        // Create an HBox to align the button to the right
        HBox topRight = new HBox(pauseButton);
        topRight.setAlignment(Pos.TOP_RIGHT); // Align button to the top-right
        topRight.setPadding(new Insets(10, 10, 0, 0)); // Add some padding for spacing

        this.setTop(topRight);

        pauseButton.setOnAction(e -> {
            SoundManager.playButtonClickSound();
            mainStage.setScene(Const.pauseScene);
        });
    }
}
