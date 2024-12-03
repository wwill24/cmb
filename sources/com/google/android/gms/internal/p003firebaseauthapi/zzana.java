package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzana  reason: invalid package */
public final class zzana extends AbstractList implements RandomAccess, zzakx {
    /* access modifiers changed from: private */
    public final zzakx zza;

    public zzana(zzakx zzakx) {
        this.zza = zzakx;
    }

    public final /* bridge */ /* synthetic */ Object get(int i10) {
        return ((zzakw) this.zza).get(i10);
    }

    public final Iterator iterator() {
        return new zzamz(this);
    }

    public final ListIterator listIterator(int i10) {
        return new zzamy(this, i10);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzakx zze() {
        return this;
    }

    public final Object zzf(int i10) {
        return this.zza.zzf(i10);
    }

    public final List zzh() {
        return this.zza.zzh();
    }

    public final void zzi(zzajf zzajf) {
        throw new UnsupportedOperationException();
    }
}
