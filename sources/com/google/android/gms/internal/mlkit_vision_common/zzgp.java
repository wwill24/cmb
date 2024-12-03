package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzgp implements ObjectEncoder {
    static final zzgp zza = new zzgp();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;
    private static final FieldDescriptor zzi;
    private static final FieldDescriptor zzj;
    private static final FieldDescriptor zzk;
    private static final FieldDescriptor zzl;
    private static final FieldDescriptor zzm;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("deviceInfo");
        zzae zzae = new zzae();
        zzae.zza(1);
        zzb = builder.withProperty(zzae.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("nnapiInfo");
        zzae zzae2 = new zzae();
        zzae2.zza(2);
        zzc = builder2.withProperty(zzae2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("gpuInfo");
        zzae zzae3 = new zzae();
        zzae3.zza(3);
        zzd = builder3.withProperty(zzae3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("pipelineIdentifier");
        zzae zzae4 = new zzae();
        zzae4.zza(4);
        zze = builder4.withProperty(zzae4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("acceptedConfigurations");
        zzae zzae5 = new zzae();
        zzae5.zza(5);
        zzf = builder5.withProperty(zzae5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("action");
        zzae zzae6 = new zzae();
        zzae6.zza(6);
        zzg = builder6.withProperty(zzae6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("status");
        zzae zzae7 = new zzae();
        zzae7.zza(7);
        zzh = builder7.withProperty(zzae7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("customErrors");
        zzae zzae8 = new zzae();
        zzae8.zza(8);
        zzi = builder8.withProperty(zzae8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("benchmarkStatus");
        zzae zzae9 = new zzae();
        zzae9.zza(9);
        zzj = builder9.withProperty(zzae9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("validationTestResult");
        zzae zzae10 = new zzae();
        zzae10.zza(10);
        zzk = builder10.withProperty(zzae10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("timestampUs");
        zzae zzae11 = new zzae();
        zzae11.zza(11);
        zzl = builder11.withProperty(zzae11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("elapsedUs");
        zzae zzae12 = new zzae();
        zzae12.zza(12);
        zzm = builder12.withProperty(zzae12.zzb()).build();
    }

    private zzgp() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzlo zzlo = (zzlo) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
