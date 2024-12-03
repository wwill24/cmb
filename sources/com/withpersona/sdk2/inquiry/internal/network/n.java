package com.withpersona.sdk2.inquiry.internal.network;

import com.withpersona.sdk2.inquiry.ui.network.b;
import fj.d;
import fj.g;
import fk.a;
import retrofit2.s;

public final class n implements d<b> {

    /* renamed from: a  reason: collision with root package name */
    private final c f26915a;

    /* renamed from: b  reason: collision with root package name */
    private final a<s> f26916b;

    public n(c cVar, a<s> aVar) {
        this.f26915a = cVar;
        this.f26916b = aVar;
    }

    public static n a(c cVar, a<s> aVar) {
        return new n(cVar, aVar);
    }

    public static b c(c cVar, s sVar) {
        return (b) g.e(cVar.j(sVar));
    }

    /* renamed from: b */
    public b get() {
        return c(this.f26915a, this.f26916b.get());
    }
}
