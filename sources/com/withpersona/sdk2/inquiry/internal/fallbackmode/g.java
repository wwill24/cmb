package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import fj.d;
import ji.a;

public final class g implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final f f26380a;

    /* renamed from: b  reason: collision with root package name */
    private final fk.a<RealFallbackModeManager> f26381b;

    public g(f fVar, fk.a<RealFallbackModeManager> aVar) {
        this.f26380a = fVar;
        this.f26381b = aVar;
    }

    public static g a(f fVar, fk.a<RealFallbackModeManager> aVar) {
        return new g(fVar, aVar);
    }

    public static a b(f fVar, RealFallbackModeManager realFallbackModeManager) {
        return (a) fj.g.e(fVar.a(realFallbackModeManager));
    }

    /* renamed from: c */
    public a get() {
        return b(this.f26380a, this.f26381b.get());
    }
}
