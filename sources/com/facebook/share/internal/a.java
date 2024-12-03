package com.facebook.share.internal;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;

public final /* synthetic */ class a implements CallbackManagerImpl.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f37929a;

    public /* synthetic */ a(int i10) {
        this.f37929a = i10;
    }

    public final boolean onActivityResult(int i10, Intent intent) {
        return ShareInternalUtility.m178registerStaticShareCallback$lambda0(this.f37929a, i10, intent);
    }
}
