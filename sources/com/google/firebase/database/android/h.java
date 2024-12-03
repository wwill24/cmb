package com.google.firebase.database.android;

import com.google.firebase.database.core.TokenProvider;
import com.google.firebase.internal.InternalTokenResult;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TokenProvider.TokenChangeListener f21043a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InternalTokenResult f21044b;

    public /* synthetic */ h(TokenProvider.TokenChangeListener tokenChangeListener, InternalTokenResult internalTokenResult) {
        this.f21043a = tokenChangeListener;
        this.f21044b = internalTokenResult;
    }

    public final void run() {
        this.f21043a.onTokenChange(this.f21044b.getToken());
    }
}
