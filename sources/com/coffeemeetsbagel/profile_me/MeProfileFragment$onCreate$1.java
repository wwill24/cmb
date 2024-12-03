package com.coffeemeetsbagel.profile_me;

import com.coffeemeetsbagel.profile_me.MeProfileViewModel;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class MeProfileFragment$onCreate$1 extends Lambda implements Function1<MeProfileViewModel.UpsellViewState, Unit> {
    final /* synthetic */ MeProfileFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MeProfileFragment$onCreate$1(MeProfileFragment meProfileFragment) {
        super(1);
        this.this$0 = meProfileFragment;
    }

    public final void a(MeProfileViewModel.UpsellViewState upsellViewState) {
        a.C0491a aVar = a.f40771d;
        aVar.a("MeProfileFragment", "upsellState: " + upsellViewState);
        if (upsellViewState != null) {
            this.this$0.z1(upsellViewState);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((MeProfileViewModel.UpsellViewState) obj);
        return Unit.f32013a;
    }
}
