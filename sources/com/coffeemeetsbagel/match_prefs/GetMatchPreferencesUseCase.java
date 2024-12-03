package com.coffeemeetsbagel.match_prefs;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.domain.repository.m;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import ja.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import qj.h;

public final class GetMatchPreferencesUseCase {

    /* renamed from: a  reason: collision with root package name */
    private final UserRepository f34527a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final QuestionRepository f34528b;

    /* renamed from: c  reason: collision with root package name */
    private final FeatureFlagRepository f34529c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final m f34530d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final b f34531a;

        /* renamed from: b  reason: collision with root package name */
        private List<f> f34532b;

        /* renamed from: c  reason: collision with root package name */
        private List<f> f34533c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f34534d;

        public a(b bVar, List<f> list, List<f> list2, boolean z10) {
            j.g(bVar, "user");
            j.g(list, "freeItems");
            j.g(list2, "premiumItems");
            this.f34531a = bVar;
            this.f34532b = list;
            this.f34533c = list2;
            this.f34534d = z10;
        }

        public final List<f> a() {
            return this.f34532b;
        }

        public final boolean b() {
            return this.f34534d;
        }

        public final List<f> c() {
            return this.f34533c;
        }

        public final b d() {
            return this.f34531a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return j.b(this.f34531a, aVar.f34531a) && j.b(this.f34532b, aVar.f34532b) && j.b(this.f34533c, aVar.f34533c) && this.f34534d == aVar.f34534d;
        }

        public int hashCode() {
            int hashCode = ((((this.f34531a.hashCode() * 31) + this.f34532b.hashCode()) * 31) + this.f34533c.hashCode()) * 31;
            boolean z10 = this.f34534d;
            if (z10) {
                z10 = true;
            }
            return hashCode + (z10 ? 1 : 0);
        }

