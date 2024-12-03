package com.coffeemeetsbagel.deactivate;

import android.content.DialogInterface;

public final /* synthetic */ class p implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeactivateCompRouter f12028a;

    public /* synthetic */ p(DeactivateCompRouter deactivateCompRouter) {
        this.f12028a = deactivateCompRouter;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        DeactivateCompRouter.y(this.f12028a, dialogInterface);
    }
}
