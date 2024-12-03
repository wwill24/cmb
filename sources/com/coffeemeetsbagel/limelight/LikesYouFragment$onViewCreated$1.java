package com.coffeemeetsbagel.limelight;

import com.coffeemeetsbagel.likes_you.s;
import com.google.android.material.tabs.TabLayout;
import da.a;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouFragment$onViewCreated$1 extends Lambda implements Function1<List<? extends s>, Unit> {
    final /* synthetic */ LikesYouFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouFragment$onViewCreated$1(LikesYouFragment likesYouFragment) {
        super(1);
        this.this$0 = likesYouFragment;
    }

    public final void a(List<s> list) {
        a D0 = this.this$0.f34350e;
        j.d(D0);
        TabLayout tabLayout = D0.f40560j;
        LikesYouFragment likesYouFragment = this.this$0;
        j.f(list, "tabList");
        if (!list.isEmpty()) {
            tabLayout.setVisibility(0);
            j.f(tabLayout, "tabLayout");
            likesYouFragment.Q0(list, tabLayout);
            return;
        }
        tabLayout.setVisibility(8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}
