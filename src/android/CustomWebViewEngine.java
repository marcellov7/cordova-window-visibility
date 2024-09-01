package com.example;

import android.content.Context;
import android.view.View;

import org.apache.cordova.engine.SystemWebViewEngine;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;

public class CustomWebViewEngine extends SystemWebViewEngine {
    public CustomWebViewEngine(Context context, CordovaPreferences preferences) {
        super(new CustomWebView(context), preferences);
    }

    public CustomWebViewEngine(CustomWebView webView) {
        super(webView);
    }
}