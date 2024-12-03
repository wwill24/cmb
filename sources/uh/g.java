package uh;

import android.content.DialogInterface;
import com.leanplum.ActionContext;
import com.leanplum.messagetemplates.actions.RichHtmlMessage;

public final /* synthetic */ class g implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RichHtmlMessage f24660a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActionContext f24661b;

    public /* synthetic */ g(RichHtmlMessage richHtmlMessage, ActionContext actionContext) {
        this.f24660a = richHtmlMessage;
        this.f24661b = actionContext;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.f24660a.lambda$present$0(this.f24661b, dialogInterface);
    }
}
