package com.coffeemeetsbagel.bakery;

import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
import fj.d;
import fj.g;
import fk.a;

public final class c0 implements d<FirebaseContract.Analytics> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Bakery> f11072a;

    public c0(a<Bakery> aVar) {
        this.f11072a = aVar;
    }

    public static c0 a(a<Bakery> aVar) {
        return new c0(aVar);
    }

    public static FirebaseContract.Analytics b(Bakery bakery) {
        return (FirebaseContract.Analytics) g.e(c.z(bakery));
    }

    /* renamed from: c */
    public FirebaseContract.Analytics get() {
        return b(this.f11072a.get());
    }
}
