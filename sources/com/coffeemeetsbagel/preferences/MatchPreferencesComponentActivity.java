package com.coffeemeetsbagel.preferences;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.m;
import b6.d;
import b6.g;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.match_prefs.dealbreaker.DealBreakerSheetFragment;
import com.coffeemeetsbagel.preferences.h;
import com.coffeemeetsbagel.util.RequestCode;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.s1;

public final class MatchPreferencesComponentActivity extends d<h, MatchPrefsContainerRouter> {

    /* renamed from: j  reason: collision with root package name */
    public static final a f35786j = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            return new Intent(context, MatchPreferencesComponentActivity.class);
        }

        public final void b(Activity activity) {
            j.g(activity, IdentityHttpResponse.CONTEXT);
            activity.startActivityForResult(a(activity), RequestCode.MATCH_PREFERENCES);
        }
    }

    /* access modifiers changed from: protected */
    public String K0() {
        return "MatchPreferences";
    }

    /* access modifiers changed from: protected */
    /* renamed from: N0 */
    public h G0() {
        return new h();
    }

    /* access modifiers changed from: protected */
    /* renamed from: O0 */
    public MatchPrefsContainerRouter H0(ViewGroup viewGroup) {
        j.g(viewGroup, "parentViewGroup");
        g A0 = ((h) this.f7848e).A0();
        j.f(A0, "dependencyFragment.component");
        return new l((h.a) A0).b(viewGroup);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DealBreakerSheetFragment dealBreakerSheetFragment = new DealBreakerSheetFragment();
        Bakery.j().P1(dealBreakerSheetFragment);
        s1 unused = j.d(m.a(this), (CoroutineContext) null, (CoroutineStart) null, new MatchPreferencesComponentActivity$onCreate$1(dealBreakerSheetFragment, this, (c<? super MatchPreferencesComponentActivity$onCreate$1>) null), 3, (Object) null);
    }
}
