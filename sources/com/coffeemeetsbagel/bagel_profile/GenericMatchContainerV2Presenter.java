package com.coffeemeetsbagel.bagel_profile;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import androidx.core.content.a;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bagel_profile.main.GenericMatchContainerV2Interactor;
import com.coffeemeetsbagel.bagel_profile.main.GenericMatchContainerView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class GenericMatchContainerV2Presenter extends p<GenericMatchContainerView> {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final GenericMatchContainerV2Interactor f10997e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenericMatchContainerV2Presenter(GenericMatchContainerView genericMatchContainerView, GenericMatchContainerV2Interactor genericMatchContainerV2Interactor) {
        super(genericMatchContainerView);
        j.g(genericMatchContainerView, "view");
        j.g(genericMatchContainerV2Interactor, "interactor");
        this.f10997e = genericMatchContainerV2Interactor;
    }

    /* access modifiers changed from: private */
    public static final void o(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void p(Function1 function1, Object obj) {
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

    private final CharSequence t(int i10) {
        String str;
        Drawable drawable;
        ImageSpan imageSpan;
        if (i10 == 0) {
            str = "1  ";
        } else {
            str = i10 + "  ";
        }
        if (i10 == 0) {
            drawable = a.getDrawable(((GenericMatchContainerView) this.f7869c).getContext(), R.drawable.flower);
        } else {
            drawable = a.getDrawable(((GenericMatchContainerView) this.f7869c).getContext(), R.drawable.ic_single_bean);
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

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        ((com.uber.autodispose.p) ((GenericMatchContainerView) this.f7869c).b().g(com.uber.autodispose.a.a(this))).c(new n(new GenericMatchContainerV2Presenter$didLoad$1(this)));
        ((com.uber.autodispose.p) ((GenericMatchContainerView) this.f7869c).k().g(com.uber.autodispose.a.a(this))).c(new o(new GenericMatchContainerV2Presenter$didLoad$2(this)));
        ((com.uber.autodispose.p) ((GenericMatchContainerView) this.f7869c).c().g(com.uber.autodispose.a.a(this))).c(new p(new GenericMatchContainerV2Presenter$didLoad$3(this)));
        ((com.uber.autodispose.p) ((GenericMatchContainerView) this.f7869c).f().g(com.uber.autodispose.a.a(this))).c(new q(new GenericMatchContainerV2Presenter$didLoad$4(this)));
    }

    public final void u() {
        ((GenericMatchContainerView) this.f7869c).d();
    }

    public final void v() {
        ((GenericMatchContainerView) this.f7869c).g();
    }

    public final void w(boolean z10) {
        ((GenericMatchContainerView) this.f7869c).h(z10);
    }

    public final void y(int i10) {
        ((GenericMatchContainerView) this.f7869c).i(t(i10));
    }

    public final void z(boolean z10, boolean z11) {
        ((GenericMatchContainerView) this.f7869c).j(z10, z11);
    }
}
