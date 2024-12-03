package com.coffeemeetsbagel.new_user_experience.match_prefs.distance;

import com.coffeemeetsbagel.match_prefs.MatchPreferenceQuestions;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import ja.b;
import java.util.Optional;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Session;
import rn.a;

final class DistanceMatchPreferenceInteractor$displayQuestionDistance$1 extends Lambda implements Function1<b, a<? extends Pair<? extends b, ? extends Optional<QuestionWAnswers>>>> {
    final /* synthetic */ DistanceMatchPreferenceInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DistanceMatchPreferenceInteractor$displayQuestionDistance$1(DistanceMatchPreferenceInteractor distanceMatchPreferenceInteractor) {
        super(1);
        this.this$0 = distanceMatchPreferenceInteractor;
    }

    /* access modifiers changed from: private */
    public static final Pair d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Pair) function1.invoke(obj);
    }

    /* renamed from: c */
    public final a<? extends Pair<b, Optional<QuestionWAnswers>>> invoke(final b bVar) {
        j.g(bVar, "user");
        return this.this$0.i2().a(bVar.u(), MatchPreferenceQuestions.DISTANCE.b()).Y(new o(new Function1<Optional<QuestionWAnswers>, Pair<? extends b, ? extends Optional<QuestionWAnswers>>>() {
            /* renamed from: a */
            public final Pair<b, Optional<QuestionWAnswers>> invoke(Optional<QuestionWAnswers> optional) {
                j.g(optional, Session.Feature.OPTIONAL_ELEMENT);
                return new Pair<>(bVar, optional);
            }
        }));
    }
}
