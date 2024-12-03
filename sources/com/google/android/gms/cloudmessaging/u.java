package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.cloudmessaging.zze;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import ne.b;

public final class u {

    /* renamed from: e  reason: collision with root package name */
    private static u f38468e;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f38469a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ScheduledExecutorService f38470b;

    /* renamed from: c  reason: collision with root package name */
    private p f38471c = new p(this, (o) null);

    /* renamed from: d  reason: collision with root package name */
    private int f38472d = 1;

    u(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f38470b = scheduledExecutorService;
        this.f38469a = context.getApplicationContext();
    }

    public static synchronized u b(Context context) {
        u uVar;
        synchronized (u.class) {
            if (f38468e == null) {
                zze.zza();
                f38468e = new u(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new b("MessengerIpcClient"))));
            }
            uVar = f38468e;
        }
        return uVar;
    }

    private final synchronized int f() {
        int i10;
        i10 = this.f38472d;
        this.f38472d = i10 + 1;
        return i10;
    }

    private final synchronized <T> Task<T> g(s<T> sVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(sVar);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 9);
            sb2.append("Queueing ");
            sb2.append(valueOf);
        }
        if (!this.f38471c.g(sVar)) {
            p pVar = new p(this, (o) null);
            this.f38471c = pVar;
            pVar.g(sVar);
        }
        return sVar.f38465b.getTask();
    }

    public final Task<Void> c(int i10, Bundle bundle) {
        return g(new r(f(), 2, bundle));
    }

    public final Task<Bundle> d(int i10, Bundle bundle) {
        return g(new t(f(), 1, bundle));
    }
}
