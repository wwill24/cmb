package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzku implements ObjectEncoder {
    static final zzku zza = new zzku();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("durationMs");
        zzdg zzdg = new zzdg();
        zzdg.zza(1);
        zzb = builder.withProperty(zzdg.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("handledErrors");
        zzdg zzdg2 = new zzdg();
        zzdg2.zza(2);
        zzc = builder2.withProperty(zzdg2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("partiallyHandledErrors");
        zzdg zzdg3 = new zzdg();
        zzdg3.zza(3);
        zzd = builder3.withProperty(zzdg3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("unhandledErrors");
        zzdg zzdg4 = new zzdg();
        zzdg4.zza(4);
        zze = builder4.withProperty(zzdg4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("httpResponseCode");
        zzdg zzdg5 = new zzdg();
        zzdg5.zza(5);
        zzf = builder5.withProperty(zzdg5.zzb()).build();
    }

    private zzku() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzpu zzpu = (zzpu) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
