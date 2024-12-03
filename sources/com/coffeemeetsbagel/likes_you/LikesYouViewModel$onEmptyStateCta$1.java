package com.coffeemeetsbagel.likes_you;

import com.coffeemeetsbagel.likes_you.LikesYouViewModel;
import com.coffeemeetsbagel.store.PurchaseSource;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouViewModel$onEmptyStateCta$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ LikesYouViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouViewModel$onEmptyStateCta$1(LikesYouViewModel likesYouViewModel) {
        super(1);
        this.this$0 = likesYouViewModel;
    }

    public final void a(Boolean bool) {
        Pair pair;
        j.f(bool, "hasMoreLikes");
        if (bool.booleanValue()) {
            pair = new Pair("Limelight empty with rising", "limelight not subscribed with likes");
        } else {
            pair = new Pair("Limelight empty", "limelight not subscribed");
        }
        this.this$0.f34133n.o(new LikesYouViewModel.a.C0406a(new PurchaseSource((String) pair.c(), (String) pair.d())));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Boolean) obj);
        return Unit.f32013a;
    }
}
