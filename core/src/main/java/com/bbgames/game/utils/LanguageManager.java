package com.bbgames.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.bbgames.game.utils.LanguageStrings.Language;

public class LanguageManager {

    private static final String PREF_NAME = "bbgames_settings";
    private static final String KEY_LANG = "language";

    private static Preferences prefs = Gdx.app.getPreferences(PREF_NAME);

    public static void setLanguage(Language lang) {
        LanguageStrings.setLanguage(lang);
        prefs.putString(KEY_LANG, lang.toString());
        prefs.flush();
    }

    public static void loadLanguage() {
        String saved = prefs.getString(KEY_LANG, "EN");
        LanguageStrings.setLanguage(Language.valueOf(saved));
    }
}
