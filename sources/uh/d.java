package uh;

import android.content.DialogInterface;
import com.leanplum.ActionContext;
import com.leanplum.messagetemplates.actions.ConfirmMessage;

public final /* synthetic */ class d implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfirmMessage f24655a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActionContext f24656b;

    public /* synthetic */ d(ConfirmMessage confirmMessage, ActionContext actionContext) {
        this.f24655a = confirmMessage;
        this.f24656b = actionContext;
    }

    public final void onClick(DialogInterface dialogInterface, int i10) {
        this.f24655a.lambda$present$1(this.f24656b, dialogInterface, i10);
    }
}
