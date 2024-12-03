package com.google.android.gms.internal.play_billing;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@Deprecated
public final class zzel extends AbstractList implements RandomAccess, zzcn {
    /* access modifiers changed from: private */
    public final zzcn zza;

    public zzel(zzcn zzcn) {
        this.zza = zzcn;
    }

    public final /* bridge */ /* synthetic */ Object get(int i10) {
        return ((zzcm) this.zza).get(i10);
    }

    public final Iterator iterator() {
        return new zzek(this);
    }

    public final ListIterator listIterator(int i10) {
        return new zzej(this, i10);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzcn zze() {
        return this;
    }

    public final Object zzf(int i10) {
        return this.zza.zzf(i10);
    }

    public final List zzh() {
        return this.zza.zzh();
    }
}
