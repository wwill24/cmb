package com.coffeemeetsbagel.shop.shop;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import b6.d;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.feature.purchase.PurchaseDisplayUtils;
import com.coffeemeetsbagel.models.enums.RewardType;
import com.coffeemeetsbagel.shop.shop.adapter.ShopViewType;
import com.coffeemeetsbagel.store.PurchaseFailureType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import lb.e;
import lc.c;
import qj.q;
import r7.h;
import sb.b;

public class o0 extends p<ShopShopView> {

    /* renamed from: e  reason: collision with root package name */
    private final d f36552e;

    /* renamed from: f  reason: collision with root package name */
    private final b f36553f;

    /* renamed from: g  reason: collision with root package name */
    private final lb.d f36554g;

    /* renamed from: h  reason: collision with root package name */
    private final a f36555h;

    /* renamed from: j  reason: collision with root package name */
    private h f36556j;

    /* renamed from: k  reason: collision with root package name */
    private tj.b f36557k;

    /* renamed from: l  reason: collision with root package name */
    final List<e> f36558l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    final String f36559m = "ShopShopPresenter";

    /* renamed from: n  reason: collision with root package name */
    private boolean f36560n = false;

    public interface a {
        void T0();

        void f0(String str);

        void j1();

        void q1(RewardType rewardType);
    }

