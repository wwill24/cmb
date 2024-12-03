package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.common.zzi;
import java.util.HashMap;
import java.util.concurrent.Executor;
import le.b;

final class s1 extends g {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final HashMap f39050f = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final Context f39051g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public volatile Handler f39052h;

    /* renamed from: i  reason: collision with root package name */
    private final r1 f39053i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final b f39054j;

    /* renamed from: k  reason: collision with root package name */
    private final long f39055k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final long f39056l;

    s1(Context context, Looper looper) {
        r1 r1Var = new r1(this, (q1) null);
        this.f39053i = r1Var;
        this.f39051g = context.getApplicationContext();
        this.f39052h = new zzi(looper, r1Var);
        this.f39054j = b.b();
        this.f39055k = 5000;
        this.f39056l = 300000;
    }

    /* access modifiers changed from: protected */
    public final void d(n1 n1Var, ServiceConnection serviceConnection, String str) {
        p.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f39050f) {
            p1 p1Var = (p1) this.f39050f.get(n1Var);
            if (p1Var == null) {
                String obj = n1Var.toString();
                throw new IllegalStateException("Nonexistent connection status for service config: " + obj);
            } else if (p1Var.h(serviceConnection)) {
                p1Var.f(serviceConnection, str);
                if (p1Var.i()) {
                    this.f39052h.sendMessageDelayed(this.f39052h.obtainMessage(0, n1Var), this.f39055k);
                }
            } else {
                String obj2 = n1Var.toString();
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + obj2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean f(n1 n1Var, ServiceConnection serviceConnection, String str, Executor executor) {
        boolean j10;
        p.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f39050f) {
            p1 p1Var = (p1) this.f39050f.get(n1Var);
            if (p1Var == null) {
                p1Var = new p1(this, n1Var);
                p1Var.d(serviceConnection, serviceConnection, str);
                p1Var.e(str, executor);
                this.f39050f.put(n1Var, p1Var);
            } else {
                this.f39052h.removeMessages(0, n1Var);
                if (!p1Var.h(serviceConnection)) {
                    p1Var.d(serviceConnection, serviceConnection, str);
                    int a10 = p1Var.a();
                    if (a10 == 1) {
                        serviceConnection.onServiceConnected(p1Var.b(), p1Var.c());
                    } else if (a10 == 2) {
                        p1Var.e(str, executor);
                    }
                } else {
                    String obj = n1Var.toString();
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + obj);
                }
            }
            j10 = p1Var.j();
        }
        return j10;
    }
}
