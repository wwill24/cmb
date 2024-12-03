package com.coffeemeetsbagel.domain.repository;

import java.util.List;
import java.util.concurrent.Callable;

public final /* synthetic */ class i1 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f12522a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubscriptionRepository f12523b;

    public /* synthetic */ i1(List list, SubscriptionRepository subscriptionRepository) {
        this.f12522a = list;
        this.f12523b = subscriptionRepository;
    }

    public final Object call() {
        return SubscriptionRepository.e0(this.f12522a, this.f12523b);
    }
}
