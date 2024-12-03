package com.coffeemeetsbagel.new_user_experience.biography;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class BiographyInteractor$updateSchool$1$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ boolean $shouldLaunchSkipDialog;
    final /* synthetic */ BiographyInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BiographyInteractor$updateSchool$1$1(boolean z10, BiographyInteractor biographyInteractor) {
        super(1);
        this.$shouldLaunchSkipDialog = z10;
        this.this$0 = biographyInteractor;
    }

    public final void a(Integer num) {
        if (this.$shouldLaunchSkipDialog) {
            this.this$0.R2("School Name");
        } else {
            this.this$0.L2();
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Integer) obj);
        return Unit.f32013a;
    }
}
