package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.internal.p;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

public final class zzof implements zznr {
    private final zzku zza;
    private zzmt zzb = new zzmt();
    private final int zzc;

    private zzof(zzku zzku, int i10) {
        this.zza = zzku;
        zzoo.zza();
        this.zzc = i10;
    }

    public static zznr zzf(zzku zzku) {
        return new zzof(zzku, 0);
    }

    public static zznr zzg(zzku zzku, int i10) {
        return new zzof(zzku, 1);
    }

    public final int zza() {
        return this.zzc;
    }

    public final zznr zzb(zzkt zzkt) {
        this.zza.zzf(zzkt);
        return this;
    }

    public final zznr zzc(zzmt zzmt) {
        this.zzb = zzmt;
        return this;
    }

    public final String zzd() {
        zzmv zzf = this.zza.zzj().zzf();
        if (zzf == null || zzac.zzb(zzf.zzk())) {
            return "NA";
        }
        return (String) p.k(zzf.zzk());
    }

    public final byte[] zze(int i10, boolean z10) {
        boolean z11;
        zzmt zzmt = this.zzb;
        if (1 != (i10 ^ 1)) {
            z11 = false;
        } else {
            z11 = true;
        }
        zzmt.zzf(Boolean.valueOf(z11));
        this.zzb.zze(Boolean.FALSE);
        this.zza.zzi(this.zzb.zzm());
        try {
            zzoo.zza();
            if (i10 == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzix.zza).ignoreNullValues(true).build().encode(this.zza.zzj()).getBytes("utf-8");
            }
            zzkw zzj = this.zza.zzj();
            zzcy zzcy = new zzcy();
            zzix.zza.configure(zzcy);
            return zzcy.zza().zza(zzj);
        } catch (UnsupportedEncodingException e10) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e10);
        }
    }
}
