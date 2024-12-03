package com.coffeemeetsbagel.bakery;

import android.content.Context;
import fj.d;
import fj.g;
import fk.a;
import hb.c;

public final class l implements d<e7.d> {

    /* renamed from: a  reason: collision with root package name */
    private final a<a7.a> f11263a;

    /* renamed from: b  reason: collision with root package name */
    private final a<Context> f11264b;

    /* renamed from: c  reason: collision with root package name */
    private final a<c> f11265c;

    public l(a<a7.a> aVar, a<Context> aVar2, a<c> aVar3) {
        this.f11263a = aVar;
        this.f11264b = aVar2;
        this.f11265c = aVar3;
    }

    public static e7.d a(a7.a aVar, Context context, c cVar) {
        return (e7.d) g.e(c.i(aVar, context, cVar));
    }

    public static l b(a<a7.a> aVar, a<Context> aVar2, a<c> aVar3) {
        return new l(aVar, aVar2, aVar3);
    }

    /* renamed from: c */
    public e7.d get() {
        return a(this.f11263a.get(), this.f11264b.get(), this.f11265c.get());
    }
}
