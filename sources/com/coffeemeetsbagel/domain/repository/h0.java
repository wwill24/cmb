package com.coffeemeetsbagel.domain.repository;

import fj.d;
import fk.a;
import u6.i;

public final class h0 implements d<PhotoRepository> {

    /* renamed from: a  reason: collision with root package name */
    private final a<i> f12513a;

    public h0(a<i> aVar) {
        this.f12513a = aVar;
    }

    public static h0 a(a<i> aVar) {
        return new h0(aVar);
    }

    public static PhotoRepository c(i iVar) {
        return new PhotoRepository(iVar);
    }

    /* renamed from: b */
    public PhotoRepository get() {
        return c(this.f12513a.get());
    }
}
