package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzb;
import java.util.concurrent.Future;

public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Future f8863a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f8864b;

    public /* synthetic */ b0(Future future, Runnable runnable) {
        this.f8863a = future;
        this.f8864b = runnable;
    }

    public final void run() {
        Future future = this.f8863a;
        Runnable runnable = this.f8864b;
        if (!future.isDone() && !future.isCancelled()) {
            future.cancel(true);
            zzb.zzj("BillingClient", "Async task is taking too long, cancel it!");
            if (runnable != null) {
                runnable.run();
            }
        }
    }
}
