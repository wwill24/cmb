package com.leanplum.messagetemplates.actions;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import com.leanplum.ActionArgs;
import com.leanplum.ActionContext;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.internal.Util;
import com.leanplum.messagetemplates.MessageTemplate;
import com.leanplum.messagetemplates.MessageTemplateConstants;
import uh.a;

public class AlertMessage implements MessageTemplate {
    private static final String ALERT = "Alert";
    private AlertDialog alertDialog;

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$present$0(ActionContext actionContext, DialogInterface dialogInterface, int i10) {
        this.alertDialog = null;
        actionContext.runActionNamed(MessageTemplateConstants.Args.DISMISS_ACTION);
        actionContext.actionDismissed();
    }

    @NonNull
    public ActionArgs createActionArgs(Context context) {
        return new ActionArgs().with("Title", Util.getApplicationName(context)).with(MessageTemplateConstants.Args.MESSAGE, MessageTemplateConstants.Values.ALERT_MESSAGE).with(MessageTemplateConstants.Args.DISMISS_TEXT, MessageTemplateConstants.Values.OK_TEXT).withAction(MessageTemplateConstants.Args.DISMISS_ACTION, (String) null);
    }

    public boolean dismiss(@NonNull ActionContext actionContext) {
        AlertDialog alertDialog2 = this.alertDialog;
        if (alertDialog2 == null) {
            return true;
        }
        alertDialog2.dismiss();
        this.alertDialog = null;
        actionContext.actionDismissed();
        return true;
    }

    @NonNull
    public String getName() {
        return ALERT;
    }

    public boolean present(@NonNull ActionContext actionContext) {
        Activity currentActivity = LeanplumActivityHelper.getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing()) {
            return false;
        }
        AlertDialog create = new AlertDialog.Builder(currentActivity).setTitle(actionContext.stringNamed("Title")).setMessage(actionContext.stringNamed(MessageTemplateConstants.Args.MESSAGE)).setCancelable(false).setPositiveButton(actionContext.stringNamed(MessageTemplateConstants.Args.DISMISS_TEXT), new a(this, actionContext)).create();
        this.alertDialog = create;
        create.show();
        return true;
    }
}
