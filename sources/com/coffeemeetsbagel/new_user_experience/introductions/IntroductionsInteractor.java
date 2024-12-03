package com.coffeemeetsbagel.new_user_experience.introductions;

import b6.s;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.models.ProfileDtoImplementation;
import com.coffeemeetsbagel.models.dto.ProfileDataContract;
import com.coffeemeetsbagel.new_user_experience.introductions.IntroductionsPresenter;
import com.coffeemeetsbagel.new_user_experience.introductions.r;
import com.uber.autodispose.n;
import com.uber.autodispose.t;
import d7.g;
import java.util.HashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import lc.w;
import na.b;

public final class IntroductionsInteractor extends s<IntroductionsPresenter, p> implements IntroductionsPresenter.a {

    /* renamed from: f  reason: collision with root package name */
    public b f35076f;

    /* renamed from: g  reason: collision with root package name */
    public ProfileRepository f35077g;

    /* renamed from: h  reason: collision with root package name */
    public g f35078h;

    /* renamed from: j  reason: collision with root package name */
    public a7.a f35079j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public ProfileDtoImplementation f35080k;

    /* renamed from: l  reason: collision with root package name */
    private int f35081l;

    public static final class a implements r.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IntroductionsInteractor f35082a;

        a(IntroductionsInteractor introductionsInteractor) {
            this.f35082a = introductionsInteractor;
        }

        public void a() {
            this.f35082a.P1().d("Onboarding - Name - Why Name Screen - Outside zone Tapped");
        }

        public void b() {
            this.f35082a.P1().g("Onboarding - Name - Why Name Screen");
        }

