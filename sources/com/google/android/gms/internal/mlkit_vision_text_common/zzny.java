package com.google.android.gms.internal.mlkit_vision_text_common;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public final class zzny implements zzof {
    final List zza;

    public zzny(Context context, zznx zznx) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zznx.zzc()) {
            arrayList.add(new zzoo(context, zznx));
        }
    }

    public final void zza(zznv zznv) {
        for (zzof zza2 : this.zza) {
            zza2.zza(zznv);
        }
    }
}
