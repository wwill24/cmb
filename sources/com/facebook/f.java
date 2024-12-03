package com.facebook;

import com.facebook.internal.FeatureManager;

public final /* synthetic */ class f implements FeatureManager.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f37822a;

    public /* synthetic */ f(String str) {
        this.f37822a = str;
    }

    public final void onCompleted(boolean z10) {
        FacebookException.m17_init_$lambda0(this.f37822a, z10);
    }
}
