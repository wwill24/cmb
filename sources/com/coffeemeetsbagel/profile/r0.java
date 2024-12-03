package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkProfile;
import kotlin.jvm.internal.j;
import qj.w;

public final class r0 {

    /* renamed from: a  reason: collision with root package name */
    private final UserRepository f36139a;

    public r0(UserRepository userRepository) {
        j.g(userRepository, "userRepository");
        this.f36139a = userRepository;
    }

    public final w<Integer> a(ModelProfileUpdateDelta modelProfileUpdateDelta, NetworkProfile networkProfile) {
        j.g(modelProfileUpdateDelta, "delta");
        j.g(networkProfile, "changedProfile");
        return this.f36139a.x(modelProfileUpdateDelta, networkProfile);
    }
}
