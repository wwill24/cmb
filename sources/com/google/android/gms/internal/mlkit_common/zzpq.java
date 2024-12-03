package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.common.internal.p;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

public final class zzpq implements zzpe {
    private final zzle zza;
    private zznz zzb = new zznz();

    private zzpq(zzle zzle, int i10) {
        this.zza = zzle;
        zzqb.zza();
    }

    public static zzpe zzf(zzle zzle) {
        return new zzpq(zzle, 0);
    }

    public static zzpe zzg() {
        return new zzpq(new zzle(), 0);
    }

    public final zzpe zza(zzld zzld) {
        this.zza.zzf(zzld);
        return this;
    }

    public final zzpe zzb(zzlk zzlk) {
        this.zza.zzi(zzlk);
        return this;
    }

    public final zzpe zzc(zznz zznz) {
        this.zzb = zznz;
        return this;
    }

    public final String zzd() {
        zzob zzf = this.zza.zzk().zzf();
        if (zzf == null || zzag.zzc(zzf.zzk())) {
            return "NA";
        }
        return (String) p.k(zzf.zzk());
    }

    public final byte[] zze(int i10, boolean z10) {
        boolean z11;
        int i11 = i10 ^ 1;
        zznz zznz = this.zzb;
        if (1 != i11) {
            z11 = false;
        } else {
            z11 = true;
        }
        zznz.zzf(Boolean.valueOf(z11));
        this.zzb.zze(Boolean.FALSE);
        this.zza.zzj(this.zzb.zzm());
        try {
            zzqb.zza();
            if (i10 == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzjh.zza).ignoreNullValues(true).build().encode(this.zza.zzk()).getBytes("utf-8");
            }
            zzlg zzk = this.zza.zzk();
            zzbs zzbs = new zzbs();
            zzjh.zza.configure(zzbs);
            return zzbs.zza().zza(zzk);
        } catch (UnsupportedEncodingException e10) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e10);
        }
    }
}
