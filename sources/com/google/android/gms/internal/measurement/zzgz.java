package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

final class zzgz extends ContentObserver {
    zzgz(Handler handler) {
        super((Handler) null);
    }

    public final void onChange(boolean z10) {
        zzha.zzl.set(true);
    }
}
