package com.google.android.gms.internal.mlkit_vision_text_common;

import java.io.IOException;
import java.util.Iterator;

public final class zzv {
    private final String zza = "\n";

    private zzv(String str) {
    }

    public static zzv zza(String str) {
        return new zzv("\n");
    }

    static final CharSequence zzc(Object obj) {
        obj.getClass();
        if (obj instanceof CharSequence) {
            return (CharSequence) obj;
        }
        return obj.toString();
    }

    public final String zzb(Iterable iterable) {
        Iterator it = iterable.iterator();
        StringBuilder sb2 = new StringBuilder();
        try {
            if (it.hasNext()) {
                sb2.append(zzc(it.next()));
                while (it.hasNext()) {
                    sb2.append(this.zza);
                    sb2.append(zzc(it.next()));
                }
            }
            return sb2.toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }
}
