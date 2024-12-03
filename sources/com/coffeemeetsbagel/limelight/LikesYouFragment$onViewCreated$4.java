package com.coffeemeetsbagel.limelight;

import android.view.View;
import androidx.fragment.app.h;
import com.coffeemeetsbagel.likes_you.LikesYouViewModel;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellComponentActivity;
import com.google.android.material.tabs.TabLayout;
import da.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouFragment$onViewCreated$4 extends Lambda implements Function1<LikesYouViewModel.b, Unit> {
    final /* synthetic */ LikesYouFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouFragment$onViewCreated$4(LikesYouFragment likesYouFragment) {
        super(1);
        this.this$0 = likesYouFragment;
    }

    /* access modifiers changed from: private */
    public static final void f(LikesYouFragment likesYouFragment) {
        j.g(likesYouFragment, "this$0");
        a D0 = likesYouFragment.f34350e;
        j.d(D0);
        D0.f40559h.post(new f(likesYouFragment));
    }

    /* access modifiers changed from: private */
    public static final void h(LikesYouFragment likesYouFragment) {
        j.g(likesYouFragment, "this$0");
        a D0 = likesYouFragment.f34350e;
        j.d(D0);
        D0.f40559h.s1(0);
    }

    /* access modifiers changed from: private */
    public static final void i(LikesYouFragment likesYouFragment, View view) {
        j.g(likesYouFragment, "this$0");
        PremiumUpsellComponentActivity.a aVar = PremiumUpsellComponentActivity.f36846j;
        h requireActivity = likesYouFragment.requireActivity();
        j.f(requireActivity, "requireActivity()");
        aVar.b(requireActivity, new PurchaseSource("limelight subscription banner", "Subscription Banner"));
    }

    public final void e(LikesYouViewModel.b bVar) {
        if (bVar instanceof LikesYouViewModel.b.a) {
            a D0 = this.this$0.f34350e;
            j.d(D0);
            D0.f40558g.setVisibility(8);
            a D02 = this.this$0.f34350e;
            j.d(D02);
            D02.f40559h.setVisibility(8);
            a D03 = this.this$0.f34350e;
            j.d(D03);
            D03.f40553b.setVisibility(0);
            a D04 = this.this$0.f34350e;
            j.d(D04);
            D04.f40562l.setVisibility(8);
            a D05 = this.this$0.f34350e;
            j.d(D05);
            TabLayout tabLayout = D05.f40560j;
            a D06 = this.this$0.f34350e;
            j.d(D06);
            LikesYouViewModel.b.a aVar = (LikesYouViewModel.b.a) bVar;
            tabLayout.K(D06.f40560j.B(aVar.c()));
            this.this$0.I0(aVar.a(), aVar.b());
        } else if (bVar instanceof LikesYouViewModel.b.c) {
            a D07 = this.this$0.f34350e;
            j.d(D07);
            D07.f40558g.setVisibility(8);
            a D08 = this.this$0.f34350e;
            j.d(D08);
            D08.f40559h.setVisibility(0);
            a D09 = this.this$0.f34350e;
            j.d(D09);
            D09.f40553b.setVisibility(8);
            a D010 = this.this$0.f34350e;
            j.d(D010);
            TabLayout tabLayout2 = D010.f40560j;
            a D011 = this.this$0.f34350e;
            j.d(D011);
            LikesYouViewModel.b.c cVar = (LikesYouViewModel.b.c) bVar;
            tabLayout2.K(D011.f40560j.B(cVar.c()));
            this.this$0.L0().K(cVar.b(), new d(this.this$0));
            if (cVar.a()) {
                a D012 = this.this$0.f34350e;
                j.d(D012);
                D012.f40562l.setVisibility(8);
                return;
            }
            a D013 = this.this$0.f34350e;
            j.d(D013);
            D013.f40562l.setVisibility(0);
            a D014 = this.this$0.f34350e;
            j.d(D014);
            D014.f40562l.setOnClickListener(new e(this.this$0));
        } else if (j.b(bVar, LikesYouViewModel.b.C0407b.f34157a)) {
            a D015 = this.this$0.f34350e;
            j.d(D015);
            D015.f40558g.setVisibility(0);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        e((LikesYouViewModel.b) obj);
        return Unit.f32013a;
    }
}
