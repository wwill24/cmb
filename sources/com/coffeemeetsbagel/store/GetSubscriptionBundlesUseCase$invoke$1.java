package com.coffeemeetsbagel.store;

import com.coffeemeetsbagel.utils.model.Optional;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import vb.a;
import vb.c;

final class GetSubscriptionBundlesUseCase$invoke$1 extends Lambda implements Function2<Pair<? extends Optional<a>, ? extends Optional<c>>, List<? extends c>, Pair<? extends Pair<? extends Optional<a>, ? extends Optional<c>>, ? extends List<? extends c>>> {

    /* renamed from: a  reason: collision with root package name */
    public static final GetSubscriptionBundlesUseCase$invoke$1 f36704a = new GetSubscriptionBundlesUseCase$invoke$1();

    GetSubscriptionBundlesUseCase$invoke$1() {
        super(2);
    }

    /* renamed from: a */
    public final Pair<Pair<Optional<a>, Optional<c>>, List<c>> invoke(Pair<? extends Optional<a>, ? extends Optional<c>> pair, List<c> list) {
        j.g(pair, "activeSubInfo");
        j.g(list, "bundles");
        return new Pair<>(pair, list);
    }
}
