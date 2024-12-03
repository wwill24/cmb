package com.coffeemeetsbagel.new_user_experience.profile_review;

import com.coffeemeetsbagel.models.dto.ProfileDataContract;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import x6.d;

final class ProfileReviewInteractor$didBecomeActive$1 extends Lambda implements Function1<d<ProfileDataContract>, Unit> {
    final /* synthetic */ ProfileReviewInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfileReviewInteractor$didBecomeActive$1(ProfileReviewInteractor profileReviewInteractor) {
        super(1);
        this.this$0 = profileReviewInteractor;
    }

    public final void a(d<ProfileDataContract> dVar) {
        String firstName;
        ProfileDataContract d10 = dVar.d();
        if (d10 != null && (firstName = d10.getFirstName()) != null) {
            ((ProfileReviewPresenter) this.this$0.f7875e).m(firstName);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((d) obj);
        return Unit.f32013a;
    }
}
