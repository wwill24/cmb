package com.google.android.gms.internal.mlkit_vision_face;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzep implements ObjectEncoder {
    static final zzep zza = new zzep();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("errorCode");
        zzcq zzcq = new zzcq();
        zzcq.zza(1);
        zzb = builder.withProperty(zzcq.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("isColdCall");
        zzcq zzcq2 = new zzcq();
        zzcq2.zza(2);
        zzc = builder2.withProperty(zzcq2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("imageInfo");
        zzcq zzcq3 = new zzcq();
        zzcq3.zza(3);
        zzd = builder3.withProperty(zzcq3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("detectorOptions");
        zzcq zzcq4 = new zzcq();
        zzcq4.zza(4);
        zze = builder4.withProperty(zzcq4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("contourDetectedFaces");
        zzcq zzcq5 = new zzcq();
        zzcq5.zza(5);
        zzf = builder5.withProperty(zzcq5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("nonContourDetectedFaces");
        zzcq zzcq6 = new zzcq();
        zzcq6.zza(6);
        zzg = builder6.withProperty(zzcq6.zzb()).build();
    }

    private zzep() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzdn zzdn = (zzdn) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, (Object) zzdn.zzb());
        objectEncoderContext.add(zzc, (Object) zzdn.zzc());
        objectEncoderContext.add(zzd, (Object) null);
        objectEncoderContext.add(zze, (Object) zzdn.zza());
        objectEncoderContext.add(zzf, (Object) zzdn.zzd());
        objectEncoderContext.add(zzg, (Object) zzdn.zze());
    }
}
