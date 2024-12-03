package com.coffeemeetsbagel.profile;

import fj.d;
import fk.a;
import u6.k;

public final class w implements d<ProfileRepositoryV2> {

    /* renamed from: a  reason: collision with root package name */
    private final a<k> f36146a;

    public w(a<k> aVar) {
        this.f36146a = aVar;
    }

    public static w a(a<k> aVar) {
        return new w(aVar);
    }

    public static ProfileRepositoryV2 c(k kVar) {
        return new ProfileRepositoryV2(kVar);
    }

    /* renamed from: b */
    public ProfileRepositoryV2 get() {
        return c(this.f36146a.get());
    }
}