        public String toString() {
            return "Result(user=" + this.f34531a + ", freeItems=" + this.f34532b + ", premiumItems=" + this.f34533c + ", locked=" + this.f34534d + PropertyUtils.MAPPED_DELIM2;
        }
    }

    public GetMatchPreferencesUseCase(UserRepository userRepository, QuestionRepository questionRepository, FeatureFlagRepository featureFlagRepository, m mVar) {
        j.g(userRepository, "userRepository");
        j.g(questionRepository, "questionRepository");
        j.g(featureFlagRepository, "featureRepository");
        j.g(mVar, "capabilityRepository");
        this.f34527a = userRepository;
        this.f34528b = questionRepository;
        this.f34529c = featureFlagRepository;
        this.f34530d = mVar;
    }

    /* access modifiers changed from: private */
    public final h<Optional<ab.a>> j(String str, QuestionGroupType questionGroupType, boolean z10) {
        if (z10) {
            h<Optional<ab.a>> Y = QuestionRepository.y(this.f34528b, questionGroupType, str, true, false, 8, (Object) null).v().Y(new c(GetMatchPreferencesUseCase$getMigrationGroup$1.f34535a));
            j.f(Y, "{\n            /*\n       …              }\n        }");
            return Y;
        }
        h<Optional<ab.a>> X = h.X(Optional.empty());
        j.f(X, "{\n            Flowable.j…pWQuestions>())\n        }");
        return X;
    }

    /* access modifiers changed from: private */
    public static final Optional k(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Optional) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final List<f> l(b bVar) {
        f fVar;
        f[] fVarArr = new f[6];
        fVarArr[0] = new f(MatchPreference$Type.GENDER, (QuestionWAnswers) null, false, 6, (DefaultConstructorMarker) null);
        fVarArr[1] = new f(MatchPreference$Type.AGE, (QuestionWAnswers) null, false, 6, (DefaultConstructorMarker) null);
        if (bVar.x()) {
            fVar = new f(MatchPreference$Type.HEIGHT_METRIC, (QuestionWAnswers) null, false, 6, (DefaultConstructorMarker) null);
        } else {
            fVar = new f(MatchPreference$Type.HEIGHT_IMPERIAL, (QuestionWAnswers) null, false, 6, (DefaultConstructorMarker) null);
        }
        fVarArr[2] = fVar;
        fVarArr[3] = new f(MatchPreference$Type.DISTANCE, (QuestionWAnswers) null, false, 6, (DefaultConstructorMarker) null);
        fVarArr[4] = new f(MatchPreference$Type.ETHNICITY, (QuestionWAnswers) null, false, 6, (DefaultConstructorMarker) null);
        fVarArr[5] = new f(MatchPreference$Type.RELIGION, (QuestionWAnswers) null, false, 6, (DefaultConstructorMarker) null);
        return q.m(fVarArr);
    }

    /* access modifiers changed from: private */
    public static final boolean n(Function2 function2, Object obj, Object obj2) {
        j.g(function2, "$tmp0");
        return ((Boolean) function2.invoke(obj, obj2)).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final rn.a o(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (rn.a) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final List<f> p(ab.a aVar, boolean z10) {
        f fVar;
        MatchPreference$Type matchPreference$Type;
        List<QuestionWAnswers> b10 = aVar.b();
        ArrayList arrayList = new ArrayList(r.t(b10, 10));
        for (QuestionWAnswers questionWAnswers : b10) {
            String name = questionWAnswers.e().getName();
            if (j.b(name, MatchPreferenceQuestions.HEIGHT.b())) {
                if (z10) {
                    matchPreference$Type = MatchPreference$Type.HEIGHT_METRIC;
                } else {
                    matchPreference$Type = MatchPreference$Type.HEIGHT_IMPERIAL;
                }
                fVar = new f(matchPreference$Type, questionWAnswers, false);
            } else if (j.b(name, MatchPreferenceQuestions.DISTANCE.b())) {
                fVar = new f(MatchPreference$Type.DISTANCE, questionWAnswers, false);
            } else if (j.b(name, MatchPreferenceQuestions.AGE.b())) {
                fVar = new f(MatchPreference$Type.AGE, questionWAnswers, false);
            } else {
                fVar = new f(MatchPreference$Type.FREE_PREFERENCE, questionWAnswers, false);
            }
            arrayList.add(fVar);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final List<f> q(ab.a aVar, boolean z10, boolean z11) {
        f fVar;
        MatchPreference$Type matchPreference$Type;
        List<QuestionWAnswers> b10 = aVar.b();
        ArrayList arrayList = new ArrayList(r.t(b10, 10));
        for (QuestionWAnswers questionWAnswers : b10) {
            String name = questionWAnswers.e().getName();
            if (j.b(name, MatchPreferenceQuestions.HEIGHT.b())) {
                if (z10) {
                    matchPreference$Type = MatchPreference$Type.HEIGHT_METRIC;
                } else {
                    matchPreference$Type = MatchPreference$Type.HEIGHT_IMPERIAL;
                }
                fVar = new f(matchPreference$Type, questionWAnswers, !z11);
            } else if (j.b(name, MatchPreferenceQuestions.DISTANCE.b())) {
                fVar = new f(MatchPreference$Type.DISTANCE, questionWAnswers, !z11);
            } else if (j.b(name, MatchPreferenceQuestions.AGE.b())) {
                fVar = new f(MatchPreference$Type.AGE, questionWAnswers, !z11);
            } else {
                fVar = new f(MatchPreference$Type.PREMIUM_PREFERENCE, questionWAnswers, !z11);
            }
            arrayList.add(fVar);
        }
        return arrayList;
    }

    public final h<a> m() {
        h<R> M = this.f34527a.p().w(new a(GetMatchPreferencesUseCase$invoke$1.f34536a)).M(new b(new GetMatchPreferencesUseCase$invoke$2(this, this.f34529c.A("ProfileMigration.Enabled.Android"))));
        j.f(M, "operator fun invoke(): F…    }\n            }\n    }");
        return M;
    }
}
