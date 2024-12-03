package com.coffeemeetsbagel.fragments;

import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class FragmentMyProfileDetails$fillFields$1$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ QuestionGroupType $type;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FragmentMyProfileDetails$fillFields$1$2(QuestionGroupType questionGroupType) {
        super(1);
        this.$type = questionGroupType;
    }

    public final void a(Throwable th2) {
        j.f(th2, "throwable");
        a.f40771d.c("FragmentMyProfileDetails", "Failed to set up question group " + this.$type, th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
