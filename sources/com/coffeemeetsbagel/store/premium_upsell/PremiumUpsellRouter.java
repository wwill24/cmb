package com.coffeemeetsbagel.store.premium_upsell;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import b6.u;
import com.coffeemeetsbagel.feature.purchase.PurchaseDisplayUtils;
import com.coffeemeetsbagel.store.PurchaseFailureType;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellInteractor;
import com.coffeemeetsbagel.store.premium_upsell.k;
import com.coffeemeetsbagel.store.subscription_benefits.SubscriptionBenefitsRouter;
import com.coffeemeetsbagel.store.subscription_benefits.e;
import com.coffeemeetsbagel.store.subscription_variants.d;
import gk.f;
import java.util.List;
import java.util.Stack;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.p;
import r7.h;
import ub.b;
import vb.a;
import vb.c;
import xb.e;

public final class PremiumUpsellRouter extends u<View, k.b, PremiumUpsellInteractor> {

    /* renamed from: f  reason: collision with root package name */
    private final b f36860f;

    /* renamed from: g  reason: collision with root package name */
    private final f f36861g;

    /* renamed from: h  reason: collision with root package name */
    private u<?, ?, ?> f36862h;

    /* renamed from: i  reason: collision with root package name */
    private final Stack<u<View, ?, ?>> f36863i = new Stack<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PremiumUpsellRouter(b bVar, k.b bVar2, PremiumUpsellInteractor premiumUpsellInteractor) {
        super(bVar.getRoot(), bVar2, premiumUpsellInteractor);
        j.g(bVar, "binding");
        j.g(bVar2, "component");
        j.g(premiumUpsellInteractor, "interactor");
        this.f36860f = bVar;
        this.f36861g = b.b(new PremiumUpsellRouter$loadingProgressBar$2(bVar2));
    }

    private final h o() {
        return (h) this.f36861g.getValue();
    }

    private final boolean q() {
        u<?, ?, ?> uVar = this.f36862h;
        if (uVar != null && CollectionsKt___CollectionsKt.E(this.f36863i, uVar)) {
            Stack<u<View, ?, ?>> stack = this.f36863i;
            p.a(stack).remove(this.f36862h);
        }
        if (this.f36863i.size() <= 0) {
            return false;
        }
        u pop = this.f36863i.pop();
        j.f(pop, "router");
        r(pop);
        return true;
    }

    private final void r(u<View, ?, ?> uVar) {
        u<?, ?, ?> uVar2 = this.f36862h;
        if (uVar2 != null) {
            b(uVar2);
            this.f36860f.f41961d.removeAllViews();
        }
        this.f36862h = uVar;
        a(uVar);
        FrameLayout frameLayout = this.f36860f.f41961d;
        u uVar3 = this.f36862h;
        j.d(uVar3);
        frameLayout.addView(uVar3.l());
        if (this.f36862h instanceof SubscriptionBenefitsRouter) {
            ((PremiumUpsellInteractor) f()).i2();
        } else {
            ((PremiumUpsellInteractor) f()).j2();
        }
        this.f36863i.push(uVar);
    }

    /* access modifiers changed from: protected */
    public boolean g() {
        return p();
    }

    public final void m() {
        this.f36863i.clear();
        o().dismiss();
        ((k.b) e()).i().finish();
    }

    public final void n(PurchaseFailureType purchaseFailureType) {
        j.g(purchaseFailureType, "purchaseFailureType");
        Activity i10 = ((k.b) e()).i();
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("ARG_FAILURE_MESSAGE", PurchaseDisplayUtils.getErrorForFailedPurchase(purchaseFailureType));
        Unit unit = Unit.f32013a;
        i10.setResult(242, intent.putExtras(bundle));
        m();
    }

    public final boolean p() {
        if (q()) {
            return true;
        }
        ((PremiumUpsellInteractor) f()).f2();
        m();
        return false;
    }

    public final void s(PurchaseSource purchaseSource, List<c> list, PremiumUpsellInteractor.a aVar, Pair<a, c> pair) {
        j.g(purchaseSource, "purchaseSource");
        j.g(list, "bundlesToCompare");
        j.g(aVar, "childNavigationListener");
        b6.j e10 = e();
        j.f(e10, "component");
        e eVar = new e((e.a) e10);
        FrameLayout frameLayout = this.f36860f.f41961d;
        j.f(frameLayout, "binding.premiumUpsellContent");
        r(eVar.b(frameLayout, purchaseSource, list, aVar, pair));
    }

    public final void t(PurchaseSource purchaseSource, PremiumUpsellInteractor.a aVar, c cVar) {
        j.g(purchaseSource, "purchaseSource");
        j.g(aVar, "callbackListener");
        j.g(cVar, "bundle");
        b6.j e10 = e();
        j.f(e10, "component");
        com.coffeemeetsbagel.store.subscription_benefits.e eVar = new com.coffeemeetsbagel.store.subscription_benefits.e((e.a) e10);
        FrameLayout frameLayout = this.f36860f.f41961d;
        j.f(frameLayout, "binding.premiumUpsellContent");
        r(eVar.b(frameLayout, purchaseSource, aVar, cVar));
    }

    public final void u(boolean z10, PurchaseSource purchaseSource, c cVar, Pair<a, c> pair) {
        j.g(purchaseSource, "purchaseSource");
        j.g(cVar, "bundle");
        b6.j e10 = e();
        j.f(e10, "component");
        d dVar = new d((d.a) e10);
        FrameLayout frameLayout = this.f36860f.f41961d;
        j.f(frameLayout, "binding.premiumUpsellContent");
        r(dVar.b(frameLayout, purchaseSource, cVar, z10, pair));
    }
}
