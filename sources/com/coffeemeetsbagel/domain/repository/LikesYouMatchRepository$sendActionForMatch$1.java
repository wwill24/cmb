package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.match.models.Match;
import com.coffeemeetsbagel.models.Bagel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class LikesYouMatchRepository$sendActionForMatch$1 extends Lambda implements Function1<Bagel, Unit> {
    final /* synthetic */ Match $match;
    final /* synthetic */ LikesYouMatchRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouMatchRepository$sendActionForMatch$1(LikesYouMatchRepository likesYouMatchRepository, Match match) {
        super(1);
        this.this$0 = likesYouMatchRepository;
        this.$match = match;
    }

    public final void a(Bagel bagel) {
        this.this$0.f12391a.c(this.$match.getProfileId(), this.$match.getAction());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Bagel) obj);
        return Unit.f32013a;
    }
}
