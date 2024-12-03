package com.coffeemeetsbagel.phone_login;

import android.os.Bundle;
import androidx.appcompat.app.c;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.b0;
import androidx.lifecycle.i0;
import androidx.lifecycle.l0;
import androidx.lifecycle.u;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.phone_login.PhoneCodeViewModel;
import com.facebook.internal.AnalyticsEvents;
import fa.a;
import java.util.HashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.mam.element.MamElements;

public final class PhoneCodeActivity extends c {

    /* renamed from: c  reason: collision with root package name */
    public b f35645c;

    /* renamed from: d  reason: collision with root package name */
    public ProfileManager f35646d;

    /* renamed from: e  reason: collision with root package name */
    public a7.a f35647e;

    /* renamed from: f  reason: collision with root package name */
    public PhoneCodeViewModel f35648f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final String f35649g = "PhoneCodeActivity";

    static final class a implements u, f {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f35650a;

        a(Function1 function1) {
            j.g(function1, "function");
            this.f35650a = function1;
        }

        public final gk.c<?> a() {
            return this.f35650a;
        }

        public final /* synthetic */ void b(Object obj) {
            this.f35650a.invoke(obj);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof u) || !(obj instanceof f)) {
                return false;
            }
            return j.b(a(), ((f) obj).a());
        }

        public final int hashCode() {
            return a().hashCode();
        }
    }

    private final void I0() {
        fa.a.f40771d.a(this.f35649g, "observeUiState()");
        G0().t().i(this, new a(new PhoneCodeActivity$observeUiState$1(this)));
    }

    /* access modifiers changed from: private */
    public final void K0(Fragment fragment) {
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f35649g;
        aVar.a(str, "showFragment: " + fragment);
        b0 p10 = getSupportFragmentManager().p();
        j.f(p10, "supportFragmentManager.beginTransaction()");
        p10.s(R.id.phone_number_content, fragment);
        p10.g((String) null);
        p10.i();
    }

    private final void L0() {
        fa.a.f40771d.a(this.f35649g, "trackSignUpFlowEvent()");
        HashMap hashMap = new HashMap();
        hashMap.put("provider", "phone");
        if (G0().l() || G0().k()) {
            hashMap.put("assurance shown", "phone");
            if (G0().k()) {
                hashMap.put(MamElements.MamResultExtension.ELEMENT, StreamManagement.Failed.ELEMENT);
            }
        }
        if (G0().m()) {
            hashMap.put("state", "granted");
        } else if (isFinishing()) {
            hashMap.put("state", AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED);
        }
        hashMap.put("login attempts", String.valueOf(G0().o()));
        E0().trackEvent("Sign-up flow", hashMap);
    }

    public final a7.a E0() {
        a7.a aVar = this.f35647e;
        if (aVar != null) {
            return aVar;
        }
        j.y("analyticsManager");
        return null;
    }

    public final ProfileManager F0() {
        ProfileManager profileManager = this.f35646d;
        if (profileManager != null) {
            return profileManager;
        }
        j.y("profileManager");
        return null;
    }

    public final PhoneCodeViewModel G0() {
        PhoneCodeViewModel phoneCodeViewModel = this.f35648f;
        if (phoneCodeViewModel != null) {
            return phoneCodeViewModel;
        }
        j.y("viewModel");
        return null;
    }

    public final b H0() {
        b bVar = this.f35645c;
        if (bVar != null) {
            return bVar;
        }
        j.y("viewModelFactory");
        return null;
    }

    public final void J0(PhoneCodeViewModel phoneCodeViewModel) {
        j.g(phoneCodeViewModel, "<set-?>");
        this.f35648f = phoneCodeViewModel;
    }

    public void onBackPressed() {
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f35649g;
        PhoneCodeViewModel.ViewState f10 = G0().t().f();
        aVar.a(str, "onBackPressed: viewState=" + f10);
        PhoneCodeViewModel.ViewState f11 = G0().t().f();
        PhoneCodeViewModel.ViewState viewState = PhoneCodeViewModel.ViewState.PHONE;
        if (f11 == viewState) {
            finish();
        } else {
            G0().C(viewState);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bakery.j().u1(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_phone_code);
        fa.a.f40771d.a(this.f35649g, "onCreate");
        J0((PhoneCodeViewModel) new i0((l0) this, (i0.b) H0()).a(PhoneCodeViewModel.class));
        I0();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        fa.a.f40771d.a(this.f35649g, "onStop()");
        super.onStop();
        L0();
    }
}