        public void c() {
            this.f35082a.P1().d("Onboarding - Name - Why Name Screen - Next Button Tapped");
        }
    }

    /* access modifiers changed from: private */
    public static final void O1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final boolean T1(ProfileDataContract profileDataContract) {
        return profileDataContract != null && Z1(profileDataContract.getFirstName()) && Z1(profileDataContract.getLastName());
    }

    /* access modifiers changed from: private */
    public static final void U1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void V1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void W1() {
        this.f35081l++;
        new HashMap().put("number_of_failures", String.valueOf(this.f35081l));
        P1().d("Onboarding - Name - Name Input Invalid");
    }

    /* access modifiers changed from: private */
    public final void X1() {
        ((IntroductionsPresenter) this.f7875e).J(T1(this.f35080k));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0058, code lost:
        if (Z1(r4) != false) goto L_0x005a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void Y1() {
        /*
            r6 = this;
            com.coffeemeetsbagel.models.ProfileDtoImplementation r0 = r6.f35080k
            r1 = 0
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.getFirstName()
            goto L_0x000b
        L_0x000a:
            r0 = r1
        L_0x000b:
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0018
            boolean r0 = kotlin.text.r.w(r0)
            if (r0 == 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r0 = r2
            goto L_0x0019
        L_0x0018:
            r0 = r3
        L_0x0019:
            java.lang.String r4 = ""
            if (r0 != 0) goto L_0x0031
            com.coffeemeetsbagel.models.ProfileDtoImplementation r0 = r6.f35080k
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r0.getFirstName()
            if (r0 != 0) goto L_0x0028
        L_0x0027:
            r0 = r4
        L_0x0028:
            boolean r0 = r6.Z1(r0)
            if (r0 == 0) goto L_0x002f
            goto L_0x0031
        L_0x002f:
            r0 = r2
            goto L_0x0032
        L_0x0031:
            r0 = r3
        L_0x0032:
            com.coffeemeetsbagel.models.ProfileDtoImplementation r5 = r6.f35080k
            if (r5 == 0) goto L_0x003a
            java.lang.String r1 = r5.getLastName()
        L_0x003a:
            if (r1 == 0) goto L_0x0045
            boolean r1 = kotlin.text.r.w(r1)
            if (r1 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r1 = r2
            goto L_0x0046
        L_0x0045:
            r1 = r3
        L_0x0046:
            if (r1 != 0) goto L_0x005a
            com.coffeemeetsbagel.models.ProfileDtoImplementation r1 = r6.f35080k
            if (r1 == 0) goto L_0x0054
            java.lang.String r1 = r1.getLastName()
            if (r1 != 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r4 = r1
        L_0x0054:
            boolean r1 = r6.Z1(r4)
            if (r1 == 0) goto L_0x005b
        L_0x005a:
            r2 = r3
        L_0x005b:
            if (r0 == 0) goto L_0x0066
            if (r2 == 0) goto L_0x0066
            na.b r0 = r6.R1()
            r0.c()
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.introductions.IntroductionsInteractor.Y1():void");
    }

    private final boolean Z1(String str) {
        return !r.w(str) && !w.b(str);
    }

    /* access modifiers changed from: private */
    public final void d() {
        ProfileDtoImplementation profileDtoImplementation = this.f35080k;
        if (profileDtoImplementation != null) {
            ((t) S1().u(profileDtoImplementation).K(dk.a.c()).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new g(new IntroductionsInteractor$onNext$1$1(this)), new h(new IntroductionsInteractor$onNext$1$2(this)));
        }
    }

    public void H0(String str) {
        j.g(str, "name");
        ProfileDtoImplementation profileDtoImplementation = this.f35080k;
        if (profileDtoImplementation != null) {
            profileDtoImplementation.setLastName(str);
        }
        if (r.w(str)) {
            ((IntroductionsPresenter) this.f7875e).C();
            ((IntroductionsPresenter) this.f7875e).F();
        } else if (Z1(str)) {
            ((IntroductionsPresenter) this.f7875e).C();
            ((IntroductionsPresenter) this.f7875e).A();
        } else {
            ((IntroductionsPresenter) this.f7875e).A();
            ((IntroductionsPresenter) this.f7875e).G();
            R1().onError(((IntroductionsPresenter) this.f7875e).w());
            W1();
        }
        Y1();
        X1();
    }

    public final a7.a P1() {
        a7.a aVar = this.f35079j;
        if (aVar != null) {
            return aVar;
        }
        j.y("analyticsManager");
        return null;
    }

    public final g Q1() {
        g gVar = this.f35078h;
        if (gVar != null) {
            return gVar;
        }
        j.y("authenticationManager");
        return null;
    }

    public final b R1() {
        b bVar = this.f35076f;
        if (bVar != null) {
            return bVar;
        }
        j.y("interactionListener");
        return null;
    }

    public final ProfileRepository S1() {
        ProfileRepository profileRepository = this.f35077g;
        if (profileRepository != null) {
            return profileRepository;
        }
        j.y("profileRepository");
        return null;
    }

    public void Y0() {
        P1().d("Onboarding - Name - Why Button Tapped");
        ((IntroductionsPresenter) this.f7875e).H(new a(this));
    }

    public void a() {
        ProfileDtoImplementation profileDtoImplementation = this.f35080k;
        if (profileDtoImplementation != null) {
            ((IntroductionsPresenter) this.f7875e).D(profileDtoImplementation.getFirstName(), new IntroductionsInteractor$onNextClicked$1$1(this));
        }
    }

    public void r0(String str) {
        j.g(str, "name");
        ProfileDtoImplementation profileDtoImplementation = this.f35080k;
        if (profileDtoImplementation != null) {
            profileDtoImplementation.setFirstName(str);
        }
        if (r.w(str)) {
            ((IntroductionsPresenter) this.f7875e).B();
        } else if (Z1(str)) {
            ((IntroductionsPresenter) this.f7875e).B();
        } else {
            ((IntroductionsPresenter) this.f7875e).E();
            R1().onError(((IntroductionsPresenter) this.f7875e).w());
            W1();
        }
        Y1();
        X1();
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ProfileRepository S1 = S1();
        String profileId = Q1().getProfileId();
        j.f(profileId, "authenticationManager.profileId");
        ((n) S1.h(profileId).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new f(new IntroductionsInteractor$didBecomeActive$1(this)));
        P1().g("");
    }
}
