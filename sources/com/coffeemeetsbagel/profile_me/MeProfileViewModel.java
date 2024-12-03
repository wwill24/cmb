package com.coffeemeetsbagel.profile_me;

import a7.a;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import androidx.lifecycle.r;
import androidx.lifecycle.t;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.photo.Photo;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.profile.l;
import fa.a;
import ja.b;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.x0;
import wb.c;

public final class MeProfileViewModel extends f0 {

    /* renamed from: d  reason: collision with root package name */
    private PurchaseManager f36166d;

    /* renamed from: e  reason: collision with root package name */
    private a f36167e;

    /* renamed from: f  reason: collision with root package name */
    private GetMyOwnProfileLocalUseCase f36168f;

    /* renamed from: g  reason: collision with root package name */
    private c f36169g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final String f36170h = "MeProfileViewModel";
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public Price f36171i;

    /* renamed from: j  reason: collision with root package name */
    private final t<Boolean> f36172j = new t<>(Boolean.FALSE);
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final r<UpsellViewState> f36173k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final t<b> f36174l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final t<List<Photo>> f36175m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final t<l> f36176n;

    /* renamed from: o  reason: collision with root package name */
    private final LiveData<UpsellViewState> f36177o;

    /* renamed from: p  reason: collision with root package name */
    private final LiveData<b> f36178p;

    /* renamed from: q  reason: collision with root package name */
    private final LiveData<l> f36179q;

    /* renamed from: r  reason: collision with root package name */
    private final LiveData<List<Photo>> f36180r;

    /* renamed from: s  reason: collision with root package name */
    private final t<Integer> f36181s;

    public enum UpsellViewState {
        BOOST_AVAILABLE,
        BOOST_ACTIVE,
        NONE
    }

    public MeProfileViewModel(PurchaseManager purchaseManager, a aVar, GetMyOwnProfileLocalUseCase getMyOwnProfileLocalUseCase, c cVar) {
        j.g(purchaseManager, "purchaseManager");
        j.g(aVar, "analyticsManager");
        j.g(getMyOwnProfileLocalUseCase, "getMyOwnProfileLocalUseCase");
        j.g(cVar, "getActiveSubscriptionUseCase");
        this.f36166d = purchaseManager;
        this.f36167e = aVar;
        this.f36168f = getMyOwnProfileLocalUseCase;
        this.f36169g = cVar;
        r<UpsellViewState> rVar = new r<>(UpsellViewState.NONE);
        this.f36173k = rVar;
        t<b> tVar = new t<>();
        this.f36174l = tVar;
        t<List<Photo>> tVar2 = new t<>();
        this.f36175m = tVar2;
        t<l> tVar3 = new t<>();
        this.f36176n = tVar3;
        this.f36177o = rVar;
        this.f36178p = tVar;
        this.f36179q = tVar3;
        this.f36180r = tVar2;
        this.f36181s = new t<>(-1);
    }

    public final a m() {
        return this.f36167e;
    }

    public final Price n() {
        return this.f36171i;
    }

    public final GetMyOwnProfileLocalUseCase o() {
        return this.f36168f;
    }

    public final PurchaseManager p() {
        return this.f36166d;
    }

    public final LiveData<UpsellViewState> q() {
        return this.f36177o;
    }

    public final LiveData<List<Photo>> r() {
        return this.f36180r;
    }

    public final LiveData<l> s() {
        return this.f36179q;
    }

    public final LiveData<b> t() {
        return this.f36178p;
    }

    public final void u() {
        a.C0491a aVar = fa.a.f40771d;
        aVar.a(this.f36170h, "didBecomeActive() -->");
        s1 unused = j.d(g0.a(this), x0.b(), (CoroutineStart) null, new MeProfileViewModel$onTabSelected$1(this, (kotlin.coroutines.c<? super MeProfileViewModel$onTabSelected$1>) null), 2, (Object) null);
        aVar.a(this.f36170h, "<--didBecomeActive()");
    }

    public final void v() {
        fa.a.f40771d.a(this.f36170h, "willResignActive()");
        this.f36181s.m(-1);
    }
}
