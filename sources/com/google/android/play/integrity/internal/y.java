package com.google.android.play.integrity.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class y implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z f20528a;

    /* synthetic */ y(z zVar, x xVar) {
        this.f20528a = zVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f20528a.f20531b.d("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        z zVar = this.f20528a;
        zVar.c().post(new u(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f20528a.f20531b.d("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        z zVar = this.f20528a;
        zVar.c().post(new v(this));
    }
}
