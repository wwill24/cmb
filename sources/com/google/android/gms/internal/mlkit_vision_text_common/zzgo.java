package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzgo implements ObjectEncoder {
    static final zzgo zza = new zzgo();
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

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("durationMs");
        zzcv zzcv = new zzcv();
        zzcv.zza(1);
        zzb = builder.withProperty(zzcv.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("errorCode");
        zzcv zzcv2 = new zzcv();
        zzcv2.zza(2);
        zzc = builder2.withProperty(zzcv2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("isColdCall");
        zzcv zzcv3 = new zzcv();
        zzcv3.zza(3);
        zzd = builder3.withProperty(zzcv3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("autoManageModelOnBackground");
        zzcv zzcv4 = new zzcv();
        zzcv4.zza(4);
        zze = builder4.withProperty(zzcv4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("autoManageModelOnLowMemory");
        zzcv zzcv5 = new zzcv();
        zzcv5.zza(5);
        zzf = builder5.withProperty(zzcv5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("isNnApiEnabled");
        zzcv zzcv6 = new zzcv();
        zzcv6.zza(6);
        zzg = builder6.withProperty(zzcv6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("eventsCount");
        zzcv zzcv7 = new zzcv();
        zzcv7.zza(7);
        zzh = builder7.withProperty(zzcv7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("otherErrors");
        zzcv zzcv8 = new zzcv();
        zzcv8.zza(8);
        zzi = builder8.withProperty(zzcv8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("remoteConfigValueForAcceleration");
        zzcv zzcv9 = new zzcv();
        zzcv9.zza(9);
        zzj = builder9.withProperty(zzcv9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("isAccelerated");
        zzcv zzcv10 = new zzcv();
        zzcv10.zza(10);
        zzk = builder10.withProperty(zzcv10.zzb()).build();
    }

    private zzgo() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzkl zzkl = (zzkl) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, (Object) zzkl.zze());
        objectEncoderContext.add(zzc, (Object) zzkl.zza());
        objectEncoderContext.add(zzd, (Object) zzkl.zzd());
        objectEncoderContext.add(zze, (Object) zzkl.zzb());
        objectEncoderContext.add(zzf, (Object) zzkl.zzc());
        objectEncoderContext.add(zzg, (Object) null);
        objectEncoderContext.add(zzh, (Object) null);
        objectEncoderContext.add(zzi, (Object) null);
        objectEncoderContext.add(zzj, (Object) null);
        objectEncoderContext.add(zzk, (Object) null);
    }
}
