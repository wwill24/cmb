package com.coffeemeetsbagel.settings;

import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.models.dto.Question;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import gk.g;
import java.util.ArrayList;
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

@d(c = "com.coffeemeetsbagel.settings.SettingsViewModel$updateMetric$1", f = "SettingsViewModel.kt", l = {81}, m = "invokeSuspend")
final class SettingsViewModel$updateMetric$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ String $units;
    int label;
    final /* synthetic */ SettingsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingsViewModel$updateMetric$1(SettingsViewModel settingsViewModel, String str, c<? super SettingsViewModel$updateMetric$1> cVar) {
        super(2, cVar);
        this.this$0 = settingsViewModel;
        this.$units = str;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new SettingsViewModel$updateMetric$1(this.this$0, this.$units, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((SettingsViewModel$updateMetric$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            Object f10 = this.this$0.f36391i.f();
            j.d(f10);
            Question e10 = ((QuestionWAnswers) f10).e();
            SaveAnswerUseCase g10 = this.this$0.f36389g;
            List<Option> options = e10.getOptions();
            String str = this.$units;
            ArrayList<Option> arrayList = new ArrayList<>();
            for (T next : options) {
                if (j.b(((Option) next).getName(), str)) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(r.t(arrayList, 10));
            for (Option id2 : arrayList) {
                arrayList2.add(id2.getId());
            }
            a d11 = SaveAnswerUseCase.d(g10, arrayList2, (String) null, e10.getId(), e10.getGroup().getQuestionGroupApiString(), (Integer) null, (Float) null, (Float) null, (Float) null, false, (Location) null, 1010, (Object) null);
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
