package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;

public final class g1 extends s0 {

    /* renamed from: g  reason: collision with root package name */
    public final IBinder f39002g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ d f39003h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g1(d dVar, int i10, IBinder iBinder, Bundle bundle) {
        super(dVar, i10, bundle);
        this.f39003h = dVar;
        this.f39002g = iBinder;
    }

    /* access modifiers changed from: protected */
    public final void f(ConnectionResult connectionResult) {
        if (this.f39003h.zzx != null) {
            this.f39003h.zzx.g(connectionResult);
        }
        this.f39003h.onConnectionFailed(connectionResult);
    }

    /* access modifiers changed from: protected */
    public final boolean g() {
        try {
            IBinder iBinder = this.f39002g;
            p.k(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.f39003h.getServiceDescriptor().equals(interfaceDescriptor)) {
                String serviceDescriptor = this.f39003h.getServiceDescriptor();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("service descriptor mismatch: ");
                sb2.append(serviceDescriptor);
                sb2.append(" vs. ");
                sb2.append(interfaceDescriptor);
                return false;
            }
            IInterface createServiceInterface = this.f39003h.createServiceInterface(this.f39002g);
            if (createServiceInterface == null) {
                return false;
            }
            if (!d.zzn(this.f39003h, 2, 4, createServiceInterface) && !d.zzn(this.f39003h, 3, 4, createServiceInterface)) {
                return false;
            }
            this.f39003h.zzB = null;
            Bundle connectionHint = this.f39003h.getConnectionHint();
            d dVar = this.f39003h;
            if (dVar.zzw != null) {
                dVar.zzw.c(connectionHint);
            }
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }
}
