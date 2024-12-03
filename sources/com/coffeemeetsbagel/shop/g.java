package com.coffeemeetsbagel.shop;

import com.coffeemeetsbagel.shop.b;
import fj.d;
import fk.a;
import jb.c;

public final class g implements d<c> {

    /* renamed from: a  reason: collision with root package name */
    private final b.C0446b f36421a;

    /* renamed from: b  reason: collision with root package name */
    private final a<jb.b> f36422b;

    public g(b.C0446b bVar, a<jb.b> aVar) {
        this.f36421a = bVar;
        this.f36422b = aVar;
    }

    public static c a(b.C0446b bVar, jb.b bVar2) {
        return (c) fj.g.e(bVar.e(bVar2));
    }

    public static g b(b.C0446b bVar, a<jb.b> aVar) {
        return new g(bVar, aVar);
    }

    /* renamed from: c */
    public c get() {
        return a(this.f36421a, this.f36422b.get());
    }
}
