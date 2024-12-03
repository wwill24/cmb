package com.coffeemeetsbagel.feature.bagel;

import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import java.util.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;

final class GetLastPassedBagelUseCase$invoke$1 extends Lambda implements Function1<Bagel, b0<? extends Bagel>> {
    final /* synthetic */ GetLastPassedBagelUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetLastPassedBagelUseCase$invoke$1(GetLastPassedBagelUseCase getLastPassedBagelUseCase) {
        super(1);
        this.this$0 = getLastPassedBagelUseCase;
    }

    /* access modifiers changed from: private */
    public static final Bagel d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Bagel) function1.invoke(obj);
    }

    /* renamed from: c */
    public final b0<? extends Bagel> invoke(final Bagel bagel) {
        j.g(bagel, Extra.BAGEL);
        ProfileRepositoryV2 b10 = this.this$0.f12690b;
        String profileId = bagel.getProfileId();
        j.f(profileId, "bagel.profileId");
        return b10.h(profileId).L().D(new u(new Function1<Optional<NetworkProfile>, Bagel>() {
            /* renamed from: a */
            public final Bagel invoke(Optional<NetworkProfile> optional) {
                j.g(optional, "it");
                Bagel bagel = bagel;
                bagel.setProfile(optional.get());
                return bagel;
            }
        }));
    }
}
