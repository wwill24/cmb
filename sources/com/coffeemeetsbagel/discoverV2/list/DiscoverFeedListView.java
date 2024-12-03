package com.coffeemeetsbagel.discoverV2.list;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbRecyclerView;
import com.coffeemeetsbagel.dialogs.DialogPrimarySecondaryVertical;
import com.coffeemeetsbagel.dialogs.a0;
import com.coffeemeetsbagel.dialogs.b0;
import com.coffeemeetsbagel.discoverV2.list.b;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.GiveTake;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mparticle.identity.IdentityHttpResponse;
import fa.a;
import j5.x;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.rx2.RxConvertKt;
import lc.c;
import qj.q;
import r7.h;

public final class DiscoverFeedListView extends RelativeLayout {

    /* renamed from: q  reason: collision with root package name */
    public static final a f12313q = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f12314a = "DiscoverFeedListView";

    /* renamed from: b  reason: collision with root package name */
    private CmbRecyclerView f12315b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f12316c;

    /* renamed from: d  reason: collision with root package name */
    private h f12317d;

    /* renamed from: e  reason: collision with root package name */
    private Dialog f12318e;

    /* renamed from: f  reason: collision with root package name */
    private Dialog f12319f;

    /* renamed from: g  reason: collision with root package name */
    private io.reactivex.subjects.a<GiveTake> f12320g;

    /* renamed from: h  reason: collision with root package name */
    private io.reactivex.subjects.a<Price> f12321h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public io.reactivex.subjects.a<Bagel> f12322j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public io.reactivex.subjects.a<Pair<GiveTake, PurchaseType>> f12323k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public io.reactivex.subjects.a<x> f12324l;

    /* renamed from: m  reason: collision with root package name */
    private final LinearLayoutManager f12325m;

    /* renamed from: n  reason: collision with root package name */
    private final RecyclerView.t f12326n;

    /* renamed from: p  reason: collision with root package name */
    private final RecyclerView.w f12327p;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements a0.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DiscoverFeedListView f12328a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GiveTake f12329b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ PurchaseType f12330c;

        b(DiscoverFeedListView discoverFeedListView, GiveTake giveTake, PurchaseType purchaseType) {
            this.f12328a = discoverFeedListView;
            this.f12329b = giveTake;
            this.f12330c = purchaseType;
        }

        public void a() {
        }

        public void d() {
        }

