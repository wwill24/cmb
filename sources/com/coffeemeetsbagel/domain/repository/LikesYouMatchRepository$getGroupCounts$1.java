package com.coffeemeetsbagel.domain.repository;

import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouMatchRepository$getGroupCounts$1 extends Lambda implements Function2<Integer, Integer, Pair<? extends Integer, ? extends Integer>> {

    /* renamed from: a  reason: collision with root package name */
    public static final LikesYouMatchRepository$getGroupCounts$1 f12405a = new LikesYouMatchRepository$getGroupCounts$1();

    LikesYouMatchRepository$getGroupCounts$1() {
        super(2);
    }

    /* renamed from: a */
    public final Pair<Integer, Integer> invoke(Integer num, Integer num2) {
        j.g(num, "count");
        j.g(num2, "maxCount");
        return new Pair<>(num, num2);
    }
}
