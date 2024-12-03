package com.coffeemeetsbagel.new_user_experience.relationship_goals;

import b6.s;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.DynamicMultipleChoiceQuestion;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.new_user_experience.relationship_goals.RelationshipGoalsPresenter;
import com.coffeemeetsbagel.transport.SuccessStatus;
import gk.h;
import hb.c;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.j;

public final class f extends s<RelationshipGoalsPresenter, l> implements RelationshipGoalsPresenter.a {

    /* renamed from: f  reason: collision with root package name */
    private final String f35622f = "GoodStuffQuestion 1";

    /* renamed from: g  reason: collision with root package name */
    private final String f35623g = "GoodStuffQuestion 2";

    /* renamed from: h  reason: collision with root package name */
    public na.b f35624h;

    /* renamed from: j  reason: collision with root package name */
    public ProfileManager f35625j;

    /* renamed from: k  reason: collision with root package name */
    public a7.a f35626k;

    /* renamed from: l  reason: collision with root package name */
    public c f35627l;

    /* renamed from: m  reason: collision with root package name */
    public s9.a f35628m;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35629a;

        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|19) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.coffeemeetsbagel.new_user_experience.relationship_goals.RelationshipGoalPage[] r0 = com.coffeemeetsbagel.new_user_experience.relationship_goals.RelationshipGoalPage.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.new_user_experience.relationship_goals.RelationshipGoalPage r1 = com.coffeemeetsbagel.new_user_experience.relationship_goals.RelationshipGoalPage.MARRIAGE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.new_user_experience.relationship_goals.RelationshipGoalPage r1 = com.coffeemeetsbagel.new_user_experience.relationship_goals.RelationshipGoalPage.COMMITTED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.coffeemeetsbagel.new_user_experience.relationship_goals.RelationshipGoalPage r1 = com.coffeemeetsbagel.new_user_experience.relationship_goals.RelationshipGoalPage.CASUAL     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.coffeemeetsbagel.new_user_experience.relationship_goals.RelationshipGoalPage r1 = com.coffeemeetsbagel.new_user_experience.relationship_goals.RelationshipGoalPage.NOT_SURE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.coffeemeetsbagel.new_user_experience.relationship_goals.RelationshipGoalPage r1 = com.coffeemeetsbagel.new_user_experience.relationship_goals.RelationshipGoalPage.PREFER_NOT_TO_SAY     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.coffeemeetsbagel.new_user_experience.relationship_goals.RelationshipGoalPage r1 = com.coffeemeetsbagel.new_user_experience.relationship_goals.RelationshipGoalPage.WITHIN_TWO_YEARS     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.coffeemeetsbagel.new_user_experience.relationship_goals.RelationshipGoalPage r1 = com.coffeemeetsbagel.new_user_experience.relationship_goals.RelationshipGoalPage.AFTER_TWO_YEARS     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.coffeemeetsbagel.new_user_experience.relationship_goals.RelationshipGoalPage r1 = com.coffeemeetsbagel.new_user_experience.relationship_goals.RelationshipGoalPage.NOT_SURE_WHEN     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                f35629a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.relationship_goals.f.a.<clinit>():void");
        }
    }

    public static final class b implements jc.b<Void> {
        b() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
        }
    }

    private final void M1(DynamicMultipleChoiceQuestion dynamicMultipleChoiceQuestion) {
        boolean z10;
        if (dynamicMultipleChoiceQuestion.getAnswerName().length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            L1().w(dynamicMultipleChoiceQuestion.getQuestionName(), dynamicMultipleChoiceQuestion.getAnswerName());
            if (dynamicMultipleChoiceQuestion.getQuestionName().equals(this.f35622f)) {
                ((RelationshipGoalsPresenter) this.f7875e).p(RelationshipGoalPage.f35582a.a(dynamicMultipleChoiceQuestion.getAnswerName()));
            } else if (dynamicMultipleChoiceQuestion.getQuestionName().equals(this.f35623g)) {
                ((RelationshipGoalsPresenter) this.f7875e).q(RelationshipGoalPage.f35582a.a(dynamicMultipleChoiceQuestion.getAnswerName()));
            }
        }
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        modelProfileUpdateDelta.addOnboardingQuestion(dynamicMultipleChoiceQuestion);
        K1().p(new b(), modelProfileUpdateDelta, true);
    }

    private final void N1(String str) {
        a7.a H1 = H1();
        String format2 = String.format("Onboarding - %s - Next Button Tapped", Arrays.copyOf(new Object[]{((RelationshipGoalsPresenter) this.f7875e).B()}, 1));
        j.f(format2, "format(this, *args)");
        H1.trackEvent(format2, g0.f(h.a("destination", str)));
    }

    private final void O1() {
        a7.a H1 = H1();
        String format2 = String.format("Onboarding - %s - Back Button Tapped", Arrays.copyOf(new Object[]{((RelationshipGoalsPresenter) this.f7875e).B()}, 1));
        j.f(format2, "format(this, *args)");
        H1.d(format2);
    }

    private final void P1() {
        a7.a H1 = H1();
        String format2 = String.format("Onboarding - %s - Hardware Back Button Tapped", Arrays.copyOf(new Object[]{((RelationshipGoalsPresenter) this.f7875e).B()}, 1));
        j.f(format2, "format(this, *args)");
        H1.d(format2);
    }

    private final void Q1() {
        if (!j.b(((RelationshipGoalsPresenter) this.f7875e).B(), RelationshipGoalPage.CASUAL.d()) || (!I1().a("TinderOnboarding.V1.Android") && !I1().a("TinderOnboarding.V2.Android"))) {
            a7.a H1 = H1();
            String format2 = String.format("Onboarding - %s - Next Button Tapped", Arrays.copyOf(new Object[]{((RelationshipGoalsPresenter) this.f7875e).B()}, 1));
            j.f(format2, "format(this, *args)");
            H1.d(format2);
            return;
        }
        a7.a H12 = H1();
        String format3 = String.format("Onboarding - %s - Next Button Tapped", Arrays.copyOf(new Object[]{((RelationshipGoalsPresenter) this.f7875e).B()}, 1));
        j.f(format3, "format(this, *args)");
        H12.trackEvent(format3, g0.f(h.a("destination", ModelDeeplinkData.CMB_AUTHORITY)));
    }

    private final void R1() {
        a7.a H1 = H1();
        String format2 = String.format("Onboarding - %s", Arrays.copyOf(new Object[]{((RelationshipGoalsPresenter) this.f7875e).B()}, 1));
        j.f(format2, "format(this, *args)");
        H1.g(format2);
    }

    public void C0(RelationshipGoalPage relationshipGoalPage, String str) {
        boolean z10;
        j.g(relationshipGoalPage, "goal");
        j.g(str, "displayedText");
        Q1();
        DynamicMultipleChoiceQuestion dynamicMultipleChoiceQuestion = new DynamicMultipleChoiceQuestion(this.f35622f, t9.a.onboardingGoalsQ1, relationshipGoalPage.c(), str);
        int i10 = a.f35629a[relationshipGoalPage.ordinal()];
        if (i10 == 1) {
            ((RelationshipGoalsPresenter) this.f7875e).A(8388613);
            M1(dynamicMultipleChoiceQuestion);
            R1();
        } else if (i10 == 2) {
            ((RelationshipGoalsPresenter) this.f7875e).v(8388613);
            M1(dynamicMultipleChoiceQuestion);
            R1();
        } else if (i10 == 3) {
            if (I1().a("TinderOnboarding.V1.Android")) {
                ((RelationshipGoalsPresenter) this.f7875e).u(8388613);
            } else if (I1().a("TinderOnboarding.V2.Android")) {
                ((RelationshipGoalsPresenter) this.f7875e).t(8388613);
            } else {
                ((RelationshipGoalsPresenter) this.f7875e).r(8388613);
            }
            M1(dynamicMultipleChoiceQuestion);
            R1();
        } else if (i10 == 4) {
            ((RelationshipGoalsPresenter) this.f7875e).y(8388613);
            M1(dynamicMultipleChoiceQuestion);
            R1();
        } else if (i10 != 5) {
            if (str.length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                dynamicMultipleChoiceQuestion = DynamicMultipleChoiceQuestion.copy$default(dynamicMultipleChoiceQuestion, this.f35623g, t9.a.onboardingGoalsQ2, (String) null, (String) null, 12, (Object) null);
                M1(dynamicMultipleChoiceQuestion);
            }
            M1(dynamicMultipleChoiceQuestion);
            na.b.f(J1(), (Map) null, 1, (Object) null);
        } else {
            ((RelationshipGoalsPresenter) this.f7875e).z(8388613);
            M1(dynamicMultipleChoiceQuestion);
            R1();
        }
    }

    public final a7.a H1() {
        a7.a aVar = this.f35626k;
        if (aVar != null) {
            return aVar;
        }
        j.y("analyticsManager");
        return null;
    }

    public final s9.a I1() {
        s9.a aVar = this.f35628m;
        if (aVar != null) {
            return aVar;
        }
        j.y("featureManager");
        return null;
    }

    public final na.b J1() {
        na.b bVar = this.f35624h;
        if (bVar != null) {
            return bVar;
        }
        j.y("interactionListener");
        return null;
    }

    public final ProfileManager K1() {
        ProfileManager profileManager = this.f35625j;
        if (profileManager != null) {
            return profileManager;
        }
        j.y("legacyProfileManager");
        return null;
    }

    public final c L1() {
        c cVar = this.f35627l;
        if (cVar != null) {
            return cVar;
        }
        j.y("managerSharedPreferences");
        return null;
    }

    public void M(RelationshipGoalPage relationshipGoalPage) {
        j.g(relationshipGoalPage, "goal");
        ((RelationshipGoalsPresenter) this.f7875e).m(true);
    }

    public void N() {
        if (I1().a("TinderOnboarding.V1.Android")) {
            N1("tinder");
            ((l) B1()).n();
        } else if (I1().a("TinderOnboarding.V2.Android")) {
            N1("casual_search");
            ((l) B1()).m();
        }
    }

    public void g(boolean z10) {
        RelationshipGoalPage relationshipGoalPage;
        int i10;
        if (z10) {
            P1();
        } else {
            O1();
        }
        RelationshipGoalsPageView n10 = ((RelationshipGoalsPresenter) this.f7875e).n();
        if (n10 != null) {
            relationshipGoalPage = n10.g();
        } else {
            relationshipGoalPage = null;
        }
        if (relationshipGoalPage == null) {
            i10 = -1;
        } else {
            i10 = a.f35629a[relationshipGoalPage.ordinal()];
        }
        switch (i10) {
            case 1:
            case 2:
            case 3:
            case 4:
                ((RelationshipGoalsPresenter) this.f7875e).w(8388611);
                return;
            case 6:
            case 7:
            case 8:
                ((RelationshipGoalsPresenter) this.f7875e).A(8388611);
                return;
            default:
                J1().d();
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        a7.a H1 = H1();
        String format2 = String.format("Onboarding - %s", Arrays.copyOf(new Object[]{RelationshipGoalPage.FIRST_QUESTION.d()}, 1));
        j.f(format2, "format(this, *args)");
        H1.g(format2);
        String r10 = L1().r(this.f35622f);
        if (r10 != null) {
            ((RelationshipGoalsPresenter) this.f7875e).p(RelationshipGoalPage.f35582a.a(r10));
        }
        String r11 = L1().r(this.f35623g);
        if (r11 != null) {
            ((RelationshipGoalsPresenter) this.f7875e).q(RelationshipGoalPage.f35582a.a(r11));
        }
    }
}
