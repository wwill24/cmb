package com.coffeemeetsbagel.new_user_experience.match_prefs.gender;

import b6.s;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.models.entities.GenderType;
import com.coffeemeetsbagel.new_user_experience.match_prefs.k;
import com.coffeemeetsbagel.new_user_experience.match_prefs.l;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.uber.autodispose.p;
import fa.a;
import java.util.concurrent.TimeUnit;
import jc.b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class GenderMatchPreferenceInteractor extends s<i, j> {

    /* renamed from: f  reason: collision with root package name */
    public ProfileManager f35362f;

    /* renamed from: g  reason: collision with root package name */
    public k f35363g;

    /* renamed from: h  reason: collision with root package name */
    public l f35364h;

    public static final class a implements b<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GenderMatchPreferenceInteractor f35365a;

        a(GenderMatchPreferenceInteractor genderMatchPreferenceInteractor) {
            this.f35365a = genderMatchPreferenceInteractor;
        }

        public void b(CmbErrorCode cmbErrorCode) {
            this.f35365a.N1().onError(((i) this.f35365a.f7875e).m());
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            this.f35365a.P1().f();
            fa.a.f40771d.a("MatchPrefs", "Next tap - Gender");
            this.f35365a.N1().onSuccess(ProfileConstants.Field.GENDER);
        }
    }

    /* access modifiers changed from: private */
    public static final void L1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void M1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void Q1() {
        String apiKey = ((i) this.f7875e).k().getApiKey();
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        modelProfileUpdateDelta.updateCriteriaGender(apiKey);
        P1().p(new a(this), modelProfileUpdateDelta, true);
    }

    public final k N1() {
        k kVar = this.f35363g;
        if (kVar != null) {
            return kVar;
        }
        j.y("dataListener");
        return null;
    }

    public final l O1() {
        l lVar = this.f35364h;
        if (lVar != null) {
            return lVar;
        }
        j.y("dataStream");
        return null;
    }

    public final ProfileManager P1() {
        ProfileManager profileManager = this.f35362f;
        if (profileManager != null) {
            return profileManager;
        }
        j.y("profileManager");
        return null;
    }

    /* access modifiers changed from: protected */
    public void y1() {
        GenderType genderType;
        String criteriaGender;
        super.y1();
        NetworkProfile j10 = P1().j();
        if (j10 == null || (criteriaGender = j10.getCriteriaGender()) == null) {
            genderType = null;
        } else {
            genderType = GenderType.Companion.fromApiKey(criteriaGender);
        }
        ((i) this.f7875e).n(genderType);
        ((p) ((i) this.f7875e).l().g(com.uber.autodispose.a.a(this))).c(new f(new GenderMatchPreferenceInteractor$didBecomeActive$1(this)));
        a.C0491a aVar = fa.a.f40771d;
        boolean b10 = O1().b();
        aVar.a("MatchPrefs - Age", "does save stream have any observers? " + b10);
        ((p) O1().a().p0(1, TimeUnit.SECONDS).g(com.uber.autodispose.a.a(this))).c(new g(new GenderMatchPreferenceInteractor$didBecomeActive$2(this)));
    }
}
