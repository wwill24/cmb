package com.coffeemeetsbagel.match;

import java.util.concurrent.Callable;

public final /* synthetic */ class r implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BagelRepository f34515a;

    public /* synthetic */ r(BagelRepository bagelRepository) {
        this.f34515a = bagelRepository;
    }

    public final Object call() {
        return BagelRepository.m(this.f34515a);
    }
}
