package com.coffeemeetsbagel.hidereport.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import b6.d;
import b6.g;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffemeetsbagel.hide_report.h;
import com.coffemeetsbagel.hide_report.i;
import com.coffemeetsbagel.hide_report.w;
import com.google.firebase.ktx.BuildConfig;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import u9.e;

public final class HideReportComponentActivity extends d<e, w> {

    /* renamed from: j  reason: collision with root package name */
    public static final a f13953j = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Activity activity, String str, String str2, boolean z10, boolean z11, String str3, String str4) {
            j.g(activity, IdentityHttpResponse.CONTEXT);
            j.g(str, "profileId");
            j.g(str3, "source");
            j.g(str4, "matchType");
            Bundle bundle = new Bundle();
            bundle.putString(Extra.PROFILE_ID, str);
            bundle.putString(Extra.BAGEL_ID, str2);
            bundle.putBoolean(Extra.IS_CONNECTED, z11);
            bundle.putBoolean(Extra.IS_HIDE, z10);
            bundle.putString(Extra.MATCH_TYPE, str4);
            bundle.putString("source", str3);
            activity.startActivityForResult(new Intent(activity, HideReportComponentActivity.class).putExtras(bundle), 9304);
        }
    }

    /* access modifiers changed from: protected */
    public String K0() {
        return "HideReportComponentActivity";
    }

    /* access modifiers changed from: protected */
    /* renamed from: N0 */
    public e G0() {
        return new e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: O0 */
    public w H0(ViewGroup viewGroup) {
        String str;
        String str2;
        String str3;
        j.g(viewGroup, "parentViewGroup");
        Bundle extras = getIntent().getExtras();
        j.d(extras);
        boolean z10 = extras.getBoolean(Extra.IS_CONNECTED, false);
        Bundle extras2 = getIntent().getExtras();
        j.d(extras2);
        boolean z11 = extras2.getBoolean(Extra.IS_HIDE, false);
        Bundle extras3 = getIntent().getExtras();
        String str4 = null;
        if (extras3 != null) {
            str = extras3.getString(Extra.BAGEL_ID, (String) null);
        } else {
            str = null;
        }
        Bundle extras4 = getIntent().getExtras();
        if (extras4 != null) {
            str2 = extras4.getString(Extra.PROFILE_ID, (String) null);
        } else {
            str2 = null;
        }
        Bundle extras5 = getIntent().getExtras();
        if (extras5 != null) {
            str3 = extras5.getString("source");
        } else {
            str3 = null;
        }
        String str5 = str3 == null ? BuildConfig.VERSION_NAME : str3;
        Bundle extras6 = getIntent().getExtras();
        if (extras6 != null) {
            str4 = extras6.getString(Extra.MATCH_TYPE);
        }
        String str6 = str4 == null ? BuildConfig.VERSION_NAME : str4;
        g A0 = ((e) this.f7848e).A0();
        j.f(A0, "dependencyFragment.component");
        return new i((h) A0).b(viewGroup, z11, z10, str, str2, str5, str6);
    }
}
