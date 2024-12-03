package com.coffeemeetsbagel.match_view;

import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class MatchViewInteractor$compareChipAnswers$1$1 extends Lambda implements Function2<List<? extends String>, List<? extends String>, Pair<? extends List<? extends String>, ? extends List<? extends String>>> {

    /* renamed from: a  reason: collision with root package name */
    public static final MatchViewInteractor$compareChipAnswers$1$1 f34639a = new MatchViewInteractor$compareChipAnswers$1$1();

    MatchViewInteractor$compareChipAnswers$1$1() {
        super(2);
    }

    /* renamed from: a */
    public final Pair<List<String>, List<String>> invoke(List<String> list, List<String> list2) {
        j.g(list, "selfAnswers");
        j.g(list2, "matchAnswers");
        return new Pair<>(list2, list);
    }
}
