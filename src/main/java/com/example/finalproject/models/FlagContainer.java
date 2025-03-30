package com.example.finalproject.models;

import com.example.finalproject.Const;
import com.example.finalproject.scenes.CreditScene;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static com.example.finalproject.MainApplication.mainStage;

public class FlagContainer extends GridPane{
    private ArrayList<Flag> flags = new ArrayList<>(Arrays.asList(
            new Flag("Poland", "/com/example/finalproject/Poland Flag.png", "Europe"),
            new Flag("Indonesia", "/com/example/finalproject/Indonesia.png", "Asia"),
            new Flag("France", "/com/example/finalproject/France Flag.png", "Europe"),
            new Flag("Denmark", "/com/example/finalproject/Denmark Flag.png", "Europe"),
            new Flag("Finland", "/com/example/finalproject/Finland Flag.png", "Europe"),
            new Flag("Russia", "/com/example/finalproject/Russia Flag.png", "Europe and Asia"),
            new Flag("Germany", "/com/example/finalproject/Germany Flag.png", "Europe"),
            new Flag("Vietnam", "/com/example/finalproject/Vietnam Flag.png", "Asia"),
            // Loop
            new Flag("Poland", "/com/example/finalproject/Poland Flag.png", "Europe"),
            new Flag("Indonesia", "/com/example/finalproject/Indonesia.png", "Asia"),
            new Flag("France", "/com/example/finalproject/France Flag.png", "Europe"),
            new Flag("Denmark", "/com/example/finalproject/Denmark Flag.png", "Europe"),
            new Flag("Finland", "/com/example/finalproject/Finland Flag.png", "Europe"),
            new Flag("Russia", "/com/example/finalproject/Russia Flag.png", "Europe and Asia"),
            new Flag("Germany", "/com/example/finalproject/Germany Flag.png", "Europe"),
            new Flag("Vietnam", "/com/example/finalproject/Vietnam Flag.png", "Asia")
    ));

    private final ArrayList<FlagItem> openedFlags = new ArrayList<>();
    private final int totalPairs;
    private int matchedPairs;

    public FlagContainer(int size) {
        //Collections.shuffle(flags);
        this.totalPairs = (size * size) / 2;
        this.setHgap(Const.CELL_GAP);
        this.setVgap(Const.CELL_GAP);
        this.setAlignment(Pos.CENTER);

        // Set constraints (optional as we don't span rows or columns)
        for (int i = 0; i < size; i++) {
            ColumnConstraints colConst = new ColumnConstraints(Const.CELL_WIDTH);
            this.getColumnConstraints().add(colConst);
            RowConstraints rowConst = new RowConstraints(Const.CELL_HEIGHT);
            this.getRowConstraints().add(rowConst);
        }

        int temp = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                FlagItem item = new FlagItem(
                        flags.get(temp).getName(),
                        flags.get(temp).getImageUrl(),
                        this
                );
                this.add(item, col, row);
                temp++;
            }
        }
    }
    public void handleFlagClick(FlagItem item) {
        System.out.println("Click Parent " + item.getFlagName());
        if (openedFlags.contains(item) || item.isMatch()) {
            // If item is opening or matched -> do nothing
            return;
        }
        openedFlags.add(item);

        if (openedFlags.size() == 2) {
            // Do this one if have time
            if(checkMatch()) {
                System.out.println("Match!!");
                Flag temp = findFlagByName(item);
                alertSuccess(temp);
            } else {
                System.out.println("Wrong pairs");
                Flag temp = findFlagByName(item);
                alertFail(temp);
            }
        }
    }

    private boolean checkMatch() {
        if (openedFlags.size() < 2) return false;

        FlagItem first = openedFlags.get(0);
        FlagItem second = openedFlags.get(1);

        boolean isMatch = first.getFlagName().equals(second.getFlagName());

        if (isMatch) {
            first.setMatch(true);
            second.setMatch(true);
            first.setOpacity(0);
            second.setOpacity(0);
            matchedPairs++;
            System.out.println(matchedPairs + " - " + totalPairs);
            if (matchedPairs == totalPairs) {
                System.out.println("You win!");
                endGame();
            }
        } else {
            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(event -> {
                first.reset();
                second.reset();
                openedFlags.clear();
            });
            pause.play();
        }

        openedFlags.clear();
        return isMatch;
    }

    private void endGame() {
        System.out.println("End game");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("You WIN!!");
        alert.setContentText("All pairs were found!");
        alert.showAndWait();
        mainStage.setScene(new CreditScene());
    }

    private void alertSuccess(Flag flag) {
        if(flag == null) return;
        System.out.println("Match");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(flag.getName().toUpperCase());
        alert.setHeaderText("Congratulation!!");
        alert.setContentText("This country is in" + flag.getContinent());
    }

    private void alertFail(Flag flag) {
        if(flag == null) return;
        System.out.println("Failed to match");
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(flag.getName().toUpperCase());
        alert.setHeaderText("Ops!!");
        alert.setContentText("This country is in" + flag.getContinent());
    }

    private Flag findFlagByName(FlagItem item) {
        for (int i = 0; i < flags.size(); i++) {
            if(item.getFlagName().compareTo(flags.get(0).getName()) == 0) {
                return flags.get(0);
            }
        }
        return null;
    }
}
