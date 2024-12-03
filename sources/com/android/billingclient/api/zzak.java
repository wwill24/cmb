package com.android.billingclient.api;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zzb;

final class zzak extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f9054a;

    public final void onReceiveResult(int i10, Bundle bundle) {
        this.f9054a.a(zzb.zze(bundle, "BillingClient"));
    }
}
