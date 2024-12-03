package com.coffeemeetsbagel.likes_you;

import gk.h;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class LikesYouViewModel$trackItemSelection$2 extends Lambda implements Function1<Pair<? extends List<? extends String>, ? extends String>, Unit> {
    final /* synthetic */ Map<String, String> $attributes;
    final /* synthetic */ LikesYouViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouViewModel$trackItemSelection$2(Map<String, String> map, LikesYouViewModel likesYouViewModel) {
        super(1);
        this.$attributes = map;
        this.this$0 = likesYouViewModel;
    }

    public final void a(Pair<? extends List<String>, String> pair) {
        this.$attributes.putAll(h0.l(h.a("tab_type", pair.b()), h.a("groups_belonging", ((List) pair.a()).toString())));
        this.this$0.f34123d.trackEvent("Limelight Profile Tapped", this.$attributes);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Pair) obj);
        return Unit.f32013a;
    }
}
