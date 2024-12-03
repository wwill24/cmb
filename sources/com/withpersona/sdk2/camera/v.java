package com.withpersona.sdk2.camera;

import fj.d;
import fk.a;
import kotlin.Result;
import kotlinx.coroutines.flow.h;

public final class v implements d<SelfieDirectionFeed> {

    /* renamed from: a  reason: collision with root package name */
    private final a<SelfieProcessor> f14378a;

    /* renamed from: b  reason: collision with root package name */
    private final a<h<Result<w>>> f14379b;

    public v(a<SelfieProcessor> aVar, a<h<Result<w>>> aVar2) {
        this.f14378a = aVar;
        this.f14379b = aVar2;
    }

    public static v a(a<SelfieProcessor> aVar, a<h<Result<w>>> aVar2) {
        return new v(aVar, aVar2);
    }

    public static SelfieDirectionFeed c(SelfieProcessor selfieProcessor, h<Result<w>> hVar) {
        return new SelfieDirectionFeed(selfieProcessor, hVar);
    }

    /* renamed from: b */
    public SelfieDirectionFeed get() {
        return c(this.f14378a.get(), this.f14379b.get());
    }
}
