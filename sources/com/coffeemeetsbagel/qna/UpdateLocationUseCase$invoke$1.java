package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.models.enums.ProfileQuestion;
import ja.b;
import java.util.Optional;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;

final class UpdateLocationUseCase$invoke$1 extends Lambda implements Function1<b, b0<? extends Pair<? extends String, ? extends Optional<QuestionWAnswers>>>> {
    final /* synthetic */ UpdateLocationUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UpdateLocationUseCase$invoke$1(UpdateLocationUseCase updateLocationUseCase) {
        super(1);
        this.this$0 = updateLocationUseCase;
    }

    /* access modifiers changed from: private */
    public static final Pair d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Pair) function1.invoke(obj);
    }

    /* renamed from: c */
    public final b0<? extends Pair<String, Optional<QuestionWAnswers>>> invoke(final b bVar) {
        j.g(bVar, "user");
        return this.this$0.f36225b.I(ProfileQuestion.LOCATION.getApiKey(), bVar.u()).L().D(new g0(new Function1<Optional<QuestionWAnswers>, Pair<? extends String, ? extends Optional<QuestionWAnswers>>>() {
            /* renamed from: a */
            public final Pair<String, Optional<QuestionWAnswers>> invoke(Optional<QuestionWAnswers> optional) {
                j.g(optional, "it");
                return new Pair<>(bVar.u(), optional);
            }
        }));
    }
}
