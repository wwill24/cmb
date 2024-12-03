package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.Map;

public final class zzro {
    private final Map<String, zzak> zza;
    private final zzak zzb;

    /* synthetic */ zzro(Map map, zzak zzak, zzrn zzrn) {
        this.zza = map;
        this.zzb = zzak;
    }

    public static zzrq zzb() {
        return new zzrq((zzrp) null);
    }

    public final String toString() {
        String valueOf = String.valueOf(Collections.unmodifiableMap(this.zza));
        String valueOf2 = String.valueOf(this.zzb);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 32 + valueOf2.length());
        sb2.append("Properties: ");
        sb2.append(valueOf);
        sb2.append(" pushAfterEvaluate: ");
        sb2.append(valueOf2);
        return sb2.toString();
    }

    public final zzak zza() {
        return this.zzb;
    }

    public final Map<String, zzak> zzc() {
        return Collections.unmodifiableMap(this.zza);
    }

    public final void zzd(String str, zzak zzak) {
        this.zza.put(str, zzak);
    }
}
