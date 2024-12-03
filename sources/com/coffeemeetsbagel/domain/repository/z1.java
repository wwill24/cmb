package com.coffeemeetsbagel.domain.repository;

import java.util.concurrent.Callable;

public final /* synthetic */ class z1 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuggestedRepository f12627a;

    public /* synthetic */ z1(SuggestedRepository suggestedRepository) {
        this.f12627a = suggestedRepository;
    }

    public final Object call() {
        return SuggestedRepository.G(this.f12627a);
    }
}
