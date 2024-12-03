package com.google.firebase.database.android;

import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.database.core.TokenProvider;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.concurrent.ExecutorService;

public final /* synthetic */ class e implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExecutorService f21037a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TokenProvider.TokenChangeListener f21038b;

    public /* synthetic */ e(ExecutorService executorService, TokenProvider.TokenChangeListener tokenChangeListener) {
        this.f21037a = executorService;
        this.f21038b = tokenChangeListener;
    }

    public final void handle(Provider provider) {
        ((InteropAppCheckTokenProvider) provider.get()).addAppCheckTokenListener(new f(this.f21037a, this.f21038b));
    }
}
