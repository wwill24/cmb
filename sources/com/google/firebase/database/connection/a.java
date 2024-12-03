package com.google.firebase.database.connection;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PersistentConnectionImpl f21050a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f21051b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f21052c;

    public /* synthetic */ a(PersistentConnectionImpl persistentConnectionImpl, boolean z10, boolean z11) {
        this.f21050a = persistentConnectionImpl;
        this.f21051b = z10;
        this.f21052c = z11;
    }

    public final void run() {
        this.f21050a.lambda$tryScheduleReconnect$3(this.f21051b, this.f21052c);
    }
}
