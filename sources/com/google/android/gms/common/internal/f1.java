package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

public final class f1 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final int f38994a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d f38995b;

    public f1(d dVar, int i10) {
        this.f38995b = dVar;
        this.f38994a = i10;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        l lVar;
        d dVar = this.f38995b;
        if (iBinder == null) {
            d.zzk(dVar, 16);
            return;
        }
        synchronized (dVar.zzq) {
            d dVar2 = this.f38995b;
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof l)) {
                lVar = new u0(iBinder);
            } else {
                lVar = (l) queryLocalInterface;
            }
            dVar2.zzr = lVar;
        }
        this.f38995b.zzl(0, (Bundle) null, this.f38994a);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f38995b.zzq) {
            this.f38995b.zzr = null;
        }
        Handler handler = this.f38995b.zzb;
        handler.sendMessage(handler.obtainMessage(6, this.f38994a, 1));
    }
}
