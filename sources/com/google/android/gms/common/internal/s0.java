package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

abstract class s0 extends d1 {

    /* renamed from: d  reason: collision with root package name */
    public final int f39047d;

    /* renamed from: e  reason: collision with root package name */
    public final Bundle f39048e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ d f39049f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected s0(d dVar, int i10, Bundle bundle) {
        super(dVar, Boolean.TRUE);
        this.f39049f = dVar;
        this.f39047d = i10;
        this.f39048e = bundle;
    }

    /* JADX WARNING: type inference failed for: r3v5, types: [android.os.Parcelable] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ void a(java.lang.Object r3) {
        /*
            r2 = this;
            int r3 = r2.f39047d
            r0 = 1
            r1 = 0
            if (r3 != 0) goto L_0x001c
            boolean r3 = r2.g()
            if (r3 != 0) goto L_0x001b
            com.google.android.gms.common.internal.d r3 = r2.f39049f
            r3.zzp(r0, (android.os.IInterface) null)
            com.google.android.gms.common.ConnectionResult r3 = new com.google.android.gms.common.ConnectionResult
            r0 = 8
            r3.<init>(r0, r1)
            r2.f(r3)
        L_0x001b:
            return
        L_0x001c:
            com.google.android.gms.common.internal.d r3 = r2.f39049f
            r3.zzp(r0, (android.os.IInterface) null)
            android.os.Bundle r3 = r2.f39048e
            if (r3 == 0) goto L_0x002e
            java.lang.String r0 = "pendingIntent"
            android.os.Parcelable r3 = r3.getParcelable(r0)
            r1 = r3
            android.app.PendingIntent r1 = (android.app.PendingIntent) r1
        L_0x002e:
            com.google.android.gms.common.ConnectionResult r3 = new com.google.android.gms.common.ConnectionResult
            int r0 = r2.f39047d
            r3.<init>(r0, r1)
            r2.f(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.s0.a(java.lang.Object):void");
    }

    /* access modifiers changed from: protected */
    public final void b() {
    }

    /* access modifiers changed from: protected */
    public abstract void f(ConnectionResult connectionResult);

    /* access modifiers changed from: protected */
    public abstract boolean g();
}
