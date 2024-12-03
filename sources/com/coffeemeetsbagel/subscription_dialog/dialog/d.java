package com.coffeemeetsbagel.subscription_dialog.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;

public final class d extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private final View f37052a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Context context, View view) {
        super(context);
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(view, "subscriptionDialogView");
        this.f37052a = view;
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
            window.setBackgroundDrawableResource(17170445);
        }
        setContentView(view);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewParent parent = this.f37052a.getParent();
        j.e(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).removeView(this.f37052a);
    }
}
