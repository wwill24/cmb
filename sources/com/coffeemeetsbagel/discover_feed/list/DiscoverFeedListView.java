package com.coffeemeetsbagel.discover_feed.list;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbRecyclerView;
import com.coffeemeetsbagel.dialogs.DialogPrimarySecondaryVertical;
import com.coffeemeetsbagel.dialogs.a0;
import com.coffeemeetsbagel.dialogs.b0;
import com.coffeemeetsbagel.discover_feed.list.a;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.GiveTake;
import com.coffeemeetsbagel.models.Price;
import j5.x;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import lc.c;
import qj.q;
import r6.h0;
import r6.i0;
import r6.j0;
import r6.k0;
import r7.h;

public class DiscoverFeedListView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private CmbRecyclerView f12362a;

    /* renamed from: b  reason: collision with root package name */
    private Dialog f12363b;

    /* renamed from: c  reason: collision with root package name */
    private h f12364c;

    /* renamed from: d  reason: collision with root package name */
    private Dialog f12365d;

    /* renamed from: e  reason: collision with root package name */
    private Dialog f12366e;

    /* renamed from: f  reason: collision with root package name */
    private io.reactivex.subjects.a<GiveTake> f12367f;

    /* renamed from: g  reason: collision with root package name */
    private io.reactivex.subjects.a<Price> f12368g;

    /* renamed from: h  reason: collision with root package name */
    private io.reactivex.subjects.a<Bagel> f12369h;

    /* renamed from: j  reason: collision with root package name */
    private io.reactivex.subjects.a<GiveTake> f12370j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public io.reactivex.subjects.a<x> f12371k;

    /* renamed from: l  reason: collision with root package name */
    private LinearLayoutManager f12372l = new LinearLayoutManager(getContext());

    /* renamed from: m  reason: collision with root package name */
    private RecyclerView.t f12373m = new a();

    /* renamed from: n  reason: collision with root package name */
    private final RecyclerView.w f12374n = new h0(this);

    class a extends RecyclerView.t {
        a() {
        }

        public void a(@NonNull RecyclerView recyclerView, int i10) {
            super.a(recyclerView, i10);
        }

        public void b(@NonNull RecyclerView recyclerView, int i10, int i11) {
            super.b(recyclerView, i10, i11);
            if (!recyclerView.canScrollVertically(1)) {
                DiscoverFeedListView.this.f12371k.d(x.a());
            }
        }
    }

    public DiscoverFeedListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(RecyclerView.d0 d0Var) {
        m(d0Var.w());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(GiveTake giveTake, View view) {
        this.f12367f.d(giveTake);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit p(Bagel bagel) {
        this.f12369h.d(bagel);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q(Price price, View view) {
        this.f12368g.d(price);
    }

    public void A(int i10) {
        RecyclerView.d0 d02 = this.f12362a.d0(i10);
        if (d02 instanceof a.C0134a) {
            ((a.C0134a) d02).Z();
        }
    }

    public void B(int i10) {
        RecyclerView.d0 d02 = this.f12362a.d0(i10);
        if (d02 instanceof a.C0134a) {
            ((a.C0134a) d02).a0();
        }
    }

    public void C(Price price) {
        if (!((Activity) getContext()).isFinishing()) {
            b0 b0Var = new b0(getContext(), R.string.dialog_notenoughbeans_title, R.string.dialog_notenoughbeans_content, R.string.dialog_notenoughbeans_button_dls);
            this.f12366e = b0Var;
            b0 b0Var2 = b0Var;
            b0Var.b(new k0(this, price));
            this.f12366e.show();
        }
    }

    public void D() {
        if (!((Activity) getContext()).isFinishing()) {
            h hVar = new h(getContext());
            this.f12364c = hVar;
            hVar.show();
        }
    }

    public void E(int i10, int i11, CharSequence charSequence, int i12, a0.a aVar) {
        a0.f12077d.a(getContext(), getContext().getString(i10), getContext().getString(i11), charSequence, getContext().getString(i12), false, aVar, (Function0<Unit>) null);
    }

    public q<GiveTake> F() {
        return this.f12367f.P();
    }

    public q<GiveTake> f() {
        return this.f12370j.P();
    }

    public void g() {
        this.f12362a.l(this.f12373m);
        this.f12362a.m(this.f12374n);
    }

    public int getFirstVisibleCard() {
        return ((LinearLayoutManager) this.f12362a.getLayoutManager()).a2();
    }

    public Integer getLastVisibleCard() {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f12362a.getLayoutManager();
        int c22 = linearLayoutManager.c2();
        Rect rect = new Rect();
        if (linearLayoutManager.D(c22) == null) {
            return null;
        }
        linearLayoutManager.D(c22).getGlobalVisibleRect(rect);
        if (((double) rect.height()) >= ((double) linearLayoutManager.D(c22).getMeasuredHeight()) * 0.5d) {
            return Integer.valueOf(c22);
        }
        return null;
    }

    public void h() {
        c.h(this.f12363b);
        c.h(this.f12365d);
        c.h(this.f12366e);
        this.f12363b = null;
        this.f12365d = null;
        this.f12366e = null;
    }

    public void i() {
        c.h(this.f12365d);
    }

    public void j() {
        c.h(this.f12366e);
    }

    public void k() {
        c.h(this.f12364c);
    }

    public void l() {
        c.h(this.f12363b);
    }

    public void m(int i10) {
        RecyclerView.d0 d02 = this.f12362a.d0(i10);
        if (d02 instanceof a.C0134a) {
            ((a.C0134a) d02).W();
        }
    }

    public q<x> r() {
        return this.f12371k.P();
    }

    public void s(int i10, String str, int i11, GiveTake giveTake) {
        if (!((Activity) getContext()).isFinishing()) {
            b0 b0Var = new b0(getContext(), i10, R.string.empty, i11);
            this.f12363b = b0Var;
            b0 b0Var2 = b0Var;
            b0Var.c(str);
            ((b0) this.f12363b).b(new i0(this, giveTake));
            if (this.f12363b.getWindow() != null) {
                this.f12363b.getWindow().setLayout(-1, -2);
            }
            this.f12363b.show();
        }
    }

    public void setAdapter(a aVar) {
        CmbRecyclerView cmbRecyclerView = (CmbRecyclerView) findViewById(R.id.recycler_view);
        this.f12362a = cmbRecyclerView;
        cmbRecyclerView.setLayoutManager(this.f12372l);
        this.f12362a.setAdapter(aVar);
        this.f12367f = io.reactivex.subjects.a.C0();
        this.f12368g = io.reactivex.subjects.a.C0();
        this.f12369h = io.reactivex.subjects.a.C0();
        this.f12370j = io.reactivex.subjects.a.C0();
        this.f12371k = io.reactivex.subjects.a.C0();
    }

    public q<Price> t() {
        return this.f12368g.P();
    }

    public q<Bagel> u() {
        return this.f12369h.P();
    }

    public q<x> v() {
        return this.f12362a.K1();
    }

    public void w(int i10) {
        this.f12362a.s1(i10);
    }

    public void x(int i10, int i11) {
        RecyclerView.d0 d02 = this.f12362a.d0(i10);
        if (d02 instanceof a.C0134a) {
            ((a.C0134a) d02).X(i11);
        }
    }

    public void y(Bagel bagel, String str) {
        if (!((Activity) getContext()).isFinishing()) {
            DialogPrimarySecondaryVertical.f12065a.a(getContext(), DialogPrimarySecondaryVertical.PrimaryCtaStyle.NORMAL, (Integer) null, R.string.its_a_match, R.string.you_liked_each_other, R.string.start_chatting, new j0(this, bagel), Integer.valueOf(R.string.not_now), (Function0<Unit>) null, (Function0<Unit>) null);
        }
    }

    public void z(int i10) {
        RecyclerView.d0 d02 = this.f12362a.d0(i10);
        if (d02 instanceof a.C0134a) {
            ((a.C0134a) d02).Y();
        }
    }
}
