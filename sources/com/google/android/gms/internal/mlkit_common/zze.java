package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import androidx.core.content.g;

final class zze extends zzs {
    zze() {
    }

    /* access modifiers changed from: protected */
    public final int zza(Context context, zzr zzr, boolean z10) {
        if (zzr.zza.getAuthority().lastIndexOf(64) < 0 || g.b(context, "android.permission.INTERACT_ACROSS_USERS") != 0) {
            return 3;
        }
        return 2;
    }
}
