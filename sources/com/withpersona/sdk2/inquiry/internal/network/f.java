package com.withpersona.sdk2.inquiry.internal.network;

import com.withpersona.sdk2.inquiry.governmentid.network.b;
import fj.d;
import fj.g;
import fk.a;
import retrofit2.s;

public final class f implements d<b> {

    /* renamed from: a  reason: collision with root package name */
    private final c f26904a;

    /* renamed from: b  reason: collision with root package name */
    private final a<s> f26905b;

    public f(c cVar, a<s> aVar) {
        this.f26904a = cVar;
        this.f26905b = aVar;
    }

    public static f a(c cVar, a<s> aVar) {
        return new f(cVar, aVar);
    }

    public static b c(c cVar, s sVar) {
        return (b) g.e(cVar.b(sVar));
    }

    /* renamed from: b */
    public b get() {
        return c(this.f26904a, this.f26905b.get());
    }
}
