package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.domain.repository.UserRepository$updateAppsFlyerId$1;
import ja.b;
import java.util.concurrent.Callable;

public final /* synthetic */ class g3 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f12509a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserRepository f12510b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b f12511c;

    public /* synthetic */ g3(String str, UserRepository userRepository, b bVar) {
        this.f12509a = str;
        this.f12510b = userRepository;
        this.f12511c = bVar;
    }

    public final Object call() {
        return UserRepository$updateAppsFlyerId$1.AnonymousClass1.d(this.f12509a, this.f12510b, this.f12511c);
    }
}
