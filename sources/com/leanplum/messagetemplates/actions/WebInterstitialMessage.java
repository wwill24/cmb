package com.leanplum.messagetemplates.actions;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import com.leanplum.ActionArgs;
import com.leanplum.ActionContext;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.messagetemplates.MessageTemplate;
import com.leanplum.messagetemplates.controllers.WebInterstitialController;
import com.leanplum.messagetemplates.options.WebInterstitialOptions;
import uh.h;

public class WebInterstitialMessage implements MessageTemplate {
    private static final String WEB_INTERSTITIAL = "Web Interstitial";
    private WebInterstitialController webInterstitial;

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$present$0(ActionContext actionContext, DialogInterface dialogInterface) {
        this.webInterstitial = null;
        actionContext.actionDismissed();
    }

    @NonNull
    public ActionArgs createActionArgs(@NonNull Context context) {
        return WebInterstitialOptions.toArgs();
    }

    public boolean dismiss(@NonNull ActionContext actionContext) {
        WebInterstitialController webInterstitialController = this.webInterstitial;
        if (webInterstitialController == null) {
            return true;
        }
        webInterstitialController.dismiss();
        return true;
    }

    @NonNull
    public String getName() {
        return WEB_INTERSTITIAL;
    }

    public boolean present(@NonNull ActionContext actionContext) {
        Activity currentActivity = LeanplumActivityHelper.getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing()) {
            return false;
        }
        WebInterstitialController webInterstitialController = new WebInterstitialController(currentActivity, new WebInterstitialOptions(actionContext));
        this.webInterstitial = webInterstitialController;
        webInterstitialController.setOnDismissListener(new h(this, actionContext));
        this.webInterstitial.show();
        return true;
    }
}
