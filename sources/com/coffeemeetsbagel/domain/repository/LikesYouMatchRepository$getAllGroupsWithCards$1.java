package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.likesyou.db.LikesYouGroupWithCards;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.h;
import rn.a;

final class LikesYouMatchRepository$getAllGroupsWithCards$1 extends Lambda implements Function1<List<? extends LikesYouGroupWithCards>, a<? extends List<? extends LikesYouGroupWithCards>>> {

    /* renamed from: a  reason: collision with root package name */
    public static final LikesYouMatchRepository$getAllGroupsWithCards$1 f12404a = new LikesYouMatchRepository$getAllGroupsWithCards$1();

    LikesYouMatchRepository$getAllGroupsWithCards$1() {
        super(1);
    }

    /* renamed from: a */
    public final a<? extends List<LikesYouGroupWithCards>> invoke(List<LikesYouGroupWithCards> list) {
        j.g(list, "list");
        if (list.isEmpty()) {
            return h.H(new NoSuchElementException("no group found"));
        }
        return h.X(list);
    }
}
