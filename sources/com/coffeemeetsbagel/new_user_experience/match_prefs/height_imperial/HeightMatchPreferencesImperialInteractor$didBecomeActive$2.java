package com.coffeemeetsbagel.new_user_experience.match_prefs.height_imperial;

import com.coffeemeetsbagel.qna.QuestionWAnswers;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class HeightMatchPreferencesImperialInteractor$didBecomeActive$2 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ HeightMatchPreferencesImperialInteractor this$0;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35395a;

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
                f35395a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.match_prefs.height_imperial.HeightMatchPreferencesImperialInteractor$didBecomeActive$2.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HeightMatchPreferencesImperialInteractor$didBecomeActive$2(HeightMatchPreferencesImperialInteractor heightMatchPreferencesImperialInteractor) {
        super(1);
        this.this$0 = heightMatchPreferencesImperialInteractor;
    }

    public final void a(String str) {
        Unit unit;
        QuestionWAnswers V1 = this.this$0.V1();
        if (V1 != null) {
            HeightMatchPreferencesImperialInteractor heightMatchPreferencesImperialInteractor = this.this$0;
            Pair<o, o> o10 = ((m) heightMatchPreferencesImperialInteractor.f7875e).o();
            int i10 = a.f35395a[heightMatchPreferencesImperialInteractor.Z1().ordinal()];
            boolean z10 = false;
            if (i10 != 1) {
                if (i10 == 2) {
                    z10 = ((m) heightMatchPreferencesImperialInteractor.f7875e).p();
                } else if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                } else if (!((m) heightMatchPreferencesImperialInteractor.f7875e).p()) {
                    z10 = true;
                }
            }
            heightMatchPreferencesImperialInteractor.a2(o10, V1, z10);
            unit = Unit.f32013a;
        } else {
            unit = null;
        }
        if (unit == null) {
            HeightMatchPreferencesImperialInteractor heightMatchPreferencesImperialInteractor2 = this.this$0;
            heightMatchPreferencesImperialInteractor2.e2(((m) heightMatchPreferencesImperialInteractor2.f7875e).o());
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((String) obj);
        return Unit.f32013a;
    }
}
