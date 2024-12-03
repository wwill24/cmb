package com.coffeemeetsbagel.feature.profile_completion_helper.religion;

import android.view.View;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.feature.likepassflow.RowItemView;
import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ReligionFragment$onCreateView$1 extends Lambda implements Function1<QuestionWAnswers, Unit> {
    final /* synthetic */ ReligionFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReligionFragment$onCreateView$1(ReligionFragment religionFragment) {
        super(1);
        this.this$0 = religionFragment;
    }

    /* access modifiers changed from: private */
    public static final void d(ReligionFragment religionFragment, Option option, View view) {
        j.g(religionFragment, "this$0");
        j.g(option, "$option");
        religionFragment.F0(option.getId(), option.getTitle());
    }

    public final void c(QuestionWAnswers questionWAnswers) {
        List<Option> options = questionWAnswers.e().getOptions();
        ReligionFragment religionFragment = this.this$0;
        for (Option option : options) {
            View inflate = religionFragment.getLayoutInflater().inflate(R.layout.row_view_cmb_dls, religionFragment.A0().f15814b, false);
            j.e(inflate, "null cannot be cast to non-null type com.coffeemeetsbagel.feature.likepassflow.RowItemView");
            RowItemView rowItemView = (RowItemView) inflate;
            rowItemView.setText(option.getTitle());
            rowItemView.setOnClickListener(new a(religionFragment, option));
            religionFragment.C0().add(rowItemView);
            religionFragment.A0().f15814b.addView(rowItemView);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        c((QuestionWAnswers) obj);
        return Unit.f32013a;
    }
}
