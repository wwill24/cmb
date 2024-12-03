package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import com.squareup.moshi.s;
import fj.d;
import fk.a;

public final class e implements d<FallbackModeApiController> {

    /* renamed from: a  reason: collision with root package name */
    private final a<FallbackModeService> f26378a;

    /* renamed from: b  reason: collision with root package name */
    private final a<s> f26379b;

    public e(a<FallbackModeService> aVar, a<s> aVar2) {
        this.f26378a = aVar;
        this.f26379b = aVar2;
    }

    public static e a(a<FallbackModeService> aVar, a<s> aVar2) {
        return new e(aVar, aVar2);
    }

    public static FallbackModeApiController c(FallbackModeService fallbackModeService, s sVar) {
        return new FallbackModeApiController(fallbackModeService, sVar);
    }

    /* renamed from: b */
    public FallbackModeApiController get() {
        return c(this.f26378a.get(), this.f26379b.get());
    }
}
