package com.example.finalproject.panes;
import com.example.finalproject.Const;
import com.example.finalproject.models.FlagContainer;
import javafx.geometry.Pos;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class PlayingPane extends BorderPane {
    public PlayingPane() {
        FlagContainer container = new FlagContainer(Const.SIZE_4);
        this.setCenter(container);
        BorderPane.setAlignment(container, Pos.CENTER);
    }
}
