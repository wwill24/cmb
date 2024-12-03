package com.coffeemeetsbagel.store;

import com.coffeemeetsbagel.store.GetSubscriptionBundlesUseCase;
import com.coffeemeetsbagel.utils.model.Optional;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import vb.a;
import vb.c;

final class GetSubscriptionBundlesUseCase$invoke$3 extends Lambda implements Function1<Pair<? extends Pair<? extends Optional<a>, ? extends Optional<c>>, ? extends List<? extends c>>, GetSubscriptionBundlesUseCase.a> {

    /* renamed from: a  reason: collision with root package name */
    public static final GetSubscriptionBundlesUseCase$invoke$3 f36705a = new GetSubscriptionBundlesUseCase$invoke$3();

    GetSubscriptionBundlesUseCase$invoke$3() {
        super(1);
    }

    /* renamed from: a */
    public final GetSubscriptionBundlesUseCase.a invoke(Pair<? extends Pair<? extends Optional<a>, ? extends Optional<c>>, ? extends List<c>> pair) {
        j.g(pair, "pair");
        fa.a.f40771d.a("GetSubscriptionBundlesUseCase", "combineLatest()");
        Optional optional = (Optional) ((Pair) pair.c()).c();
        Optional optional2 = (Optional) ((Pair) pair.c()).d();
        ArrayList arrayList = new ArrayList();
        for (Object next : (Iterable) pair.d()) {
            if (!((c) next).k().isEmpty()) {
                arrayList.add(next);
            }
        }
        return new GetSubscriptionBundlesUseCase.a(optional, optional2, arrayList);
    }
}
