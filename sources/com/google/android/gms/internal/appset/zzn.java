package com.google.android.gms.internal.appset;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.internal.e;

final class zzn extends a.C0480a<zzd, a.d.c> {
    zzn() {
    }

    public final /* synthetic */ a.f buildClient(Context context, Looper looper, e eVar, Object obj, f fVar, n nVar) {
        a.d.c cVar = (a.d.c) obj;
        return new zzd(context, looper, eVar, fVar, nVar);
    }
}
