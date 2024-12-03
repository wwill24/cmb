package uh;

import android.content.DialogInterface;
import com.leanplum.ActionContext;
import com.leanplum.messagetemplates.actions.ConfirmMessage;

public final /* synthetic */ class c implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfirmMessage f24653a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActionContext f24654b;

    public /* synthetic */ c(ConfirmMessage confirmMessage, ActionContext actionContext) {
        this.f24653a = confirmMessage;
        this.f24654b = actionContext;
    }

    public final void onClick(DialogInterface dialogInterface, int i10) {
        this.f24653a.lambda$present$0(this.f24654b, dialogInterface, i10);
    }
}
