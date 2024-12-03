package com.coffeemeetsbagel.feature.bagel;

import com.coffeemeetsbagel.models.Bagel;
import java.util.concurrent.Callable;

public final /* synthetic */ class f implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s f12709a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bagel f12710b;

    public /* synthetic */ f(s sVar, Bagel bagel) {
        this.f12709a = sVar;
        this.f12710b = bagel;
    }

    public final Object call() {
        return this.f12709a.D0(this.f12710b);
    }
}
