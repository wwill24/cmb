package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.entities.LikesYouCardEntity;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouMatchRepository$getGroupsFromCardProfileId$1 extends Lambda implements Function1<LikesYouCardEntity, List<? extends String>> {

    /* renamed from: a  reason: collision with root package name */
    public static final LikesYouMatchRepository$getGroupsFromCardProfileId$1 f12407a = new LikesYouMatchRepository$getGroupsFromCardProfileId$1();

    LikesYouMatchRepository$getGroupsFromCardProfileId$1() {
        super(1);
    }

    /* renamed from: a */
    public final List<String> invoke(LikesYouCardEntity likesYouCardEntity) {
        j.g(likesYouCardEntity, "it");
        return likesYouCardEntity.getGroupIds();
    }
}
