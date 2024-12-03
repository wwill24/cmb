package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzcf;
import we.d;

final class r7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzau f40224a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f40225b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzcf f40226c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ g8 f40227d;

    r7(g8 g8Var, zzau zzau, String str, zzcf zzcf) {
        this.f40227d = g8Var;
        this.f40224a = zzau;
        this.f40225b = str;
        this.f40226c = zzcf;
    }

    public final void run() {
        u4 u4Var;
        byte[] bArr = null;
        try {
            g8 g8Var = this.f40227d;
            d H = g8Var.f39878d;
            if (H == null) {
                g8Var.f40059a.d().r().a("Discarding data. Failed to send event to service to bundle");
                u4Var = this.f40227d.f40059a;
            } else {
                bArr = H.r0(this.f40224a, this.f40225b);
                this.f40227d.E();
                u4Var = this.f40227d.f40059a;
            }
        } catch (RemoteException e10) {
            this.f40227d.f40059a.d().r().b("Failed to send event to the service to bundle", e10);
            u4Var = this.f40227d.f40059a;
        } catch (Throwable th2) {
            this.f40227d.f40059a.N().H(this.f40226c, bArr);
            throw th2;
        }
        u4Var.N().H(this.f40226c, bArr);
    }
}
