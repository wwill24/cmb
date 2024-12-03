package com.leanplum.messagetemplates.actions;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import com.leanplum.ActionArgs;
import com.leanplum.ActionContext;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.messagetemplates.MessageTemplate;
import com.leanplum.messagetemplates.controllers.CenterPopupController;
import com.leanplum.messagetemplates.options.CenterPopupOptions;
import uh.b;

public class CenterPopupMessage implements MessageTemplate {
    private static final String CENTER_POPUP = "Center Popup";
    private CenterPopupController popup;

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$present$0(ActionContext actionContext, DialogInterface dialogInterface) {
        this.popup = null;
        actionContext.actionDismissed();
    }

    @NonNull
    public ActionArgs createActionArgs(@NonNull Context context) {
        return CenterPopupOptions.toArgs(context);
    }

    public boolean dismiss(@NonNull ActionContext actionContext) {
        CenterPopupController centerPopupController = this.popup;
        if (centerPopupController == null) {
            return true;
        }
        centerPopupController.dismiss();
        return true;
    }

    @NonNull
    public String getName() {
        return CENTER_POPUP;
    }

    public boolean present(@NonNull ActionContext actionContext) {
        Activity currentActivity = LeanplumActivityHelper.getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing()) {
            return false;
        }
        CenterPopupController centerPopupController = new CenterPopupController(currentActivity, new CenterPopupOptions(actionContext));
        this.popup = centerPopupController;
        centerPopupController.setOnDismissListener(new b(this, actionContext));
        this.popup.show();
        return true;
    }
}
