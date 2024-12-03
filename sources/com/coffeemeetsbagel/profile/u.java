package com.coffeemeetsbagel.profile;

import java.util.List;
import java.util.concurrent.Callable;

public final /* synthetic */ class u implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f36143a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProfileRepositoryV2 f36144b;

    public /* synthetic */ u(List list, ProfileRepositoryV2 profileRepositoryV2) {
        this.f36143a = list;
        this.f36144b = profileRepositoryV2;
    }

    public final Object call() {
        return ProfileRepositoryV2.u(this.f36143a, this.f36144b);
    }
}
