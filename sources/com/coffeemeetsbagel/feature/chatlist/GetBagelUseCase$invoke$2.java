package com.coffeemeetsbagel.feature.chatlist;

import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.photo.Photo;
import com.coffeemeetsbagel.profile.ProfileMappersKt;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.profile.l;
import ja.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;
import v6.c;

final class GetBagelUseCase$invoke$2 extends Lambda implements Function1<Optional<Bagel>, b0<? extends Optional<Bagel>>> {
    final /* synthetic */ GetBagelUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetBagelUseCase$invoke$2(GetBagelUseCase getBagelUseCase) {
        super(1);
        this.this$0 = getBagelUseCase;
    }

    /* access modifiers changed from: private */
    public static final Optional d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Optional) function1.invoke(obj);
    }

    /* renamed from: c */
    public final b0<? extends Optional<Bagel>> invoke(Optional<Bagel> optional) {
        j.g(optional, "optionalBagel");
        if (!optional.isPresent()) {
            return w.C(Optional.empty());
        }
        Bagel bagel = optional.get();
        j.f(bagel, "optionalBagel.get()");
        final Bagel bagel2 = bagel;
        ProfileRepositoryV2 c10 = this.this$0.f12892d;
        String profileId = bagel2.getProfileId();
        j.f(profileId, "mutableBagel.profileId");
        return c10.n(profileId).L().D(new y0(new Function1<Pair<? extends l, ? extends List<? extends Photo>>, Optional<Bagel>>() {
            /* renamed from: a */
            public final Optional<Bagel> invoke(Pair<l, ? extends List<Photo>> pair) {
                j.g(pair, "profilePhotos");
                NetworkProfile g10 = ProfileMappersKt.g(pair.c(), (b) null);
                Iterable<Photo> iterable = (Iterable) pair.d();
                ArrayList arrayList = new ArrayList(r.t(iterable, 10));
                for (Photo e10 : iterable) {
                    arrayList.add(c.e(e10));
                }
                g10.setPhotos(arrayList);
                bagel2.setProfile(g10);
                return Optional.of(bagel2);
            }
        }));
    }
}
