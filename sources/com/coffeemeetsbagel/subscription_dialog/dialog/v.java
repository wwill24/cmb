package com.coffeemeetsbagel.subscription_dialog.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.store.u;
import kotlin.jvm.internal.j;

public final class v extends p<x> {

    /* renamed from: e  reason: collision with root package name */
    private Dialog f37068e;

    /* renamed from: f  reason: collision with root package name */
    private u f37069f;

    /* renamed from: g  reason: collision with root package name */
    private final String f37070g;

    public interface a {
        void a();

        void b();

        void c();

        void d();

        void m();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(x xVar) {
        super(xVar);
        j.g(xVar, "view");
        String simpleName = v.class.getSimpleName();
        j.f(simpleName, "SubscriptionDialogPresenter::class.java.simpleName");
        this.f37070g = simpleName;
    }

    /* access modifiers changed from: private */
    public static final void t(a aVar, View view) {
        j.g(aVar, "$listener");
        aVar.b();
    }

    /* access modifiers changed from: private */
    public static final void u(a aVar, View view) {
        j.g(aVar, "$listener");
        aVar.d();
    }

    /* access modifiers changed from: private */
    public static final void v(a aVar, View view) {
        j.g(aVar, "$listener");
        aVar.m();
    }

    /* access modifiers changed from: private */
    public static final void w(a aVar, View view) {
        j.g(aVar, "$listener");
        aVar.c();
    }

    /* access modifiers changed from: private */
    public static final void y(a aVar, DialogInterface dialogInterface) {
        j.g(aVar, "$listener");
        aVar.a();
    }

    public final void A() {
        ((x) this.f7869c).getBuyMoreBeansView().setVisibility(0);
    }

    public final void o() {
        Dialog dialog = this.f37068e;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.f37068e = null;
    }

    public final boolean p() {
        Dialog dialog = this.f37068e;
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    public final void q(String str) {
        j.g(str, "firstName");
        Context context = ((x) this.f7869c).getContext();
        j.f(context, "view.context");
        u uVar = new u(context, str);
        this.f37069f = uVar;
        j.d(uVar);
        uVar.show();
    }

    public final void r(a aVar) {
        j.g(aVar, "listener");
        ((x) this.f7869c).getSubscriptionCta().setOnClickListener(new q(aVar));
        ((x) this.f7869c).getCancelCta().setOnClickListener(new r(aVar));
        ((x) this.f7869c).getDisclaimer().setOnClickListener(new s(aVar));
        ((x) this.f7869c).getBuyMoreBeansView().setOnClickListener(new t(aVar));
        Dialog dialog = this.f37068e;
        boolean z10 = true;
        if (dialog == null || !dialog.isShowing()) {
            z10 = false;
        }
        if (z10) {
            fa.a.f40771d.b(this.f37070g, "Can't show SubscriptionDialog, it's already being displayed.");
            return;
        }
        Context context = ((x) this.f7869c).getContext();
        j.f(context, "view.context");
        V v10 = this.f7869c;
        j.f(v10, "view");
        d dVar = new d(context, v10);
        this.f37068e = dVar;
        dVar.setOnDismissListener(new u(aVar));
        Dialog dialog2 = this.f37068e;
        if (dialog2 != null) {
            dialog2.show();
        }
    }

    public final void z(Activity activity) {
        j.g(activity, "activity");
        View findViewById = activity.findViewById(16908290);
        j.f(findViewById, "rootView");
        sb.a.f(findViewById, R.string.error_google_play_prices);
    }
}
