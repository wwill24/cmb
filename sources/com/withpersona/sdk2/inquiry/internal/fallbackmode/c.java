package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import com.withpersona.sdk2.inquiry.internal.fallbackmode.i;
import fj.d;
import fj.g;
import fk.a;

public final class c implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final b f26373a;

    /* renamed from: b  reason: collision with root package name */
    private final a<FallbackModeApiController> f26374b;

    /* renamed from: c  reason: collision with root package name */
    private final a<i.a> f26375c;

    public c(b bVar, a<FallbackModeApiController> aVar, a<i.a> aVar2) {
        this.f26373a = bVar;
        this.f26374b = aVar;
        this.f26375c = aVar2;
    }

    public static a a(b bVar, FallbackModeApiController fallbackModeApiController, i.a aVar) {
        return (a) g.e(bVar.a(fallbackModeApiController, aVar));
    }

    public static c b(b bVar, a<FallbackModeApiController> aVar, a<i.a> aVar2) {
        return new c(bVar, aVar, aVar2);
    }

    /* renamed from: c */
    public a get() {
        return a(this.f26373a, this.f26374b.get(), this.f26375c.get());
    }
}
