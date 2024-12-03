package com.google.android.gms.internal.auth;

import ae.a;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.p;

public final class zzbt implements a {
    public final f<Object> getSpatulaHeader(d dVar) {
        p.k(dVar);
        return dVar.h(new zzbs(this, dVar));
    }

    public final f<Object> performProxyRequest(d dVar, ProxyRequest proxyRequest) {
        p.k(dVar);
        p.k(proxyRequest);
        return dVar.h(new zzbq(this, dVar, proxyRequest));
    }
}
