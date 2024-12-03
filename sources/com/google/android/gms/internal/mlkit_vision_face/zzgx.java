package com.google.android.gms.internal.mlkit_vision_face;

import com.facebook.internal.ServerProtocol;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzgx implements ObjectEncoder {
    static final zzgx zza = new zzgx();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("name");
        zzcq zzcq = new zzcq();
        zzcq.zza(1);
        zzb = builder.withProperty(zzcq.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("type");
        zzcq zzcq2 = new zzcq();
        zzcq2.zza(2);
        zzc = builder2.withProperty(zzcq2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
        zzcq zzcq3 = new zzcq();
        zzcq3.zza(3);
        zzd = builder3.withProperty(zzcq3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("featureLevel");
        zzcq zzcq4 = new zzcq();
        zzcq4.zza(4);
        zze = builder4.withProperty(zzcq4.zzb()).build();
    }

    private zzgx() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zznd zznd = (zznd) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
