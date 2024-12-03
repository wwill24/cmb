package com.coffeemeetsbagel.upsell_banner;

import android.view.View;
import b6.p;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.q;

public final class UpsellBannerPresenter extends p<View> {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final kc.a f37551e;

    /* renamed from: f  reason: collision with root package name */
    private final a f37552f;

    /* renamed from: g  reason: collision with root package name */
    private final String f37553g;

    /* renamed from: h  reason: collision with root package name */
    private final String f37554h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final int f37555j = this.f7869c.getResources().getDimensionPixelSize(d.baseline_1x);

    public interface a {
        void n0();

        void t();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UpsellBannerPresenter(kc.a aVar, a aVar2, String str, String str2) {
        super(aVar.getRoot());
        j.g(aVar, "binding");
        j.g(aVar2, "listener");
        j.g(str, "ctaText");
        j.g(str2, "description");
        this.f37551e = aVar;
        this.f37552f = aVar2;
        this.f37553g = str;
        this.f37554h = str2;
    }

    /* access modifiers changed from: private */
    public static final void o(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void p(UpsellBannerPresenter upsellBannerPresenter, View view) {
        j.g(upsellBannerPresenter, "this$0");
        upsellBannerPresenter.f37552f.t();
    }

    /* access modifiers changed from: private */
    public static final void q(UpsellBannerPresenter upsellBannerPresenter, View view) {
        j.g(upsellBannerPresenter, "this$0");
        upsellBannerPresenter.f37552f.n0();
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        this.f37551e.f41069d.setText(this.f37554h);
        this.f37551e.f41068c.setText(this.f37553g);
        ((com.uber.autodispose.p) q.V(this.f37551e.f41067b).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new k(new UpsellBannerPresenter$didLoad$1(this)));
        this.f37551e.f41068c.setOnClickListener(new l(this));
        this.f37551e.f41067b.setOnClickListener(new m(this));
    }

    public final void r() {
        this.f37551e.getRoot().setVisibility(8);
    }
}
