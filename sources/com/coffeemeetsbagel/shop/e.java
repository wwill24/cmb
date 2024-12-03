package com.coffeemeetsbagel.shop;

import com.coffeemeetsbagel.shop.b;
import fj.d;
import fj.g;
import jb.a;

public final class e implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final b.C0446b f36418a;

    /* renamed from: b  reason: collision with root package name */
    private final fk.a<jb.b> f36419b;

    public e(b.C0446b bVar, fk.a<jb.b> aVar) {
        this.f36418a = bVar;
        this.f36419b = aVar;
    }

    public static a a(b.C0446b bVar, jb.b bVar2) {
        return (a) g.e(bVar.c(bVar2));
    }

    public static e b(b.C0446b bVar, fk.a<jb.b> aVar) {
        return new e(bVar, aVar);
    }

    /* renamed from: c */
    public a get() {
        return a(this.f36418a, this.f36419b.get());
    }
}
