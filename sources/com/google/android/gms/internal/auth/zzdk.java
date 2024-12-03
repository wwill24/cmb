package com.google.android.gms.internal.auth;

import java.io.Serializable;

final class zzdk implements Serializable, zzdj {
    final zzdj zza;
    volatile transient boolean zzb;
    transient Object zzc;

    zzdk(zzdj zzdj) {
        zzdj.getClass();
        this.zza = zzdj;
    }

    public final String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Suppliers.memoize(");
        if (this.zzb) {
            obj = "<supplier that returned " + this.zzc + ">";
        } else {
            obj = this.zza;
        }
        sb2.append(obj);
        sb2.append(")");
        return sb2.toString();
    }

    public final Object zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    Object zza2 = this.zza.zza();
                    this.zzc = zza2;
                    this.zzb = true;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}
