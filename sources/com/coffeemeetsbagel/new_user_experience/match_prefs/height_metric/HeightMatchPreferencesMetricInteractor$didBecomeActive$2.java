package com.coffeemeetsbagel.new_user_experience.match_prefs.height_metric;

import com.coffeemeetsbagel.qna.QuestionWAnswers;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class HeightMatchPreferencesMetricInteractor$didBecomeActive$2 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ HeightMatchPreferencesMetricInteractor this$0;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35428a;

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
                f35428a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.match_prefs.height_metric.HeightMatchPreferencesMetricInteractor$didBecomeActive$2.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HeightMatchPreferencesMetricInteractor$didBecomeActive$2(HeightMatchPreferencesMetricInteractor heightMatchPreferencesMetricInteractor) {
        super(1);
        this.this$0 = heightMatchPreferencesMetricInteractor;
    }

    public final void a(String str) {
        Unit unit;
        Pair<Integer, Integer> o10 = ((m) this.this$0.f7875e).o();
        QuestionWAnswers V1 = this.this$0.V1();
        if (V1 != null) {
            HeightMatchPreferencesMetricInteractor heightMatchPreferencesMetricInteractor = this.this$0;
            int i10 = a.f35428a[heightMatchPreferencesMetricInteractor.X1().ordinal()];
            boolean z10 = false;
            if (i10 != 1) {
                if (i10 == 2) {
                    z10 = ((m) heightMatchPreferencesMetricInteractor.f7875e).p();
                } else if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                } else if (!((m) heightMatchPreferencesMetricInteractor.f7875e).p()) {
                    z10 = true;
                }
            }
            heightMatchPreferencesMetricInteractor.Z1(o10, V1, z10);
            unit = Unit.f32013a;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.this$0.Y1(o10);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((String) obj);
        return Unit.f32013a;
    }
}
