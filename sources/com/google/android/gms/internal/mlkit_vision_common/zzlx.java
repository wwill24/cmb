package com.google.android.gms.internal.mlkit_vision_common;

import android.os.SystemClock;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class zzlx implements Closeable {
    private static final Map zza = new HashMap();
    private final String zzb;
    private int zzc;
    private double zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private long zzh;

    private zzlx(String str) {
        this.zzg = 2147483647L;
        this.zzh = -2147483648L;
        this.zzb = str;
    }

    private final void zza() {
        this.zzc = 0;
        this.zzd = 0.0d;
        this.zze = 0;
        this.zzg = 2147483647L;
        this.zzh = -2147483648L;
    }

    public static zzlx zze(String str) {
        zzmw.zza();
        if (!zzmw.zzb()) {
            return zzlv.zza;
        }
        Map map = zza;
        if (map.get("detectorTaskWithResource#run") == null) {
            map.put("detectorTaskWithResource#run", new zzlx("detectorTaskWithResource#run"));
        }
        return (zzlx) map.get("detectorTaskWithResource#run");
    }

    public void close() {
        long j10 = this.zze;
        if (j10 != 0) {
            zzd(j10);
            return;
        }
        throw new IllegalStateException("Did you forget to call start()?");
    }

    public zzlx zzb() {
        this.zze = SystemClock.elapsedRealtimeNanos() / 1000;
        return this;
    }

    public void zzc(long j10) {
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
        long j11 = this.zzf;
        if (j11 != 0 && elapsedRealtimeNanos - j11 >= 1000000) {
            zza();
        }
        this.zzf = elapsedRealtimeNanos;
        this.zzc++;
        this.zzd += (double) j10;
        this.zzg = Math.min(this.zzg, j10);
        this.zzh = Math.max(this.zzh, j10);
        if (this.zzc % 50 == 0) {
            String.format(Locale.US, "[%s] cur=%dus, counts=%d, min=%dus, max=%dus, avg=%dus", new Object[]{this.zzb, Long.valueOf(j10), Integer.valueOf(this.zzc), Long.valueOf(this.zzg), Long.valueOf(this.zzh), Integer.valueOf((int) (this.zzd / ((double) this.zzc)))});
            zzmw.zza();
        }
        if (this.zzc % 500 == 0) {
            zza();
        }
    }

    public void zzd(long j10) {
        zzc((SystemClock.elapsedRealtimeNanos() / 1000) - j10);
    }
}
