package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.likesyou.EncountersResponse;
import com.coffeemeetsbagel.models.entities.MatchEntity;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import v6.d;

final class LikesYouMatchRepository$fetchMatchRemote$1 extends Lambda implements Function1<EncountersResponse, List<? extends MatchEntity>> {
    final /* synthetic */ LikesYouMatchRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouMatchRepository$fetchMatchRemote$1(LikesYouMatchRepository likesYouMatchRepository) {
        super(1);
        this.this$0 = likesYouMatchRepository;
    }

    /* renamed from: a */
    public final List<MatchEntity> invoke(EncountersResponse encountersResponse) {
        j.g(encountersResponse, "it");
        return this.this$0.f12396f.c(encountersResponse.getData().getEncounters(), d.f18075a);
    }
}
