package com.coffeemeetsbagel.match;

import com.coffeemeetsbagel.models.Bagel;
import java.util.concurrent.Callable;

public final /* synthetic */ class n implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bagel f34509a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BagelRepository f34510b;

    public /* synthetic */ n(Bagel bagel, BagelRepository bagelRepository) {
        this.f34509a = bagel;
        this.f34510b = bagelRepository;
    }

    public final Object call() {
        return BagelRepository.j(this.f34509a, this.f34510b);
    }
}
