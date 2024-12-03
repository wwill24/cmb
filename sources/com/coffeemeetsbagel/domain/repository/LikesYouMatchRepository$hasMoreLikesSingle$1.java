package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.database.daos.i0;
import com.coffeemeetsbagel.likesyou.db.LikesYouGroupWithCards;
import java.util.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouMatchRepository$hasMoreLikesSingle$1 extends Lambda implements Function1<Optional<LikesYouGroupWithCards>, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public static final LikesYouMatchRepository$hasMoreLikesSingle$1 f12409a = new LikesYouMatchRepository$hasMoreLikesSingle$1();

    LikesYouMatchRepository$hasMoreLikesSingle$1() {
        super(1);
    }

    /* renamed from: a */
    public final Boolean invoke(Optional<LikesYouGroupWithCards> optional) {
        j.g(optional, "it");
        boolean z10 = false;
        if (!i0.a(optional) && optional.get().getGroup().getCount() > optional.get().getCards().size()) {
            z10 = true;
        }
        return Boolean.valueOf(z10);
    }
}
