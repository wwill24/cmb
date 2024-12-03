package com.coffeemeetsbagel.domain.repository;

import android.app.Activity;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.o;
import com.coffeemeetsbagel.google_play.CmbBillingClient;
import hb.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.a;
import qj.b0;
import qj.w;

public final class SkuDetailsRepository {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final CmbBillingClient f12422a;

    /* renamed from: b  reason: collision with root package name */
    private final UserRepository f12423b;

    /* renamed from: c  reason: collision with root package name */
    private final c f12424c;

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f12425d = q.m("com.coffeemeetsbagel.beanpack.small", "com.coffeemeetsbagel.beanpack.medium", "com.coffeemeetsbagel.beanpack.large");
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, o> f12426e = new HashMap<>();

    public SkuDetailsRepository(CmbBillingClient cmbBillingClient, UserRepository userRepository, c cVar) {
        j.g(cmbBillingClient, "billingClient");
        j.g(userRepository, "userRepository");
        j.g(cVar, "sharedPrefsMan");
        this.f12422a = cmbBillingClient;
        this.f12423b = userRepository;
        this.f12424c = cVar;
    }

    /* access modifiers changed from: private */
    public final String h() {
        String str;
        if (this.f12424c.p("is_set_to_baking")) {
            str = "staging";
        } else {
            str = "production";
        }
        return this.f12423b.l() + ':' + str;
    }

    /* access modifiers changed from: private */
    public static final Map j(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Map) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final o l(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (o) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 n(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    public final a g(Purchase purchase) {
        j.g(purchase, "purchase");
        if (!purchase.g()) {
            return this.f12422a.D(purchase);
        }
        a m10 = a.m();
        j.f(m10, "{\n            Completable.complete()\n        }");
        return m10;
    }

    public final w<Map<String, o>> i() {
        if (this.f12426e.size() == this.f12425d.size()) {
            w<Map<String, o>> C = w.C(this.f12426e);
            j.f(C, "just(skuDetailsCache)");
            return C;
        }
        w<R> D = this.f12422a.R(this.f12425d, "inapp").D(new p0(new SkuDetailsRepository$getBeanPackSkuDetails$1(this)));
        j.f(D, "fun getBeanPackSkuDetail…        }\n        }\n    }");
        return D;
    }

    public final w<o> k(String str) {
        j.g(str, "sku");
        if (this.f12426e.containsKey(str)) {
            w<o> C = w.C(this.f12426e.get(str));
            j.f(C, "{\n            Single.jus…ailsCache[sku])\n        }");
            return C;
        }
        w<R> D = this.f12422a.R(p.e(str), "inapp").D(new o0(new SkuDetailsRepository$getSkuDetails$1(str)));
        j.f(D, "sku: String) : Single<Pr…              }\n        }");
        return D;
    }

    public final w<Purchase> m(Activity activity, String str) {
        j.g(activity, "activity");
        j.g(str, "sku");
        w<R> v10 = k(str).v(new q0(new SkuDetailsRepository$purchaseSku$1(this, activity)));
        j.f(v10, "fun purchaseSku(activity…ad())\n            }\n    }");
        return v10;
    }
}
