package com.google.android.gms.internal.mlkit_vision_face;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
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
    private static final FieldDescriptor zzn;
    private static final FieldDescriptor zzo;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("appId");
        zzcq zzcq = new zzcq();
        zzcq.zza(1);
        zzb = builder.withProperty(zzcq.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder(RemoteConfigConstants.RequestFieldKey.APP_VERSION);
        zzcq zzcq2 = new zzcq();
        zzcq2.zza(2);
        zzc = builder2.withProperty(zzcq2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("firebaseProjectId");
        zzcq zzcq3 = new zzcq();
        zzcq3.zza(3);
        zzd = builder3.withProperty(zzcq3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("mlSdkVersion");
        zzcq zzcq4 = new zzcq();
        zzcq4.zza(4);
        zze = builder4.withProperty(zzcq4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("tfliteSchemaVersion");
        zzcq zzcq5 = new zzcq();
        zzcq5.zza(5);
        zzf = builder5.withProperty(zzcq5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("gcmSenderId");
        zzcq zzcq6 = new zzcq();
        zzcq6.zza(6);
        zzg = builder6.withProperty(zzcq6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("apiKey");
        zzcq zzcq7 = new zzcq();
        zzcq7.zza(7);
        zzh = builder7.withProperty(zzcq7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("languages");
        zzcq zzcq8 = new zzcq();
        zzcq8.zza(8);
        zzi = builder8.withProperty(zzcq8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("mlSdkInstanceId");
        zzcq zzcq9 = new zzcq();
        zzcq9.zza(9);
        zzj = builder9.withProperty(zzcq9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("isClearcutClient");
        zzcq zzcq10 = new zzcq();
        zzcq10.zza(10);
        zzk = builder10.withProperty(zzcq10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("isStandaloneMlkit");
        zzcq zzcq11 = new zzcq();
        zzcq11.zza(11);
        zzl = builder11.withProperty(zzcq11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("isJsonLogging");
        zzcq zzcq12 = new zzcq();
        zzcq12.zza(12);
        zzm = builder12.withProperty(zzcq12.zzb()).build();
        FieldDescriptor.Builder builder13 = FieldDescriptor.builder("buildLevel");
        zzcq zzcq13 = new zzcq();
        zzcq13.zza(13);
        zzn = builder13.withProperty(zzcq13.zzb()).build();
        FieldDescriptor.Builder builder14 = FieldDescriptor.builder("optionalModuleVersion");
        zzcq zzcq14 = new zzcq();
        zzcq14.zza(14);
        zzo = builder14.withProperty(zzcq14.zzb()).build();
    }

    private zzip() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzmv zzmv = (zzmv) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, (Object) zzmv.zzg());
        objectEncoderContext.add(zzc, (Object) zzmv.zzh());
        objectEncoderContext.add(zzd, (Object) null);
        objectEncoderContext.add(zze, (Object) zzmv.zzj());
        objectEncoderContext.add(zzf, (Object) zzmv.zzk());
        objectEncoderContext.add(zzg, (Object) null);
        objectEncoderContext.add(zzh, (Object) null);
        objectEncoderContext.add(zzi, (Object) zzmv.zza());
        objectEncoderContext.add(zzj, (Object) zzmv.zzi());
        objectEncoderContext.add(zzk, (Object) zzmv.zzb());
        objectEncoderContext.add(zzl, (Object) zzmv.zzd());
        objectEncoderContext.add(zzm, (Object) zzmv.zzc());
        objectEncoderContext.add(zzn, (Object) zzmv.zze());
        objectEncoderContext.add(zzo, (Object) zzmv.zzf());
    }
}
