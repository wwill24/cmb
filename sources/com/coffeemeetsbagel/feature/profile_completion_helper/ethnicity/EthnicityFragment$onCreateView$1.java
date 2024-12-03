package com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity;

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

final class EthnicityFragment$onCreateView$1 extends Lambda implements Function1<QuestionWAnswers, Unit> {
    final /* synthetic */ EthnicityFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EthnicityFragment$onCreateView$1(EthnicityFragment ethnicityFragment) {
        super(1);
        this.this$0 = ethnicityFragment;
    }

    /* access modifiers changed from: private */
    public static final void d(EthnicityFragment ethnicityFragment, Option option, RowItemView rowItemView, View view) {
        j.g(ethnicityFragment, "this$0");
        j.g(option, "$option");
        j.g(rowItemView, "$rowItemView");
        ethnicityFragment.F0(option.getId());
        rowItemView.setChecked(ethnicityFragment.f13241e.contains(option.getId()));
    }

    public final void c(QuestionWAnswers questionWAnswers) {
        List<Option> options = questionWAnswers.e().getOptions();
        EthnicityFragment ethnicityFragment = this.this$0;
        for (Option option : options) {
            View inflate = ethnicityFragment.getLayoutInflater().inflate(R.layout.row_view_cmb_dls, ethnicityFragment.B0().f15814b, false);
            j.e(inflate, "null cannot be cast to non-null type com.coffeemeetsbagel.feature.likepassflow.RowItemView");
            RowItemView rowItemView = (RowItemView) inflate;
            rowItemView.setText(option.getTitle());
            rowItemView.setOnClickListener(new a(ethnicityFragment, option, rowItemView));
            ethnicityFragment.B0().f15814b.addView(rowItemView);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        c((QuestionWAnswers) obj);
        return Unit.f32013a;
    }
}
