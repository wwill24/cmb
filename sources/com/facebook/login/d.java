package com.facebook.login;

import android.content.DialogInterface;

public final /* synthetic */ class d implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceAuthDialog f37891a;

    public /* synthetic */ d(DeviceAuthDialog deviceAuthDialog) {
        this.f37891a = deviceAuthDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i10) {
        DeviceAuthDialog.m156presentConfirmation$lambda8(this.f37891a, dialogInterface, i10);
    }
}
