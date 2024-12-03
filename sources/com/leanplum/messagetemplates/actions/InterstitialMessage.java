package com.leanplum.messagetemplates.actions;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import com.leanplum.ActionArgs;
import com.leanplum.ActionContext;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.messagetemplates.MessageTemplate;
import com.leanplum.messagetemplates.controllers.InterstitialController;
import com.leanplum.messagetemplates.options.InterstitialOptions;
import uh.e;

public class InterstitialMessage implements MessageTemplate {
    private static final String INTERSTITIAL = "Interstitial";
    private InterstitialController interstitial;

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$present$0(ActionContext actionContext, DialogInterface dialogInterface) {
        this.interstitial = null;
        actionContext.actionDismissed();
    }

    @NonNull
    public ActionArgs createActionArgs(@NonNull Context context) {
        return InterstitialOptions.toArgs(context);
    }

    public boolean dismiss(@NonNull ActionContext actionContext) {
        InterstitialController interstitialController = this.interstitial;
        if (interstitialController == null) {
            return true;
        }
        interstitialController.dismiss();
        return true;
    }

    @NonNull
    public String getName() {
        return INTERSTITIAL;
    }

    public boolean present(@NonNull ActionContext actionContext) {
        Activity currentActivity = LeanplumActivityHelper.getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing()) {
            return false;
        }
        InterstitialController interstitialController = new InterstitialController(currentActivity, new InterstitialOptions(actionContext));
        this.interstitial = interstitialController;
        interstitialController.setOnDismissListener(new e(this, actionContext));
        this.interstitial.show();
        return true;
    }
}
