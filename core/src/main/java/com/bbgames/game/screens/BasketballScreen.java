package com.bbgames.game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.bbgames.game.MySportsGame;
import com.bbgames.game.utils.ScreenManager;
import com.bbgames.game.utils.LanguageStrings;

public class BasketballScreen implements Screen {

    private MySportsGame game;
    private BitmapFont font;
    float ballX = 150, ballY = 200;

    public BasketballScreen(MySportsGame game) {
        this.game = game;
        font = new BitmapFont();
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.1f, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isTouched()) {
            ballX = Gdx.input.getX();
            ballY = Gdx.graphics.getHeight() - Gdx.input.getY();
        }

        game.batch.begin();
        font.getData().setScale(LanguageStrings.BUTTON_SCALE);
        font.draw(game.batch, "🏀", ballX, ballY);
        font.draw(game.batch, LanguageStrings.get("back"), 50, 50);
        game.batch.end();

        if (LanguageStrings.isTouched(50,10,150,60)) ScreenManager.showSportSelect();
    }

    @Override public void dispose() { font.dispose(); }
    @Override public void show() {}
    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
}
