package com.coffeemeetsbagel.limelight.profile_activity;

import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.dialogs.s;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class LikesYouProfilePresenter$connectionsDialog$2 extends Lambda implements Function0<s> {
    final /* synthetic */ LikesYouProfilePresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouProfilePresenter$connectionsDialog$2(LikesYouProfilePresenter likesYouProfilePresenter) {
        super(0);
        this.this$0 = likesYouProfilePresenter;
    }

    /* renamed from: a */
    public final s invoke() {
        return new s(this.this$0.f7869c.getContext(), (int) R.string.its_a_match, (int) R.string.you_liked_each_other, (int) R.string.start_chatting, (int) R.string.not_now, false);
    }
}
