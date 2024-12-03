package com.coffeemeetsbagel.likes_you;

import com.coffeemeetsbagel.likesyou.db.LikesYouGroupWithCards;
import java.util.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouViewModel$fetchAndRenderLikesYouCards$disposable$1 extends Lambda implements Function1<Optional<LikesYouGroupWithCards>, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public static final LikesYouViewModel$fetchAndRenderLikesYouCards$disposable$1 f34162a = new LikesYouViewModel$fetchAndRenderLikesYouCards$disposable$1();

    LikesYouViewModel$fetchAndRenderLikesYouCards$disposable$1() {
        super(1);
    }

    /* renamed from: a */
    public final Boolean invoke(Optional<LikesYouGroupWithCards> optional) {
        j.g(optional, "it");
        return Boolean.valueOf(optional.isPresent());
    }
}
