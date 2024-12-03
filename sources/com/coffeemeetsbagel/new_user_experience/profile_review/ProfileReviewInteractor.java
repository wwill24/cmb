package com.coffeemeetsbagel.new_user_experience.profile_review;

import b6.s;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.new_user_experience.profile_review.ProfileReviewPresenter;
import com.uber.autodispose.n;
import d7.g;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import na.b;
import sj.a;

public final class ProfileReviewInteractor extends s<ProfileReviewPresenter, i> implements ProfileReviewPresenter.a {

    /* renamed from: f  reason: collision with root package name */
    public b f35567f;

    /* renamed from: g  reason: collision with root package name */
    public ProfileRepository f35568g;

    /* renamed from: h  reason: collision with root package name */
    public g f35569h;

    /* access modifiers changed from: private */
    public static final void J1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    public final g K1() {
        g gVar = this.f35569h;
        if (gVar != null) {
            return gVar;
        }
        j.y("authenticationManager");
        return null;
    }

    public final b L1() {
        b bVar = this.f35567f;
        if (bVar != null) {
            return bVar;
        }
        j.y("interactionListener");
        return null;
    }

    public final ProfileRepository M1() {
        ProfileRepository profileRepository = this.f35568g;
        if (profileRepository != null) {
            return profileRepository;
        }
        j.y("profileRepository");
        return null;
    }

    public void a() {
        b.f(L1(), (Map) null, 1, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ProfileRepository M1 = M1();
        String profileId = K1().getProfileId();
        j.f(profileId, "authenticationManager.profileId");
        ((n) M1.h(profileId).a0(a.a()).g(com.uber.autodispose.a.a(this))).c(new f(new ProfileReviewInteractor$didBecomeActive$1(this)));
    }
}
