package com.coffeemeetsbagel.match_view;

import android.content.Context;
import com.coffeemeetsbagel.dialogs.ChipSelectQuestionDialog;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.profile.ProfileView;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.j;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class MatchViewPresenter$showEditAnswerDialog$primaryClickListener$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ j $getQuestionsUseCase;
    final /* synthetic */ String $profileId;
    final /* synthetic */ QuestionGroupType $questionGroupType;
    final /* synthetic */ SaveAnswerUseCase $saveAnswerUseCase;
    final /* synthetic */ MatchViewPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchViewPresenter$showEditAnswerDialog$primaryClickListener$1(MatchViewPresenter matchViewPresenter, String str, QuestionGroupType questionGroupType, j jVar, SaveAnswerUseCase saveAnswerUseCase) {
        super(0);
        this.this$0 = matchViewPresenter;
        this.$profileId = str;
        this.$questionGroupType = questionGroupType;
        this.$getQuestionsUseCase = jVar;
        this.$saveAnswerUseCase = saveAnswerUseCase;
    }

    public final void invoke() {
        MatchViewPresenter matchViewPresenter = this.this$0;
        Context context = ((ProfileView) this.this$0.f7869c).getContext();
        kotlin.jvm.internal.j.f(context, "view.context");
        matchViewPresenter.f34649k = new ChipSelectQuestionDialog(context, this.$profileId, this.$questionGroupType, this.$getQuestionsUseCase, this.$saveAnswerUseCase);
        ChipSelectQuestionDialog C = this.this$0.f34649k;
        kotlin.jvm.internal.j.d(C);
        C.show();
    }
}
