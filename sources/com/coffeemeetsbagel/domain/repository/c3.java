package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.NetworkProfile;
import java.util.concurrent.Callable;

public final /* synthetic */ class c3 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserRepository f12481a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NetworkProfile f12482b;

    public /* synthetic */ c3(UserRepository userRepository, NetworkProfile networkProfile) {
        this.f12481a = userRepository;
        this.f12482b = networkProfile;
    }

    public final Object call() {
        return UserRepository$refreshMyProfile$1.e(this.f12481a, this.f12482b);
    }
}
