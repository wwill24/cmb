package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rd.m;
import sd.a;
import sd.b;

public final class zzbb extends m<zzbb> {
    private final List<a> zza = new ArrayList();
    private final List<b> zzb = new ArrayList();
    private final Map<String, List<a>> zzc = new HashMap();

    public final String toString() {
        HashMap hashMap = new HashMap();
        if (!this.zza.isEmpty()) {
            hashMap.put("products", this.zza);
        }
        if (!this.zzb.isEmpty()) {
            hashMap.put("promotions", this.zzb);
        }
        if (!this.zzc.isEmpty()) {
            hashMap.put("impressions", this.zzc);
        }
        hashMap.put("productAction", (Object) null);
        return m.zza(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzc(m mVar) {
        String str;
        zzbb zzbb = (zzbb) mVar;
        zzbb.zza.addAll(this.zza);
        zzbb.zzb.addAll(this.zzb);
        for (Map.Entry next : this.zzc.entrySet()) {
            String str2 = (String) next.getKey();
            for (a aVar : (List) next.getValue()) {
                if (aVar != null) {
                    if (str2 == null) {
                        str = "";
                    } else {
                        str = str2;
                    }
                    if (!zzbb.zzc.containsKey(str)) {
                        zzbb.zzc.put(str, new ArrayList());
                    }
                    zzbb.zzc.get(str).add(aVar);
                }
            }
        }
    }

    public final List<a> zzd() {
        return Collections.unmodifiableList(this.zza);
    }

    public final List<b> zze() {
        return Collections.unmodifiableList(this.zzb);
    }

    public final Map<String, List<a>> zzf() {
        return this.zzc;
    }
}
