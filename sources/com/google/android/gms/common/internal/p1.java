package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import me.p;

final class p1 implements ServiceConnection, t1 {

    /* renamed from: a  reason: collision with root package name */
    private final Map f39034a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private int f39035b = 2;

    /* renamed from: c  reason: collision with root package name */
    private boolean f39036c;

    /* renamed from: d  reason: collision with root package name */
    private IBinder f39037d;

    /* renamed from: e  reason: collision with root package name */
    private final n1 f39038e;

    /* renamed from: f  reason: collision with root package name */
    private ComponentName f39039f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ s1 f39040g;

    public p1(s1 s1Var, n1 n1Var) {
        this.f39040g = s1Var;
        this.f39038e = n1Var;
    }

    public final int a() {
        return this.f39035b;
    }

    public final ComponentName b() {
        return this.f39039f;
    }

    public final IBinder c() {
        return this.f39037d;
    }

    public final void d(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f39034a.put(serviceConnection, serviceConnection2);
    }

    public final void e(String str, Executor executor) {
        this.f39035b = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (p.l()) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            s1 s1Var = this.f39040g;
            boolean d10 = s1Var.f39054j.d(s1Var.f39051g, str, this.f39038e.c(s1Var.f39051g), this, this.f39038e.a(), executor);
            this.f39036c = d10;
            if (d10) {
                this.f39040g.f39052h.sendMessageDelayed(this.f39040g.f39052h.obtainMessage(1, this.f39038e), this.f39040g.f39056l);
            } else {
                this.f39035b = 2;
                try {
                    s1 s1Var2 = this.f39040g;
                    s1Var2.f39054j.c(s1Var2.f39051g, this);
                } catch (IllegalArgumentException unused) {
                }
            }
        } finally {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.f39034a.remove(serviceConnection);
    }

    public final void g(String str) {
        this.f39040g.f39052h.removeMessages(1, this.f39038e);
        s1 s1Var = this.f39040g;
        s1Var.f39054j.c(s1Var.f39051g, this);
        this.f39036c = false;
        this.f39035b = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.f39034a.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.f39034a.isEmpty();
    }

    public final boolean j() {
        return this.f39036c;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f39040g.f39050f) {
            this.f39040g.f39052h.removeMessages(1, this.f39038e);
            this.f39037d = iBinder;
            this.f39039f = componentName;
            for (ServiceConnection onServiceConnected : this.f39034a.values()) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.f39035b = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f39040g.f39050f) {
            this.f39040g.f39052h.removeMessages(1, this.f39038e);
            this.f39037d = null;
            this.f39039f = componentName;
            for (ServiceConnection onServiceDisconnected : this.f39034a.values()) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.f39035b = 2;
        }
    }
}
