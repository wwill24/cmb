package com.coffeemeetsbagel.new_user_experience.new_to_online_dating;

import b6.s;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.models.DynamicMultipleChoiceQuestion;
import com.coffeemeetsbagel.models.entities.GenderType;
import com.coffeemeetsbagel.new_user_experience.new_to_online_dating.NewToOnlineDatingPresenter;
import com.uber.autodispose.n;
import d7.g;
import hb.c;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import na.b;

public final class NewToOnlineDatingInteractor extends s<NewToOnlineDatingPresenter, l> implements NewToOnlineDatingPresenter.a {

    /* renamed from: f  reason: collision with root package name */
    public b f35489f;

    /* renamed from: g  reason: collision with root package name */
    public ProfileRepository f35490g;

    /* renamed from: h  reason: collision with root package name */
    public g f35491h;

    /* renamed from: j  reason: collision with root package name */
    public c f35492j;

    /* renamed from: k  reason: collision with root package name */
    public a7.a f35493k;

    /* renamed from: l  reason: collision with root package name */
    private final String f35494l = "NEW_TO_ONLINE_DATING_QUESTION_KEY";
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public GenderType f35495m;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35496a;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.coffeemeetsbagel.new_user_experience.new_to_online_dating.NewToOnlineDatingPage[] r0 = com.coffeemeetsbagel.new_user_experience.new_to_online_dating.NewToOnlineDatingPage.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.new_user_experience.new_to_online_dating.NewToOnlineDatingPage r1 = com.coffeemeetsbagel.new_user_experience.new_to_online_dating.NewToOnlineDatingPage.FEMALE_NOT_NEW     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.new_user_experience.new_to_online_dating.NewToOnlineDatingPage r1 = com.coffeemeetsbagel.new_user_experience.new_to_online_dating.NewToOnlineDatingPage.FEMALE_NEW     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.coffeemeetsbagel.new_user_experience.new_to_online_dating.NewToOnlineDatingPage r1 = com.coffeemeetsbagel.new_user_experience.new_to_online_dating.NewToOnlineDatingPage.MALE_NOT_NEW     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.coffeemeetsbagel.new_user_experience.new_to_online_dating.NewToOnlineDatingPage r1 = com.coffeemeetsbagel.new_user_experience.new_to_online_dating.NewToOnlineDatingPage.MALE_NEW     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f35496a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.new_to_online_dating.NewToOnlineDatingInteractor.a.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public static final void L1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void R1(DynamicMultipleChoiceQuestion dynamicMultipleChoiceQuestion) {
        boolean z10;
        if (dynamicMultipleChoiceQuestion.getAnswerName().length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            P1().w(this.f35494l, dynamicMultipleChoiceQuestion.getAnswerName());
            if (j.b(dynamicMultipleChoiceQuestion.getQuestionName(), this.f35494l)) {
                ((NewToOnlineDatingPresenter) this.f7875e).p(NewToOnlineDatingPage.f35497a.a(dynamicMultipleChoiceQuestion.getAnswerName()));
            }
        }
    }

    private final void S1(NewToOnlineDatingPage newToOnlineDatingPage) {
        HashMap hashMap = new HashMap();
        hashMap.put("new to online dating answer", newToOnlineDatingPage.c());
        String str = t9.a.onboardingNewToOnlineDatingQuestion;
        j.f(str, "onboardingNewToOnlineDatingQuestion");
        hashMap.put("new to online dating question", str);
        a7.a M1 = M1();
        String format2 = String.format("Onboarding - %s", Arrays.copyOf(new Object[]{((NewToOnlineDatingPresenter) this.f7875e).t()}, 1));
        j.f(format2, "format(this, *args)");
        M1.trackEvent(format2, hashMap);
    }

    private final void T1() {
        a7.a M1 = M1();
        String format2 = String.format("Onboarding - %s - Back Button Tapped", Arrays.copyOf(new Object[]{((NewToOnlineDatingPresenter) this.f7875e).t()}, 1));
        j.f(format2, "format(this, *args)");
        M1.d(format2);
    }

    private final void U1() {
        a7.a M1 = M1();
        String format2 = String.format("Onboarding - %s - Hardware Back Button Tapped", Arrays.copyOf(new Object[]{((NewToOnlineDatingPresenter) this.f7875e).t()}, 1));
        j.f(format2, "format(this, *args)");
        M1.d(format2);
    }

    private final void V1() {
        a7.a M1 = M1();
        String format2 = String.format("Onboarding - %s - Next Button Tapped", Arrays.copyOf(new Object[]{((NewToOnlineDatingPresenter) this.f7875e).t()}, 1));
        j.f(format2, "format(this, *args)");
        M1.d(format2);
    }

    private final void W1() {
        a7.a M1 = M1();
        String format2 = String.format("Onboarding - %s", Arrays.copyOf(new Object[]{((NewToOnlineDatingPresenter) this.f7875e).t()}, 1));
        j.f(format2, "format(this, *args)");
        M1.g(format2);
    }

    public final a7.a M1() {
        a7.a aVar = this.f35493k;
        if (aVar != null) {
            return aVar;
        }
        j.y("analyticsManager");
        return null;
    }

    public final g N1() {
        g gVar = this.f35491h;
        if (gVar != null) {
            return gVar;
        }
        j.y("authenticationManager");
        return null;
    }

