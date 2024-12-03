package com.coffeemeetsbagel.new_user_experience.match_prefs.height_imperial;

import b6.s;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.Height;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant;
import com.coffeemeetsbagel.new_user_experience.match_prefs.height_imperial.m;
import com.coffeemeetsbagel.new_user_experience.match_prefs.k;
import com.coffeemeetsbagel.new_user_experience.match_prefs.l;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.uber.autodispose.p;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jc.b;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class HeightMatchPreferencesImperialInteractor extends s<m, n> implements m.a {

    /* renamed from: f  reason: collision with root package name */
    private final QuestionWAnswers f35384f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f35385g;

    /* renamed from: h  reason: collision with root package name */
    public ProfileManager f35386h;

    /* renamed from: j  reason: collision with root package name */
    public k f35387j;

    /* renamed from: k  reason: collision with root package name */
    public l f35388k;

    /* renamed from: l  reason: collision with root package name */
    public SaveAnswerUseCase f35389l;

    /* renamed from: m  reason: collision with root package name */
    public s9.a f35390m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final String f35391n = HeightMatchPreferencesImperialInteractor.class.getSimpleName();

    /* renamed from: p  reason: collision with root package name */
    public DealbreakerVariant f35392p;

    /* renamed from: q  reason: collision with root package name */
    private final PurchaseSource f35393q = new PurchaseSource("Suggested Preference Detail", "premium suggested preferences");

    public static final class a implements b<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HeightMatchPreferencesImperialInteractor f35394a;

        a(HeightMatchPreferencesImperialInteractor heightMatchPreferencesImperialInteractor) {
            this.f35394a = heightMatchPreferencesImperialInteractor;
        }

        public void b(CmbErrorCode cmbErrorCode) {
            this.f35394a.R1().onError(((m) this.f35394a.f7875e).n());
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            this.f35394a.U1().f();
            this.f35394a.R1().onSuccess(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        }
    }

    public HeightMatchPreferencesImperialInteractor(QuestionWAnswers questionWAnswers, boolean z10) {
        this.f35384f = questionWAnswers;
        this.f35385g = z10;
    }

    /* access modifiers changed from: private */
    public static final void P1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void Q1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final Pair<o, o> W1(NetworkProfile networkProfile) {
        if (networkProfile.getCriteriaHeightFeetFrom() > 0) {
            return new Pair<>(new o(networkProfile.getCriteriaHeightFeetFrom(), networkProfile.getCriteriaHeightInchesFrom()), new o(networkProfile.getCriteriaHeightFeetTo(), networkProfile.getCriteriaHeightInchesTo()));
        }
        return new Pair<>(new o(4, 0), new o(8, 11));
    }

    private final Pair<o, o> X1(QuestionWAnswers questionWAnswers) {
        float f10;
        Float maxValue;
        Float minValue;
        if (questionWAnswers.d().isEmpty() || ((Answer) CollectionsKt___CollectionsKt.N(questionWAnswers.d())).getMinValue() == null || ((Answer) CollectionsKt___CollectionsKt.N(questionWAnswers.d())).getMaxValue() == null) {
            return new Pair<>(new o(4, 0), new o(8, 11));
        }
        Answer answer = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
        float f11 = 0.0f;
        if (answer == null || (minValue = answer.getMinValue()) == null) {
            f10 = 0.0f;
        } else {
            f10 = minValue.floatValue();
        }
        o oVar = new o(f10);
        Answer answer2 = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
        if (!(answer2 == null || (maxValue = answer2.getMaxValue()) == null)) {
            f11 = maxValue.floatValue();
        }
        return new Pair<>(oVar, new o(f11));
    }

    /* access modifiers changed from: private */
    public final void a2(Pair<o, o> pair, QuestionWAnswers questionWAnswers, boolean z10) {
        if (!this.f35385g) {
            ((com.uber.autodispose.m) SaveAnswerUseCase.d(Y1(), (List) null, (String) null, questionWAnswers.e().getId(), questionWAnswers.e().getGroup().getQuestionGroupApiString(), (Integer) null, (Float) null, Float.valueOf(pair.c().d()), Float.valueOf(pair.d().d()), z10, (Location) null, 563, (Object) null).j(com.uber.autodispose.a.a(this))).f(new h(this), new i(new HeightMatchPreferencesImperialInteractor$saveQuestion$2(this)));
        }
    }

    /* access modifiers changed from: private */
    public static final void b2(HeightMatchPreferencesImperialInteractor heightMatchPreferencesImperialInteractor) {
        j.g(heightMatchPreferencesImperialInteractor, "this$0");
        heightMatchPreferencesImperialInteractor.U1().f();
        heightMatchPreferencesImperialInteractor.R1().onSuccess(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
    }

    /* access modifiers changed from: private */
    public static final void c2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void e2(Pair<o, o> pair) {
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        if (pair.c().a(pair.d()) < 0) {
            modelProfileUpdateDelta.updateCriteriaHeightFrom(new Height(pair.c().b(), pair.c().c()));
            modelProfileUpdateDelta.updateCriteriaHeightTo(new Height(pair.d().b(), pair.d().c()));
        } else {
            modelProfileUpdateDelta.updateCriteriaHeightFrom(new Height(pair.d().b(), pair.d().c()));
            modelProfileUpdateDelta.updateCriteriaHeightTo(new Height(pair.c().b(), pair.c().c()));
        }
        U1().p(new a(this), modelProfileUpdateDelta, true);
    }

    public final k R1() {
        k kVar = this.f35387j;
        if (kVar != null) {
            return kVar;
        }
        j.y("dataListener");
        return null;
    }

    public final l S1() {
        l lVar = this.f35388k;
        if (lVar != null) {
            return lVar;
        }
        j.y("dataStream");
        return null;
    }

    public final s9.a T1() {
        s9.a aVar = this.f35390m;
        if (aVar != null) {
            return aVar;
        }
        j.y("featureManager");
        return null;
    }

    public final ProfileManager U1() {
        ProfileManager profileManager = this.f35386h;
        if (profileManager != null) {
            return profileManager;
        }
        j.y("profileManager");
        return null;
    }

    public final QuestionWAnswers V1() {
        return this.f35384f;
    }

    public final SaveAnswerUseCase Y1() {
        SaveAnswerUseCase saveAnswerUseCase = this.f35389l;
        if (saveAnswerUseCase != null) {
            return saveAnswerUseCase;
        }
        j.y("saveAnswerUseCase");
        return null;
    }

    public final DealbreakerVariant Z1() {
        DealbreakerVariant dealbreakerVariant = this.f35392p;
        if (dealbreakerVariant != null) {
            return dealbreakerVariant;
        }
        j.y("variant");
        return null;
    }

    public final void d2(DealbreakerVariant dealbreakerVariant) {
        j.g(dealbreakerVariant, "<set-?>");
        this.f35392p = dealbreakerVariant;
    }

    public void e() {
        ((n) B1()).m(this.f35393q);
    }

    /* access modifiers changed from: protected */
    public void y1() {
        DealbreakerVariant dealbreakerVariant;
        Pair<o, o> pair;
        boolean z10;
        List<Answer> d10;
        Answer answer;
        super.y1();
        if (T1().a("DealbreakersV2.VariantA.Android")) {
            dealbreakerVariant = DealbreakerVariant.VARIANT_A;
        } else if (T1().a("DealbreakersV2.VariantB.Android")) {
            dealbreakerVariant = DealbreakerVariant.VARIANT_B;
        } else {
            dealbreakerVariant = DealbreakerVariant.DISABLED;
        }
        d2(dealbreakerVariant);
        m mVar = (m) this.f7875e;
        QuestionWAnswers questionWAnswers = this.f35384f;
        if (questionWAnswers == null || (pair = X1(questionWAnswers)) == null) {
            NetworkProfile j10 = U1().j();
            j.d(j10);
            pair = W1(j10);
        }
        DealbreakerVariant Z1 = Z1();
        QuestionWAnswers questionWAnswers2 = this.f35384f;
        if (questionWAnswers2 == null || (d10 = questionWAnswers2.d()) == null || (answer = (Answer) CollectionsKt___CollectionsKt.P(d10)) == null) {
            z10 = false;
        } else {
            z10 = j.b(answer.isDealbreaker(), Boolean.TRUE);
        }
        mVar.v(pair, Z1, z10, this.f35385g);
        ((p) ((m) this.f7875e).m().g(com.uber.autodispose.a.a(this))).c(new f(new HeightMatchPreferencesImperialInteractor$didBecomeActive$1(this)));
        ((p) S1().a().p0(1, TimeUnit.SECONDS).g(com.uber.autodispose.a.a(this))).c(new g(new HeightMatchPreferencesImperialInteractor$didBecomeActive$2(this)));
    }
}
