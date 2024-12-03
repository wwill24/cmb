package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzgu implements ObjectEncoder {
    static final zzgu zza = new zzgu();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("errorCode");
        zzbk zzbk = new zzbk();
        zzbk.zza(1);
        zzb = builder.withProperty(zzbk.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("durationMs");
        zzbk zzbk2 = new zzbk();
        zzbk2.zza(2);
        zzc = builder2.withProperty(zzbk2.zzb()).build();
    }

    private zzgu() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzma zzma = (zzma) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
