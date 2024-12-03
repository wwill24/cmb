package com.google.android.gms.internal.mlkit_vision_common;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzfr implements ObjectEncoder {
    static final zzfr zza = new zzfr();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        zzae zzae = new zzae();
        zzae.zza(1);
        zzb = builder.withProperty(zzae.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("errorCode");
        zzae zzae2 = new zzae();
        zzae2.zza(2);
        zzc = builder2.withProperty(zzae2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("durationMs");
        zzae zzae3 = new zzae();
        zzae3.zza(3);
        zzd = builder3.withProperty(zzae3.zzb()).build();
    }

    private zzfr() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzjz zzjz = (zzjz) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
