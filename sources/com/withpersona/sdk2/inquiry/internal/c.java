package com.withpersona.sdk2.inquiry.internal;

import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.p;
import fj.d;
import fk.a;

public final class c implements d<ErrorReportingManager> {

    /* renamed from: a  reason: collision with root package name */
    private final a<p> f26326a;

    /* renamed from: b  reason: collision with root package name */
    private final a<s> f26327b;

    public c(a<p> aVar, a<s> aVar2) {
        this.f26326a = aVar;
        this.f26327b = aVar2;
    }

    public static c a(a<p> aVar, a<s> aVar2) {
        return new c(aVar, aVar2);
    }

    public static ErrorReportingManager c(p pVar, s sVar) {
        return new ErrorReportingManager(pVar, sVar);
    }

    /* renamed from: b */
    public ErrorReportingManager get() {
        return c(this.f26326a.get(), this.f26327b.get());
    }
}
