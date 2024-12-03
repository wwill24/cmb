package com.coffeemeetsbagel.profile_me;

import com.coffeemeetsbagel.profile.l;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class MeProfileFragment$onCreate$3 extends Lambda implements Function1<l, Unit> {
    final /* synthetic */ MeProfileFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MeProfileFragment$onCreate$3(MeProfileFragment meProfileFragment) {
        super(1);
        this.this$0 = meProfileFragment;
    }

    public final void a(l lVar) {
        a.C0491a aVar = a.f40771d;
        aVar.a("MeProfileFragment", "userProfile: " + lVar);
        if (lVar != null) {
            this.this$0.B1(lVar);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((l) obj);
        return Unit.f32013a;
    }
}
