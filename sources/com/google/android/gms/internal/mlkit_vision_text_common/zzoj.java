package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.android.gms.common.internal.p;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

public final class zzoj implements zznv {
    private final zzku zza;
    private zzmw zzb = new zzmw();
    private final int zzc;

    private zzoj(zzku zzku, int i10) {
        this.zza = zzku;
        zzos.zza();
        this.zzc = i10;
    }

    public static zznv zzf(zzku zzku) {
        return new zzoj(zzku, 0);
    }

    public static zznv zzg(zzku zzku, int i10) {
        return new zzoj(zzku, 1);
    }

    public final int zza() {
        return this.zzc;
    }

    public final zznv zzb(zzkt zzkt) {
        this.zza.zzf(zzkt);
        return this;
    }

    public final zznv zzc(zzmw zzmw) {
        this.zzb = zzmw;
        return this;
    }

    public final String zzd() {
        zzmy zzf = this.zza.zzj().zzf();
        if (zzf == null || zzab.zzb(zzf.zzk())) {
            return "NA";
        }
        return (String) p.k(zzf.zzk());
    }

    public final byte[] zze(int i10, boolean z10) {
        boolean z11;
        zzmw zzmw = this.zzb;
        if (1 != (i10 ^ 1)) {
            z11 = false;
        } else {
            z11 = true;
        }
        zzmw.zzf(Boolean.valueOf(z11));
        this.zzb.zze(Boolean.FALSE);
        this.zza.zzi(this.zzb.zzm());
        try {
            zzos.zza();
            if (i10 == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzjd.zza).ignoreNullValues(true).build().encode(this.zza.zzj()).getBytes("utf-8");
            }
            zzkw zzj = this.zza.zzj();
            zzdd zzdd = new zzdd();
            zzjd.zza.configure(zzdd);
            return zzdd.zza().zza(zzj);
        } catch (UnsupportedEncodingException e10) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e10);
        }
    }
}
