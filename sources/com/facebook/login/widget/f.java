package com.facebook.login.widget;

import android.content.DialogInterface;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;

public final /* synthetic */ class f implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LoginManager f37918a;

    public /* synthetic */ f(LoginManager loginManager) {
        this.f37918a = loginManager;
    }

    public final void onClick(DialogInterface dialogInterface, int i10) {
        LoginButton.LoginClickListener.m172performLogout$lambda2(this.f37918a, dialogInterface, i10);
    }
}
