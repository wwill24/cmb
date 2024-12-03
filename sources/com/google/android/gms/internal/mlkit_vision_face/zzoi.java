package com.google.android.gms.internal.mlkit_vision_face;

import cd.b;
import cd.f;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class zzoi implements Provider {
    public final /* synthetic */ f zza;

    public /* synthetic */ zzoi(f fVar) {
        this.zza = fVar;
    }

    public final Object get() {
        return this.zza.a("FIREBASE_ML_SDK", byte[].class, b.b("proto"), zzog.zza);
    }
}
