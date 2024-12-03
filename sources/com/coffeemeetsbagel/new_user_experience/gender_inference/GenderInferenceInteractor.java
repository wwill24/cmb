package com.coffeemeetsbagel.new_user_experience.gender_inference;

import b6.s;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.models.ProfileDtoImplementation;
import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.models.dto.Question;
import com.coffeemeetsbagel.models.entities.GenderType;
import com.coffeemeetsbagel.models.enums.InferredGenderOptions;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.new_user_experience.gender_inference.GenderInferencePresenter;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.j;
import com.uber.autodispose.m;
import com.uber.autodispose.n;
import d7.g;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import na.b;
import qj.h;

public final class GenderInferenceInteractor extends s<GenderInferencePresenter, s> implements GenderInferencePresenter.a {

    /* renamed from: f  reason: collision with root package name */
    public b f35019f;

    /* renamed from: g  reason: collision with root package name */
    public ProfileRepository f35020g;

    /* renamed from: h  reason: collision with root package name */
    public g f35021h;

    /* renamed from: j  reason: collision with root package name */
    public j f35022j;

    /* renamed from: k  reason: collision with root package name */
    public UserRepository f35023k;

    /* renamed from: l  reason: collision with root package name */
    public s9.a f35024l;

    /* renamed from: m  reason: collision with root package name */
    public SaveAnswerUseCase f35025m;

    /* renamed from: n  reason: collision with root package name */
    private ProfileDtoImplementation f35026n;

    /* renamed from: p  reason: collision with root package name */
    private QuestionWAnswers f35027p;

