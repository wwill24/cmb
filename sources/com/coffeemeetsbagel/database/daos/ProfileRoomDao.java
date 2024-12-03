package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.dto.ProfileDataContract;
import com.coffeemeetsbagel.models.entities.PhotoEntity;
import com.coffeemeetsbagel.models.entities.ProfileEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import qj.h;
import u6.k;

public abstract class ProfileRoomDao implements l<ProfileEntity>, k {
    /* access modifiers changed from: private */
    public static final Optional v(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Optional) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Pair x(Function2 function2, Object obj, Object obj2) {
        j.g(function2, "$tmp0");
        return (Pair) function2.invoke(obj, obj2);
    }

    /* access modifiers changed from: private */
    public static final List y(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    public abstract h<Map<ProfileEntity, List<PhotoEntity>>> A(List<String> list);

    public h<Optional<ProfileEntity>> a(String str) {
        j.g(str, "profileId");
        h<R> Y = z(str).v().Y(new h0(ProfileRoomDao$getProfile$1.f11611a));
        j.f(Y, "queryProfile(profileId)\n…)\n            }\n        }");
        return Y;
    }

    public int c(List<ProfileEntity> list) {
        j.g(list, "entities");
        return o(list);
    }

    public h<List<ProfileDataContract>> f(List<String> list) {
        j.g(list, "ids");
        h<R> Y = w(list).Y(new f0(ProfileRoomDao$getProfiles$1.f11612a));
        j.f(Y, "getProfileEntities(ids).…{ t -> t.map { p -> p } }");
        return Y;
    }

    public h<Map<ProfileEntity, List<PhotoEntity>>> g(List<String> list) {
        j.g(list, "ids");
        h<Map<ProfileEntity, List<PhotoEntity>>> v10 = A(list).v();
        j.f(v10, "queryProfiles(ids)\n     …  .distinctUntilChanged()");
        return v10;
    }

    public h<Pair<ProfileEntity, List<PhotoEntity>>> i(String str) {
        j.g(str, "id");
        h<Pair<ProfileEntity, List<PhotoEntity>>> n10 = h.n(a(str).v(), u(str).v(), new g0(new ProfileRoomDao$getProfileWithPhotos$1(str)));
        j.f(n10, "id: String): Flowable<Pa…t(), photoList)\n        }");
        return n10;
    }

    public int o(List<ProfileEntity> list) {
        ProfileEntity profileEntity;
        j.g(list, "data");
        List<Long> s10 = s(list);
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (T next : s10) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                q.s();
            }
            if (-1 == ((Number) next).longValue()) {
                profileEntity = list.get(i10);
            } else {
                profileEntity = null;
            }
            if (profileEntity != null) {
                arrayList.add(profileEntity);
            }
            i10 = i11;
        }
        return (list.size() - arrayList.size()) + k(arrayList);
    }

    public abstract h<List<PhotoEntity>> u(String str);

    public abstract h<List<ProfileEntity>> w(List<String> list);

    public abstract h<List<ProfileEntity>> z(String str);
}
