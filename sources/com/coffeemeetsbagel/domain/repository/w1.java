package com.coffeemeetsbagel.domain.repository;

import java.util.Comparator;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class w1 implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function2 f12595a;

    public /* synthetic */ w1(Function2 function2) {
        this.f12595a = function2;
    }

    public final int compare(Object obj, Object obj2) {
        return SubscriptionRepository$getSubscriptionBundles$1.f(this.f12595a, obj, obj2);
    }
}
