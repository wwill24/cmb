package com.coffeemeetsbagel.new_user_experience;

import com.coffeemeetsbagel.new_user_experience.h;
import fj.d;
import fj.g;
import na.a;
import na.c;

public final class j implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final h.b f35107a;

    /* renamed from: b  reason: collision with root package name */
    private final fk.a<c> f35108b;

    public j(h.b bVar, fk.a<c> aVar) {
        this.f35107a = bVar;
        this.f35108b = aVar;
    }

    public static j a(h.b bVar, fk.a<c> aVar) {
        return new j(bVar, aVar);
    }

    public static a b(h.b bVar, c cVar) {
        return (a) g.e(bVar.b(cVar));
    }

    /* renamed from: c */
    public a get() {
        return b(this.f35107a, this.f35108b.get());
    }
}
