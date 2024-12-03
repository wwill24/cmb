package com.google.android.gms.internal.gtm;

import com.google.android.gms.tagmanager.zzfv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzru {
    private final List<zzrw> zza = new ArrayList();
    private final Map<String, List<zzro>> zzb = new HashMap();
    private String zzc = "";
    private int zzd = 0;

    private zzru() {
    }

    public final zzrs zza() {
        return new zzrs(this.zza, this.zzb, this.zzc, this.zzd, (zzrr) null);
    }

    public final zzru zzb(zzro zzro) {
        String zzn = zzfv.zzn(zzfv.zzl(zzro.zzc().get(zzb.INSTANCE_NAME.toString())));
        List list = this.zzb.get(zzn);
        if (list == null) {
            list = new ArrayList();
            this.zzb.put(zzn, list);
        }
        list.add(zzro);
        return this;
    }

    public final zzru zzc(zzrw zzrw) {
        this.zza.add(zzrw);
        return this;
    }

    public final zzru zzd(int i10) {
        this.zzd = i10;
        return this;
    }

    public final zzru zze(String str) {
        this.zzc = str;
        return this;
    }

    /* synthetic */ zzru(zzrt zzrt) {
    }
}
