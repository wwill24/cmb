package com.google.android.gms.internal.mlkit_vision_face;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzgb implements ObjectEncoder {
    static final zzgb zza = new zzgb();
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
        FieldDescriptor.Builder builder = FieldDescriptor.builder("sdkVersion");
        zzcq zzcq = new zzcq();
        zzcq.zza(1);
        zzb = builder.withProperty(zzcq.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("osBuild");
        zzcq zzcq2 = new zzcq();
        zzcq2.zza(2);
        zzc = builder2.withProperty(zzcq2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("brand");
        zzcq zzcq3 = new zzcq();
        zzcq3.zza(3);
        zzd = builder3.withProperty(zzcq3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder(DeviceRequestsHelper.DEVICE_INFO_DEVICE);
        zzcq zzcq4 = new zzcq();
        zzcq4.zza(4);
        zze = builder4.withProperty(zzcq4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("hardware");
        zzcq zzcq5 = new zzcq();
        zzcq5.zza(5);
        zzf = builder5.withProperty(zzcq5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("manufacturer");
        zzcq zzcq6 = new zzcq();
        zzcq6.zza(6);
        zzg = builder6.withProperty(zzcq6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder(DeviceRequestsHelper.DEVICE_INFO_MODEL);
        zzcq zzcq7 = new zzcq();
        zzcq7.zza(7);
        zzh = builder7.withProperty(zzcq7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("product");
        zzcq zzcq8 = new zzcq();
        zzcq8.zza(8);
        zzi = builder8.withProperty(zzcq8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("soc");
        zzcq zzcq9 = new zzcq();
        zzcq9.zza(9);
        zzj = builder9.withProperty(zzcq9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("socMetaBuildId");
        zzcq zzcq10 = new zzcq();
        zzcq10.zza(10);
        zzk = builder10.withProperty(zzcq10.zzb()).build();
    }

    private zzgb() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzna zzna = (zzna) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
