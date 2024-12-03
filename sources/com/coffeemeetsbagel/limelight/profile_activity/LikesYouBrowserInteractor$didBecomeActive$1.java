package com.coffeemeetsbagel.limelight.profile_activity;

import com.coffeemeetsbagel.likesyou.db.LikesYouGroupWithCards;
import java.util.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouBrowserInteractor$didBecomeActive$1 extends Lambda implements Function1<Optional<LikesYouGroupWithCards>, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public static final LikesYouBrowserInteractor$didBecomeActive$1 f34399a = new LikesYouBrowserInteractor$didBecomeActive$1();

    LikesYouBrowserInteractor$didBecomeActive$1() {
        super(1);
    }

    /* renamed from: a */
    public final Boolean invoke(Optional<LikesYouGroupWithCards> optional) {
        j.g(optional, "it");
        return Boolean.valueOf(optional.isPresent());
    }
}
