package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import com.withpersona.sdk2.inquiry.internal.fallbackmode.d;
import com.withpersona.sdk2.inquiry.internal.fallbackmode.i;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final d f26372a;

    public b(d dVar) {
        j.g(dVar, "params");
        this.f26372a = dVar;
    }

    public final a a(FallbackModeApiController fallbackModeApiController, i.a aVar) {
        j.g(fallbackModeApiController, "fallbackModeApiController");
        j.g(aVar, "offlineModeApiController");
        d dVar = this.f26372a;
        if (dVar instanceof d.b) {
            return aVar.a(((d.b) dVar).a());
        }
        if (dVar instanceof d.a) {
            return fallbackModeApiController;
        }
        throw new NoWhenBranchMatchedException();
    }
}
