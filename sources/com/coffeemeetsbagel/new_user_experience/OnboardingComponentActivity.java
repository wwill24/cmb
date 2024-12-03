package com.coffeemeetsbagel.new_user_experience;

import android.os.Bundle;
import android.view.ViewGroup;
import b6.d;
import b6.g;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig;
import com.coffeemeetsbagel.new_user_experience.n;
import com.coffeemeetsbagel.util.RequestCode;
import gk.h;
import hb.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class OnboardingComponentActivity extends d<n, v> {

    /* renamed from: l  reason: collision with root package name */
    public static final a f34765l = new a((DefaultConstructorMarker) null);

    /* renamed from: j  reason: collision with root package name */
    public a7.a f34766j;

    /* renamed from: k  reason: collision with root package name */
    public c f34767k;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public String K0() {
        return "OnboardingComponentActivity";
    }

    /* access modifiers changed from: protected */
    /* renamed from: N0 */
    public n G0() {
        return new n();
    }

    /* access modifiers changed from: protected */
    /* renamed from: O0 */
    public v H0(ViewGroup viewGroup) {
        List list;
        j.g(viewGroup, "parentViewGroup");
        int[] intArrayExtra = getIntent().getIntArrayExtra("PAGES");
        if (intArrayExtra != null) {
            list = new ArrayList(intArrayExtra.length);
            for (int i10 : intArrayExtra) {
                list.add(OnboardingNavigationConfig.Pages.values()[i10]);
            }
        } else {
            list = q.j();
        }
        g A0 = ((n) this.f7848e).A0();
        j.f(A0, "dependencyFragment.component");
        return new h((n.a) A0).b(viewGroup, list);
    }

    public final a7.a P0() {
        a7.a aVar = this.f34766j;
        if (aVar != null) {
            return aVar;
        }
        j.y("analyticsManager");
        return null;
    }

    public final c Q0() {
        c cVar = this.f34767k;
        if (cVar != null) {
            return cVar;
        }
        j.y("sharedPreferences");
        return null;
    }

    public final void R0() {
        Q0().f("KEY_REQUESTED_PUSH_PERMISSION", true);
        requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, RequestCode.ONBOARDING_NOTIFICATION);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bakery.j().B1(this);
    }

    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        boolean z10;
        j.g(strArr, "permissions");
        j.g(iArr, "grantResults");
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 == 9308) {
            if (iArr.length == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!(!z10) || iArr[0] != 0) {
                P0().trackEvent("Onboarding Push Registered", g0.f(h.a("granted", "no")));
            } else {
                P0().trackEvent("Onboarding Push Registered", g0.f(h.a("granted", "yes")));
            }
            if (!((v) this.f7849f).q()) {
                ((v) this.f7849f).p();
            }
        }
    }
}
