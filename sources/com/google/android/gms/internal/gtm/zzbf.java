package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.p;
import java.util.HashMap;
import java.util.UUID;
import rd.m;

public final class zzbf extends m<zzbf> {
    private int zza;

    public zzbf() {
        UUID randomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (randomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits == 0 && (leastSignificantBits = (int) (randomUUID.getMostSignificantBits() & 2147483647L)) == 0) {
            leastSignificantBits = a.e.API_PRIORITY_OTHER;
        }
        p.m(leastSignificantBits);
        this.zza = leastSignificantBits;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("screenName", (Object) null);
        Boolean bool = Boolean.FALSE;
        hashMap.put("interstitial", bool);
        hashMap.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC, bool);
        hashMap.put("screenId", Integer.valueOf(this.zza));
        hashMap.put("referrerScreenId", 0);
        hashMap.put("referrerScreenName", (Object) null);
        hashMap.put("referrerUri", (Object) null);
        return m.zza(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzc(m mVar) {
        zzbf zzbf = (zzbf) mVar;
        TextUtils.isEmpty((CharSequence) null);
        int i10 = this.zza;
        if (i10 != 0) {
            zzbf.zza = i10;
        }
        TextUtils.isEmpty((CharSequence) null);
        if (!TextUtils.isEmpty((CharSequence) null)) {
            TextUtils.isEmpty((CharSequence) null);
        }
    }

    public final int zzd() {
        return this.zza;
    }
}
