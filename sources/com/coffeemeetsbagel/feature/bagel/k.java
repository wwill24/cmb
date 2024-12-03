package com.coffeemeetsbagel.feature.bagel;

import com.coffeemeetsbagel.models.Bagel;
import java.util.function.Predicate;

public final /* synthetic */ class k implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s f12712a;

    public /* synthetic */ k(s sVar) {
        this.f12712a = sVar;
    }

    public final boolean test(Object obj) {
        return this.f12712a.P0((Bagel) obj);
    }
}
