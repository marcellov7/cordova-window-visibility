package com.example;

import android.content.Context;
import android.view.View;
import org.apache.cordova.engine.SystemWebView;

public class CustomWebView extends SystemWebView {
    public CustomWebView(Context context) {
        super(context);
    }

    @Override
    public void dispatchWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(View.VISIBLE);
    }
}