    /* renamed from: q  reason: collision with root package name */
    private final String f35028q;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35029a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.coffeemeetsbagel.models.enums.InferredGenderOptions[] r0 = com.coffeemeetsbagel.models.enums.InferredGenderOptions.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.models.enums.InferredGenderOptions r1 = com.coffeemeetsbagel.models.enums.InferredGenderOptions.MEN     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.models.enums.InferredGenderOptions r1 = com.coffeemeetsbagel.models.enums.InferredGenderOptions.WOMEN     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f35029a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.gender_inference.GenderInferenceInteractor.a.<clinit>():void");
        }
    }

    public GenderInferenceInteractor() {
        String simpleName = GenderInferenceInteractor.class.getSimpleName();
        kotlin.jvm.internal.j.f(simpleName, "GenderInferenceInteractor::class.java.simpleName");
        this.f35028q = simpleName;
    }

    /* access modifiers changed from: private */
    public static final void Q1(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void R1(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final h<InferredGenderOptions> T1() {
        h<R> Y = e2().p().M(new j(new GenderInferenceInteractor$getGenderFromProfile$1(this))).Y(new k(new GenderInferenceInteractor$getGenderFromProfile$2(this)));
        kotlin.jvm.internal.j.f(Y, "private fun getGenderFro…    }\n            }\n    }");
        return Y;
    }

    /* access modifiers changed from: private */
    public static final rn.a U1(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (rn.a) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final InferredGenderOptions V1(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (InferredGenderOptions) function1.invoke(obj);
    }

    private final h<InferredGenderOptions> W1() {
        h<R> Y = e2().p().M(new h(new GenderInferenceInteractor$getGenderFromQuestion$1(this))).Y(new i(new GenderInferenceInteractor$getGenderFromQuestion$2(this)));
        kotlin.jvm.internal.j.f(Y, "private fun getGenderFro…name)\n            }\n    }");
        return Y;
    }

    /* access modifiers changed from: private */
    public static final rn.a X1(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (rn.a) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final InferredGenderOptions Y1(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (InferredGenderOptions) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void f2(InferredGenderOptions inferredGenderOptions, GenderInferenceInteractor genderInferenceInteractor) {
        kotlin.jvm.internal.j.g(inferredGenderOptions, "$inferredGender");
        kotlin.jvm.internal.j.g(genderInferenceInteractor, "this$0");
        HashMap hashMap = new HashMap();
        String apiString = inferredGenderOptions.getApiString();
        kotlin.jvm.internal.j.d(apiString);
        hashMap.put("selection", apiString);
        genderInferenceInteractor.Z1().e(hashMap);
    }

    /* access modifiers changed from: private */
    public static final void g2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final qj.a h2(InferredGenderOptions inferredGenderOptions) {
        String str;
        Question e10;
        List<Option> options;
        QuestionWAnswers questionWAnswers = this.f35027p;
        if (!(questionWAnswers == null || (e10 = questionWAnswers.e()) == null || (options = e10.getOptions()) == null)) {
            for (Option option : options) {
                if (kotlin.jvm.internal.j.b(option.getName(), inferredGenderOptions.getApiString())) {
                    if (option != null) {
                        str = option.getId();
                        SaveAnswerUseCase c22 = c2();
                        String questionGroupApiString = QuestionGroupType.ONBOARDING.getQuestionGroupApiString();
                        QuestionWAnswers questionWAnswers2 = this.f35027p;
                        kotlin.jvm.internal.j.d(questionWAnswers2);
                        String id2 = questionWAnswers2.e().getId();
                        kotlin.jvm.internal.j.d(str);
                        return SaveAnswerUseCase.d(c22, p.e(str), (String) null, id2, questionGroupApiString, (Integer) null, (Float) null, (Float) null, (Float) null, false, (Location) null, 1010, (Object) null);
                    }
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        str = null;
        SaveAnswerUseCase c222 = c2();
        String questionGroupApiString2 = QuestionGroupType.ONBOARDING.getQuestionGroupApiString();
        QuestionWAnswers questionWAnswers22 = this.f35027p;
        kotlin.jvm.internal.j.d(questionWAnswers22);
        String id22 = questionWAnswers22.e().getId();
        kotlin.jvm.internal.j.d(str);
        return SaveAnswerUseCase.d(c222, p.e(str), (String) null, id22, questionGroupApiString2, (Integer) null, (Float) null, (Float) null, (Float) null, false, (Location) null, 1010, (Object) null);
    }

    private final qj.a i2(InferredGenderOptions inferredGenderOptions) {
        GenderType genderType;
        ProfileDtoImplementation profileDtoImplementation = this.f35026n;
        kotlin.jvm.internal.j.d(profileDtoImplementation);
        int i10 = a.f35029a[inferredGenderOptions.ordinal()];
        if (i10 == 1) {
            genderType = GenderType.MALE;
        } else if (i10 == 2) {
            genderType = GenderType.FEMALE;
        } else {
            throw new Exception("Invalid selection");
        }
        profileDtoImplementation.setGender(genderType);
        ProfileRepository a22 = a2();
        ProfileDtoImplementation profileDtoImplementation2 = this.f35026n;
        kotlin.jvm.internal.j.d(profileDtoImplementation2);
        qj.a B = a22.p(profileDtoImplementation2).B();
        kotlin.jvm.internal.j.f(B, "profileRepository.saveGe…eModel!!).ignoreElement()");
        return B;
    }

    public final s9.a S1() {
        s9.a aVar = this.f35024l;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("featureManager");
        return null;
    }

    public final b Z1() {
        b bVar = this.f35019f;
        if (bVar != null) {
            return bVar;
        }
        kotlin.jvm.internal.j.y("interactionListener");
        return null;
    }

    public final ProfileRepository a2() {
        ProfileRepository profileRepository = this.f35020g;
        if (profileRepository != null) {
            return profileRepository;
        }
        kotlin.jvm.internal.j.y("profileRepository");
        return null;
    }

    public final j b2() {
        j jVar = this.f35022j;
        if (jVar != null) {
            return jVar;
        }
        kotlin.jvm.internal.j.y("questionUseCase");
        return null;
    }

    public final SaveAnswerUseCase c2() {
        SaveAnswerUseCase saveAnswerUseCase = this.f35025m;
        if (saveAnswerUseCase != null) {
            return saveAnswerUseCase;
        }
        kotlin.jvm.internal.j.y("saveAnswerUseCase");
        return null;
    }

    public void d() {
        qj.a aVar;
        InferredGenderOptions w10 = ((GenderInferencePresenter) this.f7875e).w();
        if (w10 != null) {
            if (S1().a("ProfileMigration.Enabled.Android")) {
                aVar = h2(w10);
            } else {
                aVar = i2(w10);
            }
            ((m) aVar.j(com.uber.autodispose.a.a(this))).f(new l(w10, this), new m(new GenderInferenceInteractor$onNext$1$2(this)));
        }
    }

    public final String d2() {
        return this.f35028q;
    }

    public final UserRepository e2() {
        UserRepository userRepository = this.f35023k;
        if (userRepository != null) {
            return userRepository;
        }
        kotlin.jvm.internal.j.y("userRepository");
        return null;
    }

    public void f() {
        Z1().d();
    }

    public final void j2(ProfileDtoImplementation profileDtoImplementation) {
        this.f35026n = profileDtoImplementation;
    }

    public final void k2(QuestionWAnswers questionWAnswers) {
        this.f35027p = questionWAnswers;
    }

    public void r1(InferredGenderOptions inferredGenderOptions) {
        kotlin.jvm.internal.j.g(inferredGenderOptions, ProfileConstants.Field.GENDER);
        ((GenderInferencePresenter) this.f7875e).t();
    }

    /* access modifiers changed from: protected */
    public void y1() {
        h<InferredGenderOptions> hVar;
        super.y1();
        if (S1().a("ProfileMigration.Enabled.Android")) {
            hVar = W1();
        } else {
            hVar = T1();
        }
        ((n) hVar.a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new f(new GenderInferenceInteractor$didBecomeActive$1(this)), new g(new GenderInferenceInteractor$didBecomeActive$2(this)));
    }
}
