package com.google.firebase.database.connection;

import com.google.firebase.database.connection.PersistentConnectionImpl;
import java.util.Map;

public final /* synthetic */ class e implements PersistentConnectionImpl.ConnectionRequestCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PersistentConnectionImpl f21060a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f21061b;

    public /* synthetic */ e(PersistentConnectionImpl persistentConnectionImpl, boolean z10) {
        this.f21060a = persistentConnectionImpl;
        this.f21061b = z10;
    }

    public final void onResponse(Map map) {
        this.f21060a.lambda$sendAppCheckTokenHelper$4(this.f21061b, map);
    }
}
