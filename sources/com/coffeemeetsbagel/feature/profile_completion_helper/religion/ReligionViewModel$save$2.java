package com.coffeemeetsbagel.feature.profile_completion_helper.religion;

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
import tj.b;

@d(c = "com.coffeemeetsbagel.feature.profile_completion_helper.religion.ReligionViewModel$save$2", f = "ReligionViewModel.kt", l = {}, m = "invokeSuspend")
final class ReligionViewModel$save$2 extends SuspendLambda implements Function2<k0, c<? super b>, Object> {
    final /* synthetic */ List<String> $optionIds;
    final /* synthetic */ String $questionId;
    final /* synthetic */ String $questionTypeApiString;
    int label;
    final /* synthetic */ ReligionViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReligionViewModel$save$2(ReligionViewModel religionViewModel, List<String> list, String str, String str2, c<? super ReligionViewModel$save$2> cVar) {
        super(2, cVar);
        this.this$0 = religionViewModel;
        this.$optionIds = list;
        this.$questionId = str;
        this.$questionTypeApiString = str2;
    }

    /* access modifiers changed from: private */
    public static final void k(ReligionViewModel religionViewModel) {
        a.f40771d.a(religionViewModel.f13356g, "save answer - success");
    }

    /* access modifiers changed from: private */
    public static final void m(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new ReligionViewModel$save$2(this.this$0, this.$optionIds, this.$questionId, this.$questionTypeApiString, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super b> cVar) {
        return ((ReligionViewModel$save$2) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            qj.a d10 = SaveAnswerUseCase.d(this.this$0.f13353d, this.$optionIds, (String) null, this.$questionId, this.$questionTypeApiString, (Integer) null, (Float) null, (Float) null, (Float) null, false, (Location) null, 1010, (Object) null);
            d dVar = new d(this.this$0);
            final ReligionViewModel religionViewModel = this.this$0;
            return d10.f(dVar, new e(new Function1<Throwable, Unit>() {
                public final void a(Throwable th2) {
                    j.g(th2, "throwable");
                    a.f40771d.c(religionViewModel.f13356g, "Unable to save answer", th2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((Throwable) obj);
                    return Unit.f32013a;
                }
            }));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
