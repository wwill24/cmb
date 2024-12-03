package com.google.android.gms.internal.fido;

import java.util.Arrays;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public final class zzap {
    private final String zza;
    private final zzao zzb;
    private zzao zzc;

    /* synthetic */ zzap(String str, zzam zzam) {
        zzao zzao = new zzao((zzam) null);
        this.zzb = zzao;
        this.zzc = zzao;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append(this.zza);
        sb2.append('{');
        zzao zzao = this.zzb.zzc;
        String str = "";
        while (zzao != null) {
            Object obj = zzao.zzb;
            boolean z10 = zzao instanceof zzan;
            sb2.append(str);
            String str2 = zzao.zza;
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
            zzao = zzao.zzc;
            str = ", ";
        }
        sb2.append('}');
        return sb2.toString();
    }

    public final zzap zza(String str, int i10) {
        String valueOf = String.valueOf(i10);
        zzan zzan = new zzan((zzam) null);
        this.zzc.zzc = zzan;
        this.zzc = zzan;
        zzan.zzb = valueOf;
        zzan.zza = "errorCode";
        return this;
    }

    public final zzap zzb(String str, Object obj) {
        zzao zzao = new zzao((zzam) null);
        this.zzc.zzc = zzao;
        this.zzc = zzao;
        zzao.zzb = obj;
        zzao.zza = str;
        return this;
    }
}
