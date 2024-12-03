package com.squareup.workflow1.ui.modal;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;

public final /* synthetic */ class f implements DialogInterface.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f23287a;

    public /* synthetic */ f(View view) {
        this.f23287a = view;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        return ModalViewContainer.f(this.f23287a, dialogInterface, i10, keyEvent);
    }
}
