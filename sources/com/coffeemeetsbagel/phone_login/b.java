package com.coffeemeetsbagel.phone_login;

import androidx.lifecycle.f0;
import androidx.lifecycle.i0;
import c7.d;
import com.coffeemeetsbagel.experiment.t;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.x0;
import m1.a;

public final class b extends i0.a {

    /* renamed from: i  reason: collision with root package name */
    private final d f35695i;

    /* renamed from: j  reason: collision with root package name */
    private final ga.b f35696j;

    /* renamed from: k  reason: collision with root package name */
    private final t f35697k;

    public b(d dVar, ga.b bVar, t tVar) {
        j.g(dVar, "retrofitContract");
        j.g(bVar, "rlcsManager");
        j.g(tVar, "remoteConfigManager");
        this.f35695i = dVar;
        this.f35696j = bVar;
        this.f35697k = tVar;
    }

    public <T extends f0> T b(Class<T> cls, a aVar) {
        j.g(cls, "modelClass");
        j.g(aVar, "extras");
        return new PhoneCodeViewModel(new PhoneLoginRepository(new qa.a(this.f35695i, this.f35696j, true), x0.b()));
    }
}
