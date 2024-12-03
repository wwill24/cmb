package com.google.android.gms.internal.gtm;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzxt extends AbstractList<String> implements RandomAccess, zzvs {
    /* access modifiers changed from: private */
    public final zzvs zza;

    public zzxt(zzvs zzvs) {
        this.zza = zzvs;
    }

    public final /* bridge */ /* synthetic */ Object get(int i10) {
        return ((zzvr) this.zza).get(i10);
    }

    public final Iterator<String> iterator() {
        return new zzxs(this);
    }

    public final ListIterator<String> listIterator(int i10) {
        return new zzxr(this, i10);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzvs zze() {
        return this;
    }

    public final Object zzf(int i10) {
        return this.zza.zzf(i10);
    }

    public final List<?> zzh() {
        return this.zza.zzh();
    }

    public final void zzi(zztd zztd) {
        throw new UnsupportedOperationException();
    }
}
