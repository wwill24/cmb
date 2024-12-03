package com.google.android.gms.internal.mlkit_vision_face;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

public final /* synthetic */ class zzcx implements ObjectEncoder {
    public static final /* synthetic */ zzcx zza = new zzcx();

    private /* synthetic */ zzcx() {
    }

    public final void encode(Object obj, Object obj2) {
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        int i10 = zzcy.zza;
        throw new EncodingException("Couldn't find encoder for type ".concat(String.valueOf(obj.getClass().getCanonicalName())));
    }
}
