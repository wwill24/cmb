package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.match.b0;
import com.coffeemeetsbagel.match.models.Match;
import com.coffeemeetsbagel.models.entities.MatchEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouMatchRepository$getMatch$1 extends Lambda implements Function1<List<? extends MatchEntity>, List<? extends Match>> {

    /* renamed from: a  reason: collision with root package name */
    public static final LikesYouMatchRepository$getMatch$1 f12408a = new LikesYouMatchRepository$getMatch$1();

    LikesYouMatchRepository$getMatch$1() {
        super(1);
    }

    /* renamed from: a */
    public final List<Match> invoke(List<MatchEntity> list) {
        j.g(list, "list");
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (MatchEntity a10 : list) {
            arrayList.add(b0.f34495a.a(a10));
        }
        return arrayList;
    }
}
