package com.facebook.login;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;

public final /* synthetic */ class o implements CallbackManagerImpl.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LoginManager f37908a;

    public /* synthetic */ o(LoginManager loginManager) {
        this.f37908a = loginManager;
    }

    public final boolean onActivityResult(int i10, Intent intent) {
        return LoginManager.m165startLogin$lambda1(this.f37908a, i10, intent);
    }
}
