package com.coffeemeetsbagel.upsell_banner;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.upsell_banner.UpsellBannerPresenter;
import com.coffeemeetsbagel.upsell_banner.i;

public final class g extends b6.c<n, c> {

    public interface a extends j<i> {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final kc.a f37562a;

        /* renamed from: b  reason: collision with root package name */
        private final UpsellBannerPresenter.a f37563b;

        /* renamed from: c  reason: collision with root package name */
        private final String f37564c;

        /* renamed from: d  reason: collision with root package name */
        private final String f37565d;

        public b(kc.a aVar, UpsellBannerPresenter.a aVar2, String str, String str2) {
            kotlin.jvm.internal.j.g(aVar, "binding");
            kotlin.jvm.internal.j.g(aVar2, "listener");
            kotlin.jvm.internal.j.g(str, "ctaText");
            kotlin.jvm.internal.j.g(str2, "description");
            this.f37562a = aVar;
            this.f37563b = aVar2;
            this.f37564c = str;
            this.f37565d = str2;
        }

        public final UpsellBannerPresenter a() {
            return new UpsellBannerPresenter(this.f37562a, this.f37563b, this.f37564c, this.f37565d);
        }
    }

    public interface c {
        a7.a c();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public static /* synthetic */ n c(g gVar, ViewGroup viewGroup, kc.a aVar, i.a aVar2, boolean z10, String str, String str2, String str3, int i10, Object obj) {
        return gVar.b(viewGroup, (i10 & 2) != 0 ? null : aVar, aVar2, z10, str, str2, str3);
    }

    public final n b(ViewGroup viewGroup, kc.a aVar, i.a aVar2, boolean z10, String str, String str2, String str3) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        kotlin.jvm.internal.j.g(aVar2, "listener");
        kotlin.jvm.internal.j.g(str, "ctaText");
        kotlin.jvm.internal.j.g(str2, "description");
        kotlin.jvm.internal.j.g(str3, "screenSource");
        i iVar = new i(z10, str3, aVar2);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (aVar == null) {
            aVar = kc.a.c(from, viewGroup, false);
            kotlin.jvm.internal.j.f(aVar, "inflate(inflater, parentViewGroup, false)");
        }
        a a10 = b.a().b(new b(aVar, iVar, str, str2)).c((c) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new n(aVar, a10, iVar);
    }
}
