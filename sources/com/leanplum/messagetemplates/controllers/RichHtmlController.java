package com.leanplum.messagetemplates.controllers;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.facebook.internal.ServerProtocol;
import com.leanplum.ActionContext;
import com.leanplum.Leanplum;
import com.leanplum.internal.Log;
import com.leanplum.messagetemplates.DialogCustomizer;
import com.leanplum.messagetemplates.MessageTemplates;
import com.leanplum.messagetemplates.options.RichHtmlOptions;
import com.leanplum.utils.SizeUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import org.jivesoftware.smackx.mam.element.MamElements;
import org.json.b;

public class RichHtmlController extends BaseController {
    /* access modifiers changed from: private */
    @NonNull
    public RichHtmlOptions richOptions;
    private WebView webView;

    public RichHtmlController(Activity activity, @NonNull RichHtmlOptions richHtmlOptions) {
        super(activity);
        this.richOptions = richHtmlOptions;
        init();
    }

    private WebView createHtml(Context context) {
        this.contentView.setVisibility(8);
        WebView webView2 = new WebView(context);
        webView2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        initWebSettings(webView2);
        webView2.setBackgroundColor(0);
        webView2.setLongClickable(false);
        webView2.setHapticFeedbackEnabled(false);
        webView2.setOnLongClickListener(new d());
        webView2.setWebChromeClient(new WebChromeClient());
        webView2.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                String str2;
                try {
                    RichHtmlController richHtmlController = RichHtmlController.this;
                    if (!richHtmlController.isClosing && !richHtmlController.handleOpenEvent(str) && !RichHtmlController.this.handleCloseEvent(str) && !RichHtmlController.this.handleTrackEvent(str) && !RichHtmlController.this.handleActionEvent(str)) {
                        return false;
                    }
                    return true;
                } catch (Throwable th2) {
                    ActionContext actionContext = RichHtmlController.this.richOptions.getActionContext();
                    if (actionContext != null) {
                        str2 = actionContext.getMessageId();
                    } else {
                        str2 = "";
                    }
                    Log.e("Error in Rich Interstitial messageId=" + str2, th2);
                    return false;
                }
            }
        });
        webView2.loadDataWithBaseURL((String) null, this.richOptions.getHtmlTemplate(), "text/html", "UTF-8", (String) null);
        return webView2;
    }

    private void customizeDialog() {
        DialogCustomizer customizer = MessageTemplates.getCustomizer();
        if (customizer == null) {
            return;
        }
        if (this.richOptions.isBanner()) {
            customizer.customizeBanner(this, this.contentView);
        } else {
            customizer.customizeRichInterstitial(this, this.contentView);
        }
    }

    /* access modifiers changed from: private */
    public boolean handleActionEvent(String str) {
        if (!str.contains(this.richOptions.getActionUrl()) && !str.contains(this.richOptions.getTrackActionUrl())) {
            return false;
        }
        cancel();
        String queryComponentsFromUrl = queryComponentsFromUrl(str, "action");
        try {
            queryComponentsFromUrl = URLDecoder.decode(queryComponentsFromUrl, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
        }
        ActionContext actionContext = this.richOptions.getActionContext();
        if (TextUtils.isEmpty(queryComponentsFromUrl) || actionContext == null) {
            return true;
        }
        if (str.contains(this.richOptions.getActionUrl())) {
            actionContext.runActionNamed(queryComponentsFromUrl);
            return true;
        }
        actionContext.runTrackedActionNamed(queryComponentsFromUrl);
        return true;
    }

    /* access modifiers changed from: private */
    public boolean handleCloseEvent(String str) {
        if (!str.contains(this.richOptions.getCloseUrl())) {
            return false;
        }
        runDismissAction();
        cancel();
        String queryComponentsFromUrl = queryComponentsFromUrl(str, MamElements.MamResultExtension.ELEMENT);
        if (TextUtils.isEmpty(queryComponentsFromUrl)) {
            return true;
        }
        Leanplum.track(queryComponentsFromUrl);
        return true;
    }

    /* access modifiers changed from: private */
    public boolean handleOpenEvent(String str) {
        if (!str.contains(this.richOptions.getOpenUrl())) {
            return false;
        }
        this.contentView.setVisibility(0);
        Activity activity = this.activity;
        if (activity == null || activity.isFinishing()) {
            return true;
        }
        show();
        return true;
    }

    /* access modifiers changed from: private */
    public boolean handleTrackEvent(String str) {
        if (!str.contains(this.richOptions.getTrackUrl())) {
            return false;
        }
        String queryComponentsFromUrl = queryComponentsFromUrl(str, "event");
        if (TextUtils.isEmpty(queryComponentsFromUrl)) {
            return true;
        }
        Double valueOf = Double.valueOf(Double.parseDouble(queryComponentsFromUrl(str, "value")));
        String queryComponentsFromUrl2 = queryComponentsFromUrl(str, "info");
        Map map = null;
        try {
            map = ActionContext.mapFromJson(new b(queryComponentsFromUrl(str, "parameters")));
        } catch (Exception unused) {
        }
        Map map2 = map;
        if (queryComponentsFromUrl(str, "isMessageEvent").equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            this.richOptions.getActionContext().trackMessageEvent(queryComponentsFromUrl, valueOf.doubleValue(), queryComponentsFromUrl2, map2);
            return true;
        }
        Leanplum.track(queryComponentsFromUrl, valueOf.doubleValue(), queryComponentsFromUrl2, map2);
        return true;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initWebSettings(WebView webView2) {
        WebSettings settings = webView2.getSettings();
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setAppCacheEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadWithOverviewMode(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
        settings.setSupportZoom(false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createHtml$0(View view) {
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onFadeOutAnimationEnd$1() {
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.stopLoading();
            this.webView.loadUrl("");
            RelativeLayout relativeLayout = this.contentView;
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
            this.webView.removeAllViews();
            this.webView.destroy();
        }
    }

    private String queryComponentsFromUrl(String str, String str2) {
        String[] split = str.split("\\?");
        String str3 = "";
        if (split.length > 1) {
            for (String split2 : split[1].split("&")) {
                String[] split3 = split2.split("=");
                if (split3.length > 1 && split3[0].equals(str2)) {
                    str3 = split3[1];
                }
            }
        }
        try {
            return URLDecoder.decode(str3, "UTF-8");
        } catch (Exception unused) {
            return str3;
        }
    }

    /* access modifiers changed from: package-private */
    public void addMessageChildViews(RelativeLayout relativeLayout) {
        WebView createHtml = createHtml(this.activity);
        this.webView = createHtml;
        relativeLayout.addView(createHtml);
    }

    /* access modifiers changed from: protected */
    public void applyWindowDecoration() {
        if (isFullscreen()) {
            customizeDialog();
            return;
        }
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(2);
            if (this.richOptions.isBannerWithTapOutsideFalse()) {
                window.setLayout(-1, -2);
                window.setGravity(48);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.y = this.richOptions.getHtmlYOffset(this.activity);
                window.setAttributes(attributes);
                window.setFlags(40, 40);
            } else {
                window.setFlags(32, 32);
            }
            if (this.richOptions.isHtmlAlignBottom()) {
                if (this.richOptions.isBannerWithTapOutsideFalse()) {
                    window.setGravity(80);
                } else {
                    this.contentView.setGravity(80);
                }
            }
            customizeDialog();
        }
    }

    public /* bridge */ /* synthetic */ void cancel() {
        super.cancel();
    }

    /* access modifiers changed from: package-private */
    public RelativeLayout.LayoutParams createLayoutParams() {
        RelativeLayout.LayoutParams layoutParams;
        int i10;
        if (isFullscreen()) {
            return new RelativeLayout.LayoutParams(-1, -1);
        }
        int dpToPx = SizeUtil.dpToPx(this.activity, this.richOptions.getHtmlHeight());
        RichHtmlOptions.Size htmlWidth = this.richOptions.getHtmlWidth();
        if (htmlWidth == null || TextUtils.isEmpty(htmlWidth.type)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, dpToPx);
        } else {
            int i11 = htmlWidth.value;
            if ("%".equals(htmlWidth.type)) {
                i10 = (SizeUtil.getDisplaySize(this.activity).x * i11) / 100;
            } else {
                i10 = SizeUtil.dpToPx(this.activity, i11);
            }
            layoutParams = new RelativeLayout.LayoutParams(i10, dpToPx);
        }
        layoutParams.addRule(14, -1);
        int htmlYOffset = this.richOptions.getHtmlYOffset(this.activity);
        if (this.richOptions.isBannerWithTapOutsideFalse()) {
            return layoutParams;
        }
        if (this.richOptions.isHtmlAlignBottom()) {
            layoutParams.bottomMargin = htmlYOffset;
            return layoutParams;
        }
        layoutParams.topMargin = htmlYOffset;
        return layoutParams;
    }

    public boolean dispatchTouchEvent(@NonNull MotionEvent motionEvent) {
        int i10;
        int i11;
        if (!this.richOptions.isFullScreen()) {
            if (this.richOptions.isBannerWithTapOutsideFalse()) {
                return super.dispatchTouchEvent(motionEvent);
            }
            Point displaySize = SizeUtil.getDisplaySize(this.activity);
            int width = this.webView.getWidth();
            int i12 = displaySize.x;
            int i13 = (i12 - width) / 2;
            int i14 = (i12 + width) / 2;
            int dpToPx = SizeUtil.dpToPx(Leanplum.getContext(), this.richOptions.getHtmlHeight());
            int statusBarHeight = SizeUtil.getStatusBarHeight(Leanplum.getContext());
            int htmlYOffset = this.richOptions.getHtmlYOffset(this.activity);
            if (this.richOptions.isHtmlAlignBottom()) {
                int i15 = displaySize.y;
                i10 = ((i15 - dpToPx) - statusBarHeight) - htmlYOffset;
                i11 = (i15 - htmlYOffset) - statusBarHeight;
            } else {
                int i16 = dpToPx + statusBarHeight + htmlYOffset;
                i10 = htmlYOffset + statusBarHeight;
                i11 = i16;
            }
            if (motionEvent.getY() < ((float) i10) || motionEvent.getY() > ((float) i11) || motionEvent.getX() < ((float) i13) || motionEvent.getX() > ((float) i14)) {
                if (this.richOptions.isHtmlTabOutsideToClose()) {
                    runDismissAction();
                    cancel();
                }
                this.activity.dispatchTouchEvent(motionEvent);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ View getContentView() {
        return super.getContentView();
    }

    @NonNull
    public RichHtmlOptions getRichOptions() {
        return this.richOptions;
    }

    /* access modifiers changed from: package-private */
    public boolean hasDismissButton() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isFullscreen() {
        return this.richOptions.isFullScreen();
    }

    public /* bridge */ /* synthetic */ void onBackPressed() {
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onFadeOutAnimationEnd() {
        super.onFadeOutAnimationEnd();
        new Handler().postDelayed(new c(this), 10);
    }

    public void onWindowFocusChanged(boolean z10) {
        try {
            WebView webView2 = this.webView;
            if (webView2 != null) {
                if (z10) {
                    webView2.onResume();
                } else {
                    webView2.onPause();
                }
            }
        } catch (Throwable unused) {
        }
        super.onWindowFocusChanged(z10);
    }

    /* access modifiers changed from: protected */
    public void runDismissAction() {
        if (!this.isClosing) {
            this.richOptions.dismiss();
        }
    }
}
