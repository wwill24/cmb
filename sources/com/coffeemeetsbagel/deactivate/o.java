package com.coffeemeetsbagel.deactivate;

import android.content.DialogInterface;
import android.view.KeyEvent;

public final /* synthetic */ class o implements DialogInterface.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeactivateCompRouter f12027a;

    public /* synthetic */ o(DeactivateCompRouter deactivateCompRouter) {
        this.f12027a = deactivateCompRouter;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        return DeactivateCompRouter.x(this.f12027a, dialogInterface, i10, keyEvent);
    }
}
