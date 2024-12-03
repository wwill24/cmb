package com.google.android.gms.internal.mlkit_common;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzfy implements ObjectEncoder {
    static final zzfy zza = new zzfy();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        zzbk zzbk = new zzbk();
        zzbk.zza(1);
        zzb = builder.withProperty(zzbk.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("errorCode");
        zzbk zzbk2 = new zzbk();
        zzbk2.zza(2);
        zzc = builder2.withProperty(zzbk2.zzb()).build();
    }

    private zzfy() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzkp zzkp = (zzkp) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
