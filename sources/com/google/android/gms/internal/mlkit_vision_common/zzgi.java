package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzgi implements ObjectEncoder {
    static final zzgi zza = new zzgi();
    private static final FieldDescriptor zzb;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("errorCode");
        zzae zzae = new zzae();
        zzae.zza(1);
        zzb = builder.withProperty(zzae.zzb()).build();
    }

    private zzgi() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzkq zzkq = (zzkq) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
