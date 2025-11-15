package com.bbgames.game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.bbgames.game.MySportsGame;
import com.bbgames.game.utils.ScreenManager;
import com.bbgames.game.utils.LanguageStrings;

public class SportSelectScreen implements Screen {

    private MySportsGame game;
    private BitmapFont font;

    float fbX, fbY, bbX, bbY, tnX, tnY, gymX, gymY;

    public SportSelectScreen(MySportsGame game) {
        this.game = game;
        font = new BitmapFont();
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0.2f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();

        font.getData().setScale(LanguageStrings.TITLE_SCALE);
        font.draw(game.batch, LanguageStrings.get("select_sport"), 100, Gdx.graphics.getHeight() - 70);

        font.getData().setScale(LanguageStrings.BUTTON_SCALE);

        fbX = 150; fbY = 450;
        bbX = 150; bbY = 380;
        tnX = 150; tnY = 310;
        gymX = 150; gymY = 240;

        font.draw(game.batch, LanguageStrings.get("football"), fbX, fbY);
        font.draw(game.batch, LanguageStrings.get("basketball"), bbX, bbY);
        font.draw(game.batch, LanguageStrings.get("tennis"), tnX, tnY);
        font.draw(game.batch, LanguageStrings.get("gym"), gymX, gymY);

        game.batch.end();

        if (LanguageStrings.isTouched(fbX, fbY-40, 200, 60)) ScreenManager.showFootball();
        if (LanguageStrings.isTouched(bbX, bbY-40, 200, 60)) ScreenManager.showBasketball();
        if (LanguageStrings.isTouched(tnX, tnY-40, 200, 60)) ScreenManager.showTennis();
        if (LanguageStrings.isTouched(gymX, gymY-40, 200, 60)) ScreenManager.showGym();
    }

    @Override public void dispose() { font.dispose(); }
    @Override public void show() {}
    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
}
