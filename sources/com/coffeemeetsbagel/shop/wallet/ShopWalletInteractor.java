package com.coffeemeetsbagel.shop.wallet;

import b6.d;
import b6.s;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.uber.autodispose.p;
import fa.a;
import java.util.ArrayList;
import java.util.List;
import k9.b;
import k9.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.json.JSONException;

public final class ShopWalletInteractor extends s<j, l> {

    /* renamed from: l  reason: collision with root package name */
    public static final a f36630l = new a((DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    public kb.a f36631f;

    /* renamed from: g  reason: collision with root package name */
    public PurchaseManager f36632g;

    /* renamed from: h  reason: collision with root package name */
    public b f36633h;

    /* renamed from: j  reason: collision with root package name */
    public d<?, ?> f36634j;

    /* renamed from: k  reason: collision with root package name */
    public s9.a f36635k;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void L1(org.json.b bVar, Price price) {
        try {
            bVar.put(price.getName(), price.getFreeItemCount());
        } catch (JSONException e10) {
            a.C0491a aVar = fa.a.f40771d;
            String message = e10.getMessage();
            aVar.f(new JSONException("#walletPresenter json exception during put " + message));
        }
    }

    private final List<c> M1(List<Price> list, List<Price> list2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c.C0166c(((j) this.f7875e).j(R.string.my_items)));
        if (list.isEmpty()) {
            arrayList.add(new c.b(((j) this.f7875e).j(R.string.you_have_no_items)));
        } else {
            for (Price dVar : list) {
                arrayList.add(new c.d(dVar));
            }
        }
        for (Price eVar : list2) {
            arrayList.add(new c.e(eVar));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static final List N1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void O1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final String P1(String str) {
        switch (str.hashCode()) {
            case -1603665899:
                if (str.equals("ReopenChat")) {
                    String b10 = PurchaseType.REOPEN_CHAT.b();
                    j.f(b10, "REOPEN_CHAT.displayName");
                    return b10;
                }
                break;
            case -419161864:
                if (str.equals("InstantLike")) {
                    String b11 = PurchaseType.INSTANT_LIKE.b();
                    j.f(b11, "INSTANT_LIKE.displayName");
                    return b11;
                }
                break;
            case 87159:
                if (str.equals("Woo")) {
                    String b12 = PurchaseType.WOO.b();
                    j.f(b12, "WOO.displayName");
                    return b12;
                }
                break;
            case 2599079:
                if (str.equals("Take")) {
                    String b13 = PurchaseType.DISCOVER_LIKES.b();
                    j.f(b13, "DISCOVER_LIKES.displayName");
                    return b13;
                }
                break;
            case 64369539:
                if (str.equals("Boost")) {
                    String b14 = PurchaseType.BOOST.b();
                    j.f(b14, "BOOST.displayName");
                    return b14;
                }
                break;
            case 980198563:
                if (str.equals("PaidLike")) {
                    String b15 = PurchaseType.PAID_LIKE.b();
                    j.f(b15, "PAID_LIKE.displayName");
                    return b15;
                }
                break;
        }
        return "";
    }

    private final void T1(List<Price> list, List<Price> list2, List<Price> list3) {
        org.json.b bVar = new org.json.b();
        for (Price next : list) {
            if (S1().a(next)) {
                next.setDisplayName(P1(next.getName()));
                if (next.getFreeItemCount() > 0 || next.isUnlimited()) {
                    list2.add(next);
                } else if (!j.b("na", next.getImageUrl()) && !j.b("na", next.getTintColor())) {
                    list3.add(next);
                }
                L1(bVar, next);
            }
        }
        Q1().a(bVar);
        u.v(list2);
        u.v(list3);
    }

    /* access modifiers changed from: private */
    public final List<c> U1(List<Price> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        T1(list, arrayList, arrayList2);
        return M1(arrayList, arrayList2);
    }

    public final kb.a Q1() {
        kb.a aVar = this.f36631f;
        if (aVar != null) {
            return aVar;
        }
        j.y("lastInventoryCacheListener");
        return null;
    }

    public final PurchaseManager R1() {
        PurchaseManager purchaseManager = this.f36632g;
        if (purchaseManager != null) {
            return purchaseManager;
        }
        j.y("purchaseManager");
        return null;
    }

    public final b S1() {
        b bVar = this.f36633h;
        if (bVar != null) {
            return bVar;
        }
        j.y("walletPriceDisplayValidator");
        return null;
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ((p) R1().priceCache().W(new g(ShopWalletInteractor$didBecomeActive$1.f36636a)).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new h(new ShopWalletInteractor$didBecomeActive$2(this)));
    }
}
