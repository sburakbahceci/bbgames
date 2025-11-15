package com.bbgames.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.bbgames.game.utils.LanguageManager;
import com.bbgames.game.utils.ScreenManager;

public class LanguageSelectScreen implements Screen {

    private SpriteBatch batch;
    private BitmapFont font;

    @Override
    public void show() {
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        font.draw(batch, "SELECT LANGUAGE / DIL SECIMI", 80, 300);
        font.draw(batch, "1 - English", 80, 260);
        font.draw(batch, "2 - Turkce", 80, 230);
        batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
            LanguageManager.setLanguage(LanguageManager.Language.ENGLISH);
            ScreenManager.setScreen(new MainMenuScreen());
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
            LanguageManager.setLanguage(LanguageManager.Language.TURKISH);
            ScreenManager.setScreen(new MainMenuScreen());
        }
    }

    @Override public void resize(int w, int h) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
