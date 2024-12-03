package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import java.util.List;
import java.util.OptionalInt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.h;
import rn.a;

final class GetGroupOptionsRemainingUseCase$invoke$1 extends Lambda implements Function1<OptionalInt, a<? extends OptionalInt>> {
    final /* synthetic */ String $profileId;
    final /* synthetic */ QuestionGroupType $questionGroup;
    final /* synthetic */ GetGroupOptionsRemainingUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetGroupOptionsRemainingUseCase$invoke$1(GetGroupOptionsRemainingUseCase getGroupOptionsRemainingUseCase, String str, QuestionGroupType questionGroupType) {
        super(1);
        this.this$0 = getGroupOptionsRemainingUseCase;
        this.$profileId = str;
        this.$questionGroup = questionGroupType;
    }

    /* access modifiers changed from: private */
    public static final OptionalInt d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (OptionalInt) function1.invoke(obj);
    }

    /* renamed from: c */
    public final a<? extends OptionalInt> invoke(final OptionalInt optionalInt) {
        j.g(optionalInt, "maxOptional");
        if (optionalInt.isPresent()) {
            return this.this$0.f36204a.H(this.$profileId, this.$questionGroup).Y(new d(new Function1<List<? extends String>, OptionalInt>() {
                /* renamed from: a */
                public final OptionalInt invoke(List<String> list) {
                    j.g(list, "answers");
                    return OptionalInt.of(optionalInt.getAsInt() - list.size());
                }
            }));
        }
        return h.X(OptionalInt.empty());
    }
}
