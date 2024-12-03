package com.coffeemeetsbagel.store;

import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.jakewharton.rxrelay2.b;
import com.uber.autodispose.a;
import com.uber.autodispose.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import qj.f;
import qj.q;
import qj.w;
import u6.j;

public final class PriceRepository {

    /* renamed from: a  reason: collision with root package name */
    private final i0 f36706a;

    /* renamed from: b  reason: collision with root package name */
    private final j f36707b;

    /* renamed from: c  reason: collision with root package name */
    private final AuthenticationScopeProvider f36708c;

    /* renamed from: d  reason: collision with root package name */
    private final String f36709d = "PriceRepository";

    /* renamed from: e  reason: collision with root package name */
    private final List<PurchaseType> f36710e;

    /* renamed from: f  reason: collision with root package name */
    private final List<PurchaseType> f36711f;

    /* renamed from: g  reason: collision with root package name */
    private final b<Map<String, Price>> f36712g;

    /* renamed from: h  reason: collision with root package name */
    private final q<Map<String, Price>> f36713h;

    public PriceRepository(i0 i0Var, j jVar, AuthenticationScopeProvider authenticationScopeProvider) {
        kotlin.jvm.internal.j.g(i0Var, "remote");
        kotlin.jvm.internal.j.g(jVar, "priceDao");
        kotlin.jvm.internal.j.g(authenticationScopeProvider, "authenticationScopeProvider");
        this.f36706a = i0Var;
        this.f36707b = jVar;
        this.f36708c = authenticationScopeProvider;
        this.f36710e = q.m(PurchaseType.BOOST, PurchaseType.BONUS_BAGEL);
        PurchaseType[] values = PurchaseType.values();
        ArrayList<PurchaseType> arrayList = new ArrayList<>();
        for (PurchaseType purchaseType : values) {
            if (!this.f36710e.contains(purchaseType)) {
                arrayList.add(purchaseType);
            }
        }
        this.f36711f = arrayList;
        ArrayList arrayList2 = new ArrayList(r.t(arrayList, 10));
        for (PurchaseType a10 : arrayList) {
            arrayList2.add(g0.a(a10));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(r.t(arrayList2, 10)), 16));
        for (Object next : arrayList2) {
            linkedHashMap.put(((Price) next).getName(), next);
        }
        b<Map<String, Price>> D0 = b.D0(linkedHashMap);
        kotlin.jvm.internal.j.f(D0, "createDefault(hardCodedF….associateBy { it.name })");
        this.f36712g = D0;
        q<Map<String, Price>> P = D0.P();
        kotlin.jvm.internal.j.f(P, "pricesInternal.hide()");
        this.f36713h = P;
        ((t) h().g(a.a(this.f36708c))).d();
    }

    private final w<List<Price>> h() {
        w<R> r10 = this.f36707b.a().D(new e0(PriceRepository$getFromDb$1.f36714a)).K(dk.a.c()).r(new f0(new PriceRepository$getFromDb$2(this)));
        kotlin.jvm.internal.j.f(r10, "private fun getFromDb():…t.name })\n        }\n    }");
        return r10;
    }

    /* access modifiers changed from: private */
    public static final List i(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void j(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final Price k(PurchaseType purchaseType) {
        String d10 = purchaseType.d();
        PurchaseType purchaseType2 = PurchaseType.UNKNOWN;
        if (kotlin.jvm.internal.j.b(d10, purchaseType2.d())) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(purchaseType2.d());
            sb2.append(" encountered, charging user arbitrary ");
            PurchaseType purchaseType3 = PurchaseType.PRICE_ERROR;
            sb2.append((int) purchaseType3.e());
            String sb3 = sb2.toString();
            fa.a.f40771d.c(this.f36709d, sb3, new IllegalStateException(sb3));
            String a10 = purchaseType.a();
            kotlin.jvm.internal.j.f(a10, "purchaseType.analyticsItemName");
            return new Price((int) purchaseType3.e(), 0, false, a10, "", "", (String) null, 64, (DefaultConstructorMarker) null);
        }
        return g0.a(purchaseType);
    }

    /* access modifiers changed from: private */
    public static final f o(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void q(PriceRepository priceRepository, List list) {
        kotlin.jvm.internal.j.g(priceRepository, "this$0");
        kotlin.jvm.internal.j.g(list, "$thePrices");
        j jVar = priceRepository.f36707b;
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Price) it.next()).toRoomEntity());
        }
        jVar.c(arrayList);
    }

    /* access modifiers changed from: private */
    public static final void r(PriceRepository priceRepository, Map map) {
        kotlin.jvm.internal.j.g(priceRepository, "this$0");
        kotlin.jvm.internal.j.g(map, "$map");
        priceRepository.f36712g.accept(map);
    }

    public final void f() {
        this.f36712g.accept(h0.i());
    }

    public final Price g(PurchaseType purchaseType) {
        Price price;
        kotlin.jvm.internal.j.g(purchaseType, "purchaseType");
        String d10 = purchaseType.d();
        Map E0 = this.f36712g.E0();
        if (E0 != null) {
            price = (Price) E0.get(d10);
        } else {
            price = null;
        }
        if (!this.f36710e.contains(purchaseType) && price == null) {
            return k(purchaseType);
        }
        return price;
    }

    public final q<Map<String, Price>> l() {
        return this.f36713h;
    }

    public final b<Map<String, Price>> m() {
        return this.f36712g;
    }

    public final qj.a n() {
        qj.a w10 = this.f36706a.a().K(dk.a.c()).w(new b0(new PriceRepository$refresh$1(this)));
        kotlin.jvm.internal.j.f(w10, "fun refresh(): Completab…)\n                }\n    }");
        return w10;
    }

    public final qj.a p(List<Price> list, Map<String, Price> map) {
        kotlin.jvm.internal.j.g(list, "thePrices");
        kotlin.jvm.internal.j.g(map, "map");
        qj.a b10 = qj.a.w(new c0(this, list)).b(qj.a.w(new d0(this, map)));
        kotlin.jvm.internal.j.f(b10, "fromAction { // step 1 -…ccept(map)\n            })");
        return b10;
    }
}
