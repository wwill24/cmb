package com.google.android.gms.internal.mlkit_vision_barcode;

import cd.b;
import cd.f;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class zzrr implements Provider {
    public final /* synthetic */ f zza;

    public /* synthetic */ zzrr(f fVar) {
        this.zza = fVar;
    }

    public final Object get() {
        return this.zza.a("FIREBASE_ML_SDK", byte[].class, b.b("proto"), zzrp.zza);
    }
}
