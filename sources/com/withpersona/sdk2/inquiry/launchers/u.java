package com.withpersona.sdk2.inquiry.launchers;

import androidx.activity.result.b;
import androidx.activity.result.c;
import c.a;
import kotlin.jvm.internal.j;

public final class u<I, O> extends c<I> {

    /* renamed from: a  reason: collision with root package name */
    private final a<I, O> f26972a;

    /* renamed from: b  reason: collision with root package name */
    private final androidx.activity.result.a<O> f26973b;

    /* renamed from: c  reason: collision with root package name */
    private c<I> f26974c;

    public u(a<I, O> aVar, androidx.activity.result.a<O> aVar2) {
        j.g(aVar, "contract");
        j.g(aVar2, "callback");
        this.f26972a = aVar;
        this.f26973b = aVar2;
    }

    public a<I, ?> a() {
        return this.f26972a;
    }

    public void c(I i10, androidx.core.app.c cVar) {
        c<I> cVar2 = this.f26974c;
        if (cVar2 != null) {
            cVar2.c(i10, cVar);
        }
    }

    public void d() {
        c<I> cVar = this.f26974c;
        if (cVar != null) {
            cVar.d();
        }
    }

    public final void e(b bVar) {
        j.g(bVar, "activityResultCaller");
        this.f26974c = bVar.registerForActivityResult(this.f26972a, this.f26973b);
    }
}
