package com.coffeemeetsbagel.feature.profile_completion_helper.education;

import android.view.View;
import com.coffeemeetsbagel.cmb_views.CmbEditText;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class EducationFragment$onCreateView$4 extends Lambda implements Function1<Pair<? extends List<? extends QuestionWAnswers>, ? extends List<? extends QuestionWAnswers>>, Unit> {
    final /* synthetic */ EducationFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EducationFragment$onCreateView$4(EducationFragment educationFragment) {
        super(1);
        this.this$0 = educationFragment;
    }

    /* access modifiers changed from: private */
    public static final void e(EducationFragment educationFragment, List list, View view) {
        j.g(educationFragment, "this$0");
        j.g(list, "$degreeQnaList");
        CmbEditText cmbEditText = educationFragment.F0().f15805b;
        j.f(cmbEditText, "binding.degree1TextView");
        educationFragment.R0(cmbEditText, (QuestionWAnswers) list.get(0));
    }

    /* access modifiers changed from: private */
    public static final void f(EducationFragment educationFragment, List list, View view) {
        j.g(educationFragment, "this$0");
        j.g(list, "$degreeQnaList");
        CmbEditText cmbEditText = educationFragment.F0().f15806c;
        j.f(cmbEditText, "binding.degree2TextView");
        educationFragment.S0(cmbEditText, (QuestionWAnswers) list.get(1));
    }

    public final void d(Pair<? extends List<QuestionWAnswers>, ? extends List<QuestionWAnswers>> pair) {
        List list = (List) pair.d();
        this.this$0.Q0((List) pair.c(), list);
        this.this$0.F0().f15805b.setOnClickListener(new c(this.this$0, list));
        this.this$0.F0().f15806c.setOnClickListener(new d(this.this$0, list));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        d((Pair) obj);
        return Unit.f32013a;
    }
}
