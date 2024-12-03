package com.coffeemeetsbagel.new_user_experience.match_prefs.age;

import com.coffeemeetsbagel.new_user_experience.match_prefs.age.LoadAgePreferenceUseCase;
import com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class AgeMatchPreferenceInteractor$didBecomeActive$1 extends Lambda implements Function1<LoadAgePreferenceUseCase.a, Unit> {
    final /* synthetic */ DealbreakerVariant $variant;
    final /* synthetic */ AgeMatchPreferenceInteractor this$0;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35163a;

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
                f35163a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.match_prefs.age.AgeMatchPreferenceInteractor$didBecomeActive$1.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AgeMatchPreferenceInteractor$didBecomeActive$1(AgeMatchPreferenceInteractor ageMatchPreferenceInteractor, DealbreakerVariant dealbreakerVariant) {
        super(1);
        this.this$0 = ageMatchPreferenceInteractor;
        this.$variant = dealbreakerVariant;
    }

    public final void a(LoadAgePreferenceUseCase.a aVar) {
        k kVar = (k) this.this$0.f7875e;
        int b10 = aVar.b();
        int a10 = aVar.a();
        int i10 = a.f35163a[this.$variant.ordinal()];
        boolean z10 = false;
        if (i10 != 1) {
            if (i10 == 2) {
                z10 = aVar.d();
            } else if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            } else if (!aVar.d()) {
                z10 = true;
            }
        }
        kVar.q(b10, a10, z10, this.$variant, Integer.valueOf(aVar.c()));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((LoadAgePreferenceUseCase.a) obj);
        return Unit.f32013a;
    }
}
