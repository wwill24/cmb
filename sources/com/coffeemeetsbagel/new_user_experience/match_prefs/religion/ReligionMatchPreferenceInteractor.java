package com.coffeemeetsbagel.new_user_experience.match_prefs.religion;

import b6.s;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.models.enums.ResourceType;
import com.coffeemeetsbagel.new_user_experience.match_prefs.d;
import com.coffeemeetsbagel.new_user_experience.match_prefs.k;
import com.coffeemeetsbagel.new_user_experience.match_prefs.l;
import com.coffeemeetsbagel.new_user_experience.match_prefs.o;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.uber.autodispose.p;
import com.uber.autodispose.t;
import fa.a;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class ReligionMatchPreferenceInteractor extends s<k, l> {

    /* renamed from: f  reason: collision with root package name */
    public ProfileManager f35456f;

    /* renamed from: g  reason: collision with root package name */
    public k f35457g;

    /* renamed from: h  reason: collision with root package name */
    public l f35458h;

    /* renamed from: j  reason: collision with root package name */
    public d f35459j;

    /* renamed from: k  reason: collision with root package name */
    public c9.a f35460k;

    public static final class a implements o.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReligionMatchPreferenceInteractor f35461a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List<Resource> f35462b;

        a(ReligionMatchPreferenceInteractor religionMatchPreferenceInteractor, List<Resource> list) {
            this.f35461a = religionMatchPreferenceInteractor;
            this.f35462b = list;
        }

        public void a() {
            this.f35461a.W1().d("Hardware Back Button Tapped", "Onboarding - Religion");
        }

        public void b() {
            this.f35461a.W1().d("Edit Button Tapped", "Onboarding - Religion");
        }

        public void c() {
            this.f35461a.W1().d("Continue Button Tapped", "Onboarding - Religion");
            this.f35461a.Y1(this.f35462b);
        }
    }

    public static final class b implements jc.b<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReligionMatchPreferenceInteractor f35463a;

        b(ReligionMatchPreferenceInteractor religionMatchPreferenceInteractor) {
            this.f35463a = religionMatchPreferenceInteractor;
        }

        public void b(CmbErrorCode cmbErrorCode) {
            this.f35463a.S1().onError(((k) this.f35463a.f7875e).j());
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            this.f35463a.V1().f();
            a.C0491a aVar = fa.a.f40771d;
            l T1 = this.f35463a.T1();
            aVar.a("MatchPrefs", "Next tap end - Religion - " + T1);
            this.f35463a.S1().onSuccess(ProfileConstants.Field.RELIGION);
        }
    }

    /* access modifiers changed from: private */
    public static final void O1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
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
    public static final void R1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void X1(List<Resource> list) {
        ((k) this.f7875e).m(new a(this, list));
    }

    /* access modifiers changed from: private */
    public final void Y1(List<Resource> list) {
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        modelProfileUpdateDelta.updateCriteriaReligion(CollectionsKt___CollectionsKt.W(list, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, ReligionMatchPreferenceInteractor$updateOnServer$1.f35465a, 30, (Object) null));
        V1().p(new b(this), modelProfileUpdateDelta, true);
    }

    public final k S1() {
        k kVar = this.f35457g;
        if (kVar != null) {
            return kVar;
        }
        j.y("dataListener");
        return null;
    }

    public final l T1() {
        l lVar = this.f35458h;
        if (lVar != null) {
            return lVar;
        }
        j.y("dataStream");
        return null;
    }

    public final c9.a U1() {
        c9.a aVar = this.f35460k;
        if (aVar != null) {
            return aVar;
        }
        j.y("getResourcesUseCase");
        return null;
    }

    public final ProfileManager V1() {
        ProfileManager profileManager = this.f35456f;
        if (profileManager != null) {
            return profileManager;
        }
        j.y("profileManager");
        return null;
    }

    public final d W1() {
        d dVar = this.f35459j;
        if (dVar != null) {
            return dVar;
        }
        j.y("tracker");
        return null;
    }

    /* access modifiers changed from: protected */
    public void y1() {
        List<String> list;
        super.y1();
        NetworkProfile j10 = V1().j();
        if (j10 != null) {
            list = j10.getCriteriaReligionAsApiParamsList();
        } else {
            list = null;
        }
        ((t) U1().a(ResourceType.RELIGION).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new f(new ReligionMatchPreferenceInteractor$didBecomeActive$1(this, list)), new g(ReligionMatchPreferenceInteractor$didBecomeActive$2.f35464a));
        ((p) ((k) this.f7875e).l().g(com.uber.autodispose.a.a(this))).c(new h(new ReligionMatchPreferenceInteractor$didBecomeActive$3(this)));
        a.C0491a aVar = fa.a.f40771d;
        boolean b10 = T1().b();
        aVar.a("MatchPrefs", "does save stream have any observers? " + b10);
        ((p) T1().a().g(com.uber.autodispose.a.a(this))).c(new i(new ReligionMatchPreferenceInteractor$didBecomeActive$4(this)));
    }
}
