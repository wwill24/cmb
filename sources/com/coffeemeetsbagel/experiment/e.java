package com.coffeemeetsbagel.experiment;

import fj.d;
import fj.g;
import fk.a;

public final class e implements d<s> {

    /* renamed from: a  reason: collision with root package name */
    private final a f12648a;

    /* renamed from: b  reason: collision with root package name */
    private final a<c7.d> f12649b;

    public e(a aVar, a<c7.d> aVar2) {
        this.f12648a = aVar;
        this.f12649b = aVar2;
    }

    public static e a(a aVar, a<c7.d> aVar2) {
        return new e(aVar, aVar2);
    }

    public static s b(a aVar, c7.d dVar) {
        return (s) g.e(aVar.d(dVar));
    }

    /* renamed from: c */
    public s get() {
        return b(this.f12648a, this.f12649b.get());
    }
}
