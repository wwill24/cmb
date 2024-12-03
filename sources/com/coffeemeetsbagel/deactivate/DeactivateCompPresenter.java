package com.coffeemeetsbagel.deactivate;

import android.view.View;
import b6.d;
import b6.p;
import com.coffeemeetsbagel.cmb_views.CmbLinearLayout;
import com.coffeemeetsbagel.models.DeactivateReason;
import com.coffeemeetsbagel.view.CmbToolbar;
import gk.f;
import java.util.List;
import k6.g;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import z9.e;

public final class DeactivateCompPresenter extends p<View> {

    /* renamed from: e  reason: collision with root package name */
    private final g f12000e;

    /* renamed from: f  reason: collision with root package name */
    private final a f12001f;

    /* renamed from: g  reason: collision with root package name */
    private final f f12002g;

    /* renamed from: h  reason: collision with root package name */
    private final f f12003h = b.b(new DeactivateCompPresenter$doneActionBarView$2(this));

    /* renamed from: j  reason: collision with root package name */
    private final f f12004j = b.b(new DeactivateCompPresenter$adapter$2(this));

    public interface a extends e {
        void Q(int i10);

        void d0();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeactivateCompPresenter(g gVar, a aVar, d<?, ?> dVar) {
        super(gVar.getRoot());
        j.g(gVar, "binding");
        j.g(aVar, "listeners");
        j.g(dVar, "activity");
        this.f12000e = gVar;
        this.f12001f = aVar;
        this.f12002g = b.b(new DeactivateCompPresenter$cmbToolbar$2(dVar));
    }

    private final u m() {
        return (u) this.f12004j.getValue();
    }

    /* access modifiers changed from: private */
    public final CmbToolbar n() {
        return (CmbToolbar) this.f12002g.getValue();
    }

    private final CmbLinearLayout o() {
        return (CmbLinearLayout) this.f12003h.getValue();
    }

    private final void q() {
        ((com.uber.autodispose.p) o().a().g(com.uber.autodispose.a.a(this))).c(new m(new DeactivateCompPresenter$initActionBarMenu$1(this)));
    }

    /* access modifiers changed from: private */
    public static final void r(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        this.f12000e.f15743c.setAdapter(m());
        q();
        n().C(o());
        o().setVisibility(8);
    }

    public final a p() {
        return this.f12001f;
    }

    public final void t(int i10) {
        m().m(i10);
    }

    public final void u(int i10) {
        this.f12000e.f15742b.setText(this.f7869c.getResources().getString(i10));
    }

    public final void v(boolean z10) {
        if (z10) {
            o().setVisibility(8);
        } else {
            o().setVisibility(0);
        }
    }

    public final void w(List<DeactivateReason> list) {
        j.g(list, "reasonsList");
        m().J(list);
    }
}
