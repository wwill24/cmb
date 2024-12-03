package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzgm implements ObjectEncoder {
    static final zzgm zza = new zzgm();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("imageFormat");
        zzcv zzcv = new zzcv();
        zzcv.zza(1);
        zzb = builder.withProperty(zzcv.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("originalImageSize");
        zzcv zzcv2 = new zzcv();
        zzcv2.zza(2);
        zzc = builder2.withProperty(zzcv2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("compressedImageSize");
        zzcv zzcv3 = new zzcv();
        zzcv3.zza(3);
        zzd = builder3.withProperty(zzcv3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("isOdmlImage");
        zzcv zzcv4 = new zzcv();
        zzcv4.zza(4);
        zze = builder4.withProperty(zzcv4.zzb()).build();
    }

    private zzgm() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzkh zzkh = (zzkh) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, (Object) zzkh.zza());
        objectEncoderContext.add(zzc, (Object) zzkh.zzb());
        objectEncoderContext.add(zzd, (Object) null);
        objectEncoderContext.add(zze, (Object) null);
    }
}
