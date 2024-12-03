package com.leanplum.messagetemplates.actions;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.leanplum.ActionArgs;
import com.leanplum.ActionContext;
import com.leanplum.Leanplum;
import com.leanplum.internal.Log;
import com.leanplum.internal.OperationQueue;
import com.leanplum.messagetemplates.MessageTemplate;
import com.leanplum.messagetemplates.MessageTemplateConstants;
import java.util.List;
import uh.f;

public class OpenUrlAction implements MessageTemplate {
    private static final String OPEN_URL = "Open URL";

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$present$0(ActionContext actionContext) {
        actionContext.runActionNamed(MessageTemplateConstants.Args.DISMISS_ACTION);
        actionContext.actionDismissed();
    }

    private static boolean openUriIntent(Context context, Intent intent) {
        ActivityInfo activityInfo;
        String str;
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (!queryIntentActivities.isEmpty()) {
            for (ResolveInfo next : queryIntentActivities) {
                if (!(next == null || (activityInfo = next.activityInfo) == null || (str = activityInfo.name) == null || !str.contains(context.getPackageName()))) {
                    intent.setPackage(next.activityInfo.packageName);
                }
            }
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e10) {
            Log.e("Activity you are trying to start doesn't exist or isn't exported in manifest: " + e10, new Object[0]);
            return false;
        }
    }

    @NonNull
    public ActionArgs createActionArgs(@NonNull Context context) {
        return new ActionArgs().with(MessageTemplateConstants.Args.URL, MessageTemplateConstants.Values.DEFAULT_URL);
    }

    public boolean dismiss(@NonNull ActionContext actionContext) {
        return true;
    }

    @NonNull
    public String getName() {
        return "Open URL";
    }

    public boolean present(@NonNull ActionContext actionContext) {
        Context context = Leanplum.getContext();
        if (context == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(actionContext.stringNamed(MessageTemplateConstants.Args.URL)));
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        boolean openUriIntent = openUriIntent(context, intent);
        OperationQueue.sharedInstance().addUiOperation(new f(actionContext));
        return openUriIntent;
    }
}
