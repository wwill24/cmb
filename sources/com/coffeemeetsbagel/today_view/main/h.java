package com.coffeemeetsbagel.today_view.main;

import android.view.ViewGroup;
import b6.u;
import com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellComponentActivity;
import com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.SuggestedUnsubPaywallInteractor;
import com.coffeemeetsbagel.today_view.main.b;
import com.coffeemeetsbagel.today_view.today_bagel.e;
import com.coffeemeetsbagel.today_view.today_bagel.n0;
import ec.d;
import ec.i;
import ic.m;
import ic.n;
import ic.o;
import java.util.Objects;
import qj.q;
import ua.a;

public class h extends u<TodayViewMainView, b.C0468b, e> {

    /* renamed from: f  reason: collision with root package name */
    private final ViewGroup f37384f;

    /* renamed from: g  reason: collision with root package name */
    u f37385g;

    /* renamed from: h  reason: collision with root package name */
    private u f37386h;

    /* renamed from: i  reason: collision with root package name */
    private Bagel f37387i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f37388j = false;

    h(TodayViewMainView todayViewMainView, b.C0468b bVar, e eVar, ViewGroup viewGroup) {
        super(todayViewMainView, bVar, eVar);
        this.f37384f = viewGroup;
    }

    private void E() {
        if (this.f37385g != null) {
            ((TodayViewMainView) l()).removeView(this.f37385g.l());
            b(this.f37385g);
        }
        F();
    }

