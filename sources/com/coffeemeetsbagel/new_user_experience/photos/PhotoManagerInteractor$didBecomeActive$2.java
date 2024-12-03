package com.coffeemeetsbagel.new_user_experience.photos;

import c6.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PhotoManagerInteractor$didBecomeActive$2 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ PhotoManagerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PhotoManagerInteractor$didBecomeActive$2(PhotoManagerInteractor photoManagerInteractor) {
        super(1);
        this.this$0 = photoManagerInteractor;
    }

    public final void a(a aVar) {
        PhotoManagerInteractor photoManagerInteractor = this.this$0;
        j.f(aVar, "activityResult");
        photoManagerInteractor.P1(aVar);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((a) obj);
        return Unit.f32013a;
    }
}
