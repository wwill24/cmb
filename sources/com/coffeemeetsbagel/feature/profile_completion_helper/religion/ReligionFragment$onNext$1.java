package com.coffeemeetsbagel.feature.profile_completion_helper.religion;

import androidx.fragment.app.h;
import com.coffeemeetsbagel.feature.profile_completion_helper.ProfileCompletionHelperActivity;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ReligionFragment$onNext$1 extends Lambda implements Function0 {
    final /* synthetic */ ReligionFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReligionFragment$onNext$1(ReligionFragment religionFragment) {
        super(0);
        this.this$0 = religionFragment;
    }

    /* renamed from: a */
    public final Void invoke() {
        h requireActivity = this.this$0.requireActivity();
        j.e(requireActivity, "null cannot be cast to non-null type com.coffeemeetsbagel.feature.profile_completion_helper.ProfileCompletionHelperActivity");
        ((ProfileCompletionHelperActivity) requireActivity).next();
        return null;
    }
}
