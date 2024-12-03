package com.google.android.gms.internal.mlkit_vision_text_common;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzoy extends zzb implements zzoz {
    public static zzoz zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.mlkit.vision.text.aidls.ITextRecognizerCreator");
        if (queryLocalInterface instanceof zzoz) {
            return (zzoz) queryLocalInterface;
        }
        return new zzox(iBinder);
    }
}
