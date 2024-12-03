package com.coffeemeetsbagel.new_user_experience.introductions;

import com.coffeemeetsbagel.new_user_experience.introductions.IntroductionsPresenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class IntroductionsPresenter$didLoad$5 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ IntroductionsPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntroductionsPresenter$didLoad$5(IntroductionsPresenter introductionsPresenter) {
        super(1);
        this.this$0 = introductionsPresenter;
    }

    public final void a(String str) {
        IntroductionsPresenter.a y10 = this.this$0.y();
        j.f(str, "it");
        y10.H0(StringsKt__StringsKt.W0(str).toString());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((String) obj);
        return Unit.f32013a;
    }
}
