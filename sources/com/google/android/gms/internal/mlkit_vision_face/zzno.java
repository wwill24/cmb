package com.google.android.gms.internal.mlkit_vision_face;

final class zzno extends zzns {
    private String zza;
    private boolean zzb;
    private int zzc;
    private byte zzd;

    zzno() {
    }

    public final zzns zza(boolean z10) {
        this.zzb = true;
        this.zzd = (byte) (1 | this.zzd);
        return this;
    }

    public final zzns zzb(int i10) {
        this.zzc = 1;
        this.zzd = (byte) (this.zzd | 2);
        return this;
    }

    public final zzns zzc(String str) {
        this.zza = str;
        return this;
    }

    public final zznt zzd() {
        String str;
        if (this.zzd == 3 && (str = this.zza) != null) {
            return new zznq(str, this.zzb, this.zzc, (zznp) null);
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
