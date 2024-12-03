package com.coffeemeetsbagel.new_user_experience.introductions;

import com.coffeemeetsbagel.models.ProfileDtoImplementationKt;
import com.coffeemeetsbagel.models.dto.ProfileDataContract;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import x6.d;

final class IntroductionsInteractor$didBecomeActive$1 extends Lambda implements Function1<d<ProfileDataContract>, Unit> {
    final /* synthetic */ IntroductionsInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntroductionsInteractor$didBecomeActive$1(IntroductionsInteractor introductionsInteractor) {
        super(1);
        this.this$0 = introductionsInteractor;
    }

    public final void a(d<ProfileDataContract> dVar) {
        ProfileDataContract d10;
        if (dVar != null && (d10 = dVar.d()) != null) {
            IntroductionsInteractor introductionsInteractor = this.this$0;
            introductionsInteractor.f35080k = ProfileDtoImplementationKt.profileDtoToImplementation(d10);
            ((IntroductionsPresenter) introductionsInteractor.f7875e).I(d10.getFirstName(), d10.getLastName());
            introductionsInteractor.X1();
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((d) obj);
        return Unit.f32013a;
    }
}
