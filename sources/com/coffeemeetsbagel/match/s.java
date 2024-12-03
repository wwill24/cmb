package com.coffeemeetsbagel.match;

import com.coffeemeetsbagel.models.Bagel;
import java.util.concurrent.Callable;

public final /* synthetic */ class s implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BagelRepository f34516a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bagel f34517b;

    public /* synthetic */ s(BagelRepository bagelRepository, Bagel bagel) {
        this.f34516a = bagelRepository;
        this.f34517b = bagel;
    }

    public final Object call() {
        return BagelRepository$updateBagel$2.d(this.f34516a, this.f34517b);
    }
}
