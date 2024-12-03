package com.coffeemeetsbagel.domain.repository;

import java.util.concurrent.Callable;

public final /* synthetic */ class l2 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuggestedRepository f12538a;

    public /* synthetic */ l2(SuggestedRepository suggestedRepository) {
        this.f12538a = suggestedRepository;
    }

    public final Object call() {
        return SuggestedRepository.O(this.f12538a);
    }
}
