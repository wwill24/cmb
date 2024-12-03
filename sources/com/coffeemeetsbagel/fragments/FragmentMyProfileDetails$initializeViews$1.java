package com.coffeemeetsbagel.fragments;

import com.coffeemeetsbagel.models.School;
import f5.i;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class FragmentMyProfileDetails$initializeViews$1 extends Lambda implements Function1<List<? extends School>, Unit> {
    final /* synthetic */ i $schoolAutoCompleteAdapter0;
    final /* synthetic */ i $schoolAutoCompleteAdapter1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FragmentMyProfileDetails$initializeViews$1(i iVar, i iVar2) {
        super(1);
        this.$schoolAutoCompleteAdapter0 = iVar;
        this.$schoolAutoCompleteAdapter1 = iVar2;
    }

    public final void a(List<School> list) {
        j.g(list, "schools");
        this.$schoolAutoCompleteAdapter0.c(list);
        this.$schoolAutoCompleteAdapter1.c(list);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}
