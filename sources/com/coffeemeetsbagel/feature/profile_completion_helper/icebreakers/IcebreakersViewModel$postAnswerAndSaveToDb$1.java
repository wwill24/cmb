package com.coffeemeetsbagel.feature.profile_completion_helper.icebreakers;

import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import gk.g;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.rx2.RxAwaitKt;
import qj.a;

@d(c = "com.coffeemeetsbagel.feature.profile_completion_helper.icebreakers.IcebreakersViewModel$postAnswerAndSaveToDb$1", f = "IcebreakersViewModel.kt", l = {76}, m = "invokeSuspend")
final class IcebreakersViewModel$postAnswerAndSaveToDb$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ String $answer;
    final /* synthetic */ String $questionGroupApiString;
    final /* synthetic */ String $questionId;
    int label;
    final /* synthetic */ IcebreakersViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IcebreakersViewModel$postAnswerAndSaveToDb$1(IcebreakersViewModel icebreakersViewModel, String str, String str2, String str3, c<? super IcebreakersViewModel$postAnswerAndSaveToDb$1> cVar) {
        super(2, cVar);
        this.this$0 = icebreakersViewModel;
        this.$answer = str;
        this.$questionId = str2;
        this.$questionGroupApiString = str3;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new IcebreakersViewModel$postAnswerAndSaveToDb$1(this.this$0, this.$answer, this.$questionId, this.$questionGroupApiString, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((IcebreakersViewModel$postAnswerAndSaveToDb$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            a d11 = SaveAnswerUseCase.d(this.this$0.f13259d, (List) null, this.$answer, this.$questionId, this.$questionGroupApiString, (Integer) null, (Float) null, (Float) null, (Float) null, false, (Location) null, 1008, (Object) null);
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
