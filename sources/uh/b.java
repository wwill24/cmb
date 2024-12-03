package uh;

import android.content.DialogInterface;
import com.leanplum.ActionContext;
import com.leanplum.messagetemplates.actions.CenterPopupMessage;

public final /* synthetic */ class b implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CenterPopupMessage f24651a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActionContext f24652b;

    public /* synthetic */ b(CenterPopupMessage centerPopupMessage, ActionContext actionContext) {
        this.f24651a = centerPopupMessage;
        this.f24652b = actionContext;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.f24651a.lambda$present$0(this.f24652b, dialogInterface);
    }
}
