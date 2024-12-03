package com.coffeemeetsbagel.feature.instagram.login;

import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import b8.b;
import com.coffeemeetsbagel.R;

public class InstagramLoginActivity extends r7.a implements b {

    /* renamed from: b  reason: collision with root package name */
    WebView f13029b;

    /* renamed from: c  reason: collision with root package name */
    b8.a f13030c;

    class a extends WebViewClient {
        a() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return InstagramLoginActivity.this.f13030c.a(str.toString());
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return InstagramLoginActivity.this.f13030c.a(webResourceRequest.getUrl().toString());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D0() {
        if (!isFinishing()) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public CookieSyncManager A0() {
        return CookieSyncManager.createInstance(this);
    }

    /* access modifiers changed from: protected */
    public CookieManager B0() {
        return CookieManager.getInstance();
    }

    public void C() {
        sb.a.g(getWindow().getDecorView().findViewById(16908290), R.string.instagram_auth_generic);
        new Handler().postDelayed(new d8.a(this), 2750);
    }

    /* access modifiers changed from: protected */
    public b8.a C0() {
        return new a(t0(), this);
    }

    public void G(String str) {
        this.f13029b.loadUrl(str);
    }

    public void N() {
        sb.a.g(getWindow().getDecorView().findViewById(16908290), R.string.instagram_auth_denied);
    }

    public void T() {
        this.f13029b.clearCache(true);
        this.f13029b.clearHistory();
        CookieSyncManager A0 = A0();
        A0.startSync();
        CookieManager B0 = B0();
        B0.removeAllCookie();
        B0.removeSessionCookie();
        A0.stopSync();
        A0.sync();
    }

    public void a() {
        setResult(-1);
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WebView webView = new WebView(this);
        this.f13029b = webView;
        webView.setWebViewClient(new a());
        addContentView(this.f13029b, new ViewGroup.LayoutParams(-1, -1));
        if (this.f13030c == null) {
            this.f13030c = C0();
        }
        this.f13030c.start();
    }

    public void onDestroy() {
        this.f13030c.stop();
        super.onDestroy();
    }
}
