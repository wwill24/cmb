package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.List;
import java.util.RandomAccess;

public final class zzbw {
    public static List zza(List list, zzu zzu) {
        if (list instanceof RandomAccess) {
            return new zzbt(list, zzu);
        }
        return new zzbv(list, zzu);
    }
}
