package com.withpersona.sdk2.inquiry.internal.network;

import com.withpersona.sdk2.inquiry.document.network.a;
import fj.d;
import fj.g;
import retrofit2.s;

public final class e implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final c f26902a;

    /* renamed from: b  reason: collision with root package name */
    private final fk.a<s> f26903b;

    public e(c cVar, fk.a<s> aVar) {
        this.f26902a = cVar;
        this.f26903b = aVar;
    }

    public static e a(c cVar, fk.a<s> aVar) {
        return new e(cVar, aVar);
    }

    public static a b(c cVar, s sVar) {
        return (a) g.e(cVar.a(sVar));
    }

    /* renamed from: c */
    public a get() {
        return b(this.f26902a, this.f26903b.get());
    }
}
