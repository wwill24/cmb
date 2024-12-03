package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import we.t;

final class zzdw extends zzch {
    private final t zza;

    zzdw(t tVar) {
        this.zza = tVar;
    }

    public final int zzd() {
        return System.identityHashCode(this.zza);
    }

    public final void zze(String str, String str2, Bundle bundle, long j10) {
        this.zza.onEvent(str, str2, bundle, j10);
    }
}
