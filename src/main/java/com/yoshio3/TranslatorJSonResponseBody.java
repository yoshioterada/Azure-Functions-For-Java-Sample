/**
 * 
 * @author Yoshio Terada
 * 
 *         Copyright (c) 2017 Yoshio Terada
 * 
 *         Permission is hereby granted, free of charge, to any person obtaining
 *         a copy of this software and associated documentation files (the
 *         "Software"), to deal in the Software without restriction, including
 *         without limitation the rights to use, copy, modify, merge, publish,
 *         distribute, sublicense, and/or sell copies of the Software, and to
 *         permit persons to whom the Software is furnished to do so, subject to
 *         the following conditions:
 * 
 *         The above copyright notice and this permission notice shall be
 *         included in all copies or substantial portions of the Software.
 * 
 *         THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *         EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *         MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *         NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *         BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *         ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *         CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *         SOFTWARE.
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
