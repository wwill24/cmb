package com.coffeemeetsbagel.limelight.profile_activity;

import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.like_pass.view.LikePassButtonsCenterDLSView;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class LikesYouProfilePresenter$ctasView$2 extends Lambda implements Function0<LikePassButtonsCenterDLSView> {
    final /* synthetic */ LikesYouProfilePresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouProfilePresenter$ctasView$2(LikesYouProfilePresenter likesYouProfilePresenter) {
        super(0);
        this.this$0 = likesYouProfilePresenter;
    }

    /* renamed from: a */
    public final LikePassButtonsCenterDLSView invoke() {
        return (LikePassButtonsCenterDLSView) this.this$0.f7869c.findViewById(R.id.like_pass_button);
    }
}
