package com.bbgames.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import java.util.HashMap;

/**
 * Dokunmatik + PC uyumlu dil sistemi
 * Metinler – Buton Boyutları – UI Ölçeklendirmeleri içerir
 */
public class LanguageStrings {

    public enum Language {
        TR, EN
    }

    private static Language currentLanguage = Language.EN;

    private static HashMap<String, String> trStrings = new HashMap<>();
    private static HashMap<String, String> enStrings = new HashMap<>();

    // --- UI Ölçeklendirme değişkenleri ---
    public static float TITLE_SCALE;
    public static float BUTTON_SCALE;
    public static float TEXT_SCALE;

    // Dokunmatik algılama eşiği
    public static float TOUCH_RADIUS;

    public static void init() {
        loadStrings();
        calculateUIScale();
    }

    public static void setLanguage(Language lang) {
        currentLanguage = lang;
    }

    public static Language getLanguage() {
        return currentLanguage;
    }

    // Çoklu platform UI ölçeği (mobile + desktop)
    private static void calculateUIScale() {
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        float base = (width + height) / 2f;

        // Mobilde butonlar daha büyük yapılır
        boolean isMobile = Gdx.app.getType().toString().equals("Android");

        TITLE_SCALE = isMobile ? base * 0.00060f : base * 0.00040f;
        BUTTON_SCALE = isMobile ? base * 0.00045f : base * 0.00030f;
        TEXT_SCALE   = isMobile ? base * 0.00032f : base * 0.00025f;

        // Dokunmatik temas alanı büyüklüğü
        TOUCH_RADIUS = isMobile ? 90f : 40f;
    }

    public static String get(String key) {
        if (currentLanguage == Language.TR) {
            return trStrings.getOrDefault(key, key);
        } else {
            return enStrings.getOrDefault(key, key);
        }
    }

    private static void loadStrings() {

        // ---------------- TURKCE ----------------
        trStrings.put("title", "BB Sports Game");
        trStrings.put("select_language", "Dil Seç");
        trStrings.put("turkish", "Türkçe");
        trStrings.put("english", "İngilizce");

        trStrings.put("play", "Oyna");
        trStrings.put("select_sport", "Spor Seç");
        trStrings.put("football", "Futbol");
        trStrings.put("basketball", "Basketbol");
        trStrings.put("tennis", "Tenis");
        trStrings.put("gym", "Fitness Salonu");
        trStrings.put("back", "Geri");

        // ---------------- ENGLISH ----------------
        enStrings.put("title", "BB Sports Game");
        enStrings.put("select_language", "Select Language");
        enStrings.put("turkish", "Turkish");
        enStrings.put("english", "English");

        enStrings.put("play", "Play");
        enStrings.put("select_sport", "Choose Sport");
        enStrings.put("football", "Football");
        enStrings.put("basketball", "Basketball");
        enStrings.put("tennis", "Tennis");
        enStrings.put("gym", "Gym");
        enStrings.put("back", "Back");
    }

    /**
     * Dokunmatik veya fare tıklamasını ortaklaştırır
     * Her butonda kullanılabilir
     */
    public static boolean isTouched(float x, float y, float w, float h) {
        // Dokunmatik:
        if (Gdx.input.isTouched()) {
            Vector2 touch = new Vector2(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
            return touch.x >= x && touch.x <= x + w && touch.y >= y && touch.y <= y + h;
        }

        // Fare ile tıklama:
        if (Gdx.input.justTouched()) {
            Vector2 touch = new Vector2(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
            return touch.x >= x && touch.x <= x + w && touch.y >= y && touch.y <= y + h;
        }

        return false;
    }

}
