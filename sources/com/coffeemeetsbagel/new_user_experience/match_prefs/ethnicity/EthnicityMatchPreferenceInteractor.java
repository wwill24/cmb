package com.coffeemeetsbagel.new_user_experience.match_prefs.ethnicity;

import b6.s;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.Resource;
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

public final class EthnicityMatchPreferenceInteractor extends s<k, l> {

    /* renamed from: f  reason: collision with root package name */
    public ProfileManager f35329f;

    /* renamed from: g  reason: collision with root package name */
    public k f35330g;

    /* renamed from: h  reason: collision with root package name */
    public l f35331h;

    /* renamed from: j  reason: collision with root package name */
    public d f35332j;

    /* renamed from: k  reason: collision with root package name */
    public c9.a f35333k;

    public static final class a implements o.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EthnicityMatchPreferenceInteractor f35334a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List<Resource> f35335b;

        a(EthnicityMatchPreferenceInteractor ethnicityMatchPreferenceInteractor, List<Resource> list) {
            this.f35334a = ethnicityMatchPreferenceInteractor;
            this.f35335b = list;
        }

        public void a() {
            this.f35334a.W1().d("Hardware Back Button Tapped", "Onboarding - Ethnicity");
        }

        public void b() {
            this.f35334a.W1().d("Edit Button Tapped", "Onboarding - Ethnicity");
        }

        public void c() {
            this.f35334a.W1().d("Continue Button Tapped", "Onboarding - Ethnicity");
            this.f35334a.Y1(this.f35335b);
        }
    }

    public static final class b implements jc.b<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EthnicityMatchPreferenceInteractor f35336a;

        b(EthnicityMatchPreferenceInteractor ethnicityMatchPreferenceInteractor) {
            this.f35336a = ethnicityMatchPreferenceInteractor;
        }

        public void b(CmbErrorCode cmbErrorCode) {
            this.f35336a.S1().onError(((k) this.f35336a.f7875e).l());
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            this.f35336a.V1().f();
            fa.a.f40771d.a("MatchPrefs", "Next tap end - Ethnicity");
            this.f35336a.S1().onSuccess("ethnicity");
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
        modelProfileUpdateDelta.updateCriteriaEthnicity(CollectionsKt___CollectionsKt.W(list, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, EthnicityMatchPreferenceInteractor$updateOnServer$1.f35338a, 30, (Object) null));
        V1().p(new b(this), modelProfileUpdateDelta, true);
    }

    public final k S1() {
        k kVar = this.f35330g;
        if (kVar != null) {
            return kVar;
        }
        j.y("dataListener");
        return null;
    }

    public final l T1() {
        l lVar = this.f35331h;
        if (lVar != null) {
            return lVar;
        }
        j.y("dataStream");
        return null;
    }

    public final c9.a U1() {
        c9.a aVar = this.f35333k;
        if (aVar != null) {
            return aVar;
        }
        j.y("getResourcesUseCase");
        return null;
    }

    public final ProfileManager V1() {
        ProfileManager profileManager = this.f35329f;
        if (profileManager != null) {
            return profileManager;
        }
        j.y("profileManager");
        return null;
    }

    public final d W1() {
        d dVar = this.f35332j;
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
            list = j10.getCriteriaEthnicityAsApiParamsList();
        } else {
            list = null;
        }
        ((t) U1().a(ResourceType.ETHNICITY).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new f(new EthnicityMatchPreferenceInteractor$didBecomeActive$1(this, list)), new g(EthnicityMatchPreferenceInteractor$didBecomeActive$2.f35337a));
        ((p) ((k) this.f7875e).k().g(com.uber.autodispose.a.a(this))).c(new h(new EthnicityMatchPreferenceInteractor$didBecomeActive$3(this)));
        a.C0491a aVar = fa.a.f40771d;
        boolean b10 = T1().b();
        aVar.a("MatchPrefs - Ethnicity", "does save stream have any observers? " + b10);
        ((p) T1().a().g(com.uber.autodispose.a.a(this))).c(new i(new EthnicityMatchPreferenceInteractor$didBecomeActive$4(this)));
    }
}
