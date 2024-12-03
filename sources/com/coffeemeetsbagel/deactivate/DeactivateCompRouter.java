package com.coffeemeetsbagel.deactivate;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import b6.d;
import b6.u;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.deactivate.g;
import com.coffeemeetsbagel.dialogs.DialogPrimarySecondaryVertical;
import com.coffeemeetsbagel.dialogs.b0;
import com.coffeemeetsbagel.dialogs.r;
import com.coffeemeetsbagel.external_links.CmbLinks;
import com.uber.autodispose.a;
import com.uber.autodispose.p;
import gk.f;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import wk.c;

public final class DeactivateCompRouter extends u<View, g.a, DeactivateCompInteractor> {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final d<?, ?> f12005f;

    /* renamed from: g  reason: collision with root package name */
    private final f f12006g;

    /* renamed from: h  reason: collision with root package name */
    private final f f12007h = b.b(new DeactivateCompRouter$dialogRatingFeedback$2(this));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeactivateCompRouter(k6.g gVar, g.a aVar, DeactivateCompInteractor deactivateCompInteractor) {
        super(gVar.getRoot(), aVar, deactivateCompInteractor);
        j.g(gVar, "view");
        j.g(aVar, "component");
        j.g(deactivateCompInteractor, "interactor");
        this.f12005f = aVar.a();
        this.f12006g = b.b(new DeactivateCompRouter$dialogHoldReason$2(deactivateCompInteractor, this));
    }

    private final r s() {
        return (r) this.f12006g.getValue();
    }

    private final b0 t() {
        return (b0) this.f12007h.getValue();
    }

    private final void v() {
        ((p) t().a().g(a.a(this.f12005f))).c(new n(new DeactivateCompRouter$initDialogRatingFeedback$1(this)));
        t().setOnKeyListener(new o(this));
        t().setOnCancelListener(new p(this));
    }

    /* access modifiers changed from: private */
    public static final void w(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final boolean x(DeactivateCompRouter deactivateCompRouter, DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        j.g(deactivateCompRouter, "this$0");
        return ((DeactivateCompInteractor) deactivateCompRouter.f()).S1(i10);
    }

    /* access modifiers changed from: private */
    public static final void y(DeactivateCompRouter deactivateCompRouter, DialogInterface dialogInterface) {
        j.g(deactivateCompRouter, "this$0");
        ((DeactivateCompInteractor) deactivateCompRouter.f()).O1();
    }

    public final void A(CmbLinks.PayItForwardSurveyParameters payItForwardSurveyParameters) {
        j.g(payItForwardSurveyParameters, "payload");
        DialogPrimarySecondaryVertical.a.c(DialogPrimarySecondaryVertical.f12065a, ((g.a) e()).a(), (DialogPrimarySecondaryVertical.PrimaryCtaStyle) null, (Integer) null, R.string.payitfoward_title, R.string.payitfoward_desc, R.string.payitfoward_cta, new DeactivateCompRouter$showPayItForward$1(this, payItForwardSurveyParameters), Integer.valueOf(R.string.payitfoward_cta_no_thanks), new DeactivateCompRouter$showPayItForward$2(this), (Function0) null, 518, (Object) null);
    }

    public final void B() {
        b0 t10 = t();
        t10.show();
        Window window = t10.getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
        }
    }

    /* access modifiers changed from: protected */
    public void j() {
        super.j();
        v();
    }

    public final void q() {
        t().dismiss();
    }

    public final void r(List<? extends Pair<String, ? extends Object>> list) {
        j.g(list, "extras");
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        for (Pair pair : list) {
            c b10 = l.b(pair.d().getClass());
            if (j.b(b10, l.b(String.class))) {
                Object d10 = pair.d();
                j.e(d10, "null cannot be cast to non-null type kotlin.String");
                bundle.putString((String) pair.c(), (String) d10);
            } else if (j.b(b10, l.b(Boolean.TYPE))) {
                Object d11 = pair.d();
                j.e(d11, "null cannot be cast to non-null type kotlin.Boolean");
                bundle.putBoolean((String) pair.c(), ((Boolean) d11).booleanValue());
            }
        }
        intent.putExtras(bundle);
        this.f12005f.setResult(-1, intent);
        this.f12005f.finish();
    }

    public final void u() {
        lc.l.c(((g.a) e()).a());
    }

    public final void z() {
        r s10 = s();
        s10.show();
        Window window = s10.getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
        }
        Window window2 = s10.getWindow();
        if (window2 != null) {
            window2.setBackgroundDrawableResource(17170445);
        }
    }
}
