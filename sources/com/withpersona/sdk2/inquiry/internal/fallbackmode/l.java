package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import com.squareup.moshi.s;
import fj.d;
import fk.a;

public final class l implements d<RealFallbackModeManager> {

    /* renamed from: a  reason: collision with root package name */
    private final a<a> f26390a;

    /* renamed from: b  reason: collision with root package name */
    private final a<s> f26391b;

    public l(a<a> aVar, a<s> aVar2) {
        this.f26390a = aVar;
        this.f26391b = aVar2;
    }

    public static l a(a<a> aVar, a<s> aVar2) {
        return new l(aVar, aVar2);
    }

    public static RealFallbackModeManager c(a aVar, s sVar) {
        return new RealFallbackModeManager(aVar, sVar);
    }

    /* renamed from: b */
    public RealFallbackModeManager get() {
        return c(this.f26390a.get(), this.f26391b.get());
    }
}
