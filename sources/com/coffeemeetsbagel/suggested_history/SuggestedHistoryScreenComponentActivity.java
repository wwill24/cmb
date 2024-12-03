package com.coffeemeetsbagel.suggested_history;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import b6.g;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.suggested_history.p;
import com.mparticle.identity.IdentityHttpResponse;
import j5.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class SuggestedHistoryScreenComponentActivity extends t<p, o> {

    /* renamed from: m  reason: collision with root package name */
    public static final a f37109m = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            context.startActivity(new Intent(context, SuggestedHistoryScreenComponentActivity.class));
        }
    }

    /* access modifiers changed from: protected */
    public String K0() {
        return "SuggestedHistoryScreenComponentActivity";
    }

    /* access modifiers changed from: protected */
    public int Q0() {
        return R.string.suggested_my_history;
    }

    /* access modifiers changed from: protected */
    /* renamed from: S0 */
    public p G0() {
        return new p();
    }

    /* access modifiers changed from: protected */
    /* renamed from: T0 */
    public o H0(ViewGroup viewGroup) {
        j.g(viewGroup, "parentViewGroup");
        g A0 = ((p) this.f7848e).A0();
        j.f(A0, "dependencyFragment.component");
        return new k((p.a) A0).b(viewGroup);
    }
}
