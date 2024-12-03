package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.entities.ProfileEntity;
import java.util.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ProfileRepositoryV2$getNetworkProfile$1 extends Lambda implements Function1<Optional<ProfileEntity>, Optional<NetworkProfile>> {

    /* renamed from: a  reason: collision with root package name */
    public static final ProfileRepositoryV2$getNetworkProfile$1 f36027a = new ProfileRepositoryV2$getNetworkProfile$1();

    ProfileRepositoryV2$getNetworkProfile$1() {
        super(1);
    }

    /* renamed from: a */
    public final Optional<NetworkProfile> invoke(Optional<ProfileEntity> optional) {
        j.g(optional, "it");
        if (!optional.isPresent()) {
            return Optional.empty();
        }
        ProfileEntity profileEntity = optional.get();
        j.f(profileEntity, "it.get()");
        return Optional.of(ProfileMappersKt.f(profileEntity));
    }
}
