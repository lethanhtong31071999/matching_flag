package com.example.finalproject.components.texts;

import com.example.finalproject.Const;
import com.example.finalproject.components.Type;
import javafx.scene.text.Font;

public class SubHeadingText extends TextBase{
    public SubHeadingText(String label) {
        /*
         * The SubHeadingText class is used for all button throughout the project.
         * This class requires 1 parameter ( display text )
         * In the constructor:
         *   - Set text (display name) by calling parent constructor and put the parameter on this
         *   - Set Font: Font-family, font-weight, font-posture, font-size
         *   - Set text color: inherit from Parent
         * */
        super(label);
        this.setFont(Font.font(Const.COMMON_FONT, Const.FONT_SIZE_SUB_HEADING));
    }
}
