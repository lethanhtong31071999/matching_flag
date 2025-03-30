package com.example.finalproject.components.texts;

import com.example.finalproject.Const;
import com.example.finalproject.components.Type;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HeadingText extends TextBase{
    /*
     * The HeadingText class is used for all button throughout the project.
     * This class requires 1 parameter ( display text )
     * In the constructor:
     *   - Set text (display name) by calling parent constructor and put the parameter on this
     *   - Set Font: Font-family, font-weight, font-posture, font-size
     *   - Set text color
     * */
    public HeadingText(String label) {
        super(label);
        this.setFont(Font.font(Const.COMMON_FONT, FontWeight.BOLD, Const.FONT_SIZE_HEADING));
        this.setFill(Const.TEXT_HEADING_COLOR);
    }
}
