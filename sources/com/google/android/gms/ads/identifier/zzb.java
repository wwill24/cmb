package com.google.android.gms.ads.identifier;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class zzb extends Thread {
    final CountDownLatch zza = new CountDownLatch(1);
    boolean zzb = false;
    private final WeakReference<AdvertisingIdClient> zzc;
    private final long zzd;

    public zzb(AdvertisingIdClient advertisingIdClient, long j10) {
        this.zzc = new WeakReference<>(advertisingIdClient);
        this.zzd = j10;
        start();
    }

    private final void zza() {
        AdvertisingIdClient advertisingIdClient = this.zzc.get();
        if (advertisingIdClient != null) {
            advertisingIdClient.zza();
            this.zzb = true;
        }
    }

    public final void run() {
        try {
            if (!this.zza.await(this.zzd, TimeUnit.MILLISECONDS)) {
                zza();
            }
        } catch (InterruptedException unused) {
            zza();
        }
    }
}
