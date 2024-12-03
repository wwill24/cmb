package com.leanplum.messagetemplates.controllers;

import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;
import com.leanplum.messagetemplates.DialogCustomizer;
import com.leanplum.messagetemplates.MessageTemplates;
import com.leanplum.messagetemplates.options.BaseMessageOptions;
import com.leanplum.messagetemplates.options.InterstitialOptions;

public class InterstitialController extends AbstractPopupController {
    public InterstitialController(Activity activity, InterstitialOptions interstitialOptions) {
        super(activity, interstitialOptions);
    }

    /* access modifiers changed from: package-private */
    public void applyWindowDecoration() {
        DialogCustomizer customizer = MessageTemplates.getCustomizer();
        if (customizer != null) {
            customizer.customizeInterstitial(this, this.contentView);
        }
    }

    public /* bridge */ /* synthetic */ void cancel() {
        super.cancel();
    }

    /* access modifiers changed from: protected */
    public RelativeLayout.LayoutParams createLayoutParams() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    public /* bridge */ /* synthetic */ View getContentView() {
        return super.getContentView();
    }

    public /* bridge */ /* synthetic */ BaseMessageOptions getOptions() {
        return super.getOptions();
    }

    /* access modifiers changed from: package-private */
    public boolean isFullscreen() {
        return true;
    }

    public /* bridge */ /* synthetic */ void onBackPressed() {
        super.onBackPressed();
    }
}
