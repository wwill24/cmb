package com.google.android.gms.internal.mlkit_common;

import cd.b;
import cd.f;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class zzpt implements Provider {
    public final /* synthetic */ f zza;

    public /* synthetic */ zzpt(f fVar) {
        this.zza = fVar;
    }

    public final Object get() {
        return this.zza.a("FIREBASE_ML_SDK", byte[].class, b.b("proto"), zzpr.zza);
    }
}
