package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;
import org.jivesoftware.smack.sm.packet.StreamManagement;

public final class zzbz extends zzce {
    private final AtomicReference zza = new AtomicReference();
    private boolean zzb;

    public static final Object zzf(Bundle bundle, Class cls) {
        Object obj;
        if (bundle == null || (obj = bundle.get(StreamManagement.AckRequest.ELEMENT)) == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e10) {
            String.format("Unexpected object type. Expected, Received: %s, %s", new Object[]{cls.getCanonicalName(), obj.getClass().getCanonicalName()});
            throw e10;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:5|6|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zzb(long r3) {
        /*
            r2 = this;
            java.util.concurrent.atomic.AtomicReference r0 = r2.zza
            monitor-enter(r0)
            boolean r1 = r2.zzb     // Catch:{ all -> 0x001a }
            if (r1 != 0) goto L_0x0010
            java.util.concurrent.atomic.AtomicReference r1 = r2.zza     // Catch:{ InterruptedException -> 0x000d }
            r1.wait(r3)     // Catch:{ InterruptedException -> 0x000d }
            goto L_0x0010
        L_0x000d:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            r3 = 0
            return r3
        L_0x0010:
            java.util.concurrent.atomic.AtomicReference r3 = r2.zza     // Catch:{ all -> 0x001a }
            java.lang.Object r3 = r3.get()     // Catch:{ all -> 0x001a }
            android.os.Bundle r3 = (android.os.Bundle) r3     // Catch:{ all -> 0x001a }
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            return r3
        L_0x001a:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbz.zzb(long):android.os.Bundle");
    }

    public final Long zzc(long j10) {
        return (Long) zzf(zzb(j10), Long.class);
    }

    public final String zzd(long j10) {
        return (String) zzf(zzb(j10), String.class);
    }

    public final void zze(Bundle bundle) {
        synchronized (this.zza) {
            try {
                this.zza.set(bundle);
                this.zzb = true;
                this.zza.notify();
            } catch (Throwable th2) {
                this.zza.notify();
                throw th2;
            }
        }
    }
}
