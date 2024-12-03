package uh;

import android.content.DialogInterface;
import com.leanplum.ActionContext;
import com.leanplum.messagetemplates.actions.AlertMessage;

public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AlertMessage f24649a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActionContext f24650b;

    public /* synthetic */ a(AlertMessage alertMessage, ActionContext actionContext) {
        this.f24649a = alertMessage;
        this.f24650b = actionContext;
    }

    public final void onClick(DialogInterface dialogInterface, int i10) {
        this.f24649a.lambda$present$0(this.f24650b, dialogInterface, i10);
    }
}
