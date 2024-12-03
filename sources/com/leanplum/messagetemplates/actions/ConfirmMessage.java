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
import uh.c;
import uh.d;

public class ConfirmMessage implements MessageTemplate {
    private static final String CONFIRM = "Confirm";
    private AlertDialog alertDialog;

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$present$0(ActionContext actionContext, DialogInterface dialogInterface, int i10) {
        this.alertDialog = null;
        actionContext.runTrackedActionNamed(MessageTemplateConstants.Args.ACCEPT_ACTION);
        actionContext.actionDismissed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$present$1(ActionContext actionContext, DialogInterface dialogInterface, int i10) {
        this.alertDialog = null;
        actionContext.runActionNamed(MessageTemplateConstants.Args.CANCEL_ACTION);
        actionContext.actionDismissed();
    }

    @NonNull
    public ActionArgs createActionArgs(@NonNull Context context) {
        return new ActionArgs().with("Title", Util.getApplicationName(context)).with(MessageTemplateConstants.Args.MESSAGE, MessageTemplateConstants.Values.CONFIRM_MESSAGE).with(MessageTemplateConstants.Args.ACCEPT_TEXT, "Yes").with(MessageTemplateConstants.Args.CANCEL_TEXT, "No").withAction(MessageTemplateConstants.Args.ACCEPT_ACTION, (String) null).withAction(MessageTemplateConstants.Args.CANCEL_ACTION, (String) null);
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
        return CONFIRM;
    }

    public boolean present(@NonNull ActionContext actionContext) {
        Activity currentActivity = LeanplumActivityHelper.getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing()) {
            return false;
        }
        AlertDialog create = new AlertDialog.Builder(currentActivity).setTitle(actionContext.stringNamed("Title")).setMessage(actionContext.stringNamed(MessageTemplateConstants.Args.MESSAGE)).setCancelable(false).setPositiveButton(actionContext.stringNamed(MessageTemplateConstants.Args.ACCEPT_TEXT), new c(this, actionContext)).setNegativeButton(actionContext.stringNamed(MessageTemplateConstants.Args.CANCEL_TEXT), new d(this, actionContext)).create();
        this.alertDialog = create;
        create.show();
        return true;
    }
}
