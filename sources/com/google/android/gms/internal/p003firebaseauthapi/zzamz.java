package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamz  reason: invalid package */
final class zzamz implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzana zzb;

    zzamz(zzana zzana) {
        this.zzb = zzana;
        this.zza = zzana.zza.iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
