package com.coffeemeetsbagel.new_user_experience.email;

import b6.s;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.new_user_experience.email.EmailPresenter;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.uber.autodispose.n;
import d7.g;
import h5.h;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import lc.w;
import na.b;

public final class EmailInteractor extends s<EmailPresenter, l> implements EmailPresenter.a {

    /* renamed from: f  reason: collision with root package name */
    public b f34955f;

    /* renamed from: g  reason: collision with root package name */
    public ProfileManager f34956g;

    /* renamed from: h  reason: collision with root package name */
    public ProfileRepository f34957h;

    /* renamed from: j  reason: collision with root package name */
    public g f34958j;

    /* renamed from: k  reason: collision with root package name */
    private final ModelProfileUpdateDelta f34959k = new ModelProfileUpdateDelta();

    public static final class a implements jc.b<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EmailInteractor f34960a;

        a(EmailInteractor emailInteractor) {
            this.f34960a = emailInteractor;
        }

        public void b(CmbErrorCode cmbErrorCode) {
            this.f34960a.L1().onError(((EmailPresenter) this.f34960a.f7875e).v());
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            b.f(this.f34960a.L1(), (Map) null, 1, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void J1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final boolean O1(String str) {
        if (h.a(str)) {
            if (str != null && !StringsKt__StringsKt.O(str, "@coffeemeetsbagel.com", false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public final g K1() {
        g gVar = this.f34958j;
        if (gVar != null) {
            return gVar;
        }
        j.y("authenticationManager");
        return null;
    }

    public void L0(String str) {
        boolean O1 = O1(str);
        if (w.a(str)) {
            L1().onError(((EmailPresenter) this.f7875e).t());
        } else if (O1) {
            L1().c();
            this.f34959k.updateEmail(str);
        }
        ((EmailPresenter) this.f7875e).r(O1);
    }

    public final b L1() {
        b bVar = this.f34955f;
        if (bVar != null) {
            return bVar;
        }
        j.y("interactionListener");
        return null;
    }

    public final ProfileManager M1() {
        ProfileManager profileManager = this.f34956g;
        if (profileManager != null) {
            return profileManager;
        }
        j.y("legacyProfileManager");
        return null;
    }

    public final ProfileRepository N1() {
        ProfileRepository profileRepository = this.f34957h;
        if (profileRepository != null) {
            return profileRepository;
        }
        j.y("profileRepository");
        return null;
    }

    public void a() {
        M1().p(new a(this), this.f34959k, true);
    }

    public void w0() {
        L1().d();
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ProfileRepository N1 = N1();
        String profileId = K1().getProfileId();
        j.f(profileId, "authenticationManager.profileId");
        ((n) N1.h(profileId).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new f(new EmailInteractor$didBecomeActive$1(this)));
        NetworkProfile j10 = M1().j();
        if (j10 != null) {
            String userEmail = j10.getUserEmail();
            j.f(userEmail, "profile.userEmail");
            ((EmailPresenter) this.f7875e).w(userEmail);
        }
    }
}
