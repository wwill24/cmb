package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.internal.p;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

public final class zzro implements zzra {
    private final zznf zza;
    private zzpx zzb = new zzpx();
    private final int zzc;

    private zzro(zznf zznf, int i10) {
        this.zza = zznf;
        zzrx.zza();
        this.zzc = i10;
    }

    public static zzra zzf(zznf zznf) {
        return new zzro(zznf, 0);
    }

    public static zzra zzg(zznf zznf, int i10) {
        return new zzro(zznf, 1);
    }

    public final int zza() {
        return this.zzc;
    }

    public final zzra zzb(zzne zzne) {
        this.zza.zzf(zzne);
        return this;
    }

    public final zzra zzc(zzpx zzpx) {
        this.zzb = zzpx;
        return this;
    }

    public final String zzd() {
        zzpz zzf = this.zza.zzj().zzf();
        if (zzf == null || zzar.zzb(zzf.zzk())) {
            return "NA";
        }
        return (String) p.k(zzf.zzk());
    }

    public final byte[] zze(int i10, boolean z10) {
        boolean z11;
        int i11 = i10 ^ 1;
        zzpx zzpx = this.zzb;
        if (1 != i11) {
            z11 = false;
        } else {
            z11 = true;
        }
        zzpx.zzf(Boolean.valueOf(z11));
        this.zzb.zze(Boolean.FALSE);
        this.zza.zzi(this.zzb.zzm());
        try {
            zzrx.zza();
            if (i10 == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzlh.zza).ignoreNullValues(true).build().encode(this.zza.zzj()).getBytes("utf-8");
            }
            zznh zzj = this.zza.zzj();
            zzdo zzdo = new zzdo();
            zzlh.zza.configure(zzdo);
            return zzdo.zza().zza(zzj);
        } catch (UnsupportedEncodingException e10) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e10);
        }
    }
}
