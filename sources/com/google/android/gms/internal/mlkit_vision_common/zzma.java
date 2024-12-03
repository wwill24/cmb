package com.google.android.gms.internal.mlkit_vision_common;

final class zzma extends zzme {
    private final String zza;
    private final boolean zzb;
    private final int zzc;

    /* synthetic */ zzma(String str, boolean z10, int i10, zzlz zzlz) {
        this.zza = str;
        this.zzb = z10;
        this.zzc = i10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzme) {
            zzme zzme = (zzme) obj;
            if (this.zza.equals(zzme.zzb()) && this.zzb == zzme.zzc() && this.zzc == zzme.zza()) {
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