    public void O0(NewToOnlineDatingPage newToOnlineDatingPage, String str) {
        j.g(newToOnlineDatingPage, "newToOnlineDatingAnswer");
        j.g(str, "displayedText");
        DynamicMultipleChoiceQuestion dynamicMultipleChoiceQuestion = new DynamicMultipleChoiceQuestion(this.f35494l, t9.a.onboardingNewToOnlineDatingQuestion, newToOnlineDatingPage.c(), str);
        V1();
        S1(newToOnlineDatingPage);
        int i10 = a.f35496a[newToOnlineDatingPage.ordinal()];
        if (i10 == 1) {
            NewToOnlineDatingPage newToOnlineDatingPage2 = NewToOnlineDatingPage.FEMALE_NOT_NEW;
            String str2 = t9.a.onboardingNewToOnlineDatingAnswerFemaleNotNew;
            j.f(str2, "onboardingNewToOnlineDatingAnswerFemaleNotNew");
            ((NewToOnlineDatingPresenter) this.f7875e).q(8388613, newToOnlineDatingPage2, str2);
            R1(dynamicMultipleChoiceQuestion);
            W1();
        } else if (i10 == 2) {
            NewToOnlineDatingPage newToOnlineDatingPage3 = NewToOnlineDatingPage.FEMALE_NEW;
            String str3 = t9.a.onboardingNewToOnlineDatingAnswerFemaleNew;
            j.f(str3, "onboardingNewToOnlineDatingAnswerFemaleNew");
            ((NewToOnlineDatingPresenter) this.f7875e).q(8388613, newToOnlineDatingPage3, str3);
            R1(dynamicMultipleChoiceQuestion);
            W1();
        } else if (i10 == 3) {
            NewToOnlineDatingPage newToOnlineDatingPage4 = NewToOnlineDatingPage.MALE_NOT_NEW;
            String str4 = t9.a.onboardingNewToOnlineDatingAnswerMaleNotNew;
            j.f(str4, "onboardingNewToOnlineDatingAnswerMaleNotNew");
            ((NewToOnlineDatingPresenter) this.f7875e).q(8388613, newToOnlineDatingPage4, str4);
            R1(dynamicMultipleChoiceQuestion);
            W1();
        } else if (i10 != 4) {
            R1(dynamicMultipleChoiceQuestion);
            b.f(O1(), (Map) null, 1, (Object) null);
        } else {
            NewToOnlineDatingPage newToOnlineDatingPage5 = NewToOnlineDatingPage.MALE_NEW;
            String str5 = t9.a.onboardingNewToOnlineDatingAnswerMaleNew;
            j.f(str5, "onboardingNewToOnlineDatingAnswerMaleNew");
            ((NewToOnlineDatingPresenter) this.f7875e).q(8388613, newToOnlineDatingPage5, str5);
            R1(dynamicMultipleChoiceQuestion);
            W1();
        }
    }

    public final b O1() {
        b bVar = this.f35489f;
        if (bVar != null) {
            return bVar;
        }
        j.y("interactionListener");
        return null;
    }

    public final c P1() {
        c cVar = this.f35492j;
        if (cVar != null) {
            return cVar;
        }
        j.y("managerSharedPreferences");
        return null;
    }

    public final ProfileRepository Q1() {
        ProfileRepository profileRepository = this.f35490g;
        if (profileRepository != null) {
            return profileRepository;
        }
        j.y("profileRepository");
        return null;
    }

    public void g(boolean z10) {
        NewToOnlineDatingPage newToOnlineDatingPage;
        int i10;
        if (z10) {
            U1();
        } else {
            T1();
        }
        NewToOnlineDatingPageView n10 = ((NewToOnlineDatingPresenter) this.f7875e).n();
        if (n10 != null) {
            newToOnlineDatingPage = n10.h();
        } else {
            newToOnlineDatingPage = null;
        }
        if (newToOnlineDatingPage == null) {
            i10 = -1;
        } else {
            i10 = a.f35496a[newToOnlineDatingPage.ordinal()];
        }
        if (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) {
            GenderType genderType = this.f35495m;
            if (genderType != null) {
                ((NewToOnlineDatingPresenter) this.f7875e).r(8388611, genderType);
                return;
            }
            return;
        }
        O1().d();
    }

    public void u0() {
        ((NewToOnlineDatingPresenter) this.f7875e).m(true);
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        a7.a M1 = M1();
        boolean z10 = true;
        String format2 = String.format("Onboarding - %s", Arrays.copyOf(new Object[]{NewToOnlineDatingPage.QUESTION.e()}, 1));
        j.f(format2, "format(this, *args)");
        M1.g(format2);
        String r10 = P1().r(this.f35494l);
        if (r10 != null) {
            if (r10.length() <= 0) {
                z10 = false;
            }
            if (z10) {
                ((NewToOnlineDatingPresenter) this.f7875e).p(NewToOnlineDatingPage.f35497a.a(r10));
            }
        }
        ProfileRepository Q1 = Q1();
        String profileId = N1().getProfileId();
        j.f(profileId, "authenticationManager.profileId");
        ((n) Q1.h(profileId).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new f(new NewToOnlineDatingInteractor$didBecomeActive$2(this)));
    }
}
