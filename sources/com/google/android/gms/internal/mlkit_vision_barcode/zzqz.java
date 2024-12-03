package com.google.android.gms.internal.mlkit_vision_barcode;

final class zzqz extends zzrd {
    private final String zza;
    private final boolean zzb;
    private final int zzc;

    /* synthetic */ zzqz(String str, boolean z10, int i10, zzqy zzqy) {
        this.zza = str;
        this.zzb = z10;
        this.zzc = i10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzrd) {
            zzrd zzrd = (zzrd) obj;
            if (this.zza.equals(zzrd.zzb()) && this.zzb == zzrd.zzc() && this.zzc == zzrd.zza()) {
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
