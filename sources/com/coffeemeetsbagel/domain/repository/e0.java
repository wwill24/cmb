package com.coffeemeetsbagel.domain.repository;

import java.util.List;
import java.util.concurrent.Callable;

public final /* synthetic */ class e0 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f12493a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PhotoRepository f12494b;

    public /* synthetic */ e0(List list, PhotoRepository photoRepository) {
        this.f12493a = list;
        this.f12494b = photoRepository;
    }

    public final Object call() {
        return PhotoRepository.m(this.f12493a, this.f12494b);
    }
}
