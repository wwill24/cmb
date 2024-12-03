package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.d;
import com.google.android.gms.internal.base.zau;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class i0 implements Handler.Callback {
    @NotOnlyInitialized

    /* renamed from: a  reason: collision with root package name */
    private final h0 f39007a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList f39008b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    final ArrayList f39009c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList f39010d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f39011e = false;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicInteger f39012f = new AtomicInteger(0);

    /* renamed from: g  reason: collision with root package name */
    private boolean f39013g = false;

    /* renamed from: h  reason: collision with root package name */
    private final Handler f39014h;

    /* renamed from: i  reason: collision with root package name */
    private final Object f39015i = new Object();

    public i0(Looper looper, h0 h0Var) {
        this.f39007a = h0Var;
        this.f39014h = new zau(looper, this);
    }

    public final void a() {
        this.f39011e = false;
        this.f39012f.incrementAndGet();
    }

    public final void b() {
        this.f39011e = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(com.google.android.gms.common.ConnectionResult r6) {
        /*
            r5 = this;
            android.os.Handler r0 = r5.f39014h
            java.lang.String r1 = "onConnectionFailure must only be called on the Handler thread"
            com.google.android.gms.common.internal.p.e(r0, r1)
            android.os.Handler r0 = r5.f39014h
            r1 = 1
            r0.removeMessages(r1)
            java.lang.Object r0 = r5.f39015i
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x004a }
            java.util.ArrayList r2 = r5.f39010d     // Catch:{ all -> 0x004a }
            r1.<init>(r2)     // Catch:{ all -> 0x004a }
            java.util.concurrent.atomic.AtomicInteger r2 = r5.f39012f     // Catch:{ all -> 0x004a }
            int r2 = r2.get()     // Catch:{ all -> 0x004a }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x004a }
        L_0x0021:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x004a }
            if (r3 == 0) goto L_0x0048
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x004a }
            com.google.android.gms.common.api.d$c r3 = (com.google.android.gms.common.api.d.c) r3     // Catch:{ all -> 0x004a }
            boolean r4 = r5.f39011e     // Catch:{ all -> 0x004a }
            if (r4 == 0) goto L_0x0046
            java.util.concurrent.atomic.AtomicInteger r4 = r5.f39012f     // Catch:{ all -> 0x004a }
            int r4 = r4.get()     // Catch:{ all -> 0x004a }
            if (r4 == r2) goto L_0x003a
            goto L_0x0046
        L_0x003a:
            java.util.ArrayList r4 = r5.f39010d     // Catch:{ all -> 0x004a }
            boolean r4 = r4.contains(r3)     // Catch:{ all -> 0x004a }
            if (r4 == 0) goto L_0x0021
            r3.g(r6)     // Catch:{ all -> 0x004a }
            goto L_0x0021
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return
        L_0x0048:
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return
        L_0x004a:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.i0.c(com.google.android.gms.common.ConnectionResult):void");
    }

    public final void d(Bundle bundle) {
        p.e(this.f39014h, "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.f39015i) {
            p.o(!this.f39013g);
            this.f39014h.removeMessages(1);
            this.f39013g = true;
            p.o(this.f39009c.isEmpty());
            ArrayList arrayList = new ArrayList(this.f39008b);
            int i10 = this.f39012f.get();
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d.b bVar = (d.b) it.next();
                if (!this.f39011e || !this.f39007a.isConnected()) {
                    break;
                } else if (this.f39012f.get() != i10) {
                    break;
                } else if (!this.f39009c.contains(bVar)) {
                    bVar.c(bundle);
                }
            }
            this.f39009c.clear();
            this.f39013g = false;
        }
    }

    public final void e(int i10) {
        p.e(this.f39014h, "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f39014h.removeMessages(1);
        synchronized (this.f39015i) {
            this.f39013g = true;
            ArrayList arrayList = new ArrayList(this.f39008b);
            int i11 = this.f39012f.get();
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d.b bVar = (d.b) it.next();
                if (!this.f39011e) {
                    break;
                } else if (this.f39012f.get() != i11) {
                    break;
                } else if (this.f39008b.contains(bVar)) {
                    bVar.f(i10);
                }
            }
            this.f39009c.clear();
            this.f39013g = false;
        }
    }

    public final void f(d.b bVar) {
        p.k(bVar);
        synchronized (this.f39015i) {
            if (this.f39008b.contains(bVar)) {
                String valueOf = String.valueOf(bVar);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("registerConnectionCallbacks(): listener ");
                sb2.append(valueOf);
                sb2.append(" is already registered");
            } else {
                this.f39008b.add(bVar);
            }
        }
        if (this.f39007a.isConnected()) {
            Handler handler = this.f39014h;
            handler.sendMessage(handler.obtainMessage(1, bVar));
        }
    }

    public final void g(d.c cVar) {
        p.k(cVar);
        synchronized (this.f39015i) {
            if (this.f39010d.contains(cVar)) {
                String valueOf = String.valueOf(cVar);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("registerConnectionFailedListener(): listener ");
                sb2.append(valueOf);
                sb2.append(" is already registered");
            } else {
                this.f39010d.add(cVar);
            }
        }
    }

    public final void h(d.c cVar) {
        p.k(cVar);
        synchronized (this.f39015i) {
            if (!this.f39010d.remove(cVar)) {
                String valueOf = String.valueOf(cVar);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("unregisterConnectionFailedListener(): listener ");
                sb2.append(valueOf);
                sb2.append(" not found");
            }
        }
    }

    public final boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            d.b bVar = (d.b) message.obj;
            synchronized (this.f39015i) {
                if (this.f39011e && this.f39007a.isConnected() && this.f39008b.contains(bVar)) {
                    bVar.c((Bundle) null);
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle message: " + i10, new Exception());
        return false;
    }
}
