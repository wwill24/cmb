package com.google.android.gms.internal.mlkit_common;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzdl implements ObjectEncoder {
    static final zzdl zza = new zzdl();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("errorCode");
        zzbk zzbk = new zzbk();
        zzbk.zza(1);
        zzb = builder.withProperty(zzbk.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("hasResult");
        zzbk zzbk2 = new zzbk();
        zzbk2.zza(2);
        zzc = builder2.withProperty(zzbk2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("isColdCall");
        zzbk zzbk3 = new zzbk();
        zzbk3.zza(3);
        zzd = builder3.withProperty(zzbk3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("imageInfo");
        zzbk zzbk4 = new zzbk();
        zzbk4.zza(4);
        zze = builder4.withProperty(zzbk4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        zzbk zzbk5 = new zzbk();
        zzbk5.zza(5);
        zzf = builder5.withProperty(zzbk5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("detectedBarcodeFormats");
        zzbk zzbk6 = new zzbk();
        zzbk6.zza(6);
        zzg = builder6.withProperty(zzbk6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("detectedBarcodeValueTypes");
        zzbk zzbk7 = new zzbk();
        zzbk7.zza(7);
        zzh = builder7.withProperty(zzbk7.zzb()).build();
    }

    private zzdl() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzca zzca = (zzca) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
