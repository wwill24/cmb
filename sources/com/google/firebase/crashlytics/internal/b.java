package com.google.firebase.crashlytics.internal;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class b implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f21008a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f21009b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f21010c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ StaticSessionData f21011d;

    public /* synthetic */ b(String str, String str2, long j10, StaticSessionData staticSessionData) {
        this.f21008a = str;
        this.f21009b = str2;
        this.f21010c = j10;
        this.f21011d = staticSessionData;
    }

    public final void handle(Provider provider) {
        ((CrashlyticsNativeComponent) provider.get()).prepareNativeSession(this.f21008a, this.f21009b, this.f21010c, this.f21011d);
    }
}
