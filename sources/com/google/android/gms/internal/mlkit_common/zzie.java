package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzie implements ObjectEncoder {
    static final zzie zza = new zzie();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("detectorOptions");
        zzbk zzbk = new zzbk();
        zzbk.zza(1);
        zzb = builder.withProperty(zzbk.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("errorCode");
        zzbk zzbk2 = new zzbk();
        zzbk2.zza(2);
        zzc = builder2.withProperty(zzbk2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("totalInitializationMs");
        zzbk zzbk3 = new zzbk();
        zzbk3.zza(3);
        zzd = builder3.withProperty(zzbk3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("loggingInitializationMs");
        zzbk zzbk4 = new zzbk();
        zzbk4.zza(4);
        zze = builder4.withProperty(zzbk4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("otherErrors");
        zzbk zzbk5 = new zzbk();
        zzbk5.zza(5);
        zzf = builder5.withProperty(zzbk5.zzb()).build();
    }

    private zzie() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zznk zznk = (zznk) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
