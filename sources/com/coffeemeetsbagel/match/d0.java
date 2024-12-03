package com.coffeemeetsbagel.match;

import fj.d;
import fj.g;
import fk.a;
import hb.c;
import nc.b;

public final class d0 implements d<w> {

    /* renamed from: a  reason: collision with root package name */
    private final a<c> f34502a;

    /* renamed from: b  reason: collision with root package name */
    private final a<b> f34503b;

    public d0(a<c> aVar, a<b> aVar2) {
        this.f34502a = aVar;
        this.f34503b = aVar2;
    }

    public static w a(c cVar, b bVar) {
        return (w) g.e(c0.f34498a.a(cVar, bVar));
    }

    public static d0 b(a<c> aVar, a<b> aVar2) {
        return new d0(aVar, aVar2);
    }

    /* renamed from: c */
    public w get() {
        return a(this.f34502a.get(), this.f34503b.get());
    }
}
