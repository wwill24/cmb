package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

final class zzhz implements ObjectEncoder {
    static final zzhz zza = new zzhz();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("scoreType");
        zzdg zzdg = new zzdg();
        zzdg.zza(1);
        zzb = builder.withProperty(zzdg.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("score");
        zzdg zzdg2 = new zzdg();
        zzdg2.zza(2);
        zzc = builder2.withProperty(zzdg2.zzb()).build();
    }

    private zzhz() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzmt zzmt = (zzmt) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
