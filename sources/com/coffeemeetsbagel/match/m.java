package com.coffeemeetsbagel.match;

import java.util.concurrent.Callable;

public final /* synthetic */ class m implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BagelRepository f34507a;

    public /* synthetic */ m(BagelRepository bagelRepository) {
        this.f34507a = bagelRepository;
    }

    public final Object call() {
        return BagelRepository.o(this.f34507a);
    }
}
