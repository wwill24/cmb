package com.coffeemeetsbagel.school.domain;

import com.coffeemeetsbagel.models.School;
import eb.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GetSingleSchoolsUseCase$invoke$1 extends Lambda implements Function1<List<? extends d>, List<? extends School>> {

    /* renamed from: a  reason: collision with root package name */
    public static final GetSingleSchoolsUseCase$invoke$1 f36374a = new GetSingleSchoolsUseCase$invoke$1();

    GetSingleSchoolsUseCase$invoke$1() {
        super(1);
    }

    /* renamed from: a */
    public final List<School> invoke(List<d> list) {
        j.g(list, "list");
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (d b10 : list) {
            arrayList.add(new School(b10.b()));
        }
        return arrayList;
    }
}
