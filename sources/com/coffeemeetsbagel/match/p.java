package com.coffeemeetsbagel.match;

import com.coffeemeetsbagel.models.Bagel;
import java.util.concurrent.Callable;

public final /* synthetic */ class p implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BagelRepository f34512a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bagel f34513b;

    public /* synthetic */ p(BagelRepository bagelRepository, Bagel bagel) {
        this.f34512a = bagelRepository;
        this.f34513b = bagel;
    }

    public final Object call() {
        return BagelRepository.r(this.f34512a, this.f34513b);
    }
}
