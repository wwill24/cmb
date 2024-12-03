package com.coffeemeetsbagel.limelight.profile_activity;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.dialogs.s;
import com.coffeemeetsbagel.hidereport.main.HideReportComponentActivity;
import com.coffeemeetsbagel.like_pass.view.LikePassButtonsCenterDLSView;
import com.coffeemeetsbagel.like_pass.view.MatchActionType;
import com.google.firebase.ktx.BuildConfig;
import gk.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import lc.c;
import r7.h;
import sj.a;

public final class LikesYouProfilePresenter extends p<View> {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final LikesYouMatchContainerInteractor f34424e;

    /* renamed from: f  reason: collision with root package name */
    private final f f34425f = b.b(new LikesYouProfilePresenter$ctasView$2(this));

    /* renamed from: g  reason: collision with root package name */
    private final f f34426g = b.b(new LikesYouProfilePresenter$connectionsDialog$2(this));

    /* renamed from: h  reason: collision with root package name */
    private final f f34427h = b.b(new LikesYouProfilePresenter$progressDialog$2(this));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LikesYouProfilePresenter(FrameLayout frameLayout, LikesYouMatchContainerInteractor likesYouMatchContainerInteractor) {
        super(frameLayout);
        j.g(frameLayout, "layout");
        j.g(likesYouMatchContainerInteractor, "interactor");
        this.f34424e = likesYouMatchContainerInteractor;
    }

    /* access modifiers changed from: private */
    public static final void E(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void F(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void q(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void r(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void t() {
        w().setIsEnabled(false);
    }

    private final s v() {
        return (s) this.f34426g.getValue();
    }

    private final LikePassButtonsCenterDLSView w() {
        return (LikePassButtonsCenterDLSView) this.f34425f.getValue();
    }

    private final h y() {
        return (h) this.f34427h.getValue();
    }

    public final void A() {
        c.h(y());
    }

    public final void B(String str, boolean z10) {
        j.g(str, "profileId");
        HideReportComponentActivity.a aVar = HideReportComponentActivity.f13953j;
        Context context = this.f7869c.getContext();
        j.e(context, "null cannot be cast to non-null type android.app.Activity");
        aVar.a((Activity) context, str, (String) null, z10, false, "likes_you_profile", BuildConfig.VERSION_NAME);
    }

    public final void C() {
        v().show();
    }

    public final void D(String str) {
        j.g(str, "bagelId");
        ((com.uber.autodispose.p) v().a().a0(a.a()).g(com.uber.autodispose.a.a(this))).c(new x0(new LikesYouProfilePresenter$showConnectionDialog$1(this, str)));
        ((com.uber.autodispose.p) v().b().a0(a.a()).g(com.uber.autodispose.a.a(this))).c(new y0(new LikesYouProfilePresenter$showConnectionDialog$2(this)));
        C();
    }

    public final void G() {
        V v10 = this.f7869c;
        j.f(v10, "view");
        sb.a.f(v10, R.string.generic_error);
    }

    public final void H(boolean z10) {
        View findViewById = this.f7869c.findViewById(R.id.loader);
        if (z10) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
    }

    public final void I() {
        y().show();
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        w().a(q.m(MatchActionType.PASS, MatchActionType.LIKE), (Long) null);
        w().setIsEnabled(false);
        ((com.uber.autodispose.p) w().e().a0(a.a()).g(com.uber.autodispose.a.a(this))).c(new v0(new LikesYouProfilePresenter$didLoad$1(this)));
        ((com.uber.autodispose.p) w().f().a0(a.a()).g(com.uber.autodispose.a.a(this))).c(new w0(new LikesYouProfilePresenter$didLoad$2(this)));
    }

    public final void u() {
        w().setIsEnabled(true);
    }

    public final void z() {
        c.h(v());
    }
}
