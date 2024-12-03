package com.coffeemeetsbagel.limelight;

import androidx.fragment.app.h;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouFragment$onViewCreated$2 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ LikesYouFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouFragment$onViewCreated$2(LikesYouFragment likesYouFragment) {
        super(1);
        this.this$0 = likesYouFragment;
    }

    public final void a(String str) {
        h activity = this.this$0.getActivity();
        j.e(activity, "null cannot be cast to non-null type com.coffeemeetsbagel.activities.main.ActivityMain");
        ((ActivityMain) activity).g5(str);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((String) obj);
        return Unit.f32013a;
    }
}
