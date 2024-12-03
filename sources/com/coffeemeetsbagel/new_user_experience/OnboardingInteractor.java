package com.coffeemeetsbagel.new_user_experience;

import android.os.Build;
import b6.d;
import b6.i;
import com.appsflyer.AFInAppEventType;
import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.entities.GenderType;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig;
import com.coffeemeetsbagel.qna.j;
import com.coffeemeetsbagel.util.RequestCode;
import com.uber.autodispose.m;
import com.uber.autodispose.p;
import d7.g;
import fa.a;
import j$.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;
import qj.q;
import tj.b;

public final class OnboardingInteractor extends i<v> {

    /* renamed from: e  reason: collision with root package name */
    public na.a f34768e;

    /* renamed from: f  reason: collision with root package name */
    public m1 f34769f;

    /* renamed from: g  reason: collision with root package name */
    public d<?, ?> f34770g;

    /* renamed from: h  reason: collision with root package name */
    public ProfileManager f34771h;

    /* renamed from: j  reason: collision with root package name */
    public a7.a f34772j;

    /* renamed from: k  reason: collision with root package name */
    public UserRepository f34773k;

    /* renamed from: l  reason: collision with root package name */
    public j f34774l;

    /* renamed from: m  reason: collision with root package name */
    public g f34775m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final String f34776n;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f34777a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages[] r0 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages r1 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.BIRTHDAY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages r1 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.GENDER_INFERENCE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages r1 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.NOTIFICATION_JUSTIFICATION     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f34777a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.OnboardingInteractor.a.<clinit>():void");
        }
    }

    public OnboardingInteractor() {
        String simpleName = OnboardingInteractor.class.getSimpleName();
        kotlin.jvm.internal.j.f(simpleName, "OnboardingInteractor::class.java.simpleName");
        this.f34776n = simpleName;
    }

    /* access modifiers changed from: private */
    public static final void O1(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final <T> b W1(q<T> qVar, Function1<? super T, Unit> function1) {
        b c10 = ((p) qVar.a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new r(new OnboardingInteractor$observeDisposable$1(function1)));
        kotlin.jvm.internal.j.f(c10, "consumer: (T) -> Unit): …> consumer.invoke(data) }");
        return c10;
    }

    /* access modifiers changed from: private */
    public static final void X1(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void Y1(c6.a aVar) {
        switch (aVar.b()) {
            case RequestCode.ONBOARDING_LOCATION /*9299*/:
                if (aVar.c() == -1) {
                    ((v) B1()).q();
                    return;
                } else if (aVar.c() == 0) {
                    ((v) B1()).s();
                    return;
                } else {
                    return;
                }
            case RequestCode.ONBOARDING_PERFECT_ATTENDANCE /*9300*/:
                if (aVar.c() == -1) {
                    ((v) B1()).q();
                    return;
                } else if (aVar.c() == 0) {
                    ((v) B1()).s();
                    return;
                } else {
                    return;
                }
            case RequestCode.ONBOARDING_SHOW_PROFILE /*9301*/:
                if (aVar.c() == -1) {
                    ((v) B1()).q();
                    return;
                } else if (aVar.c() == 0) {
                    ((v) B1()).s();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    private final void Z1(QuestionGroupType questionGroupType) {
        j U1 = U1();
        String profileId = Q1().getProfileId();
        kotlin.jvm.internal.j.f(profileId, "authenticationManager.profileId");
        ((m) U1.a(profileId, questionGroupType, true).W().j(com.uber.autodispose.a.a(this))).f(new s(this, questionGroupType), new t(new OnboardingInteractor$prefetchQuestion$2(this, questionGroupType)));
    }

    /* access modifiers changed from: private */
    public static final void a2(OnboardingInteractor onboardingInteractor, QuestionGroupType questionGroupType) {
        kotlin.jvm.internal.j.g(onboardingInteractor, "this$0");
        kotlin.jvm.internal.j.g(questionGroupType, "$type");
        a.C0491a aVar = fa.a.f40771d;
        String str = onboardingInteractor.f34776n;
        aVar.a(str, "Refreshed " + questionGroupType + ".");
    }

    /* access modifiers changed from: private */
    public static final void b2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void d2() {
        boolean z10;
        String m10 = ((v) B1()).m();
        if (m10 == null || r.w(m10)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            a7.a P1 = P1();
            String format2 = String.format("Onboarding - %s - Back Button Tapped", Arrays.copyOf(new Object[]{((v) B1()).m()}, 1));
            kotlin.jvm.internal.j.f(format2, "format(this, *args)");
            P1.d(format2);
        }
    }

    /* access modifiers changed from: private */
    public final void f2(Map<String, String> map) {
        boolean z10;
        String m10 = ((v) B1()).m();
        if (m10 == null || r.w(m10)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            a7.a P1 = P1();
            String format2 = String.format("Onboarding - %s - Next Button Tapped", Arrays.copyOf(new Object[]{((v) B1()).m()}, 1));
            kotlin.jvm.internal.j.f(format2, "format(this, *args)");
            P1.trackEvent(format2, map);
        }
    }

    public final a7.a P1() {
        a7.a aVar = this.f34772j;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("analyticsManager");
        return null;
    }

    public final g Q1() {
        g gVar = this.f34775m;
        if (gVar != null) {
            return gVar;
        }
        kotlin.jvm.internal.j.y("authenticationManager");
        return null;
    }

    public final d<?, ?> R1() {
        d<?, ?> dVar = this.f34770g;
        if (dVar != null) {
            return dVar;
        }
        kotlin.jvm.internal.j.y("componentActivity");
        return null;
    }

    public final na.a S1() {
        na.a aVar = this.f34768e;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("dataStream");
        return null;
    }

    public final ProfileManager T1() {
        ProfileManager profileManager = this.f34771h;
        if (profileManager != null) {
            return profileManager;
        }
        kotlin.jvm.internal.j.y("profileManager");
        return null;
    }

    public final j U1() {
        j jVar = this.f34774l;
        if (jVar != null) {
            return jVar;
        }
        kotlin.jvm.internal.j.y("qnAUseCase");
        return null;
    }

    public final m1 V1() {
        m1 m1Var = this.f34769f;
        if (m1Var != null) {
            return m1Var;
        }
        kotlin.jvm.internal.j.y("syncManager");
        return null;
    }

    public final boolean c2(OnboardingNavigationConfig.Pages pages) {
        int i10;
        boolean z10;
        String str;
        boolean z11;
        kotlin.jvm.internal.j.g(pages, DataLayout.ELEMENT);
        int i11 = a.f34777a[pages.ordinal()];
        if (i11 == 1) {
            NetworkProfile j10 = T1().j();
            if (j10 != null) {
                i10 = j10.getAge();
            } else {
                i10 = 0;
            }
            int year = OffsetDateTime.now().getYear() - 1900;
            if (i10 == year) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                String str2 = "user age is " + year + " due to backend default birthday 1900-01-01";
                fa.a.f40771d.c("OnboardingInteractor", str2, new IllegalStateException(str2));
            }
            if (i10 <= 0 || z10) {
                return true;
            }
            return false;
        } else if (i11 == 2) {
            NetworkProfile j11 = T1().j();
            String str3 = null;
            if (j11 != null) {
                str = j11.getGender();
            } else {
                str = null;
            }
            if (str == null || r.w(str)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                NetworkProfile j12 = T1().j();
                if (j12 != null) {
                    str3 = j12.getGender();
                }
                if (!kotlin.jvm.internal.j.b(str3, GenderType.UNSPECIFIED.getApiKey())) {
                    return false;
                }
            }
            return true;
        } else if (i11 != 3) {
            return true;
        } else {
            if (Build.VERSION.SDK_INT < 33 || androidx.core.content.a.checkSelfPermission(R1(), "android.permission.POST_NOTIFICATIONS") == 0) {
                return false;
            }
            return true;
        }
    }

    public final void e2() {
        boolean z10;
        String m10 = ((v) B1()).m();
        if (m10 == null || r.w(m10)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            a7.a P1 = P1();
            String format2 = String.format("Onboarding - %s - Hardware Back Button Tapped", Arrays.copyOf(new Object[]{((v) B1()).m()}, 1));
            kotlin.jvm.internal.j.f(format2, "format(this, *args)");
            P1.d(format2);
        }
    }

    public final void g2() {
        P1().trackEvent("completed_onboarding", (Map<String, String>) null);
    }

    public final void h2() {
        boolean z10;
        String m10 = ((v) B1()).m();
        if (m10 == null || r.w(m10)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            a7.a P1 = P1();
            String format2 = String.format("Onboarding - %s", Arrays.copyOf(new Object[]{((v) B1()).m()}, 1));
            kotlin.jvm.internal.j.f(format2, "format(this, *args)");
            P1.g(format2);
        }
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        V1().c(true);
        Z1(QuestionGroupType.ONBOARDING);
        Z1(QuestionGroupType.ORIGINAL_PROFILE);
        ((v) B1()).q();
        W1(S1().b(), new OnboardingInteractor$didBecomeActive$1(this));
        W1(S1().g(), new OnboardingInteractor$didBecomeActive$2(this));
        W1(S1().a(), new OnboardingInteractor$didBecomeActive$3(this));
        W1(S1().j(), new OnboardingInteractor$didBecomeActive$4(this));
        ((p) R1().F0().a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new q(new OnboardingInteractor$didBecomeActive$5(this)));
        P1().trackEvent(AFInAppEventType.COMPLETE_REGISTRATION, (Map<String, String>) null);
    }
}
