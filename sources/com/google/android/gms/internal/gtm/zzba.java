package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import java.util.HashMap;
import rd.m;

public final class zzba extends m<zzba> {
    public int zza;
    public int zzb;
    private String zzc;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("language", this.zzc);
        hashMap.put("screenColors", 0);
        hashMap.put("screenWidth", Integer.valueOf(this.zza));
        hashMap.put("screenHeight", Integer.valueOf(this.zzb));
        hashMap.put("viewportWidth", 0);
        hashMap.put("viewportHeight", 0);
        return m.zza(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzc(m mVar) {
        zzba zzba = (zzba) mVar;
        int i10 = this.zza;
        if (i10 != 0) {
            zzba.zza = i10;
        }
        int i11 = this.zzb;
        if (i11 != 0) {
            zzba.zzb = i11;
        }
        if (!TextUtils.isEmpty(this.zzc)) {
            zzba.zzc = this.zzc;
        }
    }

    public final String zzd() {
        return this.zzc;
    }

    public final void zze(String str) {
        this.zzc = str;
    }
}
