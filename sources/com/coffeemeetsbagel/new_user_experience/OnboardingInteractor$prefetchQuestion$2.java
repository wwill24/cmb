package com.coffeemeetsbagel.new_user_experience;

import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class OnboardingInteractor$prefetchQuestion$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ QuestionGroupType $type;
    final /* synthetic */ OnboardingInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OnboardingInteractor$prefetchQuestion$2(OnboardingInteractor onboardingInteractor, QuestionGroupType questionGroupType) {
        super(1);
        this.this$0 = onboardingInteractor;
        this.$type = questionGroupType;
    }

    public final void a(Throwable th2) {
        j.f(th2, "throwable");
        a.f40771d.c(this.this$0.f34776n, "Failed to get " + this.$type + ".", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
