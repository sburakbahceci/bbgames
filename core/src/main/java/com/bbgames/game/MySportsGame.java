package com.bbgames.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bbgames.game.utils.LanguageManager;
import com.bbgames.game.utils.LanguageStrings;
import com.bbgames.game.utils.ScreenManager;

public class MySportsGame extends Game {

    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();

        // Dil sistemini başlat
        LanguageStrings.init();
        LanguageManager.loadLanguage(); // son seçilen dili yükler

        // Screen Manager başlat
        ScreenManager.init(this);

        // İlk ekran: Ana Menü
        ScreenManager.showMainMenu();
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
