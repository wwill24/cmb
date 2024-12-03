package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.dto.Capability;
import com.coffeemeetsbagel.models.entities.CapabilityType;
import com.coffeemeetsbagel.photo.Photo;
import fa.a;
import ja.b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import kotlin.Triple;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.h;
import rn.a;
import v6.c;

final class GetMyOwnProfileTmpUseCase$invoke$1 extends Lambda implements Function1<b, a<? extends Optional<NetworkProfile>>> {
    final /* synthetic */ GetMyOwnProfileTmpUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetMyOwnProfileTmpUseCase$invoke$1(GetMyOwnProfileTmpUseCase getMyOwnProfileTmpUseCase) {
        super(1);
        this.this$0 = getMyOwnProfileTmpUseCase;
    }

    /* access modifiers changed from: private */
    public static final Optional d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Optional) function1.invoke(obj);
    }

    /* renamed from: c */
    public final a<? extends Optional<NetworkProfile>> invoke(final b bVar) {
        j.g(bVar, "user");
        a.C0491a aVar = fa.a.f40771d;
        String e10 = this.this$0.f36017e;
        String u10 = bVar.u();
        aVar.a(e10, "got user " + u10);
        h<Triple<T1, T2, T3>> c10 = ck.a.f24943a.c(this.this$0.f36013a.j(bVar.u()), this.this$0.f36015c.f(bVar.u()), this.this$0.f36016d.b());
        final GetMyOwnProfileTmpUseCase getMyOwnProfileTmpUseCase = this.this$0;
        return c10.Y(new e(new Function1<Triple<? extends Optional<l>, ? extends List<? extends Photo>, ? extends List<? extends Capability>>, Optional<NetworkProfile>>() {
            /* renamed from: a */
            public final Optional<NetworkProfile> invoke(Triple<Optional<l>, ? extends List<Photo>, ? extends List<? extends Capability>> triple) {
                boolean z10;
                j.g(triple, "triple");
                fa.a.f40771d.a(getMyOwnProfileTmpUseCase.f36017e, "got triple");
                if (!triple.a().isPresent()) {
                    return Optional.empty();
                }
                Object obj = triple.a().get();
                j.f(obj, "triple.first.get()");
                l lVar = (l) obj;
                Iterable<Photo> iterable = (Iterable) triple.b();
                ArrayList arrayList = new ArrayList(r.t(iterable, 10));
                for (Photo e10 : iterable) {
                    arrayList.add(c.e(e10));
                }
                Iterable iterable2 = (Iterable) triple.c();
                LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(r.t(iterable2, 10)), 16));
                for (Object next : iterable2) {
                    linkedHashMap.put(((Capability) next).getCapability(), next);
                }
                NetworkProfile g10 = ProfileMappersKt.g(lVar, bVar);
                g10.setPhotos(arrayList);
                Capability capability = (Capability) linkedHashMap.get(CapabilityType.SEE_ALL_LIKES_YOU);
                boolean z11 = false;
                if (capability != null) {
                    z10 = capability.getEnabled();
                } else {
                    z10 = false;
                }
                g10.setHasLimelight(z10);
                Capability capability2 = (Capability) linkedHashMap.get(CapabilityType.PREMIUM_PREFERENCES);
                if (capability2 != null) {
                    z11 = capability2.getEnabled();
                }
                g10.setHasPremiumPreferences(z11);
                return Optional.of(g10);
            }
        }));
    }
}
