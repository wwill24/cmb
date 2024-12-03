package com.facebook.login;

import com.facebook.login.LoginClient;

public final /* synthetic */ class j implements LoginClient.OnCompletedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LoginFragment f37898a;

    public /* synthetic */ j(LoginFragment loginFragment) {
        this.f37898a = loginFragment;
    }

    public final void onCompleted(LoginClient.Result result) {
        LoginFragment.m160onCreate$lambda0(this.f37898a, result);
    }
}
