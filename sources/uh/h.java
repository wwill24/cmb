package uh;

import android.content.DialogInterface;
import com.leanplum.ActionContext;
import com.leanplum.messagetemplates.actions.WebInterstitialMessage;

public final /* synthetic */ class h implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebInterstitialMessage f24662a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActionContext f24663b;

    public /* synthetic */ h(WebInterstitialMessage webInterstitialMessage, ActionContext actionContext) {
        this.f24662a = webInterstitialMessage;
        this.f24663b = actionContext;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.f24662a.lambda$present$0(this.f24663b, dialogInterface);
    }
}
