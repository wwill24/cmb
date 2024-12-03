package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import fa.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.a;
import qj.f;

public final class QuestionGroupRefreshUseCase {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final FeatureFlagRepository f36216a;

    /* renamed from: b  reason: collision with root package name */
    private final UserRepository f36217b;

    /* renamed from: c  reason: collision with root package name */
    private final QuestionRepository f36218c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f36219d = QuestionGroupRefreshUseCase.class.getSimpleName();

    public QuestionGroupRefreshUseCase(FeatureFlagRepository featureFlagRepository, UserRepository userRepository, QuestionRepository questionRepository) {
        j.g(featureFlagRepository, "featureRepository");
        j.g(userRepository, "userRepository");
        j.g(questionRepository, "questionRepository");
        this.f36216a = featureFlagRepository;
        this.f36217b = userRepository;
        this.f36218c = questionRepository;
    }

    /* access modifiers changed from: private */
    public final List<a> g(String str, boolean z10) {
        QuestionGroupType questionGroupType;
        QuestionGroupType questionGroupType2;
        QuestionGroupType questionGroupType3;
        QuestionGroupType questionGroupType4;
        QuestionGroupType questionGroupType5;
        QuestionGroupType[] questionGroupTypeArr = new QuestionGroupType[14];
        QuestionGroupType questionGroupType6 = null;
        if (z10) {
            questionGroupType = QuestionGroupType.ORIGINAL_PROFILE;
        } else {
            questionGroupType = null;
        }
        questionGroupTypeArr[0] = questionGroupType;
        if (z10) {
            questionGroupType2 = QuestionGroupType.ONBOARDING;
        } else {
            questionGroupType2 = null;
        }
        questionGroupTypeArr[1] = questionGroupType2;
        if (z10) {
            questionGroupType3 = QuestionGroupType.FREE_PREFERENCES;
        } else {
            questionGroupType3 = null;
        }
        questionGroupTypeArr[2] = questionGroupType3;
        if (z10) {
            questionGroupType4 = QuestionGroupType.ICEBREAKERS;
        } else {
            questionGroupType4 = null;
        }
        questionGroupTypeArr[3] = questionGroupType4;
        if (z10) {
            questionGroupType5 = QuestionGroupType.EDUCATION_ONE;
        } else {
            questionGroupType5 = null;
        }
        questionGroupTypeArr[4] = questionGroupType5;
        if (z10) {
            questionGroupType6 = QuestionGroupType.EDUCATION_TWO;
        }
        questionGroupTypeArr[5] = questionGroupType6;
        questionGroupTypeArr[6] = QuestionGroupType.CORE_PROFILE_DATA;
        questionGroupTypeArr[7] = QuestionGroupType.INTERESTS;
        questionGroupTypeArr[8] = QuestionGroupType.PROMPTS;
        questionGroupTypeArr[9] = QuestionGroupType.IDENTITY_PROFILE;
        questionGroupTypeArr[10] = QuestionGroupType.VALUES;
        questionGroupTypeArr[11] = QuestionGroupType.DATING_STYLE;
        questionGroupTypeArr[12] = QuestionGroupType.PERSONALITY;
        questionGroupTypeArr[13] = QuestionGroupType.MATCH_PREFERENCES;
        List<QuestionGroupType> o10 = q.o(questionGroupTypeArr);
        ArrayList arrayList = new ArrayList(r.t(o10, 10));
        for (QuestionGroupType questionGroupType7 : o10) {
            arrayList.add(this.f36218c.x(questionGroupType7, str, true, true).A(new y(new QuestionGroupRefreshUseCase$generateSources$1$1(this, questionGroupType7))).W().A());
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static final void h(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final f j(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void k(QuestionGroupRefreshUseCase questionGroupRefreshUseCase) {
        j.g(questionGroupRefreshUseCase, "this$0");
        a.C0491a aVar = fa.a.f40771d;
        String str = questionGroupRefreshUseCase.f36219d;
        j.f(str, "tag");
        aVar.a(str, "Refreshed items.");
    }

    public final qj.a i() {
        qj.a q10 = this.f36217b.m().L().w(new w(new QuestionGroupRefreshUseCase$invoke$1(this))).q(new x(this));
        j.f(q10, "operator fun invoke(): C…ms.\")\n            }\n    }");
        return q10;
    }
}
