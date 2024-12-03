package com.coffeemeetsbagel.new_user_experience.biography;

import com.coffeemeetsbagel.models.ProfileDtoImplementationKt;
import com.coffeemeetsbagel.models.dto.ProfileDataContract;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import x6.d;

final class BiographyInteractor$didBecomeActive$1 extends Lambda implements Function1<d<ProfileDataContract>, Unit> {
    final /* synthetic */ BiographyInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BiographyInteractor$didBecomeActive$1(BiographyInteractor biographyInteractor) {
        super(1);
        this.this$0 = biographyInteractor;
    }

    public final void a(d<ProfileDataContract> dVar) {
        ProfileDataContract d10;
        if (dVar != null && (d10 = dVar.d()) != null) {
            this.this$0.f34823y = ProfileDtoImplementationKt.profileDtoToImplementation(d10);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((d) obj);
        return Unit.f32013a;
    }
}
