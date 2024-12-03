package com.coffeemeetsbagel.new_user_experience.match_prefs.distance;

import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import ja.b;
import java.util.Optional;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DistanceMatchPreferenceInteractor$displayQuestionDistance$2 extends Lambda implements Function1<Pair<? extends b, ? extends Optional<QuestionWAnswers>>, Unit> {
    final /* synthetic */ DealbreakerVariant $variant;
    final /* synthetic */ DistanceMatchPreferenceInteractor this$0;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35297a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant[] r0 = com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant r1 = com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant.DISABLED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant r1 = com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant.VARIANT_A     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant r1 = com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant.VARIANT_B     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f35297a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.match_prefs.distance.DistanceMatchPreferenceInteractor$displayQuestionDistance$2.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DistanceMatchPreferenceInteractor$displayQuestionDistance$2(DistanceMatchPreferenceInteractor distanceMatchPreferenceInteractor, DealbreakerVariant dealbreakerVariant) {
        super(1);
        this.this$0 = distanceMatchPreferenceInteractor;
        this.$variant = dealbreakerVariant;
    }

    public final void a(Pair<b, Optional<QuestionWAnswers>> pair) {
        Integer num;
        boolean z10;
        this.this$0.f35296p = ((QuestionWAnswers) pair.d().get()).e();
        Answer answer = (Answer) CollectionsKt___CollectionsKt.P(((QuestionWAnswers) pair.d().get()).d());
        s sVar = (s) this.this$0.f7875e;
        if (answer != null) {
            num = answer.getIntegerValue();
        } else {
            num = null;
        }
        Integer num2 = num;
        boolean x10 = pair.c().x();
        int i10 = a.f35297a[this.$variant.ordinal()];
        boolean z11 = false;
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                } else if (answer != null) {
                    z10 = j.b(answer.isDealbreaker(), Boolean.FALSE);
                }
            } else if (answer != null) {
                z10 = j.b(answer.isDealbreaker(), Boolean.TRUE);
            }
            z11 = z10;
        }
        sVar.p(num2, x10, z11, this.$variant, true);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Pair) obj);
        return Unit.f32013a;
    }
}
