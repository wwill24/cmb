package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SubscriptionRepository$observeSubscriptionChanges$1 extends Lambda implements Function1<SubscriptionRepository.a, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public static final SubscriptionRepository$observeSubscriptionChanges$1 f12446a = new SubscriptionRepository$observeSubscriptionChanges$1();

    SubscriptionRepository$observeSubscriptionChanges$1() {
        super(1);
    }

    /* renamed from: a */
    public final Boolean invoke(SubscriptionRepository.a aVar) {
        j.g(aVar, "it");
        return Boolean.valueOf(!aVar.b());
    }
}
