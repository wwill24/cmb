package com.facebook;

import com.facebook.FacebookSdk;
import java.util.concurrent.Callable;

public final /* synthetic */ class n implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FacebookSdk.InitializeCallback f37923a;

    public /* synthetic */ n(FacebookSdk.InitializeCallback initializeCallback) {
        this.f37923a = initializeCallback;
    }

    public final Object call() {
        return FacebookSdk.m26sdkInitialize$lambda9(this.f37923a);
    }
}
