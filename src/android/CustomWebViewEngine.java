package com.example;

import android.content.Context;
import android.view.View;

import org.apache.cordova.engine.SystemWebViewEngine;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.ConfigXmlParser;

public class CustomWebViewEngine extends SystemWebViewEngine {
    public CustomWebViewEngine(Context context) {
        this(new CustomWebView(context));
    }

    public CustomWebViewEngine(CustomWebView webView) {
        super(webView);
    }

    public void init(CordovaWebView parentWebView, CordovaInterface cordova, Client client,
                     ConfigXmlParser configXmlParser) {
        super.init(parentWebView, cordova, client, configXmlParser);
        // Qui puoi aggiungere eventuali inizializzazioni personalizzate se necessario
    }
}