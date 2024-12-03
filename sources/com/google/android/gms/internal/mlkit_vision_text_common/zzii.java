package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzii implements ObjectEncoder {
    static final zzii zza = new zzii();
    private static final FieldDescriptor zzb;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("errorCode");
        zzcv zzcv = new zzcv();
        zzcv.zza(1);
        zzb = builder.withProperty(zzcv.zzb()).build();
    }

    private zzii() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        ((ObjectEncoderContext) obj2).add(zzb, (Object) ((zzmj) obj).zza());
    }
}
