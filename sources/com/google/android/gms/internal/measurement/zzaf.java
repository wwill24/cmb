package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

public final class zzaf implements zzap {
    private final boolean zza;

    public zzaf(Boolean bool) {
        this.zza = bool == null ? false : bool.booleanValue();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof zzaf) && this.zza == ((zzaf) obj).zza) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.valueOf(this.zza).hashCode();
    }

    public final String toString() {
        return String.valueOf(this.zza);
    }

    public final zzap zzbU(String str, zzg zzg, List list) {
        if ("toString".equals(str)) {
            return new zzat(Boolean.toString(this.zza));
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", new Object[]{Boolean.toString(this.zza), str}));
    }

    public final zzap zzd() {
        return new zzaf(Boolean.valueOf(this.zza));
    }

    public final Boolean zzg() {
        return Boolean.valueOf(this.zza);
    }

    public final Double zzh() {
        return Double.valueOf(true != this.zza ? 0.0d : 1.0d);
    }

    public final String zzi() {
        return Boolean.toString(this.zza);
    }

    public final Iterator zzl() {
        return null;
    }
}
