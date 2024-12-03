package com.google.firebase.database.android;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class j implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAuthTokenProvider f21047a;

    public /* synthetic */ j(AndroidAuthTokenProvider androidAuthTokenProvider) {
        this.f21047a = androidAuthTokenProvider;
    }

    public final void handle(Provider provider) {
        this.f21047a.lambda$new$0(provider);
    }
}
