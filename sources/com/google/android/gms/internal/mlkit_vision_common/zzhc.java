package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;
import org.jivesoftware.smackx.mam.element.MamElements;

final class zzhc implements ObjectEncoder {
    static final zzhc zza = new zzhc();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder(MamElements.MamResultExtension.ELEMENT);
        zzae zzae = new zzae();
        zzae.zza(1);
        zzb = builder.withProperty(zzae.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("ok");
        zzae zzae2 = new zzae();
        zzae2.zza(2);
        zzc = builder2.withProperty(zzae2.zzb()).build();
    }

    private zzhc() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzls zzls = (zzls) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
