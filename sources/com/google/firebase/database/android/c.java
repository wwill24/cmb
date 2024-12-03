package com.google.firebase.database.android;

import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.database.core.TokenProvider;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TokenProvider.TokenChangeListener f21034a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppCheckTokenResult f21035b;

    public /* synthetic */ c(TokenProvider.TokenChangeListener tokenChangeListener, AppCheckTokenResult appCheckTokenResult) {
        this.f21034a = tokenChangeListener;
        this.f21035b = appCheckTokenResult;
    }

    public final void run() {
        this.f21034a.onTokenChange(this.f21035b.getToken());
    }
}
