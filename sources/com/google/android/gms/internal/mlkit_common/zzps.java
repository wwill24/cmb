package com.google.android.gms.internal.mlkit_common;

import cd.b;
import cd.f;
import com.google.firebase.inject.Provider;
import org.jivesoftware.smackx.json.packet.JsonPacketExtension;

public final /* synthetic */ class zzps implements Provider {
    public final /* synthetic */ f zza;

    public /* synthetic */ zzps(f fVar) {
        this.zza = fVar;
    }

    public final Object get() {
        return this.zza.a("FIREBASE_ML_SDK", byte[].class, b.b(JsonPacketExtension.ELEMENT), zzpu.zza);
    }
}
