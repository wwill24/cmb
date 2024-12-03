package com.coffeemeetsbagel.new_user_experience.gender;

import ab.a;
import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.models.entities.GenderType;
import com.coffeemeetsbagel.models.enums.ProfileQuestion;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GenderInteractor$didBecomeActive$1 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ GenderInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenderInteractor$didBecomeActive$1(GenderInteractor genderInteractor) {
        super(1);
        this.this$0 = genderInteractor;
    }

    public final void a(a aVar) {
        GenderType genderType;
        T t10;
        boolean z10;
        GenderInteractor genderInteractor = this.this$0;
        Iterator<T> it = aVar.b().iterator();
        while (true) {
            genderType = null;
            if (!it.hasNext()) {
                t10 = null;
                break;
            }
            t10 = it.next();
            if (j.b(((QuestionWAnswers) t10).e().getName(), ProfileQuestion.GENDER_IDENTITY.getApiKey())) {
                break;
            }
        }
        genderInteractor.f34991t = (QuestionWAnswers) t10;
        QuestionWAnswers Q1 = this.this$0.f34991t;
        if (Q1 != null) {
            GenderInteractor genderInteractor2 = this.this$0;
            List<Option> options = Q1.e().getOptions();
            LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(r.t(options, 10)), 16));
            for (T next : options) {
                linkedHashMap.put(((Option) next).getId(), next);
            }
            Iterator<Answer> it2 = Q1.d().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Answer next2 = it2.next();
                if (next2.getOptionId() != null && linkedHashMap.containsKey(next2.getOptionId())) {
                    GenderType.Companion companion = GenderType.Companion;
                    Object obj = linkedHashMap.get(next2.getOptionId());
                    j.d(obj);
                    String name = ((Option) obj).getName();
                    j.d(name);
                    genderType = companion.fromApiKey(name);
                    break;
                }
            }
            ((GenderPresenter) genderInteractor2.f7875e).v(Q1.e().getText());
            if (genderType == null || genderType == GenderType.MALE || genderType == GenderType.FEMALE) {
                z10 = true;
            } else {
                z10 = false;
            }
            ((GenderPresenter) genderInteractor2.f7875e).w(Q1, z10);
            if (genderType != null) {
                ((GenderPresenter) genderInteractor2.f7875e).u(genderType);
            }
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((a) obj);
        return Unit.f32013a;
    }
}
