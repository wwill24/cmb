package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.photo.Photo;
import dk.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.h;
import qj.w;
import u6.k;

public final class ProfileRepositoryV2 {

    /* renamed from: a  reason: collision with root package name */
    private final k f36026a;

    public ProfileRepositoryV2(k kVar) {
        j.g(kVar, "profileDao");
        this.f36026a = kVar;
    }

    /* access modifiers changed from: private */
    public static final Optional i(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Optional) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Optional k(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Optional) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Pair m(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Pair) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Pair o(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Pair) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final List q(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Map s(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Map) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Integer u(List list, ProfileRepositoryV2 profileRepositoryV2) {
        j.g(list, "$profiles");
        j.g(profileRepositoryV2, "this$0");
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(ProfileMappersKt.c((NetworkProfile) it.next()));
        }
        return Integer.valueOf(profileRepositoryV2.f36026a.c(arrayList));
    }

    public final h<Optional<NetworkProfile>> h(String str) {
        j.g(str, "profileId");
        h<R> Y = this.f36026a.a(str).o0(a.c()).Y(new v(ProfileRepositoryV2$getNetworkProfile$1.f36027a));
        j.f(Y, "profileDao.getProfile(pr…          }\n            }");
        return Y;
    }

    public final h<Optional<l>> j(String str) {
        j.g(str, "profileId");
        h<R> Y = this.f36026a.a(str).o0(a.c()).Y(new q(ProfileRepositoryV2$getProfileLocal$1.f36028a));
        j.f(Y, "profileDao.getProfile(pr…          }\n            }");
        return Y;
    }

    public final h<Pair<l, List<Photo>>> l(String str) {
        j.g(str, "id");
        h<R> Y = this.f36026a.i(str).o0(a.c()).Y(new p(ProfileRepositoryV2$getProfileWithPhotos$1.f36029a));
        j.f(Y, "profileDao.getProfileWit…Domain() })\n            }");
        return Y;
    }

    public final h<Pair<l, List<Photo>>> n(String str) {
        j.g(str, "profileId");
        h<R> Y = this.f36026a.g(p.e(str)).o0(a.c()).Y(new s(ProfileRepositoryV2$getProfileWithPhotosLegacy$1.f36030a));
        j.f(Y, "profileDao.getProfilesWi…   .first()\n            }");
        return Y;
    }

    public final w<List<Pair<l, List<Photo>>>> p(List<String> list) {
        j.g(list, "profileIds");
        w<R> D = this.f36026a.g(list).o0(a.c()).L().D(new r(ProfileRepositoryV2$getProfilesWithPhotos$1.f36031a));
        j.f(D, "profileDao.getProfilesWi…  .toList()\n            }");
        return D;
    }

    public final h<Map<String, NetworkProfile>> r(List<String> list) {
        j.g(list, "ids");
        h<R> Y = this.f36026a.g(list).o0(a.c()).Y(new t(ProfileRepositoryV2$getProfilesWithPhotosLegacy$1.f36032a));
        j.f(Y, "profileDao.getProfilesWi…   .toMap()\n            }");
        return Y;
    }

    public final w<Integer> t(List<? extends NetworkProfile> list) {
        j.g(list, "profiles");
        w<Integer> K = w.A(new u(list, this)).K(a.c());
        j.f(K, "fromCallable {\n         …scribeOn(Schedulers.io())");
        return K;
    }
}
