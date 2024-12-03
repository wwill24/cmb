package com.google.android.gms.internal.p002authapi;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.f;
import vd.a;

/* renamed from: com.google.android.gms.internal.auth-api.zbo  reason: invalid package */
public final class zbo extends f {
    private final a.C0509a zba;

    public zbo(Context context, Looper looper, e eVar, a.C0509a aVar, d.b bVar, d.c cVar) {
        super(context, looper, 68, eVar, bVar, cVar);
        a.C0509a.C0510a aVar2 = new a.C0509a.C0510a(aVar == null ? a.C0509a.f42088d : aVar);
        aVar2.a(zbbb.zba());
        this.zba = new a.C0509a(aVar2);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        if (queryLocalInterface instanceof zbt) {
            return (zbt) queryLocalInterface;
        }
        return new zbt(iBinder);
    }

    /* access modifiers changed from: protected */
    public final Bundle getGetServiceRequestExtraArgs() {
        return this.zba.a();
    }

    public final int getMinApkVersion() {
        return 12800000;
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    /* access modifiers changed from: package-private */
    public final a.C0509a zba() {
        return this.zba;
    }
}
