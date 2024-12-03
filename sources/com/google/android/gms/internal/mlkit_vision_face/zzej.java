package com.google.android.gms.internal.mlkit_vision_face;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzej implements ObjectEncoder {
    static final zzej zza = new zzej();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("errorCode");
        zzcq zzcq = new zzcq();
        zzcq.zza(1);
        zzb = builder.withProperty(zzcq.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("isColdCall");
        zzcq zzcq2 = new zzcq();
        zzcq2.zza(2);
        zzc = builder2.withProperty(zzcq2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("inputsFormats");
        zzcq zzcq3 = new zzcq();
        zzcq3.zza(3);
        zzd = builder3.withProperty(zzcq3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("outputFormats");
        zzcq zzcq4 = new zzcq();
        zzcq4.zza(4);
        zze = builder4.withProperty(zzcq4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        zzcq zzcq5 = new zzcq();
        zzcq5.zza(5);
        zzf = builder5.withProperty(zzcq5.zzb()).build();
    }

    private zzej() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzde zzde = (zzde) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
