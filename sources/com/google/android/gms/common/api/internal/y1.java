package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import me.b;

final class y1 implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    private final g f38821a;

    /* renamed from: b  reason: collision with root package name */
    private final int f38822b;

    /* renamed from: c  reason: collision with root package name */
    private final b f38823c;

    /* renamed from: d  reason: collision with root package name */
    private final long f38824d;

    /* renamed from: e  reason: collision with root package name */
    private final long f38825e;

    y1(g gVar, int i10, b bVar, long j10, long j11, String str, String str2) {
        this.f38821a = gVar;
        this.f38822b = i10;
        this.f38823c = bVar;
        this.f38824d = j10;
        this.f38825e = j11;
    }

    static y1 a(g gVar, int i10, b bVar) {
        boolean z10;
        long j10;
        long j11;
        if (!gVar.g()) {
            return null;
        }
        RootTelemetryConfiguration a10 = q.b().a();
        if (a10 == null) {
            z10 = true;
        } else if (!a10.c0()) {
            return null;
        } else {
            z10 = a10.f0();
            l1 x10 = gVar.x(bVar);
            if (x10 != null) {
                if (!(x10.v() instanceof d)) {
                    return null;
                }
                d dVar = (d) x10.v();
                if (dVar.hasConnectionInfo() && !dVar.isConnecting()) {
                    ConnectionTelemetryConfiguration b10 = b(x10, dVar, i10);
                    if (b10 == null) {
                        return null;
                    }
                    x10.G();
                    z10 = b10.i0();
                }
            }
        }
        if (z10) {
            j10 = System.currentTimeMillis();
        } else {
            j10 = 0;
        }
        if (z10) {
            j11 = SystemClock.elapsedRealtime();
        } else {
            j11 = 0;
        }
        return new y1(gVar, i10, bVar, j10, j11, (String) null, (String) null);
    }

    private static ConnectionTelemetryConfiguration b(l1 l1Var, d dVar, int i10) {
        int[] Y;
        int[] c02;
        ConnectionTelemetryConfiguration telemetryConfiguration = dVar.getTelemetryConfiguration();
        if (telemetryConfiguration == null || !telemetryConfiguration.f0() || ((Y = telemetryConfiguration.Y()) != null ? !b.a(Y, i10) : !((c02 = telemetryConfiguration.c0()) == null || !b.a(c02, i10))) || l1Var.s() >= telemetryConfiguration.S()) {
            return null;
        }
        return telemetryConfiguration;
    }

    public final void onComplete(@NonNull Task task) {
        l1 x10;
        boolean z10;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        long j10;
        long j11;
        int i15;
        if (this.f38821a.g()) {
            RootTelemetryConfiguration a10 = q.b().a();
            if ((a10 == null || a10.c0()) && (x10 = this.f38821a.x(this.f38823c)) != null && (x10.v() instanceof d)) {
                d dVar = (d) x10.v();
                boolean z11 = true;
                int i16 = 0;
                if (this.f38824d > 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                int gCoreServiceId = dVar.getGCoreServiceId();
                if (a10 != null) {
                    boolean f02 = z10 & a10.f0();
                    int S = a10.S();
                    int Y = a10.Y();
                    i12 = a10.i0();
                    if (dVar.hasConnectionInfo() && !dVar.isConnecting()) {
                        ConnectionTelemetryConfiguration b10 = b(x10, dVar, this.f38822b);
                        if (b10 != null) {
                            if (!b10.i0() || this.f38824d <= 0) {
                                z11 = false;
                            }
                            Y = b10.S();
                            f02 = z11;
                        } else {
                            return;
                        }
                    }
                    i11 = S;
                    i10 = Y;
                } else {
                    i12 = 0;
                    i10 = 100;
                    i11 = 5000;
                }
                g gVar = this.f38821a;
                if (task.isSuccessful()) {
                    i13 = 0;
                } else {
                    if (task.isCanceled()) {
                        i16 = 100;
                    } else {
                        Exception exception = task.getException();
                        if (exception instanceof ApiException) {
                            Status status = ((ApiException) exception).getStatus();
                            int Y2 = status.Y();
                            ConnectionResult S2 = status.S();
                            if (S2 == null) {
                                i15 = -1;
                            } else {
                                i15 = S2.S();
                            }
                            i13 = i15;
                            i16 = Y2;
                        } else {
                            i16 = 101;
                        }
                    }
                    i13 = -1;
                }
                if (z10) {
                    long j12 = this.f38824d;
                    long currentTimeMillis = System.currentTimeMillis();
                    i14 = (int) (SystemClock.elapsedRealtime() - this.f38825e);
                    j11 = j12;
                    j10 = currentTimeMillis;
                } else {
                    j11 = 0;
                    j10 = 0;
                    i14 = -1;
                }
                gVar.J(new MethodInvocation(this.f38822b, i16, i13, j11, j10, (String) null, (String) null, gCoreServiceId, i14), i12, (long) i11, i10);
            }
        }
    }
}
