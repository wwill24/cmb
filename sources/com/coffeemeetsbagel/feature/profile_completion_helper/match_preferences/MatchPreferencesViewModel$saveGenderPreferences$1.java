package com.coffeemeetsbagel.feature.profile_completion_helper.match_preferences;

import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import gk.g;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.rx2.RxAwaitKt;
import qj.a;

@d(c = "com.coffeemeetsbagel.feature.profile_completion_helper.match_preferences.MatchPreferencesViewModel$saveGenderPreferences$1", f = "MatchPreferencesViewModel.kt", l = {116}, m = "invokeSuspend")
final class MatchPreferencesViewModel$saveGenderPreferences$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ QuestionWAnswers $genderPrefQuestion;
    final /* synthetic */ String $optionId;
    int label;
    final /* synthetic */ MatchPreferencesViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchPreferencesViewModel$saveGenderPreferences$1(MatchPreferencesViewModel matchPreferencesViewModel, String str, QuestionWAnswers questionWAnswers, c<? super MatchPreferencesViewModel$saveGenderPreferences$1> cVar) {
        super(2, cVar);
        this.this$0 = matchPreferencesViewModel;
        this.$optionId = str;
        this.$genderPrefQuestion = questionWAnswers;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new MatchPreferencesViewModel$saveGenderPreferences$1(this.this$0, this.$optionId, this.$genderPrefQuestion, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((MatchPreferencesViewModel$saveGenderPreferences$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            SaveAnswerUseCase f10 = this.this$0.f13288e;
            List e10 = p.e(this.$optionId);
            QuestionWAnswers questionWAnswers = this.$genderPrefQuestion;
            j.d(questionWAnswers);
            a d11 = SaveAnswerUseCase.d(f10, e10, (String) null, questionWAnswers.e().getId(), this.$genderPrefQuestion.e().getGroup().getQuestionGroupApiString(), (Integer) null, (Float) null, (Float) null, (Float) null, false, (Location) null, 1010, (Object) null);
            this.label = 1;
            if (RxAwaitKt.a(d11, this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f32013a;
    }
}
