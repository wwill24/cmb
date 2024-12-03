package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

public final /* synthetic */ class zzbr implements ObjectEncoder {
    public static final /* synthetic */ zzbr zza = new zzbr();

    private /* synthetic */ zzbr() {
    }

    public final void encode(Object obj, Object obj2) {
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        int i10 = zzbs.zza;
        throw new EncodingException("Couldn't find encoder for type ".concat(String.valueOf(obj.getClass().getCanonicalName())));
    }
}
