package com.google.firebase.database.android;

import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.database.core.TokenProvider;
import com.google.firebase.internal.InternalTokenResult;
import java.util.concurrent.ExecutorService;

public final /* synthetic */ class g implements IdTokenListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExecutorService f21041a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TokenProvider.TokenChangeListener f21042b;

    public /* synthetic */ g(ExecutorService executorService, TokenProvider.TokenChangeListener tokenChangeListener) {
        this.f21041a = executorService;
        this.f21042b = tokenChangeListener;
    }

    public final void onIdTokenChanged(InternalTokenResult internalTokenResult) {
        this.f21041a.execute(new h(this.f21042b, internalTokenResult));
    }
}
