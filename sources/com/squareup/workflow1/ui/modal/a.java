package com.squareup.workflow1.ui.modal;

import android.content.DialogInterface;

public final /* synthetic */ class a implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AlertScreen f23282a;

    public /* synthetic */ a(AlertScreen alertScreen) {
        this.f23282a = alertScreen;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        AlertContainer.i(this.f23282a, dialogInterface);
    }
}
