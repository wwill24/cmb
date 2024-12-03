package com.coffeemeetsbagel.suggested_history.suggested_history_match_container;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import androidx.core.content.a;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.dialogs.b0;
import com.coffeemeetsbagel.models.Price;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.jvm.internal.j;
import lc.c;
import zb.b;

public final class h0 extends p<View> {

    /* renamed from: e  reason: collision with root package name */
    private final b f37209e;

    /* renamed from: f  reason: collision with root package name */
    private final i0 f37210f;

    /* renamed from: g  reason: collision with root package name */
    private b0 f37211g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h0(b bVar, i0 i0Var) {
        super(bVar.getRoot());
        j.g(bVar, "binding");
        j.g(i0Var, "listener");
        this.f37209e = bVar;
        this.f37210f = i0Var;
        bVar.f42233e.setOnClickListener(new y(this));
        bVar.f42232d.setOnClickListener(new z(this));
        bVar.f42231c.setOnClickListener(new a0(this));
        bVar.f42230b.setOnClickListener(new b0(this));
        bVar.f42234f.setOnClickListener(new c0(this));
    }

    private final CharSequence B(int i10) {
        String str;
        Drawable drawable;
        ImageSpan imageSpan;
        if (i10 == 0) {
            str = "1  ";
        } else {
            str = i10 + "  ";
        }
        if (i10 == 0) {
            drawable = a.getDrawable(this.f7869c.getContext(), R.drawable.flower);
        } else {
            drawable = a.getDrawable(this.f7869c.getContext(), R.drawable.ic_single_bean);
        }
        int V = StringsKt__StringsKt.V(str);
        j.d(drawable);
        drawable.setBounds(1, 1, 32, 32);
        drawable.mutate().setTint(-1);
        if (Build.VERSION.SDK_INT >= 29) {
            imageSpan = new ImageSpan(drawable, 2);
        } else {
            imageSpan = new ImageSpan(drawable);
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(imageSpan, V, V + 1, 0);
        return spannableString;
    }

    /* access modifiers changed from: private */
    public static final void H(h0 h0Var) {
        j.g(h0Var, "this$0");
        h0Var.f37209e.f42230b.l(100);
    }

    /* access modifiers changed from: private */
    public static final void I(h0 h0Var) {
        j.g(h0Var, "this$0");
        h0Var.f37209e.f42232d.l(100);
    }

    /* access modifiers changed from: private */
    public static final void J(h0 h0Var) {
        j.g(h0Var, "this$0");
        h0Var.f37209e.f42231c.l(100);
    }

    /* access modifiers changed from: private */
    public static final void L(h0 h0Var, View view) {
        j.g(h0Var, "this$0");
        h0Var.f37210f.i();
    }

    /* access modifiers changed from: private */
    public static final void O(h0 h0Var) {
        j.g(h0Var, "this$0");
        h0Var.f37209e.f42236h.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public static final void u(h0 h0Var, View view) {
        j.g(h0Var, "this$0");
        h0Var.f37210f.J();
    }

    /* access modifiers changed from: private */
    public static final void v(h0 h0Var, View view) {
        j.g(h0Var, "this$0");
        h0Var.f37210f.a0();
    }

    /* access modifiers changed from: private */
    public static final void w(h0 h0Var, View view) {
        j.g(h0Var, "this$0");
        h0Var.f37210f.y();
    }

    /* access modifiers changed from: private */
    public static final void y(h0 h0Var, View view) {
        j.g(h0Var, "this$0");
        h0Var.f37210f.p();
    }

    /* access modifiers changed from: private */
    public static final void z(h0 h0Var, View view) {
        j.g(h0Var, "this$0");
        h0Var.f37210f.B0();
    }

    public final void A(boolean z10) {
        this.f37209e.f42232d.setEnabled(z10);
        this.f37209e.f42231c.setEnabled(z10);
    }

    public final void C() {
        b0 b0Var = this.f37211g;
        if (b0Var != null) {
            c.h(b0Var);
        }
    }

    public final void D() {
        this.f37209e.f42233e.setVisibility(8);
        this.f37209e.f42230b.setEnabled(false);
        this.f37209e.f42230b.a();
    }

    public final void E() {
        this.f37209e.f42233e.setVisibility(8);
        this.f37209e.f42231c.setEnabled(false);
        this.f37209e.f42232d.setEnabled(false);
        this.f37209e.f42231c.a();
        this.f37209e.f42232d.a();
    }

    public final void F(int i10) {
        V v10 = this.f7869c;
        j.f(v10, "view");
        sb.a.g(v10, i10);
    }

    public final void G(boolean z10) {
        this.f37209e.f42233e.j(100);
        this.f37209e.f42233e.postDelayed(new e0(this), 120);
        this.f37209e.f42233e.postDelayed(new f0(this), 120);
        if (z10) {
            this.f37209e.f42233e.postDelayed(new g0(this), 120);
        }
    }

    public final void K() {
        b0 b0Var = new b0(g().getContext(), R.string.dialog_notenoughbeans_title, R.string.dialog_notenoughbeans_content, R.string.dialog_notenoughbeans_button_dls);
        this.f37211g = b0Var;
        j.d(b0Var);
        b0Var.b(new x(this));
        b0 b0Var2 = this.f37211g;
        j.d(b0Var2);
        b0Var2.show();
    }

    public final void M() {
        this.f37209e.f42233e.setEnabled(true);
        this.f37209e.f42233e.a();
        this.f37209e.f42231c.setVisibility(8);
        this.f37209e.f42232d.setVisibility(8);
        this.f37209e.f42230b.setVisibility(8);
    }

    public final void N(Price price) {
        j.g(price, FirebaseAnalytics.Param.PRICE);
        this.f37209e.f42235g.setText(B(price.getBeanCost(1)));
        this.f37209e.f42230b.j(100);
        this.f37209e.f42230b.postDelayed(new d0(this), 120);
    }

    public final void P(int i10) {
        V v10 = this.f7869c;
        j.f(v10, "view");
        sb.a.i(v10, i10);
    }
}
