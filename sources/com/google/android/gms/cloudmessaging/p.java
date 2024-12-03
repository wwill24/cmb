package com.google.android.gms.cloudmessaging;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.internal.cloudmessaging.zzf;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import le.b;

final class p implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    int f38456a = 0;

    /* renamed from: b  reason: collision with root package name */
    final Messenger f38457b = new Messenger(new zzf(Looper.getMainLooper(), new i(this)));

    /* renamed from: c  reason: collision with root package name */
    q f38458c;

    /* renamed from: d  reason: collision with root package name */
    final Queue<s<?>> f38459d = new ArrayDeque();

    /* renamed from: e  reason: collision with root package name */
    final SparseArray<s<?>> f38460e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ u f38461f;

    /* synthetic */ p(u uVar, o oVar) {
        this.f38461f = uVar;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(int i10, String str) {
        b(i10, str, (Throwable) null);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void b(int i10, String str, Throwable th2) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Disconnected: ".concat(valueOf);
            }
        }
        int i11 = this.f38456a;
        if (i11 == 0) {
            throw new IllegalStateException();
        } else if (i11 == 1 || i11 == 2) {
            boolean isLoggable = Log.isLoggable("MessengerIpcClient", 2);
            this.f38456a = 4;
            b.b().c(this.f38461f.f38469a, this);
            zzq zzq = new zzq(i10, str, th2);
            for (s<?> c10 : this.f38459d) {
                c10.c(zzq);
            }
            this.f38459d.clear();
            for (int i12 = 0; i12 < this.f38460e.size(); i12++) {
                this.f38460e.valueAt(i12).c(zzq);
            }
            this.f38460e.clear();
        } else if (i11 == 3) {
            this.f38456a = 4;
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        this.f38461f.f38470b.execute(new k(this));
    }

    /* access modifiers changed from: package-private */
    public final synchronized void d() {
        if (this.f38456a == 1) {
            a(1, "Timed out while binding");
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void e(int i10) {
        s sVar = this.f38460e.get(i10);
        if (sVar != null) {
            StringBuilder sb2 = new StringBuilder(31);
            sb2.append("Timing out request: ");
            sb2.append(i10);
            this.f38460e.remove(i10);
            sVar.c(new zzq(3, "Timed out waiting for response", (Throwable) null));
            f();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void f() {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r2.f38456a     // Catch:{ all -> 0x0030 }
            r1 = 2
            if (r0 != r1) goto L_0x002e
            java.util.Queue<com.google.android.gms.cloudmessaging.s<?>> r0 = r2.f38459d     // Catch:{ all -> 0x0030 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x002e
            android.util.SparseArray<com.google.android.gms.cloudmessaging.s<?>> r0 = r2.f38460e     // Catch:{ all -> 0x0030 }
            int r0 = r0.size()     // Catch:{ all -> 0x0030 }
            if (r0 != 0) goto L_0x002e
            java.lang.String r0 = "MessengerIpcClient"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x0030 }
            r0 = 3
            r2.f38456a = r0     // Catch:{ all -> 0x0030 }
            le.b r0 = le.b.b()     // Catch:{ all -> 0x0030 }
            com.google.android.gms.cloudmessaging.u r1 = r2.f38461f     // Catch:{ all -> 0x0030 }
            android.content.Context r1 = r1.f38469a     // Catch:{ all -> 0x0030 }
            r0.c(r1, r2)     // Catch:{ all -> 0x0030 }
            monitor-exit(r2)
            return
        L_0x002e:
            monitor-exit(r2)
            return
        L_0x0030:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cloudmessaging.p.f():void");
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean g(s<?> sVar) {
        boolean z10;
        int i10 = this.f38456a;
        if (i10 == 0) {
            this.f38459d.add(sVar);
            if (this.f38456a == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            com.google.android.gms.common.internal.p.o(z10);
            boolean isLoggable = Log.isLoggable("MessengerIpcClient", 2);
            this.f38456a = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            try {
                if (!b.b().a(this.f38461f.f38469a, intent, this, 1)) {
                    a(0, "Unable to bind to service");
                } else {
                    this.f38461f.f38470b.schedule(new l(this), 30, TimeUnit.SECONDS);
                }
            } catch (SecurityException e10) {
                b(0, "Unable to bind to service", e10);
            }
        } else if (i10 == 1) {
            this.f38459d.add(sVar);
            return true;
        } else if (i10 != 2) {
            return false;
        } else {
            this.f38459d.add(sVar);
            c();
            return true;
        }
        return true;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.isLoggable("MessengerIpcClient", 2);
        this.f38461f.f38470b.execute(new m(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        Log.isLoggable("MessengerIpcClient", 2);
        this.f38461f.f38470b.execute(new j(this));
    }
}
