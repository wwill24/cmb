package com.google.android.gms.internal.p001authapiphone;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.internal.e;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzn  reason: invalid package */
final class zzn extends a.C0480a<zzw, a.d.c> {
    zzn() {
    }

    public final /* bridge */ /* synthetic */ a.f buildClient(Context context, Looper looper, e eVar, Object obj, f fVar, n nVar) {
        a.d.c cVar = (a.d.c) obj;
        return new zzw(context, looper, eVar, fVar, nVar);
    }
}
