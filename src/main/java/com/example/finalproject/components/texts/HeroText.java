package com.example.finalproject.components.texts;

import com.example.finalproject.Const;
import com.example.finalproject.components.Type;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class HeroText extends TextBase{
    /*
     * The HeroText class is used for all button throughout the project.
     * This class requires 1 parameter ( display text )
     * In the constructor:
     *   - Set text (display name) by calling parent constructor and put the parameter on this
     *   - Set Font: Font-family, font-weight, font-posture, font-size
     *   - Set text color
     * */
    public HeroText(String label) {
        super(label);
        this.setFont(Font.font(Const.COMMON_FONT, FontWeight.BOLD, FontPosture.REGULAR, Const.FONT_SIZE_HERO_TITLE));
        this.setFill(Const.PRIMARY_COLOR);
    }
}
