package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.entities.PhotoEntity;
import com.coffeemeetsbagel.models.entities.ProfileEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import v6.c;

final class ProfileRepositoryV2$getProfilesWithPhotosLegacy$1 extends Lambda implements Function1<Map<ProfileEntity, ? extends List<? extends PhotoEntity>>, Map<String, ? extends NetworkProfile>> {

    /* renamed from: a  reason: collision with root package name */
    public static final ProfileRepositoryV2$getProfilesWithPhotosLegacy$1 f36032a = new ProfileRepositoryV2$getProfilesWithPhotosLegacy$1();

    ProfileRepositoryV2$getProfilesWithPhotosLegacy$1() {
        super(1);
    }

    /* renamed from: a */
    public final Map<String, NetworkProfile> invoke(Map<ProfileEntity, ? extends List<PhotoEntity>> map) {
        j.g(map, "map");
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            Iterable<PhotoEntity> iterable = (Iterable) next.getValue();
            ArrayList arrayList2 = new ArrayList(r.t(iterable, 10));
            for (PhotoEntity d10 : iterable) {
                arrayList2.add(c.d(d10));
            }
            ProfileEntity profileEntity = (ProfileEntity) next.getKey();
            NetworkProfile f10 = ProfileMappersKt.f(profileEntity);
            f10.setPhotos(arrayList2);
            arrayList.add(new Pair(profileEntity.getId(), f10));
        }
        return h0.s(arrayList);
    }
}
