package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.models.entities.PhotoEntity;
import com.coffeemeetsbagel.models.entities.ProfileEntity;
import com.coffeemeetsbagel.photo.Photo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import v6.c;

final class ProfileRepositoryV2$getProfileWithPhotos$1 extends Lambda implements Function1<Pair<? extends ProfileEntity, ? extends List<? extends PhotoEntity>>, Pair<? extends l, ? extends List<? extends Photo>>> {

    /* renamed from: a  reason: collision with root package name */
    public static final ProfileRepositoryV2$getProfileWithPhotos$1 f36029a = new ProfileRepositoryV2$getProfileWithPhotos$1();

    ProfileRepositoryV2$getProfileWithPhotos$1() {
        super(1);
    }

    /* renamed from: a */
    public final Pair<l, List<Photo>> invoke(Pair<ProfileEntity, ? extends List<PhotoEntity>> pair) {
        j.g(pair, "entityPair");
        l d10 = ProfileMappersKt.d(pair.c());
        Iterable<PhotoEntity> iterable = (Iterable) pair.d();
        ArrayList arrayList = new ArrayList(r.t(iterable, 10));
        for (PhotoEntity c10 : iterable) {
            arrayList.add(c.c(c10));
        }
        return new Pair<>(d10, arrayList);
    }
}
