package com.coffeemeetsbagel.feature.profile_completion_helper.education;

import com.coffeemeetsbagel.models.School;
import f5.i;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class EducationFragment$onCreateView$1 extends Lambda implements Function1<List<? extends School>, Unit> {
    final /* synthetic */ i $schoolAutoCompleteAdapter1;
    final /* synthetic */ i $schoolAutoCompleteAdapter2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EducationFragment$onCreateView$1(i iVar, i iVar2) {
        super(1);
        this.$schoolAutoCompleteAdapter1 = iVar;
        this.$schoolAutoCompleteAdapter2 = iVar2;
    }

    public final void a(List<School> list) {
        this.$schoolAutoCompleteAdapter1.c(list);
        this.$schoolAutoCompleteAdapter2.c(list);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}
