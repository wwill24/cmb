package com.google.android.gms.internal.mlkit_vision_face;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public final class zznu implements zzob {
    final List zza;

    public zznu(Context context, zznt zznt) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zznt.zzc()) {
            arrayList.add(new zzok(context, zznt));
        }
    }

    public final void zza(zznr zznr) {
        for (zzob zza2 : this.zza) {
            zza2.zza(zznr);
        }
    }
}
