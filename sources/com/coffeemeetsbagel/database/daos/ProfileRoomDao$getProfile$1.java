package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.entities.ProfileEntity;
import java.util.List;
import java.util.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ProfileRoomDao$getProfile$1 extends Lambda implements Function1<List<? extends ProfileEntity>, Optional<ProfileEntity>> {

    /* renamed from: a  reason: collision with root package name */
    public static final ProfileRoomDao$getProfile$1 f11611a = new ProfileRoomDao$getProfile$1();

    ProfileRoomDao$getProfile$1() {
        super(1);
    }

    /* renamed from: a */
    public final Optional<ProfileEntity> invoke(List<ProfileEntity> list) {
        j.g(list, "it");
        if (list.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(list.get(0));
    }
}
