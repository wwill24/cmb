package com.leanplum.messagetemplates.actions;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import com.leanplum.ActionArgs;
import com.leanplum.ActionContext;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.internal.Log;
import com.leanplum.messagetemplates.MessageTemplate;
import com.leanplum.messagetemplates.controllers.RichHtmlController;
import com.leanplum.messagetemplates.options.RichHtmlOptions;
import uh.g;

public class RichHtmlMessage implements MessageTemplate {
    private static final String HTML = "HTML";
    private RichHtmlController richHtml;

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$present$0(ActionContext actionContext, DialogInterface dialogInterface) {
        this.richHtml = null;
        actionContext.actionDismissed();
    }

    @NonNull
    public ActionArgs createActionArgs(@NonNull Context context) {
        return RichHtmlOptions.toArgs();
    }

    public boolean dismiss(@NonNull ActionContext actionContext) {
        RichHtmlController richHtmlController = this.richHtml;
        if (richHtmlController == null) {
            return true;
        }
        richHtmlController.dismiss();
        return true;
    }

    @NonNull
    public String getName() {
        return HTML;
    }

    public boolean present(@NonNull ActionContext actionContext) {
        Activity currentActivity = LeanplumActivityHelper.getCurrentActivity();
        if (currentActivity != null && !currentActivity.isFinishing()) {
            try {
                RichHtmlOptions richHtmlOptions = new RichHtmlOptions(actionContext);
                if (richHtmlOptions.getHtmlTemplate() == null) {
                    return false;
                }
                RichHtmlController richHtmlController = new RichHtmlController(currentActivity, richHtmlOptions);
                this.richHtml = richHtmlController;
                richHtmlController.setOnDismissListener(new g(this, actionContext));
                return true;
            } catch (Throwable th2) {
                Log.e("Fail on show HTML In-App message: %s", th2.getMessage());
            }
        }
        return false;
    }
}
