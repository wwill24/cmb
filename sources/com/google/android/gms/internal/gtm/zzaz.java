package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.p;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import rd.m;

public final class zzaz extends m<zzaz> {
    private final Map<String, Object> zza = new HashMap();

    public final String toString() {
        return m.zza(this.zza);
    }

    public final /* bridge */ /* synthetic */ void zzc(m mVar) {
        zzaz zzaz = (zzaz) mVar;
        p.k(zzaz);
        zzaz.zza.putAll(this.zza);
    }

    public final Map<String, Object> zzd() {
        return Collections.unmodifiableMap(this.zza);
    }

    public final void zze(String str, String str2) {
        p.g(str);
        if (str != null && str.startsWith("&")) {
            str = str.substring(1);
        }
        p.h(str, "Name can not be empty or \"&\"");
        this.zza.put(str, str2);
    }
}
