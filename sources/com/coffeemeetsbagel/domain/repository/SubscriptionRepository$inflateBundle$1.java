package com.coffeemeetsbagel.domain.repository;

import com.leanplum.internal.Constants;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import vb.b;
import vb.d;

final class SubscriptionRepository$inflateBundle$1 extends Lambda implements Function2<List<? extends b>, List<? extends d>, Pair<? extends List<? extends b>, ? extends List<? extends d>>> {

    /* renamed from: a  reason: collision with root package name */
    public static final SubscriptionRepository$inflateBundle$1 f12445a = new SubscriptionRepository$inflateBundle$1();

    SubscriptionRepository$inflateBundle$1() {
        super(2);
    }

    /* renamed from: a */
    public final Pair<List<b>, List<d>> invoke(List<b> list, List<d> list2) {
        j.g(list, "benefits");
        j.g(list2, Constants.Keys.VARIANTS);
        return new Pair<>(list, list2);
    }
}
