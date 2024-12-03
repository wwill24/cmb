package com.facebook.login;

import android.content.DialogInterface;
import com.facebook.login.DeviceAuthDialog;
import java.util.Date;

public final /* synthetic */ class c implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceAuthDialog f37885a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f37886b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DeviceAuthDialog.PermissionsLists f37887c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f37888d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Date f37889e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Date f37890f;

    public /* synthetic */ c(DeviceAuthDialog deviceAuthDialog, String str, DeviceAuthDialog.PermissionsLists permissionsLists, String str2, Date date, Date date2) {
        this.f37885a = deviceAuthDialog;
        this.f37886b = str;
        this.f37887c = permissionsLists;
        this.f37888d = str2;
        this.f37889e = date;
        this.f37890f = date2;
    }

    public final void onClick(DialogInterface dialogInterface, int i10) {
        DeviceAuthDialog.m155presentConfirmation$lambda6(this.f37885a, this.f37886b, this.f37887c, this.f37888d, this.f37889e, this.f37890f, dialogInterface, i10);
    }
}
