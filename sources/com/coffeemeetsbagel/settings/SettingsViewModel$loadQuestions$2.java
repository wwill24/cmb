package com.coffeemeetsbagel.settings;

import com.coffeemeetsbagel.models.enums.ProfileQuestion;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.k0;

@d(c = "com.coffeemeetsbagel.settings.SettingsViewModel$loadQuestions$2", f = "SettingsViewModel.kt", l = {}, m = "invokeSuspend")
final class SettingsViewModel$loadQuestions$2 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ String $profileId;
    int label;
    final /* synthetic */ SettingsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingsViewModel$loadQuestions$2(SettingsViewModel settingsViewModel, String str, c<? super SettingsViewModel$loadQuestions$2> cVar) {
        super(2, cVar);
        this.this$0 = settingsViewModel;
        this.$profileId = str;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new SettingsViewModel$loadQuestions$2(this.this$0, this.$profileId, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((SettingsViewModel$loadQuestions$2) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            Object obj2 = this.this$0.f36388f.a(this.$profileId, ProfileQuestion.UNITS.getApiKey()).h().get();
            j.f(obj2, "getQuestionUseCase.invok…()\n                .get()");
            this.this$0.f36391i.m((QuestionWAnswers) obj2);
            return Unit.f32013a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
