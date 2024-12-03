package com.coffeemeetsbagel.new_user_experience.biography;

import com.coffeemeetsbagel.new_user_experience.biography.BiographyPresenter;
import j5.x;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class BiographyPresenter$createTemplate$2 extends Lambda implements Function1<x, Unit> {
    final /* synthetic */ BiographyPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BiographyPresenter$createTemplate$2(BiographyPresenter biographyPresenter) {
        super(1);
        this.this$0 = biographyPresenter;
    }

    public final void a(x xVar) {
        BiographyPresenter.a.z(this.this$0.z(), false, 1, (Object) null);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((x) obj);
        return Unit.f32013a;
    }
}
