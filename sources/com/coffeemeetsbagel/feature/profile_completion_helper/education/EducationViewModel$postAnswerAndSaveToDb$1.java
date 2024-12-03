package com.coffeemeetsbagel.feature.profile_completion_helper.education;

import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import fa.a;
import gk.g;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.k0;

@d(c = "com.coffeemeetsbagel.feature.profile_completion_helper.education.EducationViewModel$postAnswerAndSaveToDb$1", f = "EducationViewModel.kt", l = {}, m = "invokeSuspend")
final class EducationViewModel$postAnswerAndSaveToDb$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ String $answer;
    final /* synthetic */ String $questionGroupApiString;
    final /* synthetic */ String $questionId;
    final /* synthetic */ List<String> $selectedOptionIds;
    int label;
    final /* synthetic */ EducationViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EducationViewModel$postAnswerAndSaveToDb$1(EducationViewModel educationViewModel, List<String> list, String str, String str2, String str3, c<? super EducationViewModel$postAnswerAndSaveToDb$1> cVar) {
        super(2, cVar);
        this.this$0 = educationViewModel;
        this.$selectedOptionIds = list;
        this.$answer = str;
        this.$questionId = str2;
        this.$questionGroupApiString = str3;
    }

    /* access modifiers changed from: private */
    public static final void k(EducationViewModel educationViewModel) {
        a.C0491a aVar = a.f40771d;
        String i10 = educationViewModel.f13214f;
        j.f(i10, "tag");
        aVar.a(i10, "save answer - success");
    }

    /* access modifiers changed from: private */
    public static final void m(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new EducationViewModel$postAnswerAndSaveToDb$1(this.this$0, this.$selectedOptionIds, this.$answer, this.$questionId, this.$questionGroupApiString, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((EducationViewModel$postAnswerAndSaveToDb$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            SaveAnswerUseCase h10 = this.this$0.f13213e;
            List<String> list = this.$selectedOptionIds;
            String str = this.$answer;
            String str2 = this.$questionId;
            j.d(str2);
            qj.a d10 = SaveAnswerUseCase.d(h10, list, str, str2, this.$questionGroupApiString, (Integer) null, (Float) null, (Float) null, (Float) null, false, (Location) null, 1008, (Object) null);
            i iVar = new i(this.this$0);
            final EducationViewModel educationViewModel = this.this$0;
            d10.f(iVar, new j(new Function1<Throwable, Unit>() {
                public final void a(Throwable th2) {
                    j.g(th2, "throwable");
                    a.C0491a aVar = a.f40771d;
                    String i10 = educationViewModel.f13214f;
                    j.f(i10, "tag");
                    aVar.c(i10, "", th2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((Throwable) obj);
                    return Unit.f32013a;
                }
            }));
            return Unit.f32013a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
