package com.google.android.gms.internal.mlkit_vision_face;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzpa extends zzb implements zzpb {
    public static zzpb zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.mlkit.vision.face.aidls.IFaceDetectorCreator");
        if (queryLocalInterface instanceof zzpb) {
            return (zzpb) queryLocalInterface;
        }
        return new zzoz(iBinder);
    }
}
