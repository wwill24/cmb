package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.leanplum.internal.Constants;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import rn.a;

final class GetUserMCQUseCase$invoke$1 extends Lambda implements Function1<String, a<? extends List<? extends QuestionWAnswers>>> {
    final /* synthetic */ boolean $networkFirst;
    final /* synthetic */ QuestionGroupType $questionGroup;
    final /* synthetic */ GetUserMCQUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetUserMCQUseCase$invoke$1(GetUserMCQUseCase getUserMCQUseCase, QuestionGroupType questionGroupType, boolean z10) {
        super(1);
        this.this$0 = getUserMCQUseCase;
        this.$questionGroup = questionGroupType;
        this.$networkFirst = z10;
    }

    /* access modifiers changed from: private */
    public static final List d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    /* renamed from: c */
    public final a<? extends List<QuestionWAnswers>> invoke(String str) {
        j.g(str, Constants.Params.USER_ID);
        return QuestionRepository.y(this.this$0.f36208b, this.$questionGroup, str, this.$networkFirst, false, 8, (Object) null).Y(new o(AnonymousClass1.f36209a));
    }
}
