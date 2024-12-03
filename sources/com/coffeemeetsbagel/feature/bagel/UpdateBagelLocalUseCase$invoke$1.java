package com.coffeemeetsbagel.feature.bagel;

import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.photo.Photo;
import com.coffeemeetsbagel.profile.ProfileMappersKt;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.profile.l;
import ja.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import v6.c;

final class UpdateBagelLocalUseCase$invoke$1 extends Lambda implements Function1<Bagel, b0<? extends Bagel>> {
    final /* synthetic */ Bagel $bagel;
    final /* synthetic */ UpdateBagelLocalUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UpdateBagelLocalUseCase$invoke$1(UpdateBagelLocalUseCase updateBagelLocalUseCase, Bagel bagel) {
        super(1);
        this.this$0 = updateBagelLocalUseCase;
        this.$bagel = bagel;
    }

    /* access modifiers changed from: private */
    public static final Bagel d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Bagel) function1.invoke(obj);
    }

    /* renamed from: c */
    public final b0<? extends Bagel> invoke(final Bagel bagel) {
        j.g(bagel, "flawedBagel");
        ProfileRepositoryV2 d10 = this.this$0.f12693c;
        String profileId = this.$bagel.getProfileId();
        j.f(profileId, "bagel.profileId");
        return d10.n(profileId).L().D(new y(new Function1<Pair<? extends l, ? extends List<? extends Photo>>, Bagel>() {
            /* renamed from: a */
            public final Bagel invoke(Pair<l, ? extends List<Photo>> pair) {
                j.g(pair, "profilePhotos");
                Iterable<Photo> iterable = (Iterable) pair.d();
                ArrayList arrayList = new ArrayList(r.t(iterable, 10));
                for (Photo e10 : iterable) {
                    arrayList.add(c.e(e10));
                }
                NetworkProfile g10 = ProfileMappersKt.g(pair.c(), (b) null);
                g10.setPhotos(arrayList);
                bagel.setProfile(g10);
                return bagel;
            }
        }));
    }
}
