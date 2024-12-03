package com.coffeemeetsbagel.today_view.card.actioncards;

import com.coffeemeetsbagel.today_view.card.actioncards.b;
import fj.d;
import fj.g;
import fk.a;

public final class e implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final b.C0463b f37295a;

    /* renamed from: b  reason: collision with root package name */
    private final a<a7.a> f37296b;

    public e(b.C0463b bVar, a<a7.a> aVar) {
        this.f37295a = bVar;
        this.f37296b = aVar;
    }

    public static a a(b.C0463b bVar, a7.a aVar) {
        return (a) g.e(bVar.c(aVar));
    }

    public static e b(b.C0463b bVar, a<a7.a> aVar) {
        return new e(bVar, aVar);
    }

    /* renamed from: c */
    public a get() {
        return a(this.f37295a, this.f37296b.get());
    }
}
