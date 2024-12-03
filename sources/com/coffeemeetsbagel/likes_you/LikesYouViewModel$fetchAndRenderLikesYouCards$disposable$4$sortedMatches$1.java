package com.coffeemeetsbagel.likes_you;

import com.coffeemeetsbagel.models.entities.LikesYouCardEntity;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouViewModel$fetchAndRenderLikesYouCards$disposable$4$sortedMatches$1 extends Lambda implements Function2<LikesYouCardEntity, LikesYouCardEntity, Integer> {
    final /* synthetic */ List<String> $profileIds;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouViewModel$fetchAndRenderLikesYouCards$disposable$4$sortedMatches$1(List<String> list) {
        super(2);
        this.$profileIds = list;
    }

    /* renamed from: a */
    public final Integer invoke(LikesYouCardEntity likesYouCardEntity, LikesYouCardEntity likesYouCardEntity2) {
        return Integer.valueOf(j.i(this.$profileIds.indexOf(likesYouCardEntity.getProfileId()), this.$profileIds.indexOf(likesYouCardEntity2.getProfileId())));
    }
}
