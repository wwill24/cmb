package com.coffeemeetsbagel.new_user_experience.match_prefs.height_metric;

import b6.s;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.Height;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant;
import com.coffeemeetsbagel.new_user_experience.match_prefs.height_metric.m;
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

public final class HeightMatchPreferencesMetricInteractor extends s<m, n> implements m.a {

    /* renamed from: f  reason: collision with root package name */
    private final QuestionWAnswers f35417f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f35418g;

    /* renamed from: h  reason: collision with root package name */
    public ProfileManager f35419h;

    /* renamed from: j  reason: collision with root package name */
    public k f35420j;

    /* renamed from: k  reason: collision with root package name */
    public l f35421k;

    /* renamed from: l  reason: collision with root package name */
    public SaveAnswerUseCase f35422l;

    /* renamed from: m  reason: collision with root package name */
    public s9.a f35423m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final String f35424n = HeightMatchPreferencesMetricInteractor.class.getSimpleName();

    /* renamed from: p  reason: collision with root package name */
    public DealbreakerVariant f35425p;

    /* renamed from: q  reason: collision with root package name */
    private final PurchaseSource f35426q = new PurchaseSource("Suggested Preference Detail", "premium suggested preferences");

    public static final class a implements b<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HeightMatchPreferencesMetricInteractor f35427a;

        a(HeightMatchPreferencesMetricInteractor heightMatchPreferencesMetricInteractor) {
            this.f35427a = heightMatchPreferencesMetricInteractor;
        }

        public void b(CmbErrorCode cmbErrorCode) {
            this.f35427a.R1().onError(((m) this.f35427a.f7875e).n());
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            this.f35427a.U1().f();
            fa.a.f40771d.a("MatchPrefs", "Next tap end - Height");
            this.f35427a.R1().onSuccess(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        }
    }

