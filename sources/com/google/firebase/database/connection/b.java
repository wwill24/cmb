package com.google.firebase.database.connection;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class b implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PersistentConnectionImpl f21053a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f21054b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Task f21055c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Task f21056d;

    public /* synthetic */ b(PersistentConnectionImpl persistentConnectionImpl, long j10, Task task, Task task2) {
        this.f21053a = persistentConnectionImpl;
        this.f21054b = j10;
        this.f21055c = task;
        this.f21056d = task2;
    }

    public final void onSuccess(Object obj) {
        this.f21053a.lambda$tryScheduleReconnect$1(this.f21054b, this.f21055c, this.f21056d, (Void) obj);
    }
}
