package com.coffeemeetsbagel.new_user_experience.match_prefs.age;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.transport.SuccessStatus;
import jc.b;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.c;
import qj.f;

public final class SaveAgePreferenceUseCase {

    /* renamed from: a  reason: collision with root package name */
    private final s9.a f35176a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ProfileManager f35177b;

    /* renamed from: c  reason: collision with root package name */
    private final UserRepository f35178c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final QuestionRepository f35179d;

    public static final class a implements b<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SaveAgePreferenceUseCase f35180a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f35181b;

        a(SaveAgePreferenceUseCase saveAgePreferenceUseCase, c cVar) {
            this.f35180a = saveAgePreferenceUseCase;
            this.f35181b = cVar;
        }

        public void b(CmbErrorCode cmbErrorCode) {
            String str;
            Integer num = null;
            if (cmbErrorCode != null) {
                str = cmbErrorCode.getErrorMessage();
            } else {
                str = null;
            }
            if (cmbErrorCode != null) {
                num = Integer.valueOf(cmbErrorCode.getErrorCode());
            }
            this.f35181b.onError(new Throwable(str + " " + num));
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            this.f35180a.f35177b.f();
            this.f35181b.onComplete();
        }
    }

    public SaveAgePreferenceUseCase(s9.a aVar, ProfileManager profileManager, UserRepository userRepository, QuestionRepository questionRepository) {
        j.g(aVar, "featureManager");
        j.g(profileManager, "profileManager");
        j.g(userRepository, "userRepository");
        j.g(questionRepository, "questionRepository");
        this.f35176a = aVar;
        this.f35177b = profileManager;
        this.f35178c = userRepository;
        this.f35179d = questionRepository;
    }

    private final qj.a g(int i10, int i11) {
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        if (i11 < i10) {
            modelProfileUpdateDelta.updateCriteriaAgeFrom(i11);
            modelProfileUpdateDelta.updateCriteriaAgeTo(i10);
        } else {
            modelProfileUpdateDelta.updateCriteriaAgeFrom(i10);
            modelProfileUpdateDelta.updateCriteriaAgeTo(i11);
        }
        qj.a n10 = qj.a.n(new x(this, modelProfileUpdateDelta));
        j.f(n10, "create { emitter ->\n    …k, delta, true)\n        }");
        return n10;
    }

    /* access modifiers changed from: private */
    public static final void h(SaveAgePreferenceUseCase saveAgePreferenceUseCase, ModelProfileUpdateDelta modelProfileUpdateDelta, c cVar) {
        j.g(saveAgePreferenceUseCase, "this$0");
        j.g(modelProfileUpdateDelta, "$delta");
        j.g(cVar, "emitter");
        saveAgePreferenceUseCase.f35177b.p(new a(saveAgePreferenceUseCase, cVar), modelProfileUpdateDelta, true);
    }

    private final qj.a i(int i10, int i11, boolean z10) {
        qj.a w10 = this.f35178c.p().L().v(new v(new SaveAgePreferenceUseCase$updateQuestionAgeRange$1(this))).w(new w(new SaveAgePreferenceUseCase$updateQuestionAgeRange$2(this, i10, i11, z10)));
        j.f(w10, "private fun updateQuesti…    )\n            }\n    }");
        return w10;
    }

    /* access modifiers changed from: private */
    public static final b0 j(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final f k(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    public final qj.a f(Pair<Integer, Integer> pair, boolean z10) {
        j.g(pair, "range");
        if (this.f35176a.a("ProfileMigration.Enabled.Android")) {
            return i(pair.c().intValue(), pair.d().intValue(), z10);
        }
        return g(pair.c().intValue(), pair.d().intValue());
    }
}
