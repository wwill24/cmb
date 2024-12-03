package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SubscriptionRepository$observeSubscriptionChanges$clientStream$1 extends Lambda implements Function1<String, SubscriptionRepository.a> {

    /* renamed from: a  reason: collision with root package name */
    public static final SubscriptionRepository$observeSubscriptionChanges$clientStream$1 f12448a = new SubscriptionRepository$observeSubscriptionChanges$clientStream$1();

    SubscriptionRepository$observeSubscriptionChanges$clientStream$1() {
        super(1);
    }

    /* renamed from: a */
    public final SubscriptionRepository.a invoke(String str) {
        j.g(str, "it");
        return new SubscriptionRepository.a(str, false);
    }
}
