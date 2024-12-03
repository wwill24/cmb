package com.coffeemeetsbagel.feature.discover.search;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmb_views.CmbLinearLayout;
import com.coffeemeetsbagel.dialogs.b;
import com.coffeemeetsbagel.dialogs.e;
import com.coffeemeetsbagel.dialogs.f0;
import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.models.enums.ResourceType;
import com.coffeemeetsbagel.preferences.MatchPreferencesComponentActivity;
import com.coffeemeetsbagel.view.CmbToolbar;
import com.uber.autodispose.p;
import com.uber.autodispose.t;
import j5.h;
import j5.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import v7.c;
import w7.d;
import w7.f;
import w7.g;
import w7.i;
import w7.j;
import w7.k;
import w7.q;

public class DiscoverFilterActivity extends h implements c {
    private f0 B;
    private f0 C;
    private CmbLinearLayout D;
    private CmbLinearLayout E;
    HashMap<String, String> F;
    c9.a G;

    /* renamed from: w  reason: collision with root package name */
    FrameLayout f12999w;

    /* renamed from: x  reason: collision with root package name */
    q f13000x;

    /* renamed from: y  reason: collision with root package name */
    Dialog f13001y;

    /* renamed from: z  reason: collision with root package name */
    private v7.b f13002z;

    class a implements b.C0132b<e> {
        a() {
        }

        /* renamed from: c */
        public void a(e eVar) {
        }

        /* renamed from: d */
        public void b(e eVar) {
        }
    }

    class b implements b.C0132b<e> {
        b() {
        }

        /* renamed from: c */
        public void a(e eVar) {
        }

        /* renamed from: d */
        public void b(e eVar) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J1(List list) throws Exception {
        this.f13000x = new q(this, d1().j().isHeightUnitMetric(), W0().b(), this.f13002z, list);
        this.f13002z.start();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K1(x xVar) throws Exception {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L1(x xVar) throws Exception {
        this.f13002z.L();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M1(x xVar) throws Exception {
        this.f13002z.H();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List N1(List list) throws Exception {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((e) it.next()).a());
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O1(List list) throws Exception {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (this.F.containsKey(str)) {
                arrayList.add(this.F.get(str));
            }
        }
        lc.c.h(this.B);
        this.f13002z.y(arrayList);
        this.f13000x.u();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List P1(List list) throws Exception {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((e) it.next()).b());
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q1(List list) throws Exception {
        lc.c.h(this.C);
        this.f13002z.J(list);
        this.f13000x.w();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R1(List list, List list2, List list3) throws Exception {
        ArrayList arrayList = new ArrayList(list3.size());
        Iterator it = list3.iterator();
        while (it.hasNext()) {
            Resource resource = (Resource) it.next();
            e eVar = new e(resource.getValue(), (String) null);
            if (list.contains(resource.getKey())) {
                list2.add(eVar);
            }
            arrayList.add(eVar);
            this.F.put(resource.getValue(), resource.getKey());
        }
        f0 f0Var = new f0(this, getString(R.string.label_degree), (String) null, getString(R.string.done_dls), new a(), arrayList);
        this.B = f0Var;
        f0Var.k(list2);
        T1();
        this.B.show();
    }

    private void S1() {
        CmbToolbar cmbToolbar = this.f15597h;
        if (cmbToolbar != null) {
            cmbToolbar.setTitle(getString(R.string.discover_search_title));
            this.f15597h.X();
            CmbLinearLayout cmbLinearLayout = (CmbLinearLayout) getLayoutInflater().inflate(R.layout.discover_search_reset_menu_item, this.f15597h, false);
            this.E = cmbLinearLayout;
            this.f15597h.C(cmbLinearLayout);
            CmbLinearLayout cmbLinearLayout2 = (CmbLinearLayout) getLayoutInflater().inflate(R.layout.done_menu_item, this.f15597h, false);
            this.D = cmbLinearLayout2;
            this.f15597h.C(cmbLinearLayout2);
        }
    }

    private void T1() {
        ((p) this.B.i().W(new g()).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new w7.h(this));
    }

    private void U1() {
        ((p) this.C.i().W(new w7.e()).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new f(this));
    }

    public void A(int i10) {
        setResult(i10);
        finish();
    }

    /* access modifiers changed from: protected */
    public Fragment O0() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String Z0() {
        return null;
    }

    public void a0(j jVar, boolean z10) {
        this.f12999w.removeAllViews();
        this.f12999w.addView(this.f13000x);
        this.f13000x.s(jVar, z10);
    }

    public void b() {
        startActivity(MatchPreferencesComponentActivity.f35786j.a(this));
    }

    public int b1() {
        return R.layout.activity_blank_frame_with_toolbar;
    }

    public void exit() {
        finish();
    }

    public void j() {
        r7.h hVar = new r7.h(this);
        this.f13001y = hVar;
        hVar.show();
    }

    public void k() {
        lc.c.h(this.f13001y);
    }

    public void l(int i10) {
        sb.a.g(getWindow().getDecorView().findViewById(16908290), i10);
    }

    public void onCreate(Bundle bundle) {
        Bakery.j().D1(this);
        super.onCreate(bundle);
        this.f12999w = (FrameLayout) findViewById(R.id.frame_container);
        this.F = new HashMap<>();
        this.f13002z = new k(W0(), P0(), this);
        ((t) this.G.a(ResourceType.DISCOVER_DEGREES).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new w7.a(this));
        S1();
    }

    public void onDestroy() {
        lc.c.h(this.f13001y);
        this.f13002z.stop();
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        CmbToolbar cmbToolbar = this.f15597h;
        if (cmbToolbar != null) {
            ((p) cmbToolbar.T().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new w7.b(this));
            ((p) this.E.a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new w7.c(this));
            ((p) this.D.a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new d(this));
        }
        if (this.B != null) {
            T1();
        }
        if (this.C != null) {
            U1();
        }
    }

    public void w() {
        List list;
        j b10 = W0().b();
        if (b10.d() == null) {
            list = new ArrayList();
        } else {
            list = b10.d();
        }
        ((t) this.G.a(ResourceType.DISCOVER_DEGREES).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new i(this, list, new ArrayList(list.size())));
    }

    public boolean x1() {
        return false;
    }

    public void z() {
        List list;
        String[] stringArray = getResources().getStringArray(R.array.ethnicity);
        String[] stringArray2 = getResources().getStringArray(R.array.ethnicity_api);
        j b10 = W0().b();
        if (b10.e() == null) {
            list = new ArrayList();
        } else {
            list = b10.e();
        }
        ArrayList arrayList = new ArrayList(stringArray.length);
        ArrayList arrayList2 = new ArrayList(list.size());
        for (int i10 = 0; i10 < stringArray.length; i10++) {
            String str = stringArray[i10];
            String str2 = stringArray2[i10];
            e eVar = new e(str, str2);
            if (list.contains(str2)) {
                arrayList2.add(eVar);
            }
            arrayList.add(eVar);
        }
        f0 f0Var = new f0(this, getString(R.string.advanced_preferences_dialog_ethnicity_title), (String) null, getString(R.string.done_dls), new b(), arrayList);
        this.C = f0Var;
        f0Var.k(arrayList2);
        U1();
        this.C.show();
    }
}
