package com.coffeemeetsbagel.discoverV2;

import androidx.fragment.app.h;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DiscoverFragment$observeViewModel$2 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ DiscoverFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiscoverFragment$observeViewModel$2(DiscoverFragment discoverFragment) {
        super(1);
        this.this$0 = discoverFragment;
    }

    public final void a(Integer num) {
        j.f(num, "stringId");
        if (num.intValue() > 0) {
            h activity = this.this$0.getActivity();
            j.e(activity, "null cannot be cast to non-null type com.coffeemeetsbagel.activities.main.ActivityMain");
            ((ActivityMain) activity).z1(num.intValue());
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Integer) obj);
        return Unit.f32013a;
    }
}
