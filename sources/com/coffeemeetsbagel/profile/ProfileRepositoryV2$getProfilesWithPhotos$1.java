package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.models.entities.PhotoEntity;
import com.coffeemeetsbagel.models.entities.ProfileEntity;
import com.coffeemeetsbagel.photo.Photo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import v6.c;

final class ProfileRepositoryV2$getProfilesWithPhotos$1 extends Lambda implements Function1<Map<ProfileEntity, ? extends List<? extends PhotoEntity>>, List<? extends Pair<? extends l, ? extends List<? extends Photo>>>> {

    /* renamed from: a  reason: collision with root package name */
    public static final ProfileRepositoryV2$getProfilesWithPhotos$1 f36031a = new ProfileRepositoryV2$getProfilesWithPhotos$1();

    ProfileRepositoryV2$getProfilesWithPhotos$1() {
        super(1);
    }

    /* renamed from: a */
    public final List<Pair<l, List<Photo>>> invoke(Map<ProfileEntity, ? extends List<PhotoEntity>> map) {
        j.g(map, "map");
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            l d10 = ProfileMappersKt.d((ProfileEntity) next.getKey());
            Iterable<PhotoEntity> iterable = (Iterable) next.getValue();
            ArrayList arrayList2 = new ArrayList(r.t(iterable, 10));
            for (PhotoEntity c10 : iterable) {
                arrayList2.add(c.c(c10));
            }
            arrayList.add(new Pair(d10, arrayList2));
        }
        return CollectionsKt___CollectionsKt.x0(arrayList);
    }
}
