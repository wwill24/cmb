package com.google.android.gms.internal.mlkit_vision_face;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzl extends zzb implements zzm {
    public static zzm zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
        if (queryLocalInterface instanceof zzm) {
            return (zzm) queryLocalInterface;
        }
        return new zzk(iBinder);
    }
}
