package com.coffemeetsbagel.hide_report;

import android.view.View;
import b6.p;
import gk.f;
import kotlin.jvm.internal.j;
import r7.h;
import rc.a;

public final class HideReportMainPresenter extends p<View> {

    /* renamed from: e  reason: collision with root package name */
    private final a f37657e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f37658f;

    /* renamed from: g  reason: collision with root package name */
    private final c0 f37659g;

    /* renamed from: h  reason: collision with root package name */
    private final String f37660h = "HideReportMainPresenter";

    /* renamed from: j  reason: collision with root package name */
    private final f f37661j = b.b(new HideReportMainPresenter$progressDialog$2(this));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HideReportMainPresenter(a aVar, boolean z10, c0 c0Var) {
        super(aVar.getRoot());
        j.g(aVar, "binding");
        j.g(c0Var, "listener");
        this.f37657e = aVar;
        this.f37658f = z10;
        this.f37659g = c0Var;
    }

    /* access modifiers changed from: private */
    public static final void l(HideReportMainPresenter hideReportMainPresenter, View view) {
        j.g(hideReportMainPresenter, "this$0");
        hideReportMainPresenter.f37659g.k0();
    }

    private final h m() {
        return (h) this.f37661j.getValue();
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        p();
        this.f37657e.f41818d.J(0, 0);
        this.f37657e.f41816b.setOnClickListener(new v(this));
    }

    public final void n() {
        m().dismiss();
    }

    public final void o(int i10) {
        View findViewById = g().findViewById(y.footer_container);
        if (findViewById != null) {
            V v10 = this.f7869c;
            j.f(v10, "view");
            sb.a.c(v10, i10, 6000, findViewById);
            return;
        }
        V v11 = this.f7869c;
        j.f(v11, "view");
        sb.a.g(v11, i10);
        fa.a.f40771d.c(this.f37660h, "", new IllegalStateException("Could not find footer to show snackbar perfectly"));
    }

    public final void p() {
        if (this.f37658f) {
            this.f37657e.f41819e.setText(this.f7869c.getContext().getString(a0.hide_reason_title));
        } else {
            this.f37657e.f41819e.setText(this.f7869c.getContext().getString(a0.report_reason_title));
        }
    }

    public final void q() {
        m().show();
    }

    public final void r(String str) {
        j.g(str, "value");
        this.f37657e.f41819e.setText(str);
    }
}
