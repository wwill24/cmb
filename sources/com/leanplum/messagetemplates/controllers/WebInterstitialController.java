package com.leanplum.messagetemplates.controllers;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.leanplum.Leanplum;
import com.leanplum.messagetemplates.DialogCustomizer;
import com.leanplum.messagetemplates.MessageTemplates;
import com.leanplum.messagetemplates.options.WebInterstitialOptions;
import org.jivesoftware.smackx.mam.element.MamElements;

public class WebInterstitialController extends BaseController {
    @NonNull
    private WebInterstitialOptions webOptions;

    public WebInterstitialController(Activity activity, @NonNull WebInterstitialOptions webInterstitialOptions) {
        super(activity);
        this.webOptions = webInterstitialOptions;
        init();
    }

    private WebView createWebView(Context context) {
        WebView webView = new WebView(context);
        webView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (!WebInterstitialController.this.handleCloseEvent(str) && !WebInterstitialController.this.handleGooglePlayUri(webView.getContext(), str)) {
                    return false;
                }
                return true;
            }
        });
        webView.loadUrl(this.webOptions.getUrl());
        return webView;
    }

    /* access modifiers changed from: private */
    public boolean handleCloseEvent(String str) {
        if (!str.contains(this.webOptions.getCloseUrl())) {
            return false;
        }
        runDismissAction();
        cancel();
        String[] split = str.split("\\?");
        if (split.length > 1) {
            for (String split2 : split[1].split("&")) {
                String[] split3 = split2.split("=");
                if (split3.length > 1 && split3[0].equals(MamElements.MamResultExtension.ELEMENT)) {
                    Leanplum.track(split3[1]);
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean handleGooglePlayUri(Context context, String str) {
        Uri parse = Uri.parse(str);
        if ("market".equals(parse.getScheme())) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                context.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException unused) {
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void addMessageChildViews(RelativeLayout relativeLayout) {
        relativeLayout.addView(createWebView(this.activity));
    }

    /* access modifiers changed from: package-private */
    public void applyWindowDecoration() {
        DialogCustomizer customizer = MessageTemplates.getCustomizer();
        if (customizer != null) {
            customizer.customizeWebInterstitial(this, this.contentView);
        }
    }

    public /* bridge */ /* synthetic */ void cancel() {
        super.cancel();
    }

    /* access modifiers changed from: package-private */
    public RelativeLayout.LayoutParams createLayoutParams() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    public /* bridge */ /* synthetic */ View getContentView() {
        return super.getContentView();
    }

    @NonNull
    public WebInterstitialOptions getWebOptions() {
        return this.webOptions;
    }

    /* access modifiers changed from: protected */
    public boolean hasDismissButton() {
        return this.webOptions.hasDismissButton();
    }

    /* access modifiers changed from: package-private */
    public boolean isFullscreen() {
        return true;
    }

    public /* bridge */ /* synthetic */ void onBackPressed() {
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void runDismissAction() {
        this.webOptions.dismiss();
    }
}
