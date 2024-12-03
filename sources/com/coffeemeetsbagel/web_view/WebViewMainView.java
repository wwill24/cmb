package com.coffeemeetsbagel.web_view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class WebViewMainView extends WebView {

    public static final class a extends WebViewClient {
        a() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            j.g(webView, "view");
            j.g(str, "url");
            webView.loadUrl(str);
            return true;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WebViewMainView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WebViewMainView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public final void a(String str) {
        j.g(str, "url");
        getSettings().setJavaScriptEnabled(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setDomStorageEnabled(true);
        setWebViewClient(new a());
        loadUrl(str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebViewMainView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }
}
