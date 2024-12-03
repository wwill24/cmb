package com.withpersona.sdk2.inquiry.internal.network;

import fj.d;
import fk.a;
import retrofit2.s;

public final class g implements d<p> {

    /* renamed from: a  reason: collision with root package name */
    private final c f26906a;

    /* renamed from: b  reason: collision with root package name */
    private final a<s> f26907b;

    public g(c cVar, a<s> aVar) {
        this.f26906a = cVar;
        this.f26907b = aVar;
    }

    public static g a(c cVar, a<s> aVar) {
        return new g(cVar, aVar);
    }

    public static p c(c cVar, s sVar) {
        return (p) fj.g.e(cVar.c(sVar));
    }

    /* renamed from: b */
    public p get() {
        return c(this.f26906a, this.f26907b.get());
    }
}
