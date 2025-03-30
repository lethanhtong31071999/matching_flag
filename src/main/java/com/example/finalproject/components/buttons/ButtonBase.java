package com.example.finalproject.components.buttons;

import com.example.finalproject.Const;
import com.example.finalproject.components.Type;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class ButtonBase extends Button {
    /*
    * The ButtonBase class is used for all button throughout the project.
    * This class requires 2 parameters ("name of button", type - primary / secondary)
    * The type parameter is just for setting background and color
    * In the constructor:
    *   - Set text (display name)
    *   - Set Font: Font-family, font-weight, font-posture, font-size
    *   - Set Padding
    *   - Set Background color and Set text color based on Type
    * */
    public ButtonBase(String label, Type type) {
        this.setText(label);
        this.setFont(Font.font(Const.COMMON_FONT, FontWeight.BOLD, FontPosture.REGULAR, Const.FONT_SIZE_BASE));
        this.setTextFill(getColorByType(type));
        this.setPadding(new Insets(Const.BUTTON_PADDING));
        this.setFont(Font.font(Const.COMMON_FONT, Const.BUTTON_FONT_WEIGHT, Const.BUTTON_FONT_POSTURE, Const.BUTTON_FONT_SIZE));
        this.setBackground(new Background(new BackgroundFill(getBackGroundColorByType(type), new CornerRadii(10), null)));
    }

    private Color getColorByType(Type type) {
        Color result = null;
        switch (type) {
            case PRIMARY:
                result = Const.BUTTON_PRIMARY_TEXT;
                break;
            case SECONDARY:
                result = Const.BUTTON_SECONDARY_TEXT;
                break;
            default:
                result = Color.BLACK;
                break;
        }
        return result;
    }

    private Color getBackGroundColorByType(Type type) {
        Color result = null;
        switch (type) {
            case PRIMARY:
                result = Const.BUTTON_PRIMARY_BACKGROUND;
                break;
            case SECONDARY:
                result = Const.BUTTON_SECONDARY_BACKGROUND;
                break;
            default:
                result = Color.TRANSPARENT;
                break;
        }
        return result;
    }
}
