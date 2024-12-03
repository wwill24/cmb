package com.facebook.internal;

import android.content.DialogInterface;

public final /* synthetic */ class s implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebDialog f37869a;

    public /* synthetic */ s(WebDialog webDialog) {
        this.f37869a = webDialog;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        WebDialog.m130onCreate$lambda4(this.f37869a, dialogInterface);
    }
}
