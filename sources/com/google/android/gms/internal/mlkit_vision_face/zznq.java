package com.google.android.gms.internal.mlkit_vision_face;

final class zznq extends zznt {
    private final String zza;
    private final boolean zzb;
    private final int zzc;

    /* synthetic */ zznq(String str, boolean z10, int i10, zznp zznp) {
        this.zza = str;
        this.zzb = z10;
        this.zzc = i10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zznt) {
            zznt zznt = (zznt) obj;
            if (this.zza.equals(zznt.zzb()) && this.zzb == zznt.zzc() && this.zzc == zznt.zza()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() ^ 1000003) * 1000003) ^ (true != this.zzb ? 1237 : 1231)) * 1000003) ^ this.zzc;
    }

    public final String toString() {
        String str = this.zza;
        boolean z10 = this.zzb;
        int i10 = this.zzc;
        return "MLKitLoggingOptions{libraryName=" + str + ", enableFirelog=" + z10 + ", firelogEventType=" + i10 + "}";
    }

    public final int zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zza;
    }

    public final boolean zzc() {
        return this.zzb;
    }
}
