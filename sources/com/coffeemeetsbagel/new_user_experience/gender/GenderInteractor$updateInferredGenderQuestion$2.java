package com.coffeemeetsbagel.new_user_experience.gender;

import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.models.entities.GenderType;
import com.coffeemeetsbagel.models.enums.InferredGenderOptions;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.f;

final class GenderInteractor$updateInferredGenderQuestion$2 extends Lambda implements Function1<QuestionWAnswers, f> {
    final /* synthetic */ GenderType $genderType;
    final /* synthetic */ GenderInteractor this$0;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f34995a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.coffeemeetsbagel.models.entities.GenderType[] r0 = com.coffeemeetsbagel.models.entities.GenderType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.models.entities.GenderType r1 = com.coffeemeetsbagel.models.entities.GenderType.FEMALE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.models.entities.GenderType r1 = com.coffeemeetsbagel.models.entities.GenderType.MALE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f34995a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.gender.GenderInteractor$updateInferredGenderQuestion$2.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenderInteractor$updateInferredGenderQuestion$2(GenderType genderType, GenderInteractor genderInteractor) {
        super(1);
        this.$genderType = genderType;
        this.this$0 = genderInteractor;
    }

    /* renamed from: a */
    public final f invoke(QuestionWAnswers questionWAnswers) {
        j.g(questionWAnswers, "group");
        int i10 = a.f34995a[this.$genderType.ordinal()];
        if (i10 == 1) {
            for (Option option : questionWAnswers.e().getOptions()) {
                if (j.b(option.getName(), InferredGenderOptions.WOMEN.getApiString())) {
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        } else if (i10 != 2) {
            for (Option option2 : questionWAnswers.e().getOptions()) {
                if (j.b(option2.getName(), InferredGenderOptions.NULL.getApiString())) {
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        } else {
            for (Option option22 : questionWAnswers.e().getOptions()) {
                if (j.b(option22.getName(), InferredGenderOptions.MEN.getApiString())) {
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        SaveAnswerUseCase b22 = this.this$0.b2();
        String questionGroupApiString = QuestionGroupType.ONBOARDING.getQuestionGroupApiString();
        return SaveAnswerUseCase.d(b22, p.e(option22.getId()), (String) null, questionWAnswers.e().getId(), questionGroupApiString, (Integer) null, (Float) null, (Float) null, (Float) null, false, (Location) null, 1010, (Object) null);
    }
}
