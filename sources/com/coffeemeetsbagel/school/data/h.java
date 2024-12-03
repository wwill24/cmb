package com.coffeemeetsbagel.school.data;

import com.coffeemeetsbagel.school.data.SchoolRepository;
import java.util.List;
import java.util.concurrent.Callable;

public final /* synthetic */ class h implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SchoolRepository f36368a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f36369b;

    public /* synthetic */ h(SchoolRepository schoolRepository, List list) {
        this.f36368a = schoolRepository;
        this.f36369b = list;
    }

    public final Object call() {
        return SchoolRepository.AnonymousClass4.d(this.f36368a, this.f36369b);
    }
}
