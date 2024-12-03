package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SubscriptionRepository$observeSubscriptionChanges$2 extends Lambda implements Function1<SubscriptionRepository.a, String> {

    /* renamed from: a  reason: collision with root package name */
    public static final SubscriptionRepository$observeSubscriptionChanges$2 f12447a = new SubscriptionRepository$observeSubscriptionChanges$2();

    SubscriptionRepository$observeSubscriptionChanges$2() {
        super(1);
    }

    /* renamed from: a */
    public final String invoke(SubscriptionRepository.a aVar) {
        j.g(aVar, "it");
        return aVar.a();
    }
}
