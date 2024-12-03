package com.facebook.share.internal;

import android.content.Intent;
import com.facebook.FacebookCallback;
import com.facebook.internal.CallbackManagerImpl;

public final /* synthetic */ class b implements CallbackManagerImpl.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f37930a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FacebookCallback f37931b;

    public /* synthetic */ b(int i10, FacebookCallback facebookCallback) {
        this.f37930a = i10;
        this.f37931b = facebookCallback;
    }

    public final boolean onActivityResult(int i10, Intent intent) {
        return ShareInternalUtility.m177registerSharerCallback$lambda1(this.f37930a, this.f37931b, i10, intent);
    }
}
