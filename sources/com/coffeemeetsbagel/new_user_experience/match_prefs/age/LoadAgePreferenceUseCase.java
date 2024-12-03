package com.coffeemeetsbagel.new_user_experience.match_prefs.age;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.match_prefs.MatchPreferenceQuestions;
import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.models.entities.GenderType;
import com.coffeemeetsbagel.models.enums.ProfileQuestion;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import j$.time.LocalDate;
import j$.time.OffsetDateTime;
import j$.time.Period;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.h;
import qj.w;

public final class LoadAgePreferenceUseCase {

    /* renamed from: a  reason: collision with root package name */
    private final UserRepository f35164a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ProfileRepositoryV2 f35165b;

    /* renamed from: c  reason: collision with root package name */
    private final QuestionRepository f35166c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final s9.a f35167d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final String f35168e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final int f35169f = 25;

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35174a;

        static {
            int[] iArr = new int[GenderType.values().length];
            try {
                iArr[GenderType.MALE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f35174a = iArr;
        }
    }

    public LoadAgePreferenceUseCase(UserRepository userRepository, ProfileRepositoryV2 profileRepositoryV2, QuestionRepository questionRepository, s9.a aVar) {
        j.g(userRepository, "userRepository");
        j.g(profileRepositoryV2, "profileRepository");
        j.g(questionRepository, "questionRepository");
        j.g(aVar, "featureManager");
        this.f35164a = userRepository;
        this.f35165b = profileRepositoryV2;
        this.f35166c = questionRepository;
        this.f35167d = aVar;
        String simpleName = LoadAgePreferenceUseCase.class.getSimpleName();
        j.f(simpleName, "LoadAgePreferenceUseCase::class.java.simpleName");
        this.f35168e = simpleName;
    }

    /* access modifiers changed from: private */
    public final int A(ja.b bVar) {
        OffsetDateTime g10 = bVar.g();
        if (g10 != null) {
            return Period.between(g10.toLocalDate(), LocalDate.now()).getYears();
        }
        return this.f35169f;
    }

    /* access modifiers changed from: private */
    public final a B(QuestionWAnswers questionWAnswers, int i10) {
        List<Answer> d10;
        Answer answer;
        boolean z10;
        if (questionWAnswers == null || (d10 = questionWAnswers.d()) == null || (answer = (Answer) CollectionsKt___CollectionsKt.P(d10)) == null) {
            return null;
        }
        if (answer.getMinValue() == null || answer.getMaxValue() == null) {
            throw new Exception("Age preference answer is not a range.");
        }
        Float minValue = answer.getMinValue();
        j.d(minValue);
        int floatValue = (int) minValue.floatValue();
        Float maxValue = answer.getMaxValue();
        j.d(maxValue);
        int floatValue2 = (int) maxValue.floatValue();
        int z11 = z(i10);
        Boolean isDealbreaker = answer.isDealbreaker();
        if (isDealbreaker != null) {
            z10 = isDealbreaker.booleanValue();
        } else {
            z10 = false;
        }
        return new a(floatValue, floatValue2, z10, z11);
    }

    /* access modifiers changed from: private */
    public final GenderType C(QuestionWAnswers questionWAnswers) {
        List<Answer> d10;
        Answer answer;
        String optionId;
        String str = null;
        if (!(questionWAnswers == null || (d10 = questionWAnswers.d()) == null || (answer = (Answer) CollectionsKt___CollectionsKt.P(d10)) == null || (optionId = answer.getOptionId()) == null)) {
            List<Option> options = questionWAnswers.e().getOptions();
            LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(r.t(options, 10)), 16));
            for (T next : options) {
                linkedHashMap.put(((Option) next).getId(), next);
            }
            Option option = (Option) linkedHashMap.get(optionId);
            if (option != null) {
                str = option.getName();
            }
        }
        if (str != null) {
            return GenderType.Companion.fromApiKey(str);
        }
        throw new Exception("Gender missing.");
    }

    /* access modifiers changed from: private */
    public final a q(ja.b bVar, int i10, GenderType genderType) {
        int i11;
        int i12;
        Integer a10 = bVar.q().a();
        if (a10 != null) {
            i11 = a10.intValue();
        } else {
            i11 = r(genderType, i10);
        }
        int i13 = i11;
        Integer b10 = bVar.q().b();
        if (b10 != null) {
            i12 = b10.intValue();
        } else {
            i12 = s(genderType, i10);
        }
        return new a(i13, i12, false, z(i10), 4, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public final int r(GenderType genderType, int i10) {
        return (genderType == null ? -1 : b.f35174a[genderType.ordinal()]) == 1 ? i10 - 7 : i10 - 2;
    }

    /* access modifiers changed from: private */
    public final int s(GenderType genderType, int i10) {
        return (genderType == null ? -1 : b.f35174a[genderType.ordinal()]) == 1 ? i10 + 2 : i10 + 7;
    }

    /* access modifiers changed from: private */
    public static final b0 u(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 v(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final w<a> w(ja.b bVar) {
        w<R> D = h.n(this.f35166c.I(MatchPreferenceQuestions.AGE.b(), bVar.u()), this.f35166c.I(ProfileQuestion.GENDER_IDENTITY.getApiKey(), bVar.u()), new r(LoadAgePreferenceUseCase$loadAnswer$1.f35175a)).L().D(new s(new LoadAgePreferenceUseCase$loadAnswer$2(this, bVar)));
        j.f(D, "private fun loadAnswer(u…    }\n            }\n    }");
        return D;
    }

    /* access modifiers changed from: private */
    public static final Pair x(Function2 function2, Object obj, Object obj2) {
        j.g(function2, "$tmp0");
        return (Pair) function2.invoke(obj, obj2);
    }

    /* access modifiers changed from: private */
    public static final a y(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (a) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final int z(int i10) {
        return ((int) Math.floor((((double) i10) - ((double) 18)) / ((double) 7))) + 3;
    }

    public final w<a> t() {
        w<R> F = this.f35164a.p().L().v(new p(new LoadAgePreferenceUseCase$invoke$1(this))).F(new q(new LoadAgePreferenceUseCase$invoke$2(this)));
        j.f(F, "operator fun invoke(): S…    )\n            }\n    }");
        return F;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f35170a;

        /* renamed from: b  reason: collision with root package name */
        private final int f35171b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f35172c;

        /* renamed from: d  reason: collision with root package name */
        private final int f35173d;

        public a(int i10, int i11, boolean z10, int i12) {
            this.f35170a = i10;
            this.f35171b = i11;
            this.f35172c = z10;
            this.f35173d = i12;
        }

        public final int a() {
            return this.f35171b;
        }

        public final int b() {
            return this.f35170a;
        }

        public final int c() {
            return this.f35173d;
        }

        public final boolean d() {
            return this.f35172c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f35170a == aVar.f35170a && this.f35171b == aVar.f35171b && this.f35172c == aVar.f35172c && this.f35173d == aVar.f35173d;
        }

        public int hashCode() {
            int hashCode = ((Integer.hashCode(this.f35170a) * 31) + Integer.hashCode(this.f35171b)) * 31;
            boolean z10 = this.f35172c;
            if (z10) {
                z10 = true;
            }
            return ((hashCode + (z10 ? 1 : 0)) * 31) + Integer.hashCode(this.f35173d);
        }

        public String toString() {
            int i10 = this.f35170a;
            int i11 = this.f35171b;
            boolean z10 = this.f35172c;
            int i12 = this.f35173d;
            return "Result(ageLow=" + i10 + ", ageHigh=" + i11 + ", isDealbreaker=" + z10 + ", range=" + i12 + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(int i10, int i11, boolean z10, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
            this(i10, i11, (i13 & 4) != 0 ? false : z10, i12);
        }
    }
}
