package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Arrays;

final class zziq implements Serializable, zzim {
    final Object zza;

    zziq(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zziq) {
            return zzih.zza(this.zza, ((zziq) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "Suppliers.ofInstance(" + obj + ")";
    }

    public final Object zza() {
        return this.zza;
    }
}