    o0(d dVar, b bVar, ShopShopView shopShopView, a aVar, lb.d dVar2) {
        super(shopShopView);
        this.f36552e = dVar;
        this.f36553f = bVar;
        this.f36555h = aVar;
        this.f36554g = dVar2;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean C(ShopViewType shopViewType, e eVar) {
        return eVar.a() == shopViewType;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D(Long l10) throws Exception {
        this.f36554g.H();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean E(e eVar) {
        return eVar.a() == ShopViewType.DYNAMIC_PRE_SUBSCRIPTION_BENEFITS;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean F(e eVar) {
        return eVar.a() == ShopViewType.DYNAMIC_POST_SUBSCRIPTION_BENEFITS;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G(View view) {
        this.f36555h.f0(RewardType.BUY_LARGE.getProductSku());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H(View view) {
        this.f36555h.f0(RewardType.BUY_MEDIUM.getProductSku());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(View view) {
        this.f36555h.f0(RewardType.BUY_SMALL.getProductSku());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        this.f36555h.T0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(View view) {
        this.f36555h.q1(RewardType.FOLLOW_INSTAGRAM);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(View view) {
        this.f36555h.q1(RewardType.INVITE);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M(View view) {
        this.f36555h.q1(RewardType.FOLLOW_TWITTER);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(View view) {
        this.f36555h.q1(RewardType.TWEET);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O(View view) {
        this.f36555h.T0();
    }

    private void y(e eVar) {
        this.f36558l.add(eVar);
        this.f36560n = true;
    }

    private boolean z(ShopViewType shopViewType) {
        return this.f36558l.stream().anyMatch(new e0(shopViewType));
    }

    /* access modifiers changed from: package-private */
    public void A() {
        this.f36558l.removeIf(new k0());
        this.f36558l.removeIf(new l0());
        this.f36554g.P(ShopViewType.DYNAMIC_PRE_SUBSCRIPTION_BENEFITS);
        this.f36554g.P(ShopViewType.DYNAMIC_POST_SUBSCRIPTION_BENEFITS);
    }

    /* access modifiers changed from: package-private */
    public void B() {
        c.h(this.f36556j);
    }

    /* access modifiers changed from: package-private */
    public void P(View view) {
        qb.b bVar = new qb.b(view);
        e K = this.f36554g.K(bVar.a());
        if (K == null) {
            K = this.f36554g.K(ShopViewType.DYNAMIC_PRE_SUBSCRIPTION_BENEFITS);
        }
        if (K != null) {
            int J = this.f36554g.J(K);
            this.f36558l.set(J, bVar);
            this.f36554g.Q(bVar, J);
            return;
        }
        ((ShopShopView) this.f7869c).h(new lb.a(this.f36552e));
        y(bVar);
    }

    /* access modifiers changed from: package-private */
    public void Q() {
        if (!z(ShopViewType.PURCHASE)) {
            String string = this.f36552e.getString(R.string.price_error);
            g gVar = g.f36534a;
            RewardType rewardType = RewardType.BUY_SMALL;
            long d10 = gVar.d(rewardType);
            RewardType rewardType2 = RewardType.BUY_LARGE;
            long d11 = gVar.d(rewardType2);
            y(new ob.a(this.f36552e.getString(R.string.bean_shop_section_title_buy_beans), this.f36552e.getString(R.string.bean_shop_header, new Object[]{gVar.b(d10, d11)})));
            y(new pb.a(rewardType2, new h0(this), gVar.c(RewardType.getCurrencyCode(), Long.toString(((long) rewardType2.getRewardAmount()) * d10)), string));
            RewardType rewardType3 = RewardType.BUY_MEDIUM;
            y(new pb.a(rewardType3, new i0(this), gVar.c(RewardType.getCurrencyCode(), Long.toString(d10 * ((long) rewardType3.getRewardAmount()))), string));
            y(new pb.a(rewardType, new j0(this), (String) null, string));
        }
    }

    /* access modifiers changed from: package-private */
    public void R(View view) {
        qb.c cVar = new qb.c(view, new g0(this));
        e K = this.f36554g.K(cVar.a());
        if (K == null) {
            K = this.f36554g.K(ShopViewType.DYNAMIC_POST_SUBSCRIPTION_BENEFITS);
        }
        if (K != null) {
            int J = this.f36554g.J(K);
            this.f36558l.set(J, cVar);
            this.f36554g.Q(cVar, J);
            return;
        }
        ((ShopShopView) this.f7869c).h(new lb.a(this.f36552e));
        y(cVar);
    }

    /* access modifiers changed from: package-private */
    public void S(boolean z10) {
        String str;
        if (!z(ShopViewType.FREE)) {
            Context context = ((ShopShopView) g()).getContext();
            if (z10) {
                str = context.getString(R.string.get_free_beans_explainer_referral);
            } else {
                str = context.getString(R.string.get_free_beans_explainer);
            }
            y(new ob.a(context.getString(R.string.get_free_beans), str));
            y(new nb.a(RewardType.FOLLOW_TWITTER, new m0(this), ((ShopShopView) g()).getContext().getString(R.string.follow), androidx.core.content.a.getDrawable(((ShopShopView) g()).getContext(), R.drawable.icon_twitter)));
            y(new nb.a(RewardType.TWEET, new n0(this), ((ShopShopView) g()).getContext().getString(R.string.tweet), androidx.core.content.a.getDrawable(((ShopShopView) g()).getContext(), R.drawable.icon_twitter)));
            y(new nb.a(RewardType.FOLLOW_INSTAGRAM, new c0(this), ((ShopShopView) g()).getContext().getString(R.string.follow), androidx.core.content.a.getDrawable(((ShopShopView) g()).getContext(), R.drawable.icon_instagram)));
            if (z10) {
                y(new nb.a(RewardType.INVITE, new d0(this), ((ShopShopView) g()).getContext().getString(R.string.refer), (Drawable) null, ((ShopShopView) g()).getContext().getString(R.string.per_friend_joined)));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void T(View view) {
        e K = this.f36554g.K(ShopViewType.SUBSCRIPTION_COMPARISONS);
        qb.e eVar = new qb.e(view, new f0(this));
        if (K == null) {
            ((ShopShopView) this.f7869c).h(new lb.a(this.f36552e));
            y(eVar);
            return;
        }
        int J = this.f36554g.J(K);
        this.f36558l.set(J, eVar);
        this.f36554g.Q(eVar, J);
    }

    /* access modifiers changed from: package-private */
    public void U() {
        this.f36553f.b(this.f36552e.J0(), R.string.bean_shop_already_following_instagram);
    }

    /* access modifiers changed from: package-private */
    public void V() {
        this.f36553f.b(this.f36552e.J0(), R.string.bean_shop_already_following_twitter);
    }

    /* access modifiers changed from: package-private */
    public void W() {
        this.f36553f.b(this.f36552e.J0(), R.string.bean_shop_already_tweeted);
    }

    /* access modifiers changed from: package-private */
    public void X() {
        y(new mb.c(ShopViewType.ERROR_NO_PLAY, this.f36555h));
    }

    /* access modifiers changed from: package-private */
    public void Y() {
        y(new mb.c(ShopViewType.ERROR_NO_SKUS, this.f36555h));
    }

    /* access modifiers changed from: package-private */
    public void Z() {
        this.f36553f.b(this.f36552e.J0(), R.string.resume_unlocking_feature_purchase_success);
    }

    /* access modifiers changed from: package-private */
    public void a0() {
        h hVar = new h(((ShopShopView) this.f7869c).getContext());
        this.f36556j = hVar;
        hVar.show();
    }

    /* access modifiers changed from: package-private */
    public void b0(PurchaseFailureType purchaseFailureType) {
        this.f36553f.a(PurchaseDisplayUtils.getErrorForFailedPurchase(purchaseFailureType));
    }

    /* access modifiers changed from: package-private */
    public void c0(String str, int i10) {
        String str2;
        if (i10 <= 0 || m9.a.a(str)) {
            str2 = ((ShopShopView) g()).getResources().getString(R.string.bean_shop_buy_items_success);
        } else {
            str2 = ((ShopShopView) g()).getContext().getResources().getQuantityString(R.plurals.bean_shop_buy_success, i10, new Object[]{Integer.valueOf(i10)});
        }
        this.f36553f.d(str2);
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        ((ShopShopView) this.f7869c).setLayoutManager(new LinearLayoutManager(((ShopShopView) g()).getContext()));
        ((ShopShopView) this.f7869c).setAdapter(this.f36554g);
        this.f36557k = ((com.uber.autodispose.p) q.T(4000, TimeUnit.MILLISECONDS).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new b0(this));
    }

    /* access modifiers changed from: package-private */
    public void d0(ViewGroup viewGroup, String str) {
        this.f36553f.c(viewGroup, str);
    }

    /* access modifiers changed from: package-private */
    public void e0() {
        this.f36553f.b(this.f36552e.J0(), R.string.error_network_error_invite);
    }

    /* access modifiers changed from: package-private */
    public void f0(int i10) {
        this.f36553f.c(this.f36552e.J0(), ((ShopShopView) g()).getContext().getResources().getQuantityString(R.plurals.social_media_success, i10, new Object[]{Integer.valueOf(i10)}));
    }

    /* access modifiers changed from: package-private */
    public void g0(int i10) {
        this.f36553f.c(this.f36552e.J0(), this.f36552e.getResources().getQuantityString(R.plurals.bean_shop_still_need_beans, i10, new Object[]{Integer.valueOf(i10)}));
    }

    /* access modifiers changed from: package-private */
    public void h0() {
        if (this.f36560n) {
            this.f36554g.R(this.f36558l);
        }
    }

    /* access modifiers changed from: protected */
    public void i() {
        super.i();
        this.f36554g.I();
        tj.b bVar = this.f36557k;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    /* access modifiers changed from: package-private */
    public void i0() {
        if (this.f36557k != null) {
            for (e a10 : this.f36558l) {
                if (a10.a().equals(ShopViewType.NON_PURCHASED_SUBSCRIPTION)) {
                    this.f36557k.dispose();
                    this.f36557k = null;
                    return;
                }
            }
        }
    }
}
