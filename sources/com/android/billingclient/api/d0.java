package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzu;
import java.util.concurrent.Callable;

final class d0 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f8875a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ r f8876b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ f f8877c;

    d0(f fVar, String str, r rVar) {
        this.f8877c = fVar;
        this.f8875a = str;
        this.f8876b = rVar;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        b1 H = f.H(this.f8877c, this.f8875a);
        if (H.b() != null) {
            this.f8876b.a(H.a(), H.b());
            return null;
        }
        this.f8876b.a(H.a(), zzu.zzk());
        return null;
    }
}
