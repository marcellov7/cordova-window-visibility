package com.example;

import android.view.View;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

public class WindowVisibilityPlugin extends CordovaPlugin {
    private CordovaWebView webView;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        this.webView = webView;
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("enable")) {
            this.enable(callbackContext);
            return true;
        }
        return false;
    }

    private void enable(CallbackContext callbackContext) {
        cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                callbackContext.success("Window visibility enabled");
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        // Wake up sleeping beauty one second after Maleficent (WebView) has put her to sleep
        cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                    webView.getEngine().getView().dispatchWindowVisibilityChanged(View.VISIBLE);
                } catch (InterruptedException e) {
                    // do nothing
                }
            }
        });
    }
}