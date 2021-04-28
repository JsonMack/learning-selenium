package com.jsonmack.selenium.settings;

/**
 * @author Jason MacKeigan
 */
public class Settings {

    private final String sauceLabsUrl;

    public Settings(String sauceLabsUrl) {
        this.sauceLabsUrl = sauceLabsUrl;
    }

    public String getSauceLabsUrl() {
        return sauceLabsUrl;
    }
}
