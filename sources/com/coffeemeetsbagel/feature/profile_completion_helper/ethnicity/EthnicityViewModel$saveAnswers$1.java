package com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity;

import gk.g;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity.EthnicityViewModel$saveAnswers$1", f = "EthnicityViewModel.kt", l = {44}, m = "invokeSuspend")
final class EthnicityViewModel$saveAnswers$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ List<String> $optionIds;
    final /* synthetic */ String $questionId;
    final /* synthetic */ String $questionTypeApiString;
    int label;
    final /* synthetic */ EthnicityViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EthnicityViewModel$saveAnswers$1(EthnicityViewModel ethnicityViewModel, List<String> list, String str, String str2, c<? super EthnicityViewModel$saveAnswers$1> cVar) {
        super(2, cVar);
        this.this$0 = ethnicityViewModel;
        this.$optionIds = list;
        this.$questionId = str;
        this.$questionTypeApiString = str2;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new EthnicityViewModel$saveAnswers$1(this.this$0, this.$optionIds, this.$questionId, this.$questionTypeApiString, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((EthnicityViewModel$saveAnswers$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            EthnicityViewModel ethnicityViewModel = this.this$0;
            List<String> list = this.$optionIds;
            String str = this.$questionId;
            String str2 = this.$questionTypeApiString;
            this.label = 1;
            if (ethnicityViewModel.k(list, str, str2, this) == d10) {
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
