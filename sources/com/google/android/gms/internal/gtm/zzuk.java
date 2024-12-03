package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzun;
import java.io.IOException;
import java.util.Map;

abstract class zzuk<T extends zzun<T>> {
    zzuk() {
    }

    /* access modifiers changed from: package-private */
    public abstract int zza(Map.Entry<?, ?> entry);

    /* access modifiers changed from: package-private */
    public abstract zzuo<T> zzb(Object obj);

    /* access modifiers changed from: package-private */
    public abstract zzuo<T> zzc(Object obj);

    /* access modifiers changed from: package-private */
    public abstract Object zzd(zzuj zzuj, zzwk zzwk, int i10);

    /* access modifiers changed from: package-private */
    public abstract <UT, UB> UB zze(zzww zzww, Object obj, zzuj zzuj, zzuo<T> zzuo, UB ub2, zzxo<UT, UB> zzxo) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzf(Object obj);

    /* access modifiers changed from: package-private */
    public abstract void zzg(zzww zzww, Object obj, zzuj zzuj, zzuo<T> zzuo) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzh(zztd zztd, Object obj, zzuj zzuj, zzuo<T> zzuo) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract boolean zzi(zzwk zzwk);

    /* access modifiers changed from: package-private */
    public abstract void zzj(zztp zztp, Map.Entry<?, ?> entry) throws IOException;
}
