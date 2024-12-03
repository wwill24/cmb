package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

public final /* synthetic */ class zzdc implements ObjectEncoder {
    public static final /* synthetic */ zzdc zza = new zzdc();

    private /* synthetic */ zzdc() {
    }

    public final void encode(Object obj, Object obj2) {
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        int i10 = zzdd.zza;
        throw new EncodingException("Couldn't find encoder for type ".concat(String.valueOf(obj.getClass().getCanonicalName())));
    }
}
