package com.coffeemeetsbagel.store.alc;

import fj.d;
import fk.a;

public final class h<T> implements d<PurchaseRepository<T>> {

    /* renamed from: a  reason: collision with root package name */
    private final a<c7.d> f36777a;

    public h(a<c7.d> aVar) {
        this.f36777a = aVar;
    }

    public static <T> h<T> a(a<c7.d> aVar) {
        return new h<>(aVar);
    }

    public static <T> PurchaseRepository<T> c(c7.d dVar) {
        return new PurchaseRepository<>(dVar);
    }

    /* renamed from: b */
    public PurchaseRepository<T> get() {
        return c(this.f36777a.get());
    }
}
