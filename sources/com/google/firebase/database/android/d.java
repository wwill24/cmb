package com.google.firebase.database.android;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class d implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAppCheckTokenProvider f21036a;

    public /* synthetic */ d(AndroidAppCheckTokenProvider androidAppCheckTokenProvider) {
        this.f21036a = androidAppCheckTokenProvider;
    }

    public final void handle(Provider provider) {
        this.f21036a.lambda$new$0(provider);
    }
}
