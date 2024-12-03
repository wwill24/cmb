package com.google.android.gms.internal.mlkit_vision_text_common;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.internal.u;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class zzoi {
    private final t zza;
    private final AtomicLong zzb = new AtomicLong(-1);

    zzoi(Context context, String str) {
        this.zza = s.b(context, u.a().b("mlkit:vision").a());
    }

    public static zzoi zza(Context context) {
        return new zzoi(context, "mlkit:vision");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(long j10, Exception exc) {
        this.zzb.set(j10);
    }

    public final synchronized void zzc(int i10, int i11, long j10, long j11) {
        synchronized (this) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.zzb.get() != -1) {
                if (elapsedRealtime - this.zzb.get() <= TimeUnit.MINUTES.toMillis(30)) {
                    return;
                }
            }
            this.zza.a(new TelemetryData(0, Arrays.asList(new MethodInvocation[]{new MethodInvocation(i10, i11, 0, j10, j11, (String) null, (String) null, 0)}))).addOnFailureListener(new zzoh(this, elapsedRealtime));
        }
    }
}
