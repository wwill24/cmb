package com.google.firebase.database.connection;

import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class c implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PersistentConnectionImpl f21057a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f21058b;

    public /* synthetic */ c(PersistentConnectionImpl persistentConnectionImpl, long j10) {
        this.f21057a = persistentConnectionImpl;
        this.f21058b = j10;
    }

    public final void onFailure(Exception exc) {
        this.f21057a.lambda$tryScheduleReconnect$2(this.f21058b, exc);
    }
}
