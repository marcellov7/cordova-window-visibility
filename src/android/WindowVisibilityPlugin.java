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
    private int visibilityDelay;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        this.webView = webView;
        this.visibilityDelay = preferences.getInteger("VISIBILITY_DELAY", 1000);
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("enable")) {
            this.enable(callbackContext);
            return true;
        } else if (action.equals("setDelay")) {
            int delay = args.getInt(0);
            this.setDelay(delay, callbackContext);
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

    private void setDelay(int delay, CallbackContext callbackContext) {
        this.visibilityDelay = delay;
        callbackContext.success("Delay set to " + delay + " ms");
    }

    @Override
    public void onStop() {
        super.onStop();
        cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(visibilityDelay);
                    webView.getEngine().getView().dispatchWindowVisibilityChanged(View.VISIBLE);
                } catch (InterruptedException e) {
                    // do nothing
                }
            }
        });
    }
}