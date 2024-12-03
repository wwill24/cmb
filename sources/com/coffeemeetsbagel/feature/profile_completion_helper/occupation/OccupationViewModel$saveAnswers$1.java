package com.coffeemeetsbagel.feature.profile_completion_helper.occupation;

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

@d(c = "com.coffeemeetsbagel.feature.profile_completion_helper.occupation.OccupationViewModel$saveAnswers$1", f = "OccupationViewModel.kt", l = {54, 61}, m = "invokeSuspend")
final class OccupationViewModel$saveAnswers$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ QuestionWAnswers $employerQ;
    final /* synthetic */ String $employerText;
    final /* synthetic */ QuestionWAnswers $occupationQ;
    final /* synthetic */ String $occupationText;
    int label;
    final /* synthetic */ OccupationViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OccupationViewModel$saveAnswers$1(OccupationViewModel occupationViewModel, String str, QuestionWAnswers questionWAnswers, String str2, QuestionWAnswers questionWAnswers2, c<? super OccupationViewModel$saveAnswers$1> cVar) {
        super(2, cVar);
        this.this$0 = occupationViewModel;
        this.$occupationText = str;
        this.$occupationQ = questionWAnswers;
        this.$employerText = str2;
        this.$employerQ = questionWAnswers2;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new OccupationViewModel$saveAnswers$1(this.this$0, this.$occupationText, this.$occupationQ, this.$employerText, this.$employerQ, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((OccupationViewModel$saveAnswers$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            SaveAnswerUseCase f10 = this.this$0.f13332d;
            String str = this.$occupationText;
            QuestionWAnswers questionWAnswers = this.$occupationQ;
            j.d(questionWAnswers);
            a d11 = SaveAnswerUseCase.d(f10, (List) null, str, questionWAnswers.e().getId(), this.$occupationQ.e().getGroup().getQuestionGroupApiString(), (Integer) null, (Float) null, (Float) null, (Float) null, false, (Location) null, 1008, (Object) null);
            this.label = 1;
            if (RxAwaitKt.a(d11, this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else if (i10 == 2) {
            g.b(obj);
            return Unit.f32013a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        SaveAnswerUseCase f11 = this.this$0.f13332d;
        String str2 = this.$employerText;
        QuestionWAnswers questionWAnswers2 = this.$employerQ;
        j.d(questionWAnswers2);
        a d12 = SaveAnswerUseCase.d(f11, (List) null, str2, questionWAnswers2.e().getId(), this.$employerQ.e().getGroup().getQuestionGroupApiString(), (Integer) null, (Float) null, (Float) null, (Float) null, false, (Location) null, 1008, (Object) null);
        this.label = 2;
        if (RxAwaitKt.a(d12, this) == d10) {
            return d10;
        }
        return Unit.f32013a;
    }
}
