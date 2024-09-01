package com.example;

import android.content.Context;
import android.view.View;

import org.apache.cordova.engine.SystemWebViewEngine;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.PluginManager;
import org.apache.cordova.NativeToJsMessageQueue;

public class CustomWebViewEngine extends SystemWebViewEngine {
    public CustomWebViewEngine(Context context) {
        this(new CustomWebView(context));
    }

    public CustomWebViewEngine(CustomWebView webView) {
        super(webView);
    }

    @Override
    public void init(CordovaWebView parentWebView, CordovaInterface cordova, Client client,
                     CordovaResourceApi resourceApi, PluginManager pluginManager,
                     NativeToJsMessageQueue nativeToJsMessageQueue) {
        super.init(parentWebView, cordova, client, resourceApi, pluginManager, nativeToJsMessageQueue);
        // Qui puoi aggiungere eventuali inizializzazioni personalizzate se necessario
    }
}