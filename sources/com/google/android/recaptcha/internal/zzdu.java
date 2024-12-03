package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.List;

final class zzdu extends zzdp {
    final /* synthetic */ Iterable zza;
    final /* synthetic */ int zzb;

    zzdu(Iterable iterable, int i10) {
        this.zza = iterable;
        this.zzb = i10;
    }

    public final Iterator iterator() {
        boolean z10;
        Iterable iterable = this.zza;
        if (iterable instanceof List) {
            List list = (List) iterable;
            return list.subList(Math.min(list.size(), this.zzb), list.size()).iterator();
        }
        Iterator it = iterable.iterator();
        int i10 = this.zzb;
        it.getClass();
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        zzdi.zzb(z10, "numberToAdvance must be nonnegative");
        for (int i11 = 0; i11 < i10 && it.hasNext(); i11++) {
            it.next();
        }
        return new zzdt(this, it);
    }
}
