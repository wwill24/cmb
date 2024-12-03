package com.google.android.gms.common.moduleinstall.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.internal.e;

final class f extends a.C0480a {
    f() {
    }

    public final /* synthetic */ a.f buildClient(Context context, Looper looper, e eVar, Object obj, com.google.android.gms.common.api.internal.f fVar, n nVar) {
        a.d.c cVar = (a.d.c) obj;
        return new j(context, looper, eVar, fVar, nVar);
    }
}
