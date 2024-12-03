package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.entities.MatchEntity;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouMatchRepository$fetchMatchRemote$2 extends Lambda implements Function1<List<? extends MatchEntity>, Unit> {
    final /* synthetic */ LikesYouMatchRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouMatchRepository$fetchMatchRemote$2(LikesYouMatchRepository likesYouMatchRepository) {
        super(1);
        this.this$0 = likesYouMatchRepository;
    }

    public final void a(List<MatchEntity> list) {
        LikesYouMatchRepository likesYouMatchRepository = this.this$0;
        j.f(list, "matches");
        likesYouMatchRepository.P(list);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}
