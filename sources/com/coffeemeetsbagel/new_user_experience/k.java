package com.coffeemeetsbagel.new_user_experience;

import com.coffeemeetsbagel.new_user_experience.h;
import fj.d;
import fj.g;
import fk.a;
import na.b;
import na.c;

public final class k implements d<b> {

    /* renamed from: a  reason: collision with root package name */
    private final h.b f35109a;

    /* renamed from: b  reason: collision with root package name */
    private final a<c> f35110b;

    public k(h.b bVar, a<c> aVar) {
        this.f35109a = bVar;
        this.f35110b = aVar;
    }

    public static k a(h.b bVar, a<c> aVar) {
        return new k(bVar, aVar);
    }

    public static b c(h.b bVar, c cVar) {
        return (b) g.e(bVar.c(cVar));
    }

    /* renamed from: b */
    public b get() {
        return c(this.f35109a, this.f35110b.get());
    }
}
