package com.coffeemeetsbagel.new_user_experience;

import androidx.appcompat.app.c;
import com.coffeemeetsbagel.new_user_experience.h;
import fj.d;
import fj.g;
import fk.a;

public final class i implements d<c> {

    /* renamed from: a  reason: collision with root package name */
    private final h.b f35074a;

    /* renamed from: b  reason: collision with root package name */
    private final a<b6.d<?, ?>> f35075b;

    public i(h.b bVar, a<b6.d<?, ?>> aVar) {
        this.f35074a = bVar;
        this.f35075b = aVar;
    }

    public static c a(h.b bVar, b6.d<?, ?> dVar) {
        return (c) g.e(bVar.a(dVar));
    }

    public static i b(h.b bVar, a<b6.d<?, ?>> aVar) {
        return new i(bVar, aVar);
    }

    /* renamed from: c */
    public c get() {
        return a(this.f35074a, this.f35075b.get());
    }
}
