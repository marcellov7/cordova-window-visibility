package com.example;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

public class WindowVisibilityPlugin extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("enable")) {
            this.enable(callbackContext);
            return true;
        }
        return false;
    }

    private void enable(CallbackContext callbackContext) {
        cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                webView.getView().setCustomWebView();
                callbackContext.success();
            }
        });
    }
}