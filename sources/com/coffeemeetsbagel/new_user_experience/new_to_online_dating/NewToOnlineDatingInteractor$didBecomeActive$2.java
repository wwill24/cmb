package com.coffeemeetsbagel.new_user_experience.new_to_online_dating;

import com.coffeemeetsbagel.models.dto.ProfileDataContract;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import x6.d;

final class NewToOnlineDatingInteractor$didBecomeActive$2 extends Lambda implements Function1<d<ProfileDataContract>, Unit> {
    final /* synthetic */ NewToOnlineDatingInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NewToOnlineDatingInteractor$didBecomeActive$2(NewToOnlineDatingInteractor newToOnlineDatingInteractor) {
        super(1);
        this.this$0 = newToOnlineDatingInteractor;
    }

    public final void a(d<ProfileDataContract> dVar) {
        ProfileDataContract d10;
        if (dVar != null && (d10 = dVar.d()) != null) {
            NewToOnlineDatingInteractor newToOnlineDatingInteractor = this.this$0;
            if (newToOnlineDatingInteractor.f35495m != d10.getGender()) {
                newToOnlineDatingInteractor.f35495m = d10.getGender();
                ((NewToOnlineDatingPresenter) newToOnlineDatingInteractor.f7875e).r(8388613, d10.getGender());
            }
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((d) obj);
        return Unit.f32013a;
    }
}
