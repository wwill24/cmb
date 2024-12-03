package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.zzbq;
import com.google.android.gms.internal.measurement.zzbr;

public final class g4 implements ServiceConnection {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f39857a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ h4 f39858b;

    g4(h4 h4Var, String str) {
        this.f39858b = h4Var;
        this.f39857a = str;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder != null) {
            try {
                zzbr zzb = zzbq.zzb(iBinder);
                if (zzb == null) {
                    this.f39858b.f39891a.d().w().a("Install Referrer Service implementation was not found");
                    return;
                }
                this.f39858b.f39891a.d().v().a("Install Referrer Service connected");
                this.f39858b.f39891a.f().z(new f4(this, zzb, this));
            } catch (RuntimeException e10) {
                this.f39858b.f39891a.d().w().b("Exception occurred while calling Install Referrer API", e10);
            }
        } else {
            this.f39858b.f39891a.d().w().a("Install Referrer connection returned with null binder");
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f39858b.f39891a.d().v().a("Install Referrer Service disconnected");
    }
}
