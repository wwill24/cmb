package s6;

import android.view.ViewGroup;
import b6.u;
import com.coffeemeetsbagel.discover_feed.list.DiscoverFeedListView;
import com.coffeemeetsbagel.discover_feed.main.DiscoverFeedMainView;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellComponentActivity;
import com.coffeemeetsbagel.upsell_banner.g;
import com.coffeemeetsbagel.upsell_banner.i;
import com.coffeemeetsbagel.upsell_banner.n;
import kc.a;
import p6.d;
import q6.d;
import q6.l;
import r6.e;
import r6.g0;
import s6.d;

public class p extends u<DiscoverFeedMainView, d.a, m> {

    /* renamed from: f  reason: collision with root package name */
    private final ViewGroup f17513f;

    /* renamed from: g  reason: collision with root package name */
    private u f17514g;

    /* renamed from: h  reason: collision with root package name */
    private l f17515h;

    /* renamed from: i  reason: collision with root package name */
    private v7.d f17516i;

    /* renamed from: j  reason: collision with root package name */
    private n f17517j = null;

    public p(DiscoverFeedMainView discoverFeedMainView, d.a aVar, m mVar, ViewGroup viewGroup) {
        super(discoverFeedMainView, aVar, mVar);
        this.f17516i = aVar.G();
        this.f17513f = viewGroup;
    }

    private void r() {
        if (this.f17515h != null) {
            ((DiscoverFeedMainView) l()).removeView(this.f17515h.l());
            b(this.f17515h);
        }
        if (this.f17514g != null) {
            ((DiscoverFeedMainView) l()).removeView(this.f17514g.l());
            b(this.f17514g);
        }
        this.f17515h = null;
        this.f17514g = null;
    }

    private void s(boolean z10) {
        if (this.f17515h != null && z10) {
            ((DiscoverFeedMainView) l()).addView(this.f17515h.l());
            a(this.f17515h);
        }
        if (this.f17514g != null) {
            ((DiscoverFeedMainView) l()).addView(this.f17514g.l());
            a(this.f17514g);
        }
    }

    /* access modifiers changed from: protected */
    public void k() {
        super.k();
        r();
    }

    public void m(boolean z10, String str, String str2, i.a aVar) {
        if (this.f17517j == null) {
            n b10 = new g((g.c) e()).b((ViewGroup) l(), (a) null, aVar, z10, str, str2, "Give & Take");
            this.f17517j = b10;
            a(b10);
            ((DiscoverFeedMainView) l()).a(this.f17517j.l());
        }
    }

    public void n() {
        if (this.f17517j != null) {
            ((DiscoverFeedMainView) l()).b(this.f17517j.l());
            b(this.f17517j);
            this.f17517j = null;
        }
    }

    public void o(PurchaseSource purchaseSource) {
        PremiumUpsellComponentActivity.f36846j.b(((d.a) e()).a(), purchaseSource);
    }

    public boolean p() {
        return this.f17515h != null;
    }

    public void q() {
        w();
        u uVar = this.f17514g;
        if (uVar instanceof g0) {
            ((r6.u) uVar.f()).A2();
        }
    }

    public void t() {
        r();
        this.f17514g = new p6.d((d.c) e()).b(this.f17513f);
        this.f17515h = new q6.d((d.c) e()).b(this.f17513f);
        s(!this.f17516i.c());
    }

    public void u() {
        boolean z10 = false;
        for (int i10 = 0; i10 < ((DiscoverFeedMainView) l()).getChildCount(); i10++) {
            if (((DiscoverFeedMainView) l()).getChildAt(i10) instanceof DiscoverFeedListView) {
                z10 = true;
            }
        }
        if (!z10) {
            r();
            this.f17514g = new e((e.c) e()).b(this.f17513f);
            this.f17515h = new q6.d((d.c) e()).b(this.f17513f);
            s(true);
        }
    }

    public void v() {
        l lVar = this.f17515h;
        if (lVar != null) {
            lVar.m();
        }
    }

    public void w() {
        l lVar = this.f17515h;
        if (lVar != null) {
            lVar.n();
        }
    }
}
