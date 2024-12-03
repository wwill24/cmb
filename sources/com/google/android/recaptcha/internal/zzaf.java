package com.google.android.recaptcha.internal;

import java.util.Arrays;
import kotlin.jvm.internal.j;

public final class zzaf {
    private final zzkw zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze = null;

    public zzaf(zzkw zzkw, String str, String str2, String str3, String str4) {
        this.zza = zzkw;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzaf)) {
            return false;
        }
        zzaf zzaf = (zzaf) obj;
        if (zzaf.zza != this.zza || !j.b(zzaf.zzb, this.zzb) || !j.b(zzaf.zzc, this.zzc) || !j.b(zzaf.zzd, this.zzd) || !j.b((Object) null, (Object) null)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, null});
    }

    public final zzkw zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }
}
