package com.coffeemeetsbagel.feature.bagel;

import com.coffeemeetsbagel.models.Bagel;
import fa.a;
import vj.f;

public final /* synthetic */ class d implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bagel f12708a;

    public /* synthetic */ d(Bagel bagel) {
        this.f12708a = bagel;
    }

    public final void accept(Object obj) {
        a.f("BagelManager", "failed to insert or update to DB bagel bagel: " + this.f12708a.getId() + " - profile " + this.f12708a.getProfile());
    }
}
