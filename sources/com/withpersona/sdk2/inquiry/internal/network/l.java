package com.withpersona.sdk2.inquiry.internal.network;

import com.withpersona.sdk2.inquiry.selfie.network.a;
import fj.d;
import fj.g;
import retrofit2.s;

public final class l implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final c f26912a;

    /* renamed from: b  reason: collision with root package name */
    private final fk.a<s> f26913b;

    public l(c cVar, fk.a<s> aVar) {
        this.f26912a = cVar;
        this.f26913b = aVar;
    }

    public static l a(c cVar, fk.a<s> aVar) {
        return new l(cVar, aVar);
    }

    public static a c(c cVar, s sVar) {
        return (a) g.e(cVar.h(sVar));
    }

    /* renamed from: b */
    public a get() {
        return c(this.f26912a, this.f26913b.get());
    }
}
