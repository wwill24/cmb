package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class zzai implements zzap, zzal {
    protected final String zzd;
    protected final Map zze = new HashMap();

    public zzai(String str) {
        this.zzd = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzai)) {
            return false;
        }
        zzai zzai = (zzai) obj;
        String str = this.zzd;
        if (str != null) {
            return str.equals(zzai.zzd);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzd;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public abstract zzap zza(zzg zzg, List list);

    public final zzap zzbU(String str, zzg zzg, List list) {
        if ("toString".equals(str)) {
            return new zzat(this.zzd);
        }
        return zzaj.zza(this, new zzat(str), zzg, list);
    }

    public final String zzc() {
        return this.zzd;
    }

    public zzap zzd() {
        return this;
    }

    public final zzap zzf(String str) {
        if (this.zze.containsKey(str)) {
            return (zzap) this.zze.get(str);
        }
        return zzap.zzf;
    }

    public final Boolean zzg() {
        return Boolean.TRUE;
    }

    public final Double zzh() {
        return Double.valueOf(Double.NaN);
    }

    public final String zzi() {
        return this.zzd;
    }

    public final Iterator zzl() {
        return zzaj.zzb(this.zze);
    }

    public final void zzr(String str, zzap zzap) {
        if (zzap == null) {
            this.zze.remove(str);
        } else {
            this.zze.put(str, zzap);
        }
    }

    public final boolean zzt(String str) {
        return this.zze.containsKey(str);
    }
}
