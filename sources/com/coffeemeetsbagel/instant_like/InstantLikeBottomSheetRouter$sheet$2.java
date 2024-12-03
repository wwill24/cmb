package com.coffeemeetsbagel.instant_like;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import r5.b;

final class InstantLikeBottomSheetRouter$sheet$2 extends Lambda implements Function0<b> {
    final /* synthetic */ InstantLikeBottomSheetInteractor $interactor;
    final /* synthetic */ InstantLikeBottomSheetRouter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InstantLikeBottomSheetRouter$sheet$2(InstantLikeBottomSheetRouter instantLikeBottomSheetRouter, InstantLikeBottomSheetInteractor instantLikeBottomSheetInteractor) {
        super(0);
        this.this$0 = instantLikeBottomSheetRouter;
        this.$interactor = instantLikeBottomSheetInteractor;
    }

    /* renamed from: a */
    public final b invoke() {
        ConstraintLayout b10 = this.this$0.f14007f.getRoot();
        j.f(b10, "binding.root");
        b bVar = new b(b10, this.$interactor);
        bVar.setCancelable(true);
        return bVar;
    }
}
