package com.google.android.gms.measurement.internal;

import java.util.Iterator;

final class r implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    final Iterator f40208a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzas f40209b;

    r(zzas zzas) {
        this.f40209b = zzas;
        this.f40208a = zzas.f40490a.keySet().iterator();
    }

    /* renamed from: a */
    public final String next() {
        return (String) this.f40208a.next();
    }

    public final boolean hasNext() {
        return this.f40208a.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
