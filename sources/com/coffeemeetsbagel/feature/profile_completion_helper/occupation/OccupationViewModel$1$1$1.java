package com.coffeemeetsbagel.feature.profile_completion_helper.occupation;

import com.coffeemeetsbagel.qna.QuestionWAnswers;
import gk.g;
import java.util.List;
import java.util.Optional;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import pk.n;

@d(c = "com.coffeemeetsbagel.feature.profile_completion_helper.occupation.OccupationViewModel$1$1$1", f = "OccupationViewModel.kt", l = {}, m = "invokeSuspend")
final class OccupationViewModel$1$1$1 extends SuspendLambda implements n<Optional<QuestionWAnswers>, Optional<QuestionWAnswers>, c<? super List<? extends QuestionWAnswers>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    OccupationViewModel$1$1$1(c<? super OccupationViewModel$1$1$1> cVar) {
        super(3, cVar);
    }

    /* renamed from: i */
    public final Object l(Optional<QuestionWAnswers> optional, Optional<QuestionWAnswers> optional2, c<? super List<QuestionWAnswers>> cVar) {
        OccupationViewModel$1$1$1 occupationViewModel$1$1$1 = new OccupationViewModel$1$1$1(cVar);
        occupationViewModel$1$1$1.L$0 = optional;
        occupationViewModel$1$1$1.L$1 = optional2;
        return occupationViewModel$1$1$1.invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            return q.m((QuestionWAnswers) ((Optional) this.L$0).get(), (QuestionWAnswers) ((Optional) this.L$1).get());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
