package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzez implements ObjectEncoder {
    static final zzez zza = new zzez();
    private static final FieldDescriptor zzb;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("errorCode");
        zzae zzae = new zzae();
        zzae.zza(1);
        zzb = builder.withProperty(zzae.zzb()).build();
    }

    private zzez() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzjh zzjh = (zzjh) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
