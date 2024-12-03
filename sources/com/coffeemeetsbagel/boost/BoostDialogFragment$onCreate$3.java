package com.coffeemeetsbagel.boost;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class BoostDialogFragment$onCreate$3 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ BoostDialogFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BoostDialogFragment$onCreate$3(BoostDialogFragment boostDialogFragment) {
        super(1);
        this.this$0 = boostDialogFragment;
    }

    public final void a(Boolean bool) {
        a.f40771d.a(this.this$0.f11415b, "subscription changed: " + bool);
        j.f(bool, "hasSubscription");
        if (bool.booleanValue()) {
            BoostViewModel L0 = this.this$0.f11422j;
            BoostViewModel boostViewModel = null;
            if (L0 == null) {
                j.y("viewModel");
                L0 = null;
            }
            L0.E();
            BoostViewModel L02 = this.this$0.f11422j;
            if (L02 == null) {
                j.y("viewModel");
            } else {
                boostViewModel = L02;
            }
            boostViewModel.C();
        }
        this.this$0.l1();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Boolean) obj);
        return Unit.f32013a;
    }
}
