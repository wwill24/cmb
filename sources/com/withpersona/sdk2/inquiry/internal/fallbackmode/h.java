package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import fj.d;
import fj.g;
import fk.a;
import retrofit2.s;

public final class h implements d<FallbackModeService> {

    /* renamed from: a  reason: collision with root package name */
    private final f f26382a;

    /* renamed from: b  reason: collision with root package name */
    private final a<s> f26383b;

    public h(f fVar, a<s> aVar) {
        this.f26382a = fVar;
        this.f26383b = aVar;
    }

    public static h a(f fVar, a<s> aVar) {
        return new h(fVar, aVar);
    }

    public static FallbackModeService b(f fVar, s sVar) {
        return (FallbackModeService) g.e(fVar.b(sVar));
    }

    /* renamed from: c */
    public FallbackModeService get() {
        return b(this.f26382a, this.f26383b.get());
    }
}
