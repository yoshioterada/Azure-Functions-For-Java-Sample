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

import com.microsoft.azure.serverless.functions.annotation.*;
import com.microsoft.azure.serverless.functions.*;
import com.yoshio3.services.TranslatorTextServices;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

/**
 * Azure Functions with HTTP Trigger.
 */
public class TranslatorFunction {

    /**
     *
     * @param request
     * @param context
     * @return
     */
    @FunctionName("translate")
    public HttpResponseMessage translate(@HttpTrigger(name = "req",
            methods = {"post"},
            authLevel = AuthorizationLevel.ANONYMOUS, dataType = "string") HttpRequestMessage request,
            final ExecutionContext context) {
        context.getLogger().info("Translator was invoked:");

        Map headers = request.getHeaders();
        Object body = request.getBody();
        String originText = "";

        String contentType = (String) headers.get("content-type");
        switch (contentType) {
            case "application/json":
                originText = getTextFromJSon((LinkedHashMap) body);
                break;
            case "text/plain":
                originText = (String) body;
                break;
            default:
                break;
        }
        TranslatorTextServices translator = new TranslatorTextServices();
        String translateEnglishToJapanese = translator.translateEnglishToJapanese(originText);
        String jsonBody = createJSonMessage(originText,translateEnglishToJapanese);
        context.getLogger().info(jsonBody);

        HttpResponseMessage response = request
                .createResponse(200, jsonBody);
        return response;
    }

    private String getTextFromJSon(LinkedHashMap body) {
        if (!body.containsKey("text")) {
            return "Your request is invalid JSON format. Please specify the correct format?";
        }
        return (String) body.get("text");
    }

    private String createJSonMessage(String origin,String translated) {
        TranslatorJSonResponseBody body = new TranslatorJSonResponseBody();
        body.setOriginal(origin);
        body.setTranslatedValue(translated);
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(body);
    }
}
