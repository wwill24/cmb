package com.coffeemeetsbagel.shop.main;

import android.view.LayoutInflater;
import androidx.viewpager.widget.ViewPager;
import b6.d;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.view.CmbToolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import j5.t;
import j5.x;

class n extends p<MainShopComponentView> {

    /* renamed from: e  reason: collision with root package name */
    private final d f36457e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final b f36458f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TabLayout f36459g;

    /* renamed from: h  reason: collision with root package name */
    private ViewPager f36460h;

    /* renamed from: j  reason: collision with root package name */
    private CmbToolbar f36461j;

    class a implements ViewPager.j {
        a() {
        }

        public void S(int i10, float f10, int i11) {
        }

        public void m0(int i10) {
        }

        public void q(int i10) {
            TabLayout.g B = n.this.f36459g.B(i10);
            if (B != null) {
                B.m();
            }
            n.this.f36458f.q(i10);
        }
    }

    interface b {
        void q(int i10);
    }

    n(d dVar, MainShopComponentView mainShopComponentView, b bVar) {
        super(mainShopComponentView);
        this.f36457e = dVar;
        this.f36458f = bVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(x xVar) throws Exception {
        this.f36457e.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        CmbToolbar cmbToolbar = this.f36461j;
        if (cmbToolbar != null) {
            ((com.uber.autodispose.p) cmbToolbar.T().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new m(this));
        }
    }

    public void n(MainShopTabs mainShopTabs) {
        this.f36460h.setCurrentItem(mainShopTabs.ordinal());
    }

    /* access modifiers changed from: package-private */
    public void o(androidx.viewpager.widget.a aVar) {
        d dVar = this.f36457e;
        if (dVar instanceof t) {
            CmbToolbar P0 = ((t) dVar).P0();
            this.f36461j = P0;
            if (P0 != null) {
                P0.X();
                this.f36461j.setTitle(this.f36457e.getString(R.string.shop));
            }
        }
        ViewPager viewPager = (ViewPager) ((MainShopComponentView) g()).findViewById(R.id.shop_view_pager);
        this.f36460h = viewPager;
        viewPager.setAdapter(aVar);
        this.f36460h.c(new a());
        TabLayout tabLayout = (TabLayout) ((AppBarLayout) LayoutInflater.from(this.f36457e).inflate(R.layout.default_tab_layout_dls, ((t) this.f36457e).O0(), true)).findViewById(R.id.tab_layout);
        this.f36459g = tabLayout;
        tabLayout.setupWithViewPager(this.f36460h);
    }
}
