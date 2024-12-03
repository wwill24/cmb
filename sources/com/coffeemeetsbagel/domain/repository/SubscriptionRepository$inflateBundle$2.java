package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.entities.SubscriptionBundleEntity;
import com.coffeemeetsbagel.store.v0;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import vb.b;
import vb.c;
import vb.d;

final class SubscriptionRepository$inflateBundle$2 extends Lambda implements Function1<Pair<? extends List<? extends b>, ? extends List<? extends d>>, c> {
    final /* synthetic */ SubscriptionBundleEntity $bundleEntity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionRepository$inflateBundle$2(SubscriptionBundleEntity subscriptionBundleEntity) {
        super(1);
        this.$bundleEntity = subscriptionBundleEntity;
    }

    /* renamed from: a */
    public final c invoke(Pair<? extends List<b>, ? extends List<d>> pair) {
        j.g(pair, "pair");
        v0 v0Var = v0.f37002a;
        SubscriptionBundleEntity subscriptionBundleEntity = this.$bundleEntity;
        Object c10 = pair.c();
        j.f(c10, "pair.first");
        Object d10 = pair.d();
        j.f(d10, "pair.second");
        return v0Var.a(subscriptionBundleEntity, (List) c10, (List) d10);
    }
}
