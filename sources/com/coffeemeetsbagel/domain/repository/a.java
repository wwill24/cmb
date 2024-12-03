package com.coffeemeetsbagel.domain.repository;

import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActionCardRepository f12467a;

    public /* synthetic */ a(ActionCardRepository actionCardRepository) {
        this.f12467a = actionCardRepository;
    }

    public final Object call() {
        return ActionCardRepository.l(this.f12467a);
    }
}
