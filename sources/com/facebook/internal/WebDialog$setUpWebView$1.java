package com.facebook.internal;

import android.content.Context;
import android.webkit.WebView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/facebook/internal/WebDialog$setUpWebView$1", "Landroid/webkit/WebView;", "onWindowFocusChanged", "", "hasWindowFocus", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class WebDialog$setUpWebView$1 extends WebView {
    WebDialog$setUpWebView$1(Context context) {
        super(context);
    }

    public void onWindowFocusChanged(boolean z10) {
        try {
            super.onWindowFocusChanged(z10);
        } catch (NullPointerException unused) {
        }
    }
}
