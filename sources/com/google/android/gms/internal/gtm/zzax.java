package com.google.android.gms.internal.gtm;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import rd.m;

public final class zzax extends m<zzax> {
    private final Map<Integer, String> zza = new HashMap(4);

    public final String toString() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.zza.entrySet()) {
            String valueOf = String.valueOf(next.getKey());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 9);
            sb2.append(ViewHierarchyConstants.DIMENSION_KEY);
            sb2.append(valueOf);
            hashMap.put(sb2.toString(), next.getValue());
        }
        return m.zza(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzc(m mVar) {
        ((zzax) mVar).zza.putAll(this.zza);
    }

    public final Map<Integer, String> zzd() {
        return Collections.unmodifiableMap(this.zza);
    }
}
