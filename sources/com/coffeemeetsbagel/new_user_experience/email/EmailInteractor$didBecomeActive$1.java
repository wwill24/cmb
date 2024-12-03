package com.coffeemeetsbagel.new_user_experience.email;

import com.coffeemeetsbagel.models.dto.ProfileDataContract;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import x6.d;

final class EmailInteractor$didBecomeActive$1 extends Lambda implements Function1<d<ProfileDataContract>, Unit> {
    final /* synthetic */ EmailInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EmailInteractor$didBecomeActive$1(EmailInteractor emailInteractor) {
        super(1);
        this.this$0 = emailInteractor;
    }

    public final void a(d<ProfileDataContract> dVar) {
        String firstName;
        ProfileDataContract d10 = dVar.d();
        if (d10 != null && (firstName = d10.getFirstName()) != null) {
            ((EmailPresenter) this.this$0.f7875e).y(firstName);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((d) obj);
        return Unit.f32013a;
    }
}
