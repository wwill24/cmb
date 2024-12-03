package com.google.android.gms.internal.auth;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.tasks.Task;
import vd.b;

public final class zzbo extends c {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbo(@NonNull Activity activity, vd.c cVar) {
        super(activity, b.f42094a, cVar == null ? vd.c.f42098b : cVar, c.a.f38516c);
    }

    public final Task<String> getSpatulaHeader() {
        return doRead(v.a().b(new zzbk(this)).e(1520).a());
    }

    public final Task<ProxyResponse> performProxyRequest(@NonNull ProxyRequest proxyRequest) {
        return doWrite(v.a().b(new zzbl(this, proxyRequest)).e(1518).a());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbo(@NonNull Context context, vd.c cVar) {
        super(context, b.f42094a, cVar == null ? vd.c.f42098b : cVar, c.a.f38516c);
    }
}
