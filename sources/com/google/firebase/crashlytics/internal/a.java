package com.google.firebase.crashlytics.internal;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class a implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CrashlyticsNativeComponentDeferredProxy f21007a;

    public /* synthetic */ a(CrashlyticsNativeComponentDeferredProxy crashlyticsNativeComponentDeferredProxy) {
        this.f21007a = crashlyticsNativeComponentDeferredProxy;
    }

    public final void handle(Provider provider) {
        this.f21007a.lambda$new$0(provider);
    }
}
