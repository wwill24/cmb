package com.coffeemeetsbagel.domain.repository;

import ja.c;
import java.util.concurrent.Callable;

public final /* synthetic */ class e3 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserRepository f12497a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f12498b;

    public /* synthetic */ e3(UserRepository userRepository, c cVar) {
        this.f12497a = userRepository;
        this.f12498b = cVar;
    }

    public final Object call() {
        return UserRepository$update$1.d(this.f12497a, this.f12498b);
    }
}
