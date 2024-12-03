package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.IOException;

final class zzkx implements ObjectEncoder {
    static final zzkx zza = new zzkx();
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
        zzdg zzdg = new zzdg();
        zzdg.zza(1);
        zzb = builder.withProperty(zzdg.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder(RemoteConfigConstants.RequestFieldKey.APP_VERSION);
        zzdg zzdg2 = new zzdg();
        zzdg2.zza(2);
        zzc = builder2.withProperty(zzdg2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("firebaseProjectId");
        zzdg zzdg3 = new zzdg();
        zzdg3.zza(3);
        zzd = builder3.withProperty(zzdg3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("mlSdkVersion");
        zzdg zzdg4 = new zzdg();
        zzdg4.zza(4);
        zze = builder4.withProperty(zzdg4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("tfliteSchemaVersion");
        zzdg zzdg5 = new zzdg();
        zzdg5.zza(5);
        zzf = builder5.withProperty(zzdg5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("gcmSenderId");
        zzdg zzdg6 = new zzdg();
        zzdg6.zza(6);
        zzg = builder6.withProperty(zzdg6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("apiKey");
        zzdg zzdg7 = new zzdg();
        zzdg7.zza(7);
        zzh = builder7.withProperty(zzdg7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("languages");
        zzdg zzdg8 = new zzdg();
        zzdg8.zza(8);
        zzi = builder8.withProperty(zzdg8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("mlSdkInstanceId");
        zzdg zzdg9 = new zzdg();
        zzdg9.zza(9);
        zzj = builder9.withProperty(zzdg9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("isClearcutClient");
        zzdg zzdg10 = new zzdg();
        zzdg10.zza(10);
        zzk = builder10.withProperty(zzdg10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("isStandaloneMlkit");
        zzdg zzdg11 = new zzdg();
        zzdg11.zza(11);
        zzl = builder11.withProperty(zzdg11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("isJsonLogging");
        zzdg zzdg12 = new zzdg();
        zzdg12.zza(12);
        zzm = builder12.withProperty(zzdg12.zzb()).build();
        FieldDescriptor.Builder builder13 = FieldDescriptor.builder("buildLevel");
        zzdg zzdg13 = new zzdg();
        zzdg13.zza(13);
        zzn = builder13.withProperty(zzdg13.zzb()).build();
        FieldDescriptor.Builder builder14 = FieldDescriptor.builder("optionalModuleVersion");
        zzdg zzdg14 = new zzdg();
        zzdg14.zza(14);
        zzo = builder14.withProperty(zzdg14.zzb()).build();
    }

    private zzkx() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzpz zzpz = (zzpz) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, (Object) zzpz.zzg());
        objectEncoderContext.add(zzc, (Object) zzpz.zzh());
        objectEncoderContext.add(zzd, (Object) null);
        objectEncoderContext.add(zze, (Object) zzpz.zzj());
        objectEncoderContext.add(zzf, (Object) zzpz.zzk());
        objectEncoderContext.add(zzg, (Object) null);
        objectEncoderContext.add(zzh, (Object) null);
        objectEncoderContext.add(zzi, (Object) zzpz.zza());
        objectEncoderContext.add(zzj, (Object) zzpz.zzi());
        objectEncoderContext.add(zzk, (Object) zzpz.zzb());
        objectEncoderContext.add(zzl, (Object) zzpz.zzd());
        objectEncoderContext.add(zzm, (Object) zzpz.zzc());
        objectEncoderContext.add(zzn, (Object) zzpz.zze());
        objectEncoderContext.add(zzo, (Object) zzpz.zzf());
    }
}
