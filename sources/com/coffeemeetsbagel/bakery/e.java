package com.coffeemeetsbagel.bakery;

import com.coffeemeetsbagel.database.CmbDatabase;
import com.coffeemeetsbagel.database.room_mappers.a;
import fj.d;
import fj.g;

public final class e implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final fk.a<CmbDatabase> f11088a;

    public e(fk.a<CmbDatabase> aVar) {
        this.f11088a = aVar;
    }

    public static a a(CmbDatabase cmbDatabase) {
        return (a) g.e(c.b(cmbDatabase));
    }

    public static e b(fk.a<CmbDatabase> aVar) {
        return new e(aVar);
    }

    /* renamed from: c */
    public a get() {
        return a(this.f11088a.get());
    }
}
