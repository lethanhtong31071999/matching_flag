package com.example.finalproject.components.texts;

import com.example.finalproject.Const;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class TextBase extends Text {
    /*
     * The TextBase class is used for all button throughout the project.
     * This class requires 1 parameter ( display text )
     * In the constructor:
     *   - Set text (display name) by calling parent constructor and put the parameter on this
     *   - Set Font: Font-family, font-weight, font-posture, font-size
     *   - Set text color
     * */
    public TextBase(String label) {
        this.setText(label);
        this.setFill(Const.TEXT_COLOR);
        this.setFont(Font.font(Const.COMMON_FONT, FontWeight.NORMAL, FontPosture.REGULAR, Const.FONT_SIZE_BASE));
    }
}
