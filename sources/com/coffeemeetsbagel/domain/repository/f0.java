package com.coffeemeetsbagel.domain.repository;

import java.util.List;
import java.util.concurrent.Callable;

public final /* synthetic */ class f0 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PhotoRepository f12500a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f12501b;

    public /* synthetic */ f0(PhotoRepository photoRepository, List list) {
        this.f12500a = photoRepository;
        this.f12501b = list;
    }

    public final Object call() {
        return PhotoRepository.o(this.f12500a, this.f12501b);
    }
}
