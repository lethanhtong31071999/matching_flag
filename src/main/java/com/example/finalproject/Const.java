package com.example.finalproject;

import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Color;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;

public final class Const {
    // Clip logo
    public static int RADIUS_LOGO = 100;

    // Screen
    public static double SCREEN_WIDTH = 1200;
    public static double SCREEN_HEIGHT = 768;

    //Common fonts
    public static final String COMMON_FONT = "Arial";

    //Font sizes
    public static final int FONT_SIZE_HERO_TITLE = 72;
    public static final int FONT_SIZE_SUB_TITLE = 32;
    public static final int FONT_SIZE_BASE = 16;
    public static final int FONT_SIZE_HEADING = 24;
    public static final int FONT_SIZE_SUB_HEADING = 20;

    //Common Colors
    public static final Color BACKGROUND_COLOR = Color.web("#EFDCAB");
    public static final Color PRIMARY_COLOR = Color.web("#443627");
    public static final Color SECONDARY_COLOR = Color.web("#D98324");
    public static final Color TEXT_COLOR = Color.web("#757575");
    public static final Color TEXT_HEADING_COLOR = Color.web("#1E1E1E");

    // Button
    public static final int BUTTON_PADDING = 12;
    public static final int BUTTON_FONT_SIZE = 18;
    public static final FontWeight BUTTON_FONT_WEIGHT = FontWeight.NORMAL;
    public static final FontPosture BUTTON_FONT_POSTURE = FontPosture.REGULAR;
    public static final Color BUTTON_PRIMARY_TEXT = Color.WHITE;
    public static final Color BUTTON_PRIMARY_BACKGROUND = PRIMARY_COLOR;
    public static final Color BUTTON_SECONDARY_TEXT = Color.BLACK;
    public static final Color BUTTON_SECONDARY_BACKGROUND = SECONDARY_COLOR;

    // Background image for scenes
    public static final String BACKGROUND_INTRO = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8DkhY76x5yNR40U-fRYGT2u9lt50_-Ta5wg&s";

    // Playing Board/Table
    public static final int SIZE_4 = 4;
    public static final int CELL_WIDTH = 100;
    public static final int CELL_HEIGHT = 100;

    public static final int CELL_GAP = 10;
}
