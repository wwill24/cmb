package com.coffeemeetsbagel.school.data;

import com.coffeemeetsbagel.school.data.SchoolRepository;
import java.util.concurrent.Callable;

public final /* synthetic */ class g implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SchoolRepository f36367a;

    public /* synthetic */ g(SchoolRepository schoolRepository) {
        this.f36367a = schoolRepository;
    }

    public final Object call() {
        return SchoolRepository.AnonymousClass2.d(this.f36367a);
    }
}
