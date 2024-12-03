package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class zzrs {
    private final List<zzrw> zza;
    private final Map<String, List<zzro>> zzb;
    private final String zzc;

    /* synthetic */ zzrs(List list, Map map, String str, int i10, zzrr zzrr) {
        this.zza = Collections.unmodifiableList(list);
        this.zzb = Collections.unmodifiableMap(map);
        this.zzc = str;
    }

    public static zzru zza() {
        return new zzru((zzrt) null);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 17 + valueOf2.length());
        sb2.append("Rules: ");
        sb2.append(valueOf);
        sb2.append("  Macros: ");
        sb2.append(valueOf2);
        return sb2.toString();
    }

    public final String zzb() {
        return this.zzc;
    }

    public final List<zzrw> zzc() {
        return this.zza;
    }

    public final Map<String, List<zzro>> zzd() {
        return this.zzb;
    }
}
