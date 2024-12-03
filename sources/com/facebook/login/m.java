package com.facebook.login;

import android.content.Intent;
import com.facebook.FacebookCallback;
import com.facebook.internal.CallbackManagerImpl;

public final /* synthetic */ class m implements CallbackManagerImpl.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LoginManager f37902a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FacebookCallback f37903b;

    public /* synthetic */ m(LoginManager loginManager, FacebookCallback facebookCallback) {
        this.f37902a = loginManager;
        this.f37903b = facebookCallback;
    }

    public final boolean onActivityResult(int i10, Intent intent) {
        return LoginManager.m163registerCallback$lambda0(this.f37902a, this.f37903b, i10, intent);
    }
}
