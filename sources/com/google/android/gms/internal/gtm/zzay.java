package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import rd.m;

public final class zzay extends m<zzay> {
    private final Map<Integer, Double> zza = new HashMap(4);

    public final String toString() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.zza.entrySet()) {
            String valueOf = String.valueOf(next.getKey());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 6);
            sb2.append("metric");
            sb2.append(valueOf);
            hashMap.put(sb2.toString(), next.getValue());
        }
        return m.zza(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzc(m mVar) {
        ((zzay) mVar).zza.putAll(this.zza);
    }

    public final Map<Integer, Double> zzd() {
        return Collections.unmodifiableMap(this.zza);
    }
}
