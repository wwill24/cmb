package com.coffeemeetsbagel.shop.shop;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import b6.d;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.feature.instagram.c;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.util.StringUtils;
import com.coffeemeetsbagel.shop.post_subscription_benefits.d;
import com.coffeemeetsbagel.shop.shop.h;
import com.coffeemeetsbagel.shop.subscription_comparison.e;
import com.coffeemeetsbagel.shop.subscription_comparison.j;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.SubscriptionBenefitAttribution;
import com.coffeemeetsbagel.store.UpsellErrorDialog;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellComponentActivity;
import com.coffeemeetsbagel.subscription_dialog.benefits_carousel.a;
import e6.b;
import fa.a;
import h5.m;
import lc.p;

public class p0 extends b<ShopShopView, h.b, z> {

    /* renamed from: f  reason: collision with root package name */
    private final d f36562f;

    /* renamed from: g  reason: collision with root package name */
    private final p9.d f36563g;

    /* renamed from: h  reason: collision with root package name */
    private final c f36564h;

    /* renamed from: i  reason: collision with root package name */
    private final m f36565i;

    /* renamed from: j  reason: collision with root package name */
    private final p f36566j;

    /* renamed from: k  reason: collision with root package name */
    private final StringUtils f36567k;

    /* renamed from: l  reason: collision with root package name */
    private com.coffeemeetsbagel.shop.post_subscription_benefits.m f36568l = null;

    /* renamed from: m  reason: collision with root package name */
    private com.coffeemeetsbagel.subscription_dialog.benefits_carousel.h f36569m = null;

    /* renamed from: n  reason: collision with root package name */
    private j f36570n = null;

    p0(ShopShopView shopShopView, h.b bVar, z zVar, d dVar, p9.d dVar2, c cVar, m mVar, p pVar, StringUtils stringUtils) {
        super(shopShopView, bVar, zVar);
        this.f36562f = dVar;
        this.f36563g = dVar2;
        this.f36564h = cVar;
        this.f36565i = mVar;
        this.f36566j = pVar;
        this.f36567k = stringUtils;
    }

    public String m() {
        return this.f36562f.getString(R.string.shop_caps);
    }

    /* access modifiers changed from: package-private */
    public void n() {
        this.f36564h.f(this.f36562f);
    }

    /* access modifiers changed from: package-private */
    public void o() {
        this.f36563g.c(this.f36562f);
    }

    /* access modifiers changed from: package-private */
    public void p() {
        this.f36565i.k(this.f36562f, "bean shop");
    }

    /* access modifiers changed from: package-private */
    public void q(int i10, PurchaseType purchaseType, Price price, int i11, int i12) {
        ((o0) ((z) f()).G1()).d0(this.f36562f.J0(), this.f36567k.getQuantityString(this.f36562f, R.plurals.bean_shop_acquired_sufficient_beans, i10, Integer.valueOf(i10)) + "\n" + this.f36562f.getString(purchaseType.c()));
        this.f36562f.setResult(-1, this.f36566j.a(purchaseType, price, i11, i12));
        this.f36562f.finish();
    }

    /* access modifiers changed from: package-private */
    public void r() {
        com.coffeemeetsbagel.subscription_dialog.benefits_carousel.h hVar = this.f36569m;
        if (hVar != null) {
            b(hVar);
            this.f36569m = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void s() {
        com.coffeemeetsbagel.shop.post_subscription_benefits.m mVar = this.f36568l;
        if (mVar != null) {
            b(mVar);
            this.f36568l = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void t() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.coffeemeetsbagel"));
        intent.setPackage("com.android.vending");
        try {
            ((h.b) e()).a().startActivity(intent);
        } catch (ActivityNotFoundException e10) {
            String string = ((ShopShopView) l()).getContext().getString(R.string.bean_shop_play_not_found);
            ((o0) ((z) f()).G1()).d0(this.f36562f.J0(), string);
            a.g(p0.class.getSimpleName(), string, e10);
        }
    }

    /* access modifiers changed from: package-private */
    public View u() {
        if (this.f36568l == null) {
            com.coffeemeetsbagel.shop.post_subscription_benefits.m b10 = new com.coffeemeetsbagel.shop.post_subscription_benefits.d((d.a) e()).b((ViewGroup) l());
            this.f36568l = b10;
            a(b10);
        }
        return this.f36568l.l();
    }

    /* access modifiers changed from: package-private */
    public View v() {
        if (this.f36569m == null) {
            com.coffeemeetsbagel.subscription_dialog.benefits_carousel.h b10 = new com.coffeemeetsbagel.subscription_dialog.benefits_carousel.a((a.c) e()).b(((ShopShopView) l()).getContext(), SubscriptionBenefitAttribution.SHOP);
            this.f36569m = b10;
            a(b10);
        }
        return this.f36569m.l();
    }

    /* access modifiers changed from: package-private */
    public View w() {
        if (this.f36570n == null) {
            j b10 = new e((e.a) e()).b((ViewGroup) l());
            this.f36570n = b10;
            a(b10);
        }
        return this.f36570n.l();
    }

    public void x() {
        UpsellErrorDialog.f36742a.a(this.f36562f);
    }

    public void y(PurchaseSource purchaseSource) {
        PremiumUpsellComponentActivity.f36846j.b(((h.b) e()).a(), purchaseSource);
    }

    /* access modifiers changed from: package-private */
    public void z() {
        this.f36563g.a(this.f36562f);
    }
}
