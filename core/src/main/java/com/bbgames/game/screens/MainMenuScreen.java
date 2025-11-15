package com.bbgames.game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Color;
import com.bbgames.game.MySportsGame;
import com.bbgames.game.utils.ScreenManager;
import com.bbgames.game.utils.LanguageManager;
import com.bbgames.game.utils.LanguageStrings;

public class MainMenuScreen implements Screen {

    private MySportsGame game;
    private BitmapFont font;

    float playX, playY;
    float trX, trY;
    float enX, enY;

    public MainMenuScreen(MySportsGame game) {
        this.game = game;
        font = new BitmapFont();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();

        float centerX = Gdx.graphics.getWidth() / 2f;

        font.getData().setScale(LanguageStrings.TITLE_SCALE);
        font.setColor(Color.WHITE);
        font.draw(game.batch, LanguageStrings.get("title"), centerX - 150, Gdx.graphics.getHeight() - 100);

        font.getData().setScale(LanguageStrings.BUTTON_SCALE);

        playX = centerX - 100;
        playY = 300;
        font.draw(game.batch, LanguageStrings.get("play"), playX, playY);

        trX = centerX - 100;
        trY = 220;
        font.draw(game.batch, LanguageStrings.get("turkish"), trX, trY);

        enX = centerX - 100;
        enY = 170;
        font.draw(game.batch, LanguageStrings.get("english"), enX, enY);

        game.batch.end();

        // Tıklamalar
        if (LanguageStrings.isTouched(playX, playY - 40, 200, 60)) {
            ScreenManager.showSportSelect();
        }

        if (LanguageStrings.isTouched(trX, trY - 40, 200, 60)) {
            LanguageManager.setLanguage(LanguageStrings.Language.TR);
        }

        if (LanguageStrings.isTouched(enX, enY - 40, 200, 60)) {
            LanguageManager.setLanguage(LanguageStrings.Language.EN);
        }
    }

    @Override public void dispose() { font.dispose(); }
    @Override public void show() {}
    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
}
