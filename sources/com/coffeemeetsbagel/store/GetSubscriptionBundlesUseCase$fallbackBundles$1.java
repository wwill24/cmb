package com.coffeemeetsbagel.store;

import com.coffeemeetsbagel.utils.model.Optional;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import vb.a;
import vb.c;

final class GetSubscriptionBundlesUseCase$fallbackBundles$1 extends Lambda implements Function1<List<? extends c>, Pair<? extends Pair<? extends Optional<a>, ? extends Optional<c>>, ? extends List<? extends c>>> {
    final /* synthetic */ Pair<Pair<Optional<a>, Optional<c>>, List<c>> $pair;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetSubscriptionBundlesUseCase$fallbackBundles$1(Pair<? extends Pair<? extends Optional<a>, ? extends Optional<c>>, ? extends List<c>> pair) {
        super(1);
        this.$pair = pair;
    }

    /* renamed from: a */
    public final Pair<Pair<Optional<a>, Optional<c>>, List<c>> invoke(List<c> list) {
        j.g(list, "bundles");
        return new Pair<>(this.$pair.c(), list);
    }
}
