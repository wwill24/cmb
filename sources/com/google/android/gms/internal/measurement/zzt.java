package com.google.android.gms.internal.measurement;

import com.leanplum.internal.RequestBuilder;
import java.util.List;

public final class zzt extends zzai {
    /* access modifiers changed from: private */
    public final zzr zza;

    public zzt(zzr zzr) {
        super("internal.logger");
        this.zza = zzr;
        this.zze.put(RequestBuilder.ACTION_LOG, new zzs(this, false, true));
        this.zze.put("silent", new zzp(this, "silent"));
        ((zzai) this.zze.get("silent")).zzr(RequestBuilder.ACTION_LOG, new zzs(this, true, true));
        this.zze.put("unmonitored", new zzq(this, "unmonitored"));
        ((zzai) this.zze.get("unmonitored")).zzr(RequestBuilder.ACTION_LOG, new zzs(this, false, false));
    }

    public final zzap zza(zzg zzg, List list) {
        return zzap.zzf;
    }
}
