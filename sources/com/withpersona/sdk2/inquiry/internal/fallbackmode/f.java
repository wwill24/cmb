package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import ji.a;
import kotlin.jvm.internal.j;
import retrofit2.s;

public final class f {
    public final a a(RealFallbackModeManager realFallbackModeManager) {
        j.g(realFallbackModeManager, "fallbackModeManager");
        return realFallbackModeManager;
    }

    public final FallbackModeService b(s sVar) {
        j.g(sVar, "retrofit");
        Object b10 = sVar.b(FallbackModeService.class);
        j.f(b10, "retrofit.create(FallbackModeService::class.java)");
        return (FallbackModeService) b10;
    }
}
