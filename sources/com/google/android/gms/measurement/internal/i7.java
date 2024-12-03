package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.List;
import we.d;

final class i7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f39937a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f39938b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzq f39939c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f39940d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzcf f39941e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ g8 f39942f;

    i7(g8 g8Var, String str, String str2, zzq zzq, boolean z10, zzcf zzcf) {
        this.f39942f = g8Var;
        this.f39937a = str;
        this.f39938b = str2;
        this.f39939c = zzq;
        this.f39940d = z10;
        this.f39941e = zzcf;
    }

    public final void run() {
        Throwable th2;
        Bundle bundle;
        RemoteException e10;
        Bundle bundle2 = new Bundle();
        try {
            g8 g8Var = this.f39942f;
            d H = g8Var.f39878d;
            if (H == null) {
                g8Var.f40059a.d().r().c("Failed to get user properties; not connected to service", this.f39937a, this.f39938b);
                this.f39942f.f40059a.N().G(this.f39941e, bundle2);
                return;
            }
            p.k(this.f39939c);
            List<zzlk> z10 = H.z(this.f39937a, this.f39938b, this.f39940d, this.f39939c);
            bundle = new Bundle();
            if (z10 != null) {
                for (zzlk zzlk : z10) {
                    String str = zzlk.f40503e;
                    if (str != null) {
                        bundle.putString(zzlk.f40500b, str);
                    } else {
                        Long l10 = zzlk.f40502d;
                        if (l10 != null) {
                            bundle.putLong(zzlk.f40500b, l10.longValue());
                        } else {
                            Double d10 = zzlk.f40505g;
                            if (d10 != null) {
                                bundle.putDouble(zzlk.f40500b, d10.doubleValue());
                            }
                        }
                    }
                }
            }
            try {
                this.f39942f.E();
                this.f39942f.f40059a.N().G(this.f39941e, bundle);
            } catch (RemoteException e11) {
                e10 = e11;
                try {
                    this.f39942f.f40059a.d().r().c("Failed to get user properties; remote exception", this.f39937a, e10);
                    this.f39942f.f40059a.N().G(this.f39941e, bundle);
                } catch (Throwable th3) {
                    th2 = th3;
                    bundle2 = bundle;
                    this.f39942f.f40059a.N().G(this.f39941e, bundle2);
                    throw th2;
                }
            }
        } catch (RemoteException e12) {
            bundle = bundle2;
            e10 = e12;
            this.f39942f.f40059a.d().r().c("Failed to get user properties; remote exception", this.f39937a, e10);
            this.f39942f.f40059a.N().G(this.f39941e, bundle);
        } catch (Throwable th4) {
            th2 = th4;
            this.f39942f.f40059a.N().G(this.f39941e, bundle2);
            throw th2;
        }
    }
}