    private void F() {
        if (this.f37386h != null) {
            ((TodayViewMainView) l()).removeView(this.f37386h.l());
            b(this.f37386h);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: G */
    public void s(Bagel bagel, Bagel bagel2) {
        E();
        T(bagel, bagel2, false);
        this.f37386h = new e((e.a) e()).b(this.f37384f, bagel2, false);
        R();
    }

    /* access modifiers changed from: private */
    /* renamed from: H */
    public void r(boolean z10, boolean z11, q<Boolean> qVar, SuggestedUnsubPaywallInteractor.UnsubPaywall unsubPaywall) {
        E();
        this.f37385g = new d((d.a) e()).b(this.f37384f, z10, z11, qVar, unsubPaywall);
        R();
    }

    /* access modifiers changed from: private */
    /* renamed from: I */
    public void t(Bagel bagel, boolean z10, boolean z11, q<Boolean> qVar, SuggestedUnsubPaywallInteractor.UnsubPaywall unsubPaywall) {
        E();
        T(bagel, (Bagel) null, true);
        this.f37386h = new d((d.a) e()).b(this.f37384f, z10, z11, qVar, unsubPaywall);
        R();
    }

    private void R() {
        if (this.f37385g != null) {
            u uVar = this.f37386h;
            if (uVar != null) {
                if (uVar.l() == null || this.f37386h.l().getParent() == null) {
                    ((TodayViewMainView) l()).addView(this.f37386h.l());
                } else {
                    F();
                }
            }
            ((TodayViewMainView) l()).addView(this.f37385g.l());
            a(this.f37385g);
        }
    }

    private void T(Bagel bagel, Bagel bagel2, boolean z10) {
        boolean z11;
        u uVar = this.f37385g;
        if (!(uVar instanceof n0) || Objects.equals(((n0) uVar).n(), bagel.getId()) || bagel2 == null || Objects.equals(((n0) this.f37385g).n(), bagel2.getId())) {
            z11 = false;
        } else {
            z11 = true;
        }
        u uVar2 = this.f37386h;
        if (!(uVar2 instanceof n0) || !z11) {
            this.f37385g = new e((e.a) e()).b(this.f37384f, bagel, z10);
        } else {
            this.f37385g = uVar2;
        }
        this.f37387i = bagel;
    }

    private void p(Runnable runnable, boolean z10) {
        u uVar = this.f37385g;
        if (uVar != null) {
            if (z10) {
                a.f41949a.b(uVar.l(), runnable);
            } else {
                a.f41949a.a(uVar.l(), runnable);
            }
            this.f37388j = false;
        }
    }

    public void A() {
        u uVar = this.f37385g;
        if (uVar instanceof n0) {
            this.f37388j = true;
            ((n0) uVar).u();
        }
    }

    public void B() {
        ((e) f()).l2();
        u uVar = this.f37385g;
        if (uVar instanceof n0) {
            ((n0) uVar).v();
        }
    }

    public void C() {
        this.f37388j = false;
        u uVar = this.f37385g;
        if (uVar instanceof n0) {
            ((n0) uVar).w();
        }
    }

    public void D(Boolean bool) {
        ((b.C0468b) e()).K0().P2(bool.booleanValue());
    }

    /* access modifiers changed from: package-private */
    public void J(boolean z10, boolean z11, q<Boolean> qVar, SuggestedUnsubPaywallInteractor.UnsubPaywall unsubPaywall) {
        if (!this.f37388j || !(this.f37385g instanceof i)) {
            r(z10, z11, qVar, unsubPaywall);
        } else {
            p(new m(this, z10, z11, qVar, unsubPaywall), false);
        }
    }

    /* access modifiers changed from: package-private */
    public void K() {
        ((b.C0468b) e()).a().X3();
    }

    /* access modifiers changed from: package-private */
    public void L() {
        ((b.C0468b) e()).a().M4(true);
    }

    public void M(Bagel bagel, Bagel bagel2) {
        boolean z10;
        Bagel bagel3 = this.f37387i;
        if (bagel3 == null || !bagel3.getId().equals(bagel2.getId())) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (this.f37388j) {
            u uVar = this.f37385g;
            if ((uVar instanceof n0) || (uVar instanceof i)) {
                p(new o(this, bagel, bagel2), z10);
                return;
            }
        }
        s(bagel, bagel2);
    }

    public void N(Bagel bagel, boolean z10, boolean z11, q<Boolean> qVar, SuggestedUnsubPaywallInteractor.UnsubPaywall unsubPaywall) {
        boolean z12;
        Bagel bagel2 = this.f37387i;
        if (bagel2 == null || !bagel2.getId().equals(bagel.getId())) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (!this.f37388j || !(this.f37385g instanceof i)) {
            t(bagel, z10, z11, qVar, unsubPaywall);
        } else {
            p(new n(this, bagel, z10, z11, qVar, unsubPaywall), z12);
        }
    }

    public void O(PurchaseSource purchaseSource) {
        PremiumUpsellComponentActivity.f36846j.b(((b.C0468b) e()).n(), purchaseSource);
    }

    /* access modifiers changed from: package-private */
    public void P() {
        ((b.C0468b) e()).a().G4("FRAGMENT_INDEX_DETAILS", (ProfileCategory) null);
    }

    /* access modifiers changed from: package-private */
    public void Q() {
        ((b.C0468b) e()).a().X4();
    }

    /* access modifiers changed from: package-private */
    public void S() {
        this.f37388j = true;
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        this.f37388j = false;
        return super.h();
    }

    public void q() {
        u uVar = this.f37385g;
        if (uVar instanceof n0) {
            ((n0) uVar).o();
        }
    }

    public void u() {
        u uVar = this.f37385g;
        if (uVar instanceof n0) {
            this.f37388j = true;
            ((n0) uVar).p();
        }
    }

    public void v() {
        u uVar = this.f37385g;
        if (uVar instanceof n0) {
            this.f37388j = true;
            ((n0) uVar).q();
        }
    }

    public void w() {
        u uVar = this.f37385g;
        if (uVar instanceof n0) {
            this.f37388j = true;
            ((n0) uVar).r();
        }
    }

    public void x() {
        u uVar = this.f37385g;
        if (uVar instanceof n0) {
            this.f37388j = true;
            ((n0) uVar).s();
        }
    }

    public void y() {
        u uVar = this.f37385g;
        if (uVar instanceof n0) {
            this.f37388j = true;
            ((n0) uVar).t();
        }
    }

    public void z() {
        this.f37388j = true;
        ((e) f()).J();
    }
}