    public HeightMatchPreferencesMetricInteractor(QuestionWAnswers questionWAnswers, boolean z10) {
        this.f35417f = questionWAnswers;
        this.f35418g = z10;
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

    /* access modifiers changed from: private */
    public final void Y1(Pair<Integer, Integer> pair) {
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        modelProfileUpdateDelta.updateCriteriaHeightFrom(new Height(pair.c().intValue()));
        modelProfileUpdateDelta.updateCriteriaHeightTo(new Height(pair.d().intValue()));
        U1().p(new a(this), modelProfileUpdateDelta, true);
    }

    /* access modifiers changed from: private */
    public final void Z1(Pair<Integer, Integer> pair, QuestionWAnswers questionWAnswers, boolean z10) {
        if (!this.f35418g) {
            ((com.uber.autodispose.m) SaveAnswerUseCase.d(W1(), (List) null, (String) null, questionWAnswers.e().getId(), questionWAnswers.e().getGroup().getQuestionGroupApiString(), (Integer) null, (Float) null, Float.valueOf((float) pair.c().intValue()), Float.valueOf((float) pair.d().intValue()), z10, (Location) null, 563, (Object) null).j(com.uber.autodispose.a.a(this))).f(new h(this), new i(new HeightMatchPreferencesMetricInteractor$saveQuestion$2(this)));
        }
    }

    /* access modifiers changed from: private */
    public static final void a2(HeightMatchPreferencesMetricInteractor heightMatchPreferencesMetricInteractor) {
        j.g(heightMatchPreferencesMetricInteractor, "this$0");
        heightMatchPreferencesMetricInteractor.U1().f();
        heightMatchPreferencesMetricInteractor.R1().onSuccess(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
    }

    /* access modifiers changed from: private */
    public static final void b2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    public final k R1() {
        k kVar = this.f35420j;
        if (kVar != null) {
            return kVar;
        }
        j.y("dataListener");
        return null;
    }

    public final l S1() {
        l lVar = this.f35421k;
        if (lVar != null) {
            return lVar;
        }
        j.y("dataStream");
        return null;
    }

    public final s9.a T1() {
        s9.a aVar = this.f35423m;
        if (aVar != null) {
            return aVar;
        }
        j.y("featureManager");
        return null;
    }

    public final ProfileManager U1() {
        ProfileManager profileManager = this.f35419h;
        if (profileManager != null) {
            return profileManager;
        }
        j.y("profileManager");
        return null;
    }

    public final QuestionWAnswers V1() {
        return this.f35417f;
    }

    public final SaveAnswerUseCase W1() {
        SaveAnswerUseCase saveAnswerUseCase = this.f35422l;
        if (saveAnswerUseCase != null) {
            return saveAnswerUseCase;
        }
        j.y("saveAnswerUseCase");
        return null;
    }

    public final DealbreakerVariant X1() {
        DealbreakerVariant dealbreakerVariant = this.f35425p;
        if (dealbreakerVariant != null) {
            return dealbreakerVariant;
        }
        j.y("variant");
        return null;
    }

    public final void c2(DealbreakerVariant dealbreakerVariant) {
        j.g(dealbreakerVariant, "<set-?>");
        this.f35425p = dealbreakerVariant;
    }

    public void e() {
        ((n) B1()).m(this.f35426q);
    }

    /* access modifiers changed from: protected */
    public void y1() {
        DealbreakerVariant dealbreakerVariant;
        int i10;
        int i11;
        boolean z10;
        Float maxValue;
        Float minValue;
        super.y1();
        if (T1().a("DealbreakersV2.VariantA.Android")) {
            dealbreakerVariant = DealbreakerVariant.VARIANT_A;
        } else if (T1().a("DealbreakersV2.VariantB.Android")) {
            dealbreakerVariant = DealbreakerVariant.VARIANT_B;
        } else {
            dealbreakerVariant = DealbreakerVariant.DISABLED;
        }
        c2(dealbreakerVariant);
        NetworkProfile j10 = U1().j();
        j.d(j10);
        if (this.f35417f != null || j10.getCriteriaHeightCentimetersFrom() <= 0) {
            QuestionWAnswers questionWAnswers = this.f35417f;
            if (questionWAnswers == null) {
                P p10 = this.f7875e;
                j.f(p10, "presenter");
                m.t((m) p10, Integer.valueOf(j10.getDefaultMinHeightCm()), Integer.valueOf(j10.getDefaultMaxHeightCm()), (DealbreakerVariant) null, false, this.f35418g, 12, (Object) null);
            } else {
                Answer answer = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
                if (answer == null || (minValue = answer.getMinValue()) == null) {
                    i10 = j10.getDefaultMinHeightCm();
                } else {
                    i10 = c.b(minValue.floatValue());
                }
                Answer answer2 = (Answer) CollectionsKt___CollectionsKt.P(this.f35417f.d());
                if (answer2 == null || (maxValue = answer2.getMaxValue()) == null) {
                    i11 = j10.getDefaultMaxHeightCm();
                } else {
                    i11 = c.b(maxValue.floatValue());
                }
                Answer answer3 = (Answer) CollectionsKt___CollectionsKt.P(this.f35417f.d());
                if (answer3 != null) {
                    z10 = j.b(answer3.isDealbreaker(), Boolean.TRUE);
                } else {
                    z10 = false;
                }
                ((m) this.f7875e).r(Integer.valueOf(i10), Integer.valueOf(i11), X1(), z10, this.f35418g);
            }
        } else {
            P p11 = this.f7875e;
            j.f(p11, "presenter");
            m.t((m) p11, Integer.valueOf(j10.getCriteriaHeightCentimetersFrom()), Integer.valueOf(j10.getCriteriaHeightCentimetersTo()), (DealbreakerVariant) null, false, this.f35418g, 12, (Object) null);
        }
        ((p) ((m) this.f7875e).m().g(com.uber.autodispose.a.a(this))).c(new f(new HeightMatchPreferencesMetricInteractor$didBecomeActive$1(this)));
        ((p) S1().a().p0(1, TimeUnit.SECONDS).g(com.uber.autodispose.a.a(this))).c(new g(new HeightMatchPreferencesMetricInteractor$didBecomeActive$2(this)));
    }
}
