package com.coffeemeetsbagel.bagel_profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.browser.customtabs.d;
import b6.u;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.ActivitySettings;
import com.coffeemeetsbagel.bagel_profile.g;
import com.coffeemeetsbagel.bagel_profile.main.i;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmb_views.CmbLinearLayout;
import com.coffeemeetsbagel.external_links.CmbLinks;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.preferences.MatchPreferencesComponentActivity;
import com.coffeemeetsbagel.products.overflow_menu.OverFlowMenuAnalytics;
import com.coffeemeetsbagel.util.RequestCode;
import com.uber.autodispose.p;
import j5.t;
import j5.x;
import java.util.ArrayList;
import java.util.List;
import s8.c;
import s8.d;

public class BagelProfileComponentActivity extends t<g, u> {

    /* renamed from: m  reason: collision with root package name */
    OverFlowMenuAnalytics f10991m;

    /* renamed from: n  reason: collision with root package name */
    com.coffeemeetsbagel.experiment.t f10992n;

    /* renamed from: p  reason: collision with root package name */
    ProfileManager f10993p;

    /* renamed from: q  reason: collision with root package name */
    private CmbLinearLayout f10994q;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public c f10995t;

    class a implements c.a {
        a() {
        }

        public void a() {
            BagelProfileComponentActivity.this.h1();
            lc.c.h(BagelProfileComponentActivity.this.f10995t);
        }

        public void b() {
            BagelProfileComponentActivity.this.g1();
            lc.c.h(BagelProfileComponentActivity.this.f10995t);
        }

        public void c() {
            BagelProfileComponentActivity.this.j1();
            lc.c.h(BagelProfileComponentActivity.this.f10995t);
        }

        public void d() {
            BagelProfileComponentActivity.this.i1();
            lc.c.h(BagelProfileComponentActivity.this.f10995t);
        }
    }

    private List<d> f1(c.a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d(R.drawable.ic_tune, getString(R.string.suggested_preferences), new b(this, aVar), 0));
        arrayList.add(new d(R.drawable.tips, getString(R.string.profile_tips), new c(this, aVar), 0));
        arrayList.add(new d(R.drawable.ic_help, getString(R.string.help_support), new d(this, aVar), 0));
        arrayList.add(new d(R.drawable.settings, getString(R.string.settings), new e(aVar), 0));
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void g1() {
        new d.a().a().a(this, Uri.parse(getString(R.string.zendesk_url)));
    }

    /* access modifiers changed from: private */
    public void h1() {
        lc.a.c(this, new Intent(this, MatchPreferencesComponentActivity.class));
    }

    /* access modifiers changed from: private */
    public void i1() {
        lc.a.d(this, new Intent(this, ActivitySettings.class), RequestCode.APP_SETTINGS);
        lc.c.h(this.f10995t);
    }

    /* access modifiers changed from: private */
    public void j1() {
        CmbLinks.Companion.launchTips(this);
        lc.c.h(this.f10995t);
    }

    private boolean k1(Intent intent) {
        if (intent == null || intent.getData() == null || !intent.getData().getScheme().equals(ModelDeeplinkData.CMB_AUTHORITY) || !intent.getData().getHost().equals("me") || intent.getData().getPathSegments().size() <= 0 || !intent.getData().getLastPathSegment().equals("profile")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l1(c.a aVar, View view) {
        aVar.a();
        this.f10991m.a("Match Preferences", OverFlowMenuAnalytics.Location.PROFILE);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m1(c.a aVar, View view) {
        aVar.c();
        this.f10991m.a("Tips", OverFlowMenuAnalytics.Location.PROFILE);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n1(c.a aVar, View view) {
        aVar.b();
        this.f10991m.a("Help & Support", OverFlowMenuAnalytics.Location.PROFILE);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p1(c.a aVar, x xVar) throws Exception {
        Intent intent = getIntent();
        if (intent == null || !intent.getBooleanExtra(Extra.IS_FROM_NUX, false)) {
            c cVar = new c(this, f1(aVar));
            this.f10995t = cVar;
            cVar.show();
            return;
        }
        setResult(-1);
        finish();
    }

    private void q1() {
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra(Extra.IS_FROM_NUX, false)) {
            this.f15624j.J();
            this.f15624j.X();
            CmbLinearLayout cmbLinearLayout = (CmbLinearLayout) getLayoutInflater().inflate(R.layout.done_menu_item, this.f15624j, false);
            this.f10994q = cmbLinearLayout;
            this.f15624j.C(cmbLinearLayout);
        } else if (!this.f10992n.x()) {
            this.f15624j.J();
            this.f15624j.X();
            CmbLinearLayout cmbLinearLayout2 = (CmbLinearLayout) getLayoutInflater().inflate(R.layout.overflow_menu_item, this.f15624j, false);
            this.f10994q = cmbLinearLayout2;
            this.f15624j.C(cmbLinearLayout2);
        }
    }

    /* access modifiers changed from: protected */
    public String K0() {
        return "";
    }

    /* access modifiers changed from: protected */
    public int Q0() {
        return R.string.profile;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d1 */
    public g G0() {
        return new g();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e1 */
    public u H0(ViewGroup viewGroup) {
        boolean z10;
        String str;
        g.a aVar = (g.a) ((g) this.f7848e).A0();
        String stringExtra = getIntent().getStringExtra("source");
        String stringExtra2 = getIntent().getStringExtra(Extra.MATCH_TYPE);
        Intent intent = getIntent();
        Bagel bagel = (Bagel) intent.getSerializableExtra(Extra.BAGEL);
        NetworkProfile networkProfile = (NetworkProfile) intent.getSerializableExtra("profile");
        boolean booleanExtra = intent.getBooleanExtra(Extra.IS_FROM_NUX, false);
        if (bagel == null || !bagel.isActedUpon()) {
            z10 = false;
        } else {
            z10 = true;
        }
        boolean booleanExtra2 = intent.getBooleanExtra(Extra.HAS_BEEN_ACTED_ON, z10);
        boolean booleanExtra3 = intent.getBooleanExtra(Extra.IS_RISING_GIVE_TAKE, false);
        if (bagel != null) {
            str = bagel.getProfileId();
        } else if (networkProfile != null) {
            str = networkProfile.getId();
        } else if (booleanExtra || k1(intent)) {
            str = this.f10993p.j().getId();
        } else {
            throw new IllegalStateException("Neither bagel or profile was provided");
        }
        this.f7849f = new com.coffeemeetsbagel.bagel_profile.main.d(aVar).b(viewGroup, false, bagel, str, booleanExtra, stringExtra, booleanExtra2, stringExtra2, booleanExtra3);
        if (str.equals(this.f10993p.j().getId())) {
            q1();
        }
        return (u) this.f7849f;
    }

    public void onBackPressed() {
        ((i) this.f7849f).n();
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        Bakery.j().R1(this);
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        if (this.f10994q != null) {
            ((p) this.f10994q.a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new a(this, new a()));
        }
    }

    public boolean shouldUpRecreateTask(Intent intent) {
        return k1(getIntent());
    }
}
