package com.coffeemeetsbagel.store;

import com.coffeemeetsbagel.utils.model.Optional;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import vb.a;
import vb.c;

final class GetSubscriptionBundlesUseCase$invoke$2 extends Lambda implements Function1<Pair<? extends Pair<? extends Optional<a>, ? extends Optional<c>>, ? extends List<? extends c>>, rn.a<? extends Pair<? extends Pair<? extends Optional<a>, ? extends Optional<c>>, ? extends List<? extends c>>>> {
    final /* synthetic */ GetSubscriptionBundlesUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetSubscriptionBundlesUseCase$invoke$2(GetSubscriptionBundlesUseCase getSubscriptionBundlesUseCase) {
        super(1);
        this.this$0 = getSubscriptionBundlesUseCase;
    }

    /* renamed from: a */
    public final rn.a<? extends Pair<Pair<Optional<a>, Optional<c>>, List<c>>> invoke(Pair<? extends Pair<? extends Optional<a>, ? extends Optional<c>>, ? extends List<c>> pair) {
        j.g(pair, "it");
        return this.this$0.j(pair);
    }
}
