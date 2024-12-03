package com.google.android.gms.internal.mlkit_vision_text_common;

import cd.b;
import cd.f;
import com.google.firebase.inject.Provider;
import org.jivesoftware.smackx.json.packet.JsonPacketExtension;

public final /* synthetic */ class zzol implements Provider {
    public final /* synthetic */ f zza;

    public /* synthetic */ zzol(f fVar) {
        this.zza = fVar;
    }

    public final Object get() {
        return this.zza.a("FIREBASE_ML_SDK", byte[].class, b.b(JsonPacketExtension.ELEMENT), zzon.zza);
    }
}
