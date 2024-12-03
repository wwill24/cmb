package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.internal.e;

final class zzv extends a.C0480a {
    zzv() {
    }

    public final /* synthetic */ a.f buildClient(Context context, Looper looper, e eVar, Object obj, f fVar, n nVar) {
        a.d.c cVar = (a.d.c) obj;
        return new zzi(context, looper, eVar, fVar, nVar);
    }
}
