package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Arrays;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public final class zzv {
    private final String zza;
    private final zzu zzb;
    private zzu zzc;

    /* synthetic */ zzv(String str, zzs zzs) {
        zzu zzu = new zzu((zzs) null);
        this.zzb = zzu;
        this.zzc = zzu;
        this.zza = str;
    }

    private final zzv zze(String str, Object obj) {
        zzt zzt = new zzt((zzs) null);
        this.zzc.zzc = zzt;
        this.zzc = zzt;
        zzt.zzb = obj;
        zzt.zza = str;
        return this;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append(this.zza);
        sb2.append('{');
        zzu zzu = this.zzb.zzc;
        String str = "";
        while (zzu != null) {
            Object obj = zzu.zzb;
            sb2.append(str);
            String str2 = zzu.zza;
            if (str2 != null) {
                sb2.append(str2);
                sb2.append(SignatureVisitor.INSTANCEOF);
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb2.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb2.append(deepToString, 1, deepToString.length() - 1);
            }
            zzu = zzu.zzc;
            str = ", ";
        }
        sb2.append('}');
        return sb2.toString();
    }

    public final zzv zza(String str, float f10) {
        zze(str, String.valueOf(f10));
        return this;
    }

    public final zzv zzb(String str, int i10) {
        zze(str, String.valueOf(i10));
        return this;
    }

    public final zzv zzc(String str, Object obj) {
        zzu zzu = new zzu((zzs) null);
        this.zzc.zzc = zzu;
        this.zzc = zzu;
        zzu.zzb = obj;
        zzu.zza = str;
        return this;
    }

    public final zzv zzd(String str, boolean z10) {
        zze("trackingEnabled", String.valueOf(z10));
        return this;
    }
}
