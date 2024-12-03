package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.p;
import le.b;

public final class f8 implements ServiceConnection, d.a, d.b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f39794a;

    /* renamed from: b  reason: collision with root package name */
    private volatile m3 f39795b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ g8 f39796c;

    protected f8(g8 g8Var) {
        this.f39796c = g8Var;
    }

    public final void b(Intent intent) {
        this.f39796c.h();
        Context c10 = this.f39796c.f40059a.c();
        b b10 = b.b();
        synchronized (this) {
            if (this.f39794a) {
                this.f39796c.f40059a.d().v().a("Connection attempt already in progress");
                return;
            }
            this.f39796c.f40059a.d().v().a("Using local app measurement service");
            this.f39794a = true;
            b10.a(c10, intent, this.f39796c.f39877c, 129);
        }
    }

    public final void c(Bundle bundle) {
        p.f("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                p.k(this.f39795b);
                this.f39796c.f40059a.f().z(new c8(this, (we.d) this.f39795b.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f39795b = null;
                this.f39794a = false;
            }
        }
    }

    public final void d() {
        this.f39796c.h();
        Context c10 = this.f39796c.f40059a.c();
        synchronized (this) {
            if (this.f39794a) {
                this.f39796c.f40059a.d().v().a("Connection attempt already in progress");
            } else if (this.f39795b == null || (!this.f39795b.isConnecting() && !this.f39795b.isConnected())) {
                this.f39795b = new m3(c10, Looper.getMainLooper(), this, this);
                this.f39796c.f40059a.d().v().a("Connecting to remote service");
                this.f39794a = true;
                p.k(this.f39795b);
                this.f39795b.checkAvailabilityAndConnect();
            } else {
                this.f39796c.f40059a.d().v().a("Already awaiting connection attempt");
            }
        }
    }

    public final void e() {
        if (this.f39795b != null && (this.f39795b.isConnected() || this.f39795b.isConnecting())) {
            this.f39795b.disconnect();
        }
        this.f39795b = null;
    }

    public final void f(int i10) {
        p.f("MeasurementServiceConnection.onConnectionSuspended");
        this.f39796c.f40059a.d().q().a("Service connection suspended");
        this.f39796c.f40059a.f().z(new d8(this));
    }

    public final void g(@NonNull ConnectionResult connectionResult) {
        p.f("MeasurementServiceConnection.onConnectionFailed");
        q3 E = this.f39796c.f40059a.E();
        if (E != null) {
            E.w().b("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.f39794a = false;
            this.f39795b = null;
        }
        this.f39796c.f40059a.f().z(new e8(this));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r3.f39796c.f40059a.d().r().a("Service connect failed to get IMeasurementService");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0065 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
        /*
            r3 = this;
            java.lang.String r4 = "MeasurementServiceConnection.onServiceConnected"
            com.google.android.gms.common.internal.p.f(r4)
            monitor-enter(r3)
            r4 = 0
            if (r5 != 0) goto L_0x001e
            r3.f39794a = r4     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.g8 r4 = r3.f39796c     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.u4 r4 = r4.f40059a     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.q3 r4 = r4.d()     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.o3 r4 = r4.r()     // Catch:{ all -> 0x0063 }
            java.lang.String r5 = "Service connected with null binder"
            r4.a(r5)     // Catch:{ all -> 0x0063 }
            monitor-exit(r3)     // Catch:{ all -> 0x0063 }
            return
        L_0x001e:
            r0 = 0
            java.lang.String r1 = r5.getInterfaceDescriptor()     // Catch:{ RemoteException -> 0x0065 }
            java.lang.String r2 = "com.google.android.gms.measurement.internal.IMeasurementService"
            boolean r2 = r2.equals(r1)     // Catch:{ RemoteException -> 0x0065 }
            if (r2 == 0) goto L_0x0051
            java.lang.String r1 = "com.google.android.gms.measurement.internal.IMeasurementService"
            android.os.IInterface r1 = r5.queryLocalInterface(r1)     // Catch:{ RemoteException -> 0x0065 }
            boolean r2 = r1 instanceof we.d     // Catch:{ RemoteException -> 0x0065 }
            if (r2 == 0) goto L_0x0039
            we.d r1 = (we.d) r1     // Catch:{ RemoteException -> 0x0065 }
        L_0x0037:
            r0 = r1
            goto L_0x003f
        L_0x0039:
            com.google.android.gms.measurement.internal.h3 r1 = new com.google.android.gms.measurement.internal.h3     // Catch:{ RemoteException -> 0x0065 }
            r1.<init>(r5)     // Catch:{ RemoteException -> 0x0065 }
            goto L_0x0037
        L_0x003f:
            com.google.android.gms.measurement.internal.g8 r5 = r3.f39796c     // Catch:{ RemoteException -> 0x0065 }
            com.google.android.gms.measurement.internal.u4 r5 = r5.f40059a     // Catch:{ RemoteException -> 0x0065 }
            com.google.android.gms.measurement.internal.q3 r5 = r5.d()     // Catch:{ RemoteException -> 0x0065 }
            com.google.android.gms.measurement.internal.o3 r5 = r5.v()     // Catch:{ RemoteException -> 0x0065 }
            java.lang.String r1 = "Bound to IMeasurementService interface"
            r5.a(r1)     // Catch:{ RemoteException -> 0x0065 }
            goto L_0x0076
        L_0x0051:
            com.google.android.gms.measurement.internal.g8 r5 = r3.f39796c     // Catch:{ RemoteException -> 0x0065 }
            com.google.android.gms.measurement.internal.u4 r5 = r5.f40059a     // Catch:{ RemoteException -> 0x0065 }
            com.google.android.gms.measurement.internal.q3 r5 = r5.d()     // Catch:{ RemoteException -> 0x0065 }
            com.google.android.gms.measurement.internal.o3 r5 = r5.r()     // Catch:{ RemoteException -> 0x0065 }
            java.lang.String r2 = "Got binder with a wrong descriptor"
            r5.b(r2, r1)     // Catch:{ RemoteException -> 0x0065 }
            goto L_0x0076
        L_0x0063:
            r4 = move-exception
            goto L_0x00a2
        L_0x0065:
            com.google.android.gms.measurement.internal.g8 r5 = r3.f39796c     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.u4 r5 = r5.f40059a     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.q3 r5 = r5.d()     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.o3 r5 = r5.r()     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = "Service connect failed to get IMeasurementService"
            r5.a(r1)     // Catch:{ all -> 0x0063 }
        L_0x0076:
            if (r0 != 0) goto L_0x0090
            r3.f39794a = r4     // Catch:{ all -> 0x0063 }
            le.b r4 = le.b.b()     // Catch:{ IllegalArgumentException -> 0x00a0 }
            com.google.android.gms.measurement.internal.g8 r5 = r3.f39796c     // Catch:{ IllegalArgumentException -> 0x00a0 }
            com.google.android.gms.measurement.internal.u4 r5 = r5.f40059a     // Catch:{ IllegalArgumentException -> 0x00a0 }
            android.content.Context r5 = r5.c()     // Catch:{ IllegalArgumentException -> 0x00a0 }
            com.google.android.gms.measurement.internal.g8 r0 = r3.f39796c     // Catch:{ IllegalArgumentException -> 0x00a0 }
            com.google.android.gms.measurement.internal.f8 r0 = r0.f39877c     // Catch:{ IllegalArgumentException -> 0x00a0 }
            r4.c(r5, r0)     // Catch:{ IllegalArgumentException -> 0x00a0 }
            goto L_0x00a0
        L_0x0090:
            com.google.android.gms.measurement.internal.g8 r4 = r3.f39796c     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.u4 r4 = r4.f40059a     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.s4 r4 = r4.f()     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.a8 r5 = new com.google.android.gms.measurement.internal.a8     // Catch:{ all -> 0x0063 }
            r5.<init>(r3, r0)     // Catch:{ all -> 0x0063 }
            r4.z(r5)     // Catch:{ all -> 0x0063 }
        L_0x00a0:
            monitor-exit(r3)     // Catch:{ all -> 0x0063 }
            return
        L_0x00a2:
            monitor-exit(r3)     // Catch:{ all -> 0x0063 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f8.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        p.f("MeasurementServiceConnection.onServiceDisconnected");
        this.f39796c.f40059a.d().q().a("Service disconnected");
        this.f39796c.f40059a.f().z(new b8(this, componentName));
    }
}
