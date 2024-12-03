package com.coffeemeetsbagel.limelight.profile_activity;

import com.coffeemeetsbagel.likesyou.db.LikesYouGroupWithCards;
import java.util.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouBrowserInteractor$didBecomeActive$2 extends Lambda implements Function1<Optional<LikesYouGroupWithCards>, LikesYouGroupWithCards> {

    /* renamed from: a  reason: collision with root package name */
    public static final LikesYouBrowserInteractor$didBecomeActive$2 f34400a = new LikesYouBrowserInteractor$didBecomeActive$2();

    LikesYouBrowserInteractor$didBecomeActive$2() {
        super(1);
    }

    /* renamed from: a */
    public final LikesYouGroupWithCards invoke(Optional<LikesYouGroupWithCards> optional) {
        j.g(optional, "it");
        return optional.get();
    }
}
