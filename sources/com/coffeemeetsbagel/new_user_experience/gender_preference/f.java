package com.coffeemeetsbagel.new_user_experience.gender_preference;

import b6.s;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.models.entities.GenderType;
import com.coffeemeetsbagel.new_user_experience.gender_preference.GenderPreferencePresenter;
import com.coffeemeetsbagel.transport.SuccessStatus;
import java.util.HashMap;
import kotlin.jvm.internal.j;
import na.b;

public final class f extends s<GenderPreferencePresenter, k> implements GenderPreferencePresenter.a {

    /* renamed from: f  reason: collision with root package name */
    public ProfileManager f35067f;

    /* renamed from: g  reason: collision with root package name */
    public b f35068g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public GenderType f35069h = GenderType.UNSPECIFIED;

    public static final class a implements jc.b<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f35070a;

        a(f fVar) {
            this.f35070a = fVar;
        }

        public void b(CmbErrorCode cmbErrorCode) {
            this.f35070a.J1().onError(((GenderPreferencePresenter) this.f35070a.f7875e).r());
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            this.f35070a.K1().f();
            HashMap hashMap = new HashMap();
            hashMap.put("selection", this.f35070a.f35069h.getApiKey());
            this.f35070a.J1().e(hashMap);
        }
    }

    public final b J1() {
        b bVar = this.f35068g;
        if (bVar != null) {
            return bVar;
        }
        j.y("interactionListener");
        return null;
    }

    public final ProfileManager K1() {
        ProfileManager profileManager = this.f35067f;
        if (profileManager != null) {
            return profileManager;
        }
        j.y("profileManager");
        return null;
    }

    public void d() {
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        modelProfileUpdateDelta.updateCriteriaGender(this.f35069h.getApiKey());
        K1().p(new a(this), modelProfileUpdateDelta, true);
    }

    public void f() {
        J1().d();
    }

    public void o(GenderType genderType) {
        j.g(genderType, ProfileConstants.Field.GENDER);
        this.f35069h = genderType;
        ((GenderPreferencePresenter) this.f7875e).q();
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        GenderType.Companion companion = GenderType.Companion;
        NetworkProfile j10 = K1().j();
        j.d(j10);
        ((GenderPreferencePresenter) this.f7875e).t(companion.fromApiKey(j10.getCriteriaGender()));
    }
}
