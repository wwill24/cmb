package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzip implements ObjectEncoder {
    static final zzip zza = new zzip();
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
        zzcv zzcv = new zzcv();
        zzcv.zza(1);
        zzb = builder.withProperty(zzcv.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("nnapiInfo");
        zzcv zzcv2 = new zzcv();
        zzcv2.zza(2);
        zzc = builder2.withProperty(zzcv2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("gpuInfo");
        zzcv zzcv3 = new zzcv();
        zzcv3.zza(3);
        zzd = builder3.withProperty(zzcv3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("pipelineIdentifier");
        zzcv zzcv4 = new zzcv();
        zzcv4.zza(4);
        zze = builder4.withProperty(zzcv4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("acceptedConfigurations");
        zzcv zzcv5 = new zzcv();
        zzcv5.zza(5);
        zzf = builder5.withProperty(zzcv5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("action");
        zzcv zzcv6 = new zzcv();
        zzcv6.zza(6);
        zzg = builder6.withProperty(zzcv6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("status");
        zzcv zzcv7 = new zzcv();
        zzcv7.zza(7);
        zzh = builder7.withProperty(zzcv7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("customErrors");
        zzcv zzcv8 = new zzcv();
        zzcv8.zza(8);
        zzi = builder8.withProperty(zzcv8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("benchmarkStatus");
        zzcv zzcv9 = new zzcv();
        zzcv9.zza(9);
        zzj = builder9.withProperty(zzcv9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("validationTestResult");
        zzcv zzcv10 = new zzcv();
        zzcv10.zza(10);
        zzk = builder10.withProperty(zzcv10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("timestampUs");
        zzcv zzcv11 = new zzcv();
        zzcv11.zza(11);
        zzl = builder11.withProperty(zzcv11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("elapsedUs");
        zzcv zzcv12 = new zzcv();
        zzcv12.zza(12);
        zzm = builder12.withProperty(zzcv12.zzb()).build();
    }

    private zzip() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zznl zznl = (zznl) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
