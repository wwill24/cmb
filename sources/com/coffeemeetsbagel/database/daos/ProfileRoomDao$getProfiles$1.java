package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.dto.ProfileDataContract;
import com.coffeemeetsbagel.models.entities.ProfileEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ProfileRoomDao$getProfiles$1 extends Lambda implements Function1<List<? extends ProfileEntity>, List<? extends ProfileDataContract>> {

    /* renamed from: a  reason: collision with root package name */
    public static final ProfileRoomDao$getProfiles$1 f11612a = new ProfileRoomDao$getProfiles$1();

    ProfileRoomDao$getProfiles$1() {
        super(1);
    }

    /* renamed from: a */
    public final List<ProfileDataContract> invoke(List<ProfileEntity> list) {
        j.g(list, "t");
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (ProfileEntity add : list) {
            arrayList.add(add);
        }
        return arrayList;
    }
}
