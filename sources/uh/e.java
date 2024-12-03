package uh;

import android.content.DialogInterface;
import com.leanplum.ActionContext;
import com.leanplum.messagetemplates.actions.InterstitialMessage;

public final /* synthetic */ class e implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterstitialMessage f24657a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActionContext f24658b;

    public /* synthetic */ e(InterstitialMessage interstitialMessage, ActionContext actionContext) {
        this.f24657a = interstitialMessage;
        this.f24658b = actionContext;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.f24657a.lambda$present$0(this.f24658b, dialogInterface);
    }
}
