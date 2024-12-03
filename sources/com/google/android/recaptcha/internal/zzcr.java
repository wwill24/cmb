package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.List;

public final class zzcr {
    public static final zzcr zza = new zzcr();
    private static List zzb = q.j();

    private zzcr() {
    }

    public static final void acx(int[] iArr) {
        zzb(iArr);
    }

    public static final int zza(int[] iArr) {
        Iterator it = CollectionsKt___CollectionsKt.h0(zzb, l.n0(iArr)).iterator();
        if (it.hasNext()) {
            Object next = it.next();
            while (it.hasNext()) {
                next = Integer.valueOf(((Number) next).intValue() ^ ((Number) it.next()).intValue());
            }
            return ((Number) next).intValue();
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    public static final void zzb(int[] iArr) {
        zzb = l.n0(iArr);
    }
}
