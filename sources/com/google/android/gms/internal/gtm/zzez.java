package com.google.android.gms.internal.gtm;

import me.f;

public final class zzez {
    private double zza = 60.0d;
    private long zzb;
    private final Object zzc = new Object();
    private final String zzd = "tracking";
    private final f zze;

    public zzez(int i10, long j10, String str, f fVar) {
        this.zze = fVar;
    }

    public final boolean zza() {
        synchronized (this.zzc) {
            long currentTimeMillis = this.zze.currentTimeMillis();
            double d10 = this.zza;
            if (d10 < 60.0d) {
                double d11 = ((double) (currentTimeMillis - this.zzb)) / 2000.0d;
                if (d11 > 0.0d) {
                    d10 = Math.min(60.0d, d10 + d11);
                    this.zza = d10;
                }
            }
            this.zzb = currentTimeMillis;
            if (d10 >= 1.0d) {
                this.zza = d10 - 4.0d;
                return true;
            }
            String str = this.zzd;
            StringBuilder sb2 = new StringBuilder(str.length() + 34);
            sb2.append("Excessive ");
            sb2.append(str);
            sb2.append(" detected; call ignored.");
            zzfa.zze(sb2.toString());
            return false;
        }
    }
}