        public void e() {
            this.f12328a.f12323k.d(new Pair(this.f12329b, this.f12330c));
        }
    }

    public DiscoverFeedListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        io.reactivex.subjects.a<GiveTake> C0 = io.reactivex.subjects.a.C0();
        j.f(C0, "create()");
        this.f12320g = C0;
        io.reactivex.subjects.a<Price> C02 = io.reactivex.subjects.a.C0();
        j.f(C02, "create()");
        this.f12321h = C02;
        io.reactivex.subjects.a<Bagel> C03 = io.reactivex.subjects.a.C0();
        j.f(C03, "create()");
        this.f12322j = C03;
        io.reactivex.subjects.a<Pair<GiveTake, PurchaseType>> C04 = io.reactivex.subjects.a.C0();
        j.f(C04, "create()");
        this.f12323k = C04;
        io.reactivex.subjects.a<x> C05 = io.reactivex.subjects.a.C0();
        j.f(C05, "create()");
        this.f12324l = C05;
        this.f12325m = new LinearLayoutManager(getContext());
        this.f12326n = new g(this);
        this.f12327p = new c(this);
    }

    /* access modifiers changed from: private */
    public static final void F(DiscoverFeedListView discoverFeedListView, Price price, View view) {
        j.g(discoverFeedListView, "this$0");
        j.g(price, "$price");
        discoverFeedListView.f12321h.d(price);
    }

    /* access modifiers changed from: private */
    public static final void s(DiscoverFeedListView discoverFeedListView, GiveTake giveTake, View view) {
        j.g(discoverFeedListView, "this$0");
        j.g(giveTake, "$giveTake");
        discoverFeedListView.f12320g.d(giveTake);
    }

    /* access modifiers changed from: private */
    public static final void t(DiscoverFeedListView discoverFeedListView, RecyclerView.d0 d0Var) {
        j.g(discoverFeedListView, "this$0");
        j.g(d0Var, "holder");
        discoverFeedListView.p(d0Var.w());
    }

    /* access modifiers changed from: private */
    public static final void z(DiscoverFeedListView discoverFeedListView, GiveTake giveTake, PurchaseType purchaseType, View view) {
        j.g(discoverFeedListView, "this$0");
        j.g(giveTake, "$giveTake");
        j.g(purchaseType, "$purchaseType");
        discoverFeedListView.f12323k.d(new Pair(giveTake, purchaseType));
    }

    public final void A(Bagel bagel, String str) {
        j.g(bagel, "connectedBagel");
        Context context = getContext();
        j.e(context, "null cannot be cast to non-null type android.app.Activity");
        if (!((Activity) context).isFinishing()) {
            DialogPrimarySecondaryVertical.a aVar = DialogPrimarySecondaryVertical.f12065a;
            Context context2 = getContext();
            j.f(context2, "this.context");
            aVar.a(context2, DialogPrimarySecondaryVertical.PrimaryCtaStyle.NORMAL, (Integer) null, R.string.its_a_match, R.string.you_liked_each_other, R.string.start_chatting, new DiscoverFeedListView$showConnectedDialogDls$1(this, bagel), Integer.valueOf(R.string.not_now), (Function0<Unit>) null, (Function0<Unit>) null);
        }
    }

    public final void B(int i10) {
        CmbRecyclerView cmbRecyclerView = this.f12315b;
        j.d(cmbRecyclerView);
        RecyclerView.d0 d02 = cmbRecyclerView.d0(i10);
        if (d02 instanceof b.a) {
            ((b.a) d02).Y();
        }
    }

    public final void C(int i10) {
        CmbRecyclerView cmbRecyclerView = this.f12315b;
        j.d(cmbRecyclerView);
        RecyclerView.d0 d02 = cmbRecyclerView.d0(i10);
        if (d02 instanceof b.a) {
            ((b.a) d02).Z();
        }
    }

    public final void D(int i10) {
        CmbRecyclerView cmbRecyclerView = this.f12315b;
        j.d(cmbRecyclerView);
        RecyclerView.d0 d02 = cmbRecyclerView.d0(i10);
        if (d02 instanceof b.a) {
            ((b.a) d02).a0();
        }
    }

    public final void E(Price price) {
        j.g(price, FirebaseAnalytics.Param.PRICE);
        Context context = getContext();
        j.e(context, "null cannot be cast to non-null type android.app.Activity");
        if (!((Activity) context).isFinishing()) {
            b0 b0Var = new b0(getContext(), R.string.dialog_notenoughbeans_title, R.string.dialog_notenoughbeans_content, R.string.dialog_notenoughbeans_button_dls);
            this.f12319f = b0Var;
            j.e(b0Var, "null cannot be cast to non-null type com.coffeemeetsbagel.dialogs.DialogSingleButtonDls");
            b0 b0Var2 = b0Var;
            b0Var.b(new d(this, price));
            Dialog dialog = this.f12319f;
            j.e(dialog, "null cannot be cast to non-null type com.coffeemeetsbagel.dialogs.DialogSingleButtonDls");
            ((b0) dialog).show();
        }
    }

    public final void G() {
        Context context = getContext();
        j.e(context, "null cannot be cast to non-null type android.app.Activity");
        if (!((Activity) context).isFinishing()) {
            h hVar = this.f12317d;
            boolean z10 = true;
            if (hVar == null || !hVar.isShowing()) {
                z10 = false;
            }
            if (!z10) {
                h hVar2 = new h(getContext());
                this.f12317d = hVar2;
                j.d(hVar2);
                hVar2.show();
            }
        }
    }

    public final void H(int i10, int i11, CharSequence charSequence, int i12, a0.a aVar) {
        a0.b bVar = a0.f12077d;
        Context context = getContext();
        j.f(context, IdentityHttpResponse.CONTEXT);
        String string = getContext().getString(i10);
        j.f(string, "context.getString(title)");
        String string2 = getContext().getString(i11);
        j.f(string2, "context.getString(message)");
        j.d(charSequence);
        String string3 = getContext().getString(i12);
        j.f(string3, "context.getString(secondaryButtonText)");
        j.d(aVar);
        bVar.a(context, string, string2, charSequence, string3, false, aVar, (Function0<Unit>) null);
    }

    public final kotlinx.coroutines.flow.b<GiveTake> I() {
        q<GiveTake> P = this.f12320g.P();
        j.f(P, "takeConfirmationStream.hide()");
        return RxConvertKt.a(P);
    }

    public final int getFirstVisibleCard() {
        CmbRecyclerView cmbRecyclerView = this.f12315b;
        j.d(cmbRecyclerView);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) cmbRecyclerView.getLayoutManager();
        j.d(linearLayoutManager);
        return linearLayoutManager.a2();
    }

    public final Integer getLastVisibleCard() {
        CmbRecyclerView cmbRecyclerView = this.f12315b;
        j.d(cmbRecyclerView);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) cmbRecyclerView.getLayoutManager();
        j.d(linearLayoutManager);
        int c22 = linearLayoutManager.c2();
        Rect rect = new Rect();
        if (linearLayoutManager.D(c22) == null) {
            return null;
        }
        View D = linearLayoutManager.D(c22);
        j.d(D);
        D.getGlobalVisibleRect(rect);
        int height = rect.height();
        View D2 = linearLayoutManager.D(c22);
        j.d(D2);
        if (((double) height) >= ((double) D2.getMeasuredHeight()) * 0.5d) {
            return Integer.valueOf(c22);
        }
        return null;
    }

    public final LinearLayoutManager getLayoutManager() {
        return this.f12325m;
    }

    public final kotlinx.coroutines.flow.b<Pair<GiveTake, PurchaseType>> h() {
        q<Pair<GiveTake, PurchaseType>> P = this.f12323k.P();
        j.f(P, "activateStream.hide()");
        return RxConvertKt.a(P);
    }

    public final void i() {
        CmbRecyclerView cmbRecyclerView = this.f12315b;
        j.d(cmbRecyclerView);
        cmbRecyclerView.l(this.f12326n);
        CmbRecyclerView cmbRecyclerView2 = this.f12315b;
        j.d(cmbRecyclerView2);
        cmbRecyclerView2.m(this.f12327p);
    }

    public final void j() {
        c.h(this.f12316c);
        c.h(this.f12318e);
        c.h(this.f12319f);
        this.f12316c = null;
        this.f12318e = null;
        this.f12319f = null;
    }

    public final void k() {
        c.h(this.f12318e);
    }

    public final void l() {
        c.h(this.f12319f);
    }

    public final void m() {
        c.h(this.f12317d);
    }

    public final void n() {
        c.h(this.f12316c);
    }

    public final CharSequence o(int i10) {
        ImageSpan imageSpan;
        String str = i10 + " ";
        String string = getContext().getString(R.string.skip_the_line_primary_cta, new Object[]{str});
        j.f(string, "context.getString(R.stri…primary_cta, priceString)");
        int g02 = (StringsKt__StringsKt.g0(string, str, 0, false, 6, (Object) null) + str.length()) - 1;
        Drawable drawable = androidx.core.content.a.getDrawable(getContext(), R.drawable.ic_single_bean);
        j.d(drawable);
        drawable.setBounds(0, 4, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.mutate().setTint(-1);
        if (Build.VERSION.SDK_INT >= 29) {
            imageSpan = new ImageSpan(drawable, 2);
        } else {
            imageSpan = new ImageSpan(drawable);
        }
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(imageSpan, g02, g02 + 1, 0);
        return spannableString;
    }

    public final void p(int i10) {
        CmbRecyclerView cmbRecyclerView = this.f12315b;
        j.d(cmbRecyclerView);
        RecyclerView.d0 d02 = cmbRecyclerView.d0(i10);
        if (d02 instanceof b.a) {
            ((b.a) d02).W();
        }
    }

    public final kotlinx.coroutines.flow.b<x> q() {
        q<x> P = this.f12324l.P();
        j.f(P, "infiniteScrollStream.hide()");
        return RxConvertKt.a(P);
    }

    public final void r(int i10, String str, int i11, GiveTake giveTake) {
        j.g(giveTake, "giveTake");
        Context context = getContext();
        j.e(context, "null cannot be cast to non-null type android.app.Activity");
        if (!((Activity) context).isFinishing()) {
            b0 b0Var = new b0(getContext(), i10, R.string.empty, i11);
            this.f12316c = b0Var;
            j.e(b0Var, "null cannot be cast to non-null type com.coffeemeetsbagel.dialogs.DialogSingleButtonDls");
            b0 b0Var2 = b0Var;
            b0Var.c(str);
            Dialog dialog = this.f12316c;
            j.e(dialog, "null cannot be cast to non-null type com.coffeemeetsbagel.dialogs.DialogSingleButtonDls");
            ((b0) dialog).b(new e(this, giveTake));
            Dialog dialog2 = this.f12316c;
            j.e(dialog2, "null cannot be cast to non-null type com.coffeemeetsbagel.dialogs.DialogSingleButtonDls");
            Window window = ((b0) dialog2).getWindow();
            if (window != null) {
                window.setLayout(-1, -2);
            }
            Dialog dialog3 = this.f12316c;
            j.e(dialog3, "null cannot be cast to non-null type com.coffeemeetsbagel.dialogs.DialogSingleButtonDls");
            ((b0) dialog3).show();
        }
    }

    public final void setAdapter(b bVar) {
        View findViewById = findViewById(R.id.recycler_view);
        j.e(findViewById, "null cannot be cast to non-null type com.coffeemeetsbagel.cmb_views.CmbRecyclerView");
        CmbRecyclerView cmbRecyclerView = (CmbRecyclerView) findViewById;
        this.f12315b = cmbRecyclerView;
        j.d(cmbRecyclerView);
        cmbRecyclerView.setLayoutManager(this.f12325m);
        CmbRecyclerView cmbRecyclerView2 = this.f12315b;
        j.d(cmbRecyclerView2);
        cmbRecyclerView2.setAdapter(bVar);
    }

    public final kotlinx.coroutines.flow.b<Price> u() {
        q<Price> P = this.f12321h.P();
        j.f(P, "outOfBeansConfirmationStream.hide()");
        return RxConvertKt.a(P);
    }

    public final kotlinx.coroutines.flow.b<Bagel> v() {
        q<Bagel> P = this.f12322j.P();
        j.f(P, "redirectToChatStream.hide()");
        return RxConvertKt.a(P);
    }

    public final kotlinx.coroutines.flow.b<x> w() {
        CmbRecyclerView cmbRecyclerView = this.f12315b;
        j.d(cmbRecyclerView);
        q<x> K1 = cmbRecyclerView.K1();
        j.f(K1, "recyclerView!!.scrollState()");
        return RxConvertKt.a(K1);
    }

    public final void x(int i10, int i11) {
        CmbRecyclerView cmbRecyclerView = this.f12315b;
        j.d(cmbRecyclerView);
        RecyclerView.d0 d02 = cmbRecyclerView.d0(i10);
        if (d02 instanceof b.a) {
            ((b.a) d02).X(i11);
        }
    }

    public final void y(GiveTake giveTake, PurchaseType purchaseType) {
        j.g(giveTake, "giveTake");
        j.g(purchaseType, "purchaseType");
        Context context = getContext();
        j.e(context, "null cannot be cast to non-null type android.app.Activity");
        if (!((Activity) context).isFinishing()) {
            a.C0491a aVar = fa.a.f40771d;
            String str = this.f12314a;
            aVar.a(str, "showActivateDialogDls: type= " + purchaseType);
            if (purchaseType == PurchaseType.PAID_LIKE) {
                Context context2 = getContext();
                j.f(context2, IdentityHttpResponse.CONTEXT);
                b bVar = new b(this, giveTake, purchaseType);
                String string = getContext().getString(R.string.paused_account_discover_like_pop_up_title);
                j.f(string, "context.getString(R.stri…scover_like_pop_up_title)");
                String string2 = getContext().getString(R.string.paused_account_discover_like_pop_up_message);
                j.f(string2, "context.getString(R.stri…over_like_pop_up_message)");
                String string3 = getContext().getString(R.string.paused_account_discover_like_pop_up_cta);
                j.f(string3, "context.getString(R.stri…discover_like_pop_up_cta)");
                String string4 = getContext().getString(R.string.cancel);
                j.f(string4, "context.getString(R.string.cancel)");
                a0 a0Var = new a0(context2, bVar, string, string2, string3, string4, false, (Function0<Unit>) null);
                this.f12318e = a0Var;
                j.e(a0Var, "null cannot be cast to non-null type com.coffeemeetsbagel.dialogs.DialogSendFlowers");
                a0 a0Var2 = a0Var;
                a0Var.show();
                return;
            }
            b0 b0Var = new b0(getContext(), R.string.paused_account_discover_like_pop_up_title, R.string.paused_account_discover_like_pop_up_message, R.string.paused_account_discover_like_pop_up_cta);
            this.f12318e = b0Var;
            j.e(b0Var, "null cannot be cast to non-null type com.coffeemeetsbagel.dialogs.DialogSingleButtonDls");
            b0 b0Var2 = b0Var;
            b0Var.b(new f(this, giveTake, purchaseType));
            Dialog dialog = this.f12318e;
            j.e(dialog, "null cannot be cast to non-null type com.coffeemeetsbagel.dialogs.DialogSingleButtonDls");
            ((b0) dialog).show();
        }
    }
}
