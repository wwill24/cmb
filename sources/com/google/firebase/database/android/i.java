package com.google.firebase.database.android;

import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.database.core.TokenProvider;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.concurrent.ExecutorService;

public final /* synthetic */ class i implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExecutorService f21045a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TokenProvider.TokenChangeListener f21046b;

    public /* synthetic */ i(ExecutorService executorService, TokenProvider.TokenChangeListener tokenChangeListener) {
        this.f21045a = executorService;
        this.f21046b = tokenChangeListener;
    }

    public final void handle(Provider provider) {
        ((InternalAuthProvider) provider.get()).addIdTokenListener(new g(this.f21045a, this.f21046b));
    }
}
