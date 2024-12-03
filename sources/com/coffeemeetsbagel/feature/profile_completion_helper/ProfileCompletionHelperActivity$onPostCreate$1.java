package com.coffeemeetsbagel.feature.profile_completion_helper;

import android.widget.ProgressBar;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ProfileCompletionHelperActivity$onPostCreate$1 extends Lambda implements Function1<List<? extends QuestionWAnswers>, Unit> {
    final /* synthetic */ ProfileCompletionHelperActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfileCompletionHelperActivity$onPostCreate$1(ProfileCompletionHelperActivity profileCompletionHelperActivity) {
        super(1);
        this.this$0 = profileCompletionHelperActivity;
    }

    public final void a(List<QuestionWAnswers> list) {
        ProgressBar E0 = this.this$0.f13176k;
        if (E0 != null) {
            E0.setMax((int) (this.this$0.f13177l * ((float) list.size())));
        }
        ProfileCompletionHelperActivity profileCompletionHelperActivity = this.this$0;
        ProfileCompletionHelperViewModel O0 = profileCompletionHelperActivity.O0();
        j.f(list, "it");
        profileCompletionHelperActivity.Z0(O0.l(list, this.this$0.f13180p));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}
