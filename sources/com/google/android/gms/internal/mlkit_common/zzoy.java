package com.google.android.gms.internal.mlkit_common;

final class zzoy extends zzpg {
    private String zza;
    private boolean zzb;
    private int zzc;
    private byte zzd;

    zzoy() {
    }

    public final zzpg zza(boolean z10) {
        this.zzb = true;
        this.zzd = (byte) (1 | this.zzd);
        return this;
    }

    public final zzpg zzb(int i10) {
        this.zzc = 1;
        this.zzd = (byte) (this.zzd | 2);
        return this;
    }

    public final zzpg zzc(String str) {
        this.zza = "common";
        return this;
    }

    public final zzph zzd() {
        String str;
        if (this.zzd == 3 && (str = this.zza) != null) {
            return new zzpa(str, this.zzb, this.zzc, (zzoz) null);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.zza == null) {
            sb2.append(" libraryName");
        }
        if ((this.zzd & 1) == 0) {
            sb2.append(" enableFirelog");
        }
        if ((this.zzd & 2) == 0) {
            sb2.append(" firelogEventType");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb2.toString()));
    }
}
