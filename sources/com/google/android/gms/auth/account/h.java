package com.google.android.gms.auth.account;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.internal.auth.zzam;

final class h extends a.C0480a {
    h() {
    }

    public final /* synthetic */ a.f buildClient(Context context, Looper looper, e eVar, Object obj, d.b bVar, d.c cVar) {
        a.d.c cVar2 = (a.d.c) obj;
        return new zzam(context, looper, eVar, bVar, cVar);
    }
}
