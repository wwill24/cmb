package com.coffeemeetsbagel.boost;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import androidx.lifecycle.t;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.alc.d;
import fa.a;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.a;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.x0;

public final class BoostViewModel extends f0 {

    /* renamed from: d  reason: collision with root package name */
    private PurchaseManager f11435d;

    /* renamed from: e  reason: collision with root package name */
    private ProfileManager f11436e;

    /* renamed from: f  reason: collision with root package name */
    private d f11437f;

    /* renamed from: g  reason: collision with root package name */
    private SubscriptionRepository f11438g;

    /* renamed from: h  reason: collision with root package name */
    private final String f11439h = "BoostViewModel";
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final t<Long> f11440i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final t<Price> f11441j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final t<Boolean> f11442k;

    /* renamed from: l  reason: collision with root package name */
    private final t<BoostPaymentType> f11443l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final t<ViewState> f11444m;

    /* renamed from: n  reason: collision with root package name */
    private final LiveData<ViewState> f11445n;

    /* renamed from: o  reason: collision with root package name */
    private final LiveData<Price> f11446o;

    /* renamed from: p  reason: collision with root package name */
    private final LiveData<Boolean> f11447p;

    /* renamed from: q  reason: collision with root package name */
    private final LiveData<Long> f11448q;

    public enum ViewState {
        AVAILABLE,
        INSUFFICIENT_BEANS,
        PURCHASING_BOOST,
        PURCHASED_BOOST,
        PURCHASE_FAILED
    }

    public BoostViewModel(PurchaseManager purchaseManager, ProfileManager profileManager, d dVar, SubscriptionRepository subscriptionRepository) {
        j.g(purchaseManager, "purchaseManager");
        j.g(profileManager, "profileManager");
        j.g(dVar, "purchaseItemUseCase");
        j.g(subscriptionRepository, "subscriptionRepository");
        this.f11435d = purchaseManager;
        this.f11436e = profileManager;
        this.f11437f = dVar;
        this.f11438g = subscriptionRepository;
        t<Long> tVar = new t<>(0L);
        this.f11440i = tVar;
        t<Price> tVar2 = new t<>();
        this.f11441j = tVar2;
        t<Boolean> tVar3 = new t<>(Boolean.FALSE);
        this.f11442k = tVar3;
        this.f11443l = new t<>(BoostPaymentType.NONE);
        t<ViewState> tVar4 = new t<>(ViewState.AVAILABLE);
        this.f11444m = tVar4;
        this.f11445n = tVar4;
        this.f11446o = tVar2;
        this.f11447p = tVar3;
        this.f11448q = tVar;
    }

    /* access modifiers changed from: private */
    public static final void D(BoostViewModel boostViewModel, Bundle bundle) {
        j.g(boostViewModel, "this$0");
        s1 unused = j.d(g0.a(boostViewModel), (CoroutineContext) null, (CoroutineStart) null, new BoostViewModel$refreshBeanCount$1$1(boostViewModel, (c<? super BoostViewModel$refreshBeanCount$1$1>) null), 3, (Object) null);
    }

    private final BoostPaymentType k() {
        if (o() > 0) {
            return BoostPaymentType.GRANT;
        }
        if (l() >= ((long) n())) {
            return BoostPaymentType.BEANS;
        }
        return BoostPaymentType.NONE;
    }

    private final long l() {
        Long f10 = this.f11440i.f();
        if (f10 == null) {
            return 0;
        }
        return f10.longValue();
    }

    public final Object A(c<? super Unit> cVar) {
        Long l10;
        Integer num;
        this.f11441j.o(this.f11435d.getPrice(PurchaseType.BOOST));
        t<Long> tVar = this.f11440i;
        NetworkProfile j10 = this.f11436e.j();
        if (j10 != null) {
            l10 = a.c(j10.getBeans());
        } else {
            l10 = null;
        }
        tVar.o(l10);
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f11439h;
        Price f10 = this.f11441j.f();
        if (f10 != null) {
            num = kotlin.coroutines.jvm.internal.a.b(f10.getBeans());
        } else {
            num = null;
        }
        aVar.a(str, "Price of Boost in Beans: " + num);
        aVar.a(this.f11439h, "Bean Balance: " + this.f11440i.f());
        Object g10 = h.g(x0.b(), new BoostViewModel$initialize$2(this, (c<? super BoostViewModel$initialize$2>) null), cVar);
        if (g10 == b.d()) {
            return g10;
        }
        return Unit.f32013a;
    }

    public final Object B(c<? super Unit> cVar) {
        BoostPaymentType k10 = k();
        this.f11443l.o(k10);
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f11439h;
        aVar.a(str, "purchaseBoost(): " + k10);
        if (k10 == BoostPaymentType.NONE) {
            aVar.a(this.f11439h, "Not enough beans to purchase.");
            this.f11444m.o(ViewState.INSUFFICIENT_BEANS);
            return Unit.f32013a;
        }
        this.f11444m.o(ViewState.PURCHASING_BOOST);
        Object g10 = h.g(x0.b(), new BoostViewModel$purchaseBoost$2(this, (c<? super BoostViewModel$purchaseBoost$2>) null), cVar);
        if (g10 == b.d()) {
            return g10;
        }
        return Unit.f32013a;
    }

    public final void C() {
        this.f11436e.e(new Bundle(), new h(this));
    }

    public final void E() {
        this.f11435d.refreshPricesFromApi(new BoostViewModel$refreshBoostPrice$1(this));
    }

    public final LiveData<Long> m() {
        return this.f11448q;
    }

    public final int n() {
        Price f10 = this.f11441j.f();
        if (f10 != null) {
            return f10.getBeans();
        }
        return 0;
    }

    public final int o() {
        Price f10 = this.f11441j.f();
        if (f10 != null) {
            return f10.getFreeItemCount();
        }
        return 0;
    }

    public final LiveData<Boolean> p() {
        return this.f11447p;
    }

    public final BoostPaymentType q() {
        BoostPaymentType f10 = this.f11443l.f();
        return f10 == null ? BoostPaymentType.NONE : f10;
    }

    public final LiveData<Price> r() {
        return this.f11446o;
    }

    public final Price s() {
        return this.f11441j.f();
    }

    public final ProfileManager t() {
        return this.f11436e;
    }

    public final d u() {
        return this.f11437f;
    }

    public final PurchaseManager v() {
        return this.f11435d;
    }

    public final SubscriptionRepository w() {
        return this.f11438g;
    }

    public final LiveData<ViewState> x() {
        return this.f11445n;
    }

    public final boolean y() {
        Boolean f10 = this.f11442k.f();
        if (f10 == null) {
            return false;
        }
        return f10.booleanValue();
    }

    public final boolean z() {
        return o() > 0 || l() > ((long) n());
    }
}
