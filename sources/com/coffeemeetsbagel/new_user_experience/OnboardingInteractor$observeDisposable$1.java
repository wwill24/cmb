package com.coffeemeetsbagel.new_user_experience;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class OnboardingInteractor$observeDisposable$1 extends Lambda implements Function1<T, Unit> {
    final /* synthetic */ Function1<T, Unit> $consumer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OnboardingInteractor$observeDisposable$1(Function1<? super T, Unit> function1) {
        super(1);
        this.$consumer = function1;
    }

    public final void a(T t10) {
        this.$consumer.invoke(t10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a(obj);
        return Unit.f32013a;
    }
}
