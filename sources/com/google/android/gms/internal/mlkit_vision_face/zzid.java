package com.google.android.gms.internal.mlkit_vision_face;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzid implements ObjectEncoder {
    static final zzid zza = new zzid();
    private static final FieldDescriptor zzb;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("errorCode");
        zzcq zzcq = new zzcq();
        zzcq.zza(1);
        zzb = builder.withProperty(zzcq.zzb()).build();
    }

    private zzid() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzml zzml = (zzml) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
