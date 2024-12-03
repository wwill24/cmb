package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.IOException;

final class zziu implements ObjectEncoder {
    static final zziu zza = new zziu();
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
    private static final FieldDescriptor zzn;
    private static final FieldDescriptor zzo;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("appId");
        zzcv zzcv = new zzcv();
        zzcv.zza(1);
        zzb = builder.withProperty(zzcv.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder(RemoteConfigConstants.RequestFieldKey.APP_VERSION);
        zzcv zzcv2 = new zzcv();
        zzcv2.zza(2);
        zzc = builder2.withProperty(zzcv2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("firebaseProjectId");
        zzcv zzcv3 = new zzcv();
        zzcv3.zza(3);
        zzd = builder3.withProperty(zzcv3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("mlSdkVersion");
        zzcv zzcv4 = new zzcv();
        zzcv4.zza(4);
        zze = builder4.withProperty(zzcv4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("tfliteSchemaVersion");
        zzcv zzcv5 = new zzcv();
        zzcv5.zza(5);
        zzf = builder5.withProperty(zzcv5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("gcmSenderId");
        zzcv zzcv6 = new zzcv();
        zzcv6.zza(6);
        zzg = builder6.withProperty(zzcv6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("apiKey");
        zzcv zzcv7 = new zzcv();
        zzcv7.zza(7);
        zzh = builder7.withProperty(zzcv7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("languages");
        zzcv zzcv8 = new zzcv();
        zzcv8.zza(8);
        zzi = builder8.withProperty(zzcv8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("mlSdkInstanceId");
        zzcv zzcv9 = new zzcv();
        zzcv9.zza(9);
        zzj = builder9.withProperty(zzcv9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("isClearcutClient");
        zzcv zzcv10 = new zzcv();
        zzcv10.zza(10);
        zzk = builder10.withProperty(zzcv10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("isStandaloneMlkit");
        zzcv zzcv11 = new zzcv();
        zzcv11.zza(11);
        zzl = builder11.withProperty(zzcv11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("isJsonLogging");
        zzcv zzcv12 = new zzcv();
        zzcv12.zza(12);
        zzm = builder12.withProperty(zzcv12.zzb()).build();
        FieldDescriptor.Builder builder13 = FieldDescriptor.builder("buildLevel");
        zzcv zzcv13 = new zzcv();
        zzcv13.zza(13);
        zzn = builder13.withProperty(zzcv13.zzb()).build();
        FieldDescriptor.Builder builder14 = FieldDescriptor.builder("optionalModuleVersion");
        zzcv zzcv14 = new zzcv();
        zzcv14.zza(14);
        zzo = builder14.withProperty(zzcv14.zzb()).build();
    }

    private zziu() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzmy zzmy = (zzmy) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, (Object) zzmy.zzg());
        objectEncoderContext.add(zzc, (Object) zzmy.zzh());
        objectEncoderContext.add(zzd, (Object) null);
        objectEncoderContext.add(zze, (Object) zzmy.zzj());
        objectEncoderContext.add(zzf, (Object) zzmy.zzk());
        objectEncoderContext.add(zzg, (Object) null);
        objectEncoderContext.add(zzh, (Object) null);
        objectEncoderContext.add(zzi, (Object) zzmy.zza());
        objectEncoderContext.add(zzj, (Object) zzmy.zzi());
        objectEncoderContext.add(zzk, (Object) zzmy.zzb());
        objectEncoderContext.add(zzl, (Object) zzmy.zzd());
        objectEncoderContext.add(zzm, (Object) zzmy.zzc());
        objectEncoderContext.add(zzn, (Object) zzmy.zze());
        objectEncoderContext.add(zzo, (Object) zzmy.zzf());
    }
}
