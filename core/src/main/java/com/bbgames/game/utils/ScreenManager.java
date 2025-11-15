package com.bbgames.game.utils;

import com.bbgames.game.MySportsGame;
import com.bbgames.game.screens.*;

public class ScreenManager {

    private static MySportsGame game;

    public static void init(MySportsGame g) {
        game = g;
    }

    public static void showMainMenu() {
        game.setScreen(new MainMenuScreen(game));
    }

    public static void showSportSelect() {
        game.setScreen(new SportSelectScreen(game));
    }

    public static void showFootball() {
        game.setScreen(new FootballScreen(game));
    }

    public static void showBasketball() {
        game.setScreen(new BasketballScreen(game));
    }

    public static void showTennis() {
        game.setScreen(new TennisScreen(game));
    }

    public static void showGym() {
        game.setScreen(new GymScreen(game));
    }
}
