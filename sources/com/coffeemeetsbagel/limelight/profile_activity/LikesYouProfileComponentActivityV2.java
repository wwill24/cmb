package com.coffeemeetsbagel.limelight.profile_activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import b6.g;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.limelight.profile_activity.j;
import com.mparticle.identity.IdentityHttpResponse;
import fa.a;
import j5.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.j;
import tk.d;
import wk.l;

public final class LikesYouProfileComponentActivityV2 extends t<q0, q> {

    /* renamed from: q  reason: collision with root package name */
    public static final a f34419q = new a((DefaultConstructorMarker) null);

    /* renamed from: t  reason: collision with root package name */
    static final /* synthetic */ l<Object>[] f34420t = {kotlin.jvm.internal.l.d(new MutablePropertyReference1Impl(LikesYouProfileComponentActivityV2.class, "selectedMatchId", "getSelectedMatchId()Ljava/lang/String;", 0))};

    /* renamed from: m  reason: collision with root package name */
    private String f34421m;

    /* renamed from: n  reason: collision with root package name */
    private final d f34422n = tk.a.f33872a.a();

    /* renamed from: p  reason: collision with root package name */
    private String f34423p;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, String str, String str2, String str3) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            j.g(str, "screenSource");
            j.g(str2, "groupId");
            j.g(str3, "selectedMatchId");
            Intent intent = new Intent(context, LikesYouProfileComponentActivityV2.class);
            Bundle bundle = new Bundle();
            bundle.putString("ARG_SCREEN_SOURCE", str);
            bundle.putString("ARG_GROUP_ID", str2);
            bundle.putString("ARG_SELECTED_MATCH_ID", str3);
            intent.putExtras(bundle);
            return intent;
        }
    }

    private final String U0() {
        return (String) this.f34422n.getValue(this, f34420t[0]);
    }

    private final void V0(String str) {
        this.f34422n.setValue(this, f34420t[0], str);
    }

    /* access modifiers changed from: protected */
    public String K0() {
        return "LikesYouProfileComponentActivity";
    }

    /* access modifiers changed from: protected */
    public int Q0() {
        return R.string.limelight;
    }

    /* access modifiers changed from: protected */
    /* renamed from: S0 */
    public q0 G0() {
        return new q0();
    }

    /* access modifiers changed from: protected */
    /* renamed from: T0 */
    public q H0(ViewGroup viewGroup) {
        j.g(viewGroup, "parentViewGroup");
        g A0 = ((q0) this.f7848e).A0();
        j.f(A0, "dependencyFragment.component");
        j jVar = new j((j.b) A0);
        String str = this.f34423p;
        String str2 = null;
        if (str == null) {
            kotlin.jvm.internal.j.y("screenSource");
            str = null;
        }
        String str3 = this.f34421m;
        if (str3 == null) {
            kotlin.jvm.internal.j.y("groupId");
        } else {
            str2 = str3;
        }
        return jVar.b(str, str2, U0());
    }

    public void onCreate(Bundle bundle) {
        boolean z10;
        super.onCreate(bundle);
        if (bundle != null) {
            String string = bundle.getString("ARG_GROUP_ID", "");
            kotlin.jvm.internal.j.f(string, "savedInstanceState.getString(ARG_GROUP_ID, \"\")");
            this.f34421m = string;
            String string2 = bundle.getString("ARG_SELECTED_MATCH_ID", "");
            kotlin.jvm.internal.j.f(string2, "savedInstanceState.getSt…RG_SELECTED_MATCH_ID, \"\")");
            V0(string2);
            String string3 = bundle.getString("ARG_SCREEN_SOURCE", "");
            kotlin.jvm.internal.j.f(string3, "savedInstanceState.getSt…ng(ARG_SCREEN_SOURCE, \"\")");
            this.f34423p = string3;
        } else {
            String stringExtra = getIntent().getStringExtra("ARG_GROUP_ID");
            kotlin.jvm.internal.j.d(stringExtra);
            this.f34421m = stringExtra;
            String stringExtra2 = getIntent().getStringExtra("ARG_SELECTED_MATCH_ID");
            kotlin.jvm.internal.j.d(stringExtra2);
            V0(stringExtra2);
            String stringExtra3 = getIntent().getStringExtra("ARG_SCREEN_SOURCE");
            kotlin.jvm.internal.j.d(stringExtra3);
            this.f34423p = stringExtra3;
        }
        String str = this.f34421m;
        String str2 = null;
        if (str == null) {
            kotlin.jvm.internal.j.y("groupId");
            str = null;
        }
        boolean z11 = true;
        if (str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            if (U0().length() != 0) {
                z11 = false;
            }
            if (!z11) {
                return;
            }
        }
        a.C0491a aVar = fa.a.f40771d;
        String K0 = K0();
        String str3 = this.f34421m;
        if (str3 == null) {
            kotlin.jvm.internal.j.y("groupId");
        } else {
            str2 = str3;
        }
        aVar.c(K0, "Map: " + str2 + ", id: " + U0(), new Throwable("Missing match display data."));
        setResult(70);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        kotlin.jvm.internal.j.g(bundle, "outState");
        String str = this.f34421m;
        if (str == null) {
            kotlin.jvm.internal.j.y("groupId");
            str = null;
        }
        bundle.putString("ARG_GROUP_ID", str);
        bundle.putString("ARG_SELECTED_MATCH_ID", U0());
        super.onSaveInstanceState(bundle);
    }
}
