package com.coffeemeetsbagel.limelight;

import android.content.Context;
import androidx.fragment.app.h;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.likes_you.LikesYouViewModel;
import com.coffeemeetsbagel.limelight.profile_activity.LikesYouProfileComponentActivityV2;
import com.coffeemeetsbagel.preferences.MatchPreferencesComponentActivity;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellComponentActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouFragment$onViewCreated$3 extends Lambda implements Function1<LikesYouViewModel.a, Unit> {
    final /* synthetic */ LikesYouFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouFragment$onViewCreated$3(LikesYouFragment likesYouFragment) {
        super(1);
        this.this$0 = likesYouFragment;
    }

    public final void a(LikesYouViewModel.a aVar) {
        if (aVar instanceof LikesYouViewModel.a.e) {
            LikesYouViewModel.a.e eVar = (LikesYouViewModel.a.e) aVar;
            this.this$0.R0(eVar.b(), eVar.c(), eVar.a());
        } else if (aVar instanceof LikesYouViewModel.a.d) {
            LikesYouViewModel.a.d dVar = (LikesYouViewModel.a.d) aVar;
            LikesYouProfileComponentActivityV2.a aVar2 = LikesYouProfileComponentActivityV2.f34419q;
            Context requireContext = this.this$0.requireContext();
            j.f(requireContext, "this@LikesYouFragment.requireContext()");
            this.this$0.f34352g.b(aVar2.a(requireContext, "likes_you_" + dVar.a(), dVar.a(), dVar.b()));
        } else if (aVar instanceof LikesYouViewModel.a.f) {
            PremiumUpsellComponentActivity.a aVar3 = PremiumUpsellComponentActivity.f36846j;
            h requireActivity = this.this$0.requireActivity();
            j.f(requireActivity, "requireActivity()");
            aVar3.b(requireActivity, ((LikesYouViewModel.a.f) aVar).a());
        } else if (aVar instanceof LikesYouViewModel.a.C0406a) {
            PremiumUpsellComponentActivity.a aVar4 = PremiumUpsellComponentActivity.f36846j;
            h requireActivity2 = this.this$0.requireActivity();
            j.f(requireActivity2, "requireActivity()");
            aVar4.b(requireActivity2, ((LikesYouViewModel.a.C0406a) aVar).a());
        } else if (j.b(aVar, LikesYouViewModel.a.b.f34145a)) {
            h requireActivity3 = this.this$0.requireActivity();
            j.e(requireActivity3, "null cannot be cast to non-null type com.coffeemeetsbagel.activities.main.ActivityMain");
            ((ActivityMain) requireActivity3).X3();
        } else if (j.b(aVar, LikesYouViewModel.a.c.f34146a)) {
            MatchPreferencesComponentActivity.a aVar5 = MatchPreferencesComponentActivity.f35786j;
            h requireActivity4 = this.this$0.requireActivity();
            j.f(requireActivity4, "requireActivity()");
            aVar5.b(requireActivity4);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((LikesYouViewModel.a) obj);
        return Unit.f32013a;
    }
}
