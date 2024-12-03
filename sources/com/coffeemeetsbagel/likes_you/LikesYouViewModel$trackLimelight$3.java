package com.coffeemeetsbagel.likes_you;

import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.google.gson.d;
import ea.a;
import ea.b;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouViewModel$trackLimelight$3 extends Lambda implements Function1<Pair<? extends List<? extends a>, ? extends List<? extends b>>, Unit> {
    final /* synthetic */ Map<String, String> $params;
    final /* synthetic */ LikesYouViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouViewModel$trackLimelight$3(Map<String, String> map, LikesYouViewModel likesYouViewModel) {
        super(1);
        this.$params = map;
        this.this$0 = likesYouViewModel;
    }

    public final void a(Pair<? extends List<a>, ? extends List<b>> pair) {
        Map<String, String> map = this.$params;
        String u10 = new d().u(pair.c());
        j.f(u10, "Gson().toJson(pair.first)");
        map.put(ProfileConstants.Field.BADGE_COUNT, u10);
        Map<String, String> map2 = this.$params;
        String u11 = new d().u(pair.d());
        j.f(u11, "Gson().toJson(pair.second)");
        map2.put("bagel_count", u11);
        this.this$0.f34123d.trackEvent("Limelight Viewed", this.$params);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Pair) obj);
        return Unit.f32013a;
    }
}
