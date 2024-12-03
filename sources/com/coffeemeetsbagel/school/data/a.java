package com.coffeemeetsbagel.school.data;

import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SchoolRepository f36361a;

    public /* synthetic */ a(SchoolRepository schoolRepository) {
        this.f36361a = schoolRepository;
    }

    public final Object call() {
        return SchoolRepository.g(this.f36361a);
    }
}
