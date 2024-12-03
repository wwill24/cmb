package com.google.firebase.database.core;

import com.google.firebase.database.connection.ConnectionTokenProvider;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConnectionTokenProvider.GetTokenCallback f21066a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f21067b;

    public /* synthetic */ c(ConnectionTokenProvider.GetTokenCallback getTokenCallback, String str) {
        this.f21066a = getTokenCallback;
        this.f21067b = str;
    }

    public final void run() {
        this.f21066a.onSuccess(this.f21067b);
    }
}
