package com.coffeemeetsbagel.school.domain;

import com.coffeemeetsbagel.models.School;
import com.coffeemeetsbagel.school.data.SchoolRepository;
import fb.a;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.w;

public final class GetSingleSchoolsUseCase {

    /* renamed from: a  reason: collision with root package name */
    private final SchoolRepository f36373a;

    public GetSingleSchoolsUseCase(SchoolRepository schoolRepository) {
        j.g(schoolRepository, "repository");
        this.f36373a = schoolRepository;
    }

    /* access modifiers changed from: private */
    public static final List c(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    public final w<List<School>> b() {
        w<R> D = this.f36373a.p().D(new a(GetSingleSchoolsUseCase$invoke$1.f36374a));
        j.f(D, "repository.fetchAll()\n  …map { School(it.name) } }");
        return D;
    }
}
