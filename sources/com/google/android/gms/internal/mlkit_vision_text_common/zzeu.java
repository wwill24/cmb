package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzeu implements ObjectEncoder {
    static final zzeu zza = new zzeu();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("errorCode");
        zzcv zzcv = new zzcv();
        zzcv.zza(1);
        zzb = builder.withProperty(zzcv.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("isColdCall");
        zzcv zzcv2 = new zzcv();
        zzcv2.zza(2);
        zzc = builder2.withProperty(zzcv2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("imageInfo");
        zzcv zzcv3 = new zzcv();
        zzcv3.zza(3);
        zzd = builder3.withProperty(zzcv3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("detectorOptions");
        zzcv zzcv4 = new zzcv();
        zzcv4.zza(4);
        zze = builder4.withProperty(zzcv4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("contourDetectedFaces");
        zzcv zzcv5 = new zzcv();
        zzcv5.zza(5);
        zzf = builder5.withProperty(zzcv5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("nonContourDetectedFaces");
        zzcv zzcv6 = new zzcv();
        zzcv6.zza(6);
        zzg = builder6.withProperty(zzcv6.zzb()).build();
    }

    private zzeu() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzdp zzdp = (zzdp) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
