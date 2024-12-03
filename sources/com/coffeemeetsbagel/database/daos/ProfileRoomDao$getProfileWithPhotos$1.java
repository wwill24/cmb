package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.entities.PhotoEntity;
import com.coffeemeetsbagel.models.entities.ProfileEntity;
import java.util.List;
import java.util.Optional;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ProfileRoomDao$getProfileWithPhotos$1 extends Lambda implements Function2<Optional<ProfileEntity>, List<? extends PhotoEntity>, Pair<? extends ProfileEntity, ? extends List<? extends PhotoEntity>>> {
    final /* synthetic */ String $id;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfileRoomDao$getProfileWithPhotos$1(String str) {
        super(2);
        this.$id = str;
    }

    /* renamed from: a */
    public final Pair<ProfileEntity, List<PhotoEntity>> invoke(Optional<ProfileEntity> optional, List<PhotoEntity> list) {
        j.g(optional, "profileOptional");
        j.g(list, "photoList");
        if (!i0.a(optional)) {
            return new Pair<>(optional.get(), list);
        }
        throw new Exception("Missing profile: " + this.$id);
    }
}
