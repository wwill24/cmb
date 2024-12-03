package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.common.internal.p;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

public final class zzmk implements zzmb {
    private final zziw zza;
    private zzky zzb = new zzky();

    private zzmk(zziw zziw, int i10) {
        this.zza = zziw;
        zzmw.zza();
    }

    public static zzmb zze(zziw zziw) {
        return new zzmk(zziw, 0);
    }

    public final zzmb zza(zziv zziv) {
        this.zza.zzc(zziv);
        return this;
    }

    public final zzmb zzb(zzky zzky) {
        this.zzb = zzky;
        return this;
    }

    public final String zzc() {
        zzla zzc = this.zza.zzf().zzc();
        if (zzc == null || zzg.zzb(zzc.zzk())) {
            return "NA";
        }
        return (String) p.k(zzc.zzk());
    }

    public final byte[] zzd(int i10, boolean z10) {
        boolean z11;
        int i11 = i10 ^ 1;
        zzky zzky = this.zzb;
        if (1 != i11) {
            z11 = false;
        } else {
            z11 = true;
        }
        zzky.zzf(Boolean.valueOf(z11));
        this.zzb.zze(Boolean.FALSE);
        this.zza.zze(this.zzb.zzm());
        try {
            zzmw.zza();
            if (i10 == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzhe.zza).ignoreNullValues(true).build().encode(this.zza.zzf()).getBytes("utf-8");
            }
            zziy zzf = this.zza.zzf();
            zzam zzam = new zzam();
            zzhe.zza.configure(zzam);
            return zzam.zza().zza(zzf);
        } catch (UnsupportedEncodingException e10) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e10);
        }
    }
}
