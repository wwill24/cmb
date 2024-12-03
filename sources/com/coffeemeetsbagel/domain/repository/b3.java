package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.NetworkProfile;
import java.util.concurrent.Callable;

public final /* synthetic */ class b3 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserRepository f12476a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NetworkProfile f12477b;

    public /* synthetic */ b3(UserRepository userRepository, NetworkProfile networkProfile) {
        this.f12476a = userRepository;
        this.f12477b = networkProfile;
    }

    public final Object call() {
        return UserRepository.w(this.f12476a, this.f12477b);
    }
}
