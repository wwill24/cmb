package com.android.billingclient.api;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.android.billingclient.api.i;
import com.google.android.gms.internal.play_billing.zzb;

final class zzah extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f9053a;

    public final void onReceiveResult(int i10, Bundle bundle) {
        i.a c10 = i.c();
        c10.c(i10);
        c10.b(zzb.zzf(bundle, "BillingClient"));
        this.f9053a.a(c10.a());
    }
}
