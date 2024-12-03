package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzaq implements zzap {
    private final String zza;
    private final ArrayList zzb;

    public zzaq(String str, List list) {
        this.zza = str;
        ArrayList arrayList = new ArrayList();
        this.zzb = arrayList;
        arrayList.addAll(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaq)) {
            return false;
        }
        zzaq zzaq = (zzaq) obj;
        String str = this.zza;
        if (str == null ? zzaq.zza == null : str.equals(zzaq.zza)) {
            return this.zzb.equals(zzaq.zzb);
        }
        return false;
    }

    public final int hashCode() {
        int i10;
        String str = this.zza;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        return (i10 * 31) + this.zzb.hashCode();
    }

    public final String zzb() {
        return this.zza;
    }

    public final zzap zzbU(String str, zzg zzg, List list) {
        throw new IllegalStateException("Statement is not an evaluated entity");
    }

    public final ArrayList zzc() {
        return this.zzb;
    }

    public final zzap zzd() {
        return this;
    }

    public final Boolean zzg() {
        throw new IllegalStateException("Statement cannot be cast as Boolean");
    }

    public final Double zzh() {
        throw new IllegalStateException("Statement cannot be cast as Double");
    }

    public final String zzi() {
        throw new IllegalStateException("Statement cannot be cast as String");
    }

    public final Iterator zzl() {
        return null;
    }
}
