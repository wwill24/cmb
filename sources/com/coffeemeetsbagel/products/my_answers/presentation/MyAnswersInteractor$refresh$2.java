package com.coffeemeetsbagel.products.my_answers.presentation;

import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.leanplum.internal.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import rn.a;

final class MyAnswersInteractor$refresh$2 extends Lambda implements Function1<Pair<? extends String, ? extends Integer>, a<? extends Pair<? extends Integer, ? extends List<? extends QuestionWAnswers>>>> {
    final /* synthetic */ boolean $networkFirst;
    final /* synthetic */ MyAnswersInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MyAnswersInteractor$refresh$2(MyAnswersInteractor myAnswersInteractor, boolean z10) {
        super(1);
        this.this$0 = myAnswersInteractor;
        this.$networkFirst = z10;
    }

    /* access modifiers changed from: private */
    public static final Pair d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Pair) function1.invoke(obj);
    }

    /* renamed from: c */
    public final a<? extends Pair<Integer, List<QuestionWAnswers>>> invoke(Pair<String, Integer> pair) {
        j.g(pair, "pair");
        String c10 = pair.c();
        final Integer d10 = pair.d();
        QuestionRepository k22 = this.this$0.k2();
        QuestionGroupType questionGroupType = QuestionGroupType.PROMPTS;
        j.f(c10, Constants.Params.USER_ID);
        return QuestionRepository.y(k22, questionGroupType, c10, this.$networkFirst, false, 8, (Object) null).Y(new g0(new Function1<ab.a, Pair<? extends Integer, ? extends List<? extends QuestionWAnswers>>>() {
            /* renamed from: a */
            public final Pair<Integer, List<QuestionWAnswers>> invoke(ab.a aVar) {
                j.g(aVar, ProfileConstants.Field.QUESTIONS);
                Integer num = d10;
                List<QuestionWAnswers> b10 = aVar.b();
                ArrayList arrayList = new ArrayList();
                for (T next : b10) {
                    if (!((QuestionWAnswers) next).d().isEmpty()) {
                        arrayList.add(next);
                    }
                }
                return new Pair<>(num, arrayList);
            }
        }));
    }
}
