package com.google.android.gms.internal.mlkit_common;

import java.util.Arrays;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public final class zzz {
    private final String zza;
    private final zzx zzb;
    private zzx zzc;

    /* synthetic */ zzz(String str, zzy zzy) {
        zzx zzx = new zzx((zzw) null);
        this.zzb = zzx;
        this.zzc = zzx;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append(this.zza);
        sb2.append('{');
        zzx zzx = this.zzb.zzc;
        String str = "";
        while (zzx != null) {
            Object obj = zzx.zzb;
            boolean z10 = zzx instanceof zzv;
            sb2.append(str);
            String str2 = zzx.zza;
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
            zzx = zzx.zzc;
            str = ", ";
        }
        sb2.append('}');
        return sb2.toString();
    }

    public final zzz zza(String str, Object obj) {
        zzx zzx = new zzx((zzw) null);
        this.zzc.zzc = zzx;
        this.zzc = zzx;
        zzx.zzb = obj;
        zzx.zza = str;
        return this;
    }

    public final zzz zzb(String str, boolean z10) {
        String valueOf = String.valueOf(z10);
        zzv zzv = new zzv((zzu) null);
        this.zzc.zzc = zzv;
        this.zzc = zzv;
        zzv.zzb = valueOf;
        zzv.zza = "isManifestFile";
        return this;
    }
}
