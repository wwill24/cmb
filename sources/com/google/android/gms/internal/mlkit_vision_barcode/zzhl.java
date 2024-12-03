package com.google.android.gms.internal.mlkit_vision_barcode;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzhl implements ObjectEncoder {
    static final zzhl zza = new zzhl();
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
        zzdg zzdg = new zzdg();
        zzdg.zza(1);
        zzb = builder.withProperty(zzdg.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("osBuild");
        zzdg zzdg2 = new zzdg();
        zzdg2.zza(2);
        zzc = builder2.withProperty(zzdg2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("brand");
        zzdg zzdg3 = new zzdg();
        zzdg3.zza(3);
        zzd = builder3.withProperty(zzdg3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder(DeviceRequestsHelper.DEVICE_INFO_DEVICE);
        zzdg zzdg4 = new zzdg();
        zzdg4.zza(4);
        zze = builder4.withProperty(zzdg4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("hardware");
        zzdg zzdg5 = new zzdg();
        zzdg5.zza(5);
        zzf = builder5.withProperty(zzdg5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("manufacturer");
        zzdg zzdg6 = new zzdg();
        zzdg6.zza(6);
        zzg = builder6.withProperty(zzdg6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder(DeviceRequestsHelper.DEVICE_INFO_MODEL);
        zzdg zzdg7 = new zzdg();
        zzdg7.zza(7);
        zzh = builder7.withProperty(zzdg7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("product");
        zzdg zzdg8 = new zzdg();
        zzdg8.zza(8);
        zzi = builder8.withProperty(zzdg8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("soc");
        zzdg zzdg9 = new zzdg();
        zzdg9.zza(9);
        zzj = builder9.withProperty(zzdg9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("socMetaBuildId");
        zzdg zzdg10 = new zzdg();
        zzdg10.zza(10);
        zzk = builder10.withProperty(zzdg10.zzb()).build();
    }

    private zzhl() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzqg zzqg = (zzqg) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
