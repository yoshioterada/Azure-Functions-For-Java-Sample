/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yoshio3;

/**
 *
 * @author yoterada
 */
public class TranslatorJSonResponseBody {
    private String original;
    private String translatedValue;

    /**
     * @return the original
     */
    public String getOriginal() {
        return original;
    }

    /**
     * @param original the original to set
     */
    public void setOriginal(String original) {
        this.original = original;
    }

    /**
     * @return the translatedValue
     */
    public String getTranslatedValue() {
        return translatedValue;
    }

    /**
     * @param translatedValue the translatedValue to set
     */
    public void setTranslatedValue(String translatedValue) {
        this.translatedValue = translatedValue;
    }

    @Override
    public String toString() {
        return "TranslatorJSonResponseBody{" + "original=" + original + ", translatedValue=" + translatedValue + '}';
    }

}
