package com.google.android.gms.internal.mlkit_vision_face;

final class zzbf {
    static int zza(Object obj) {
        int i10;
        if (obj == null) {
            i10 = 0;
        } else {
            i10 = obj.hashCode();
        }
        return (int) (((long) Integer.rotateLeft((int) (((long) i10) * -862048943), 15)) * 461845907);
    }
}
