package com.coffeemeetsbagel.fragments;

import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import fa.a;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class FragmentMyProfileDetails$onCreate$1 extends Lambda implements Function1<Pair<? extends QuestionWAnswers, ? extends String>, Unit> {
    final /* synthetic */ FragmentMyProfileDetails this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FragmentMyProfileDetails$onCreate$1(FragmentMyProfileDetails fragmentMyProfileDetails) {
        super(1);
        this.this$0 = fragmentMyProfileDetails;
    }

    public final void a(Pair<QuestionWAnswers, String> pair) {
        String str;
        Answer answer = (Answer) CollectionsKt___CollectionsKt.P(pair.c().d());
        if (answer != null) {
            str = answer.getTextValue();
        } else {
            str = null;
        }
        if (!j.b(str, pair.d())) {
            a.C0491a aVar = a.f40771d;
            String name = pair.c().e().getName();
            aVar.a("FragmentMyProfileDetails", "Sending update for " + name);
            FragmentMyProfileDetails.Z3(this.this$0, (List) null, pair.d(), pair.c().e().getId(), pair.c().e().getGroup().getQuestionGroupApiString(), 1, (Object) null);
            return;
        }
        a.C0491a aVar2 = a.f40771d;
        String name2 = pair.c().e().getName();
        aVar2.a("FragmentMyProfileDetails", "Not sending duplicate update for " + name2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Pair) obj);
        return Unit.f32013a;
    }
}
