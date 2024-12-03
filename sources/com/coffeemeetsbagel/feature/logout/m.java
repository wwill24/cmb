package com.coffeemeetsbagel.feature.logout;

import androidx.lifecycle.f0;
import androidx.lifecycle.i0;
import hb.c;
import kotlin.jvm.internal.j;
import m1.a;

public final class m extends i0.a {

    /* renamed from: i  reason: collision with root package name */
    private final c f13083i;

    public m(c cVar) {
        j.g(cVar, "sharedPrefManager");
        this.f13083i = cVar;
    }

    public <T extends f0> T b(Class<T> cls, a aVar) {
        j.g(cls, "modelClass");
        j.g(aVar, "extras");
        return new l(new n(this.f13083i));
    }
}
