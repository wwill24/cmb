package com.google.firebase.database.core;

import com.google.firebase.database.connection.ConnectionTokenProvider;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConnectionTokenProvider.GetTokenCallback f21064a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f21065b;

    public /* synthetic */ b(ConnectionTokenProvider.GetTokenCallback getTokenCallback, String str) {
        this.f21064a = getTokenCallback;
        this.f21065b = str;
    }

    public final void run() {
        this.f21064a.onError(this.f21065b);
    }
}
