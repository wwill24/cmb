package com.google.android.gms.internal.play_billing;

import java.io.IOException;

final class zzdj implements zzdp {
    private final zzdf zza;
    private final zzeg zzb;
    private final boolean zzc;
    private final zzbo zzd;

    private zzdj(zzeg zzeg, zzbo zzbo, zzdf zzdf) {
        this.zzb = zzeg;
        this.zzc = zzbo.zzc(zzdf);
        this.zzd = zzbo;
        this.zza = zzdf;
    }

    static zzdj zzc(zzeg zzeg, zzbo zzbo, zzdf zzdf) {
        return new zzdj(zzeg, zzbo, zzdf);
    }

    public final int zza(Object obj) {
        zzeg zzeg = this.zzb;
        int zzb2 = zzeg.zzb(zzeg.zzd(obj));
        if (!this.zzc) {
            return zzb2;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzd(obj).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final Object zze() {
        zzdf zzdf = this.zza;
        if (zzdf instanceof zzcb) {
            return ((zzcb) zzdf).zzh();
        }
        return zzdf.zzj().zze();
    }

    public final void zzf(Object obj) {
        this.zzb.zzg(obj);
        this.zzd.zzb(obj);
    }

    public final void zzg(Object obj, Object obj2) {
        zzdr.zzC(this.zzb, obj, obj2);
        if (this.zzc) {
            this.zzd.zza(obj2);
            throw null;
        }
    }

    public final void zzh(Object obj, byte[] bArr, int i10, int i11, zzan zzan) throws IOException {
        zzcb zzcb = (zzcb) obj;
        if (zzcb.zzc == zzeh.zzc()) {
            zzcb.zzc = zzeh.zzf();
        }
        zzby zzby = (zzby) obj;
        throw null;
    }

    public final void zzi(Object obj, zzey zzey) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }

    public final boolean zzj(Object obj, Object obj2) {
        if (!this.zzb.zzd(obj).equals(this.zzb.zzd(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(obj);
        this.zzd.zza(obj2);
        throw null;
    }

    public final boolean zzk(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }
}
