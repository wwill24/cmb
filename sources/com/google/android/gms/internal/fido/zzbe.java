package com.google.android.gms.internal.fido;

import java.util.Iterator;
import org.apache.commons.beanutils.PropertyUtils;

final class zzbe extends zzba {
    final transient Object zza;

    zzbe(Object obj) {
        obj.getClass();
        this.zza = obj;
    }

    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final /* synthetic */ Iterator iterator() {
        return new zzbb(this.zza);
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        return '[' + this.zza.toString() + PropertyUtils.INDEXED_DELIM2;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i10) {
        objArr[0] = this.zza;
        return 1;
    }

    public final zzbf zzd() {
        return new zzbb(this.zza);
    }
}
