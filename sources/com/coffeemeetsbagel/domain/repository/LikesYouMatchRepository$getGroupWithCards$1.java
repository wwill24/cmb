package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.likesyou.db.LikesYouGroupWithCards;
import java.util.List;
import java.util.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouMatchRepository$getGroupWithCards$1 extends Lambda implements Function1<List<? extends LikesYouGroupWithCards>, Optional<LikesYouGroupWithCards>> {

    /* renamed from: a  reason: collision with root package name */
    public static final LikesYouMatchRepository$getGroupWithCards$1 f12406a = new LikesYouMatchRepository$getGroupWithCards$1();

    LikesYouMatchRepository$getGroupWithCards$1() {
        super(1);
    }

    /* renamed from: a */
    public final Optional<LikesYouGroupWithCards> invoke(List<LikesYouGroupWithCards> list) {
        j.g(list, "list");
        if (list.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(list.get(0));
    }
}
