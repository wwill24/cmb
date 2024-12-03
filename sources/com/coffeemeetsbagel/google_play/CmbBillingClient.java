package com.coffeemeetsbagel.google_play;

import android.app.Activity;
import android.content.Context;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.android.billingclient.api.e;
import com.android.billingclient.api.g;
import com.android.billingclient.api.h;
import com.android.billingclient.api.i;
import com.android.billingclient.api.o;
import com.android.billingclient.api.s;
import com.android.billingclient.api.t;
import com.android.billingclient.api.u;
import com.android.billingclient.api.v;
import com.mparticle.identity.IdentityHttpResponse;
import fa.a;
import gk.f;
import io.reactivex.subjects.PublishSubject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.mam.element.MamElements;
import qj.c;
import qj.q;
import qj.w;
import qj.y;

public final class CmbBillingClient {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final int f13907a = 3;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f13908b = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f13909c = CmbBillingClient.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final s f13910d = new l(this);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final PublishSubject<Pair<i, List<Purchase>>> f13911e;

    /* renamed from: f  reason: collision with root package name */
    private final f f13912f;

    public static final class a implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CmbBillingClient f13913a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f13914b;

        a(CmbBillingClient cmbBillingClient, c cVar) {
            this.f13913a = cmbBillingClient;
            this.f13914b = cVar;
        }

        public void a(i iVar) {
            Throwable th2;
            j.g(iVar, MamElements.MamResultExtension.ELEMENT);
            if (iVar.b() == 0) {
                this.f13913a.f13908b.set(0);
                this.f13914b.onComplete();
                return;
            }
            CmbBillingClient cmbBillingClient = this.f13913a;
            String str = '[' + iVar.b() + "] " + iVar.a();
            switch (iVar.b()) {
                case -3:
                    String a10 = iVar.a();
                    j.f(a10, "debugMessage");
                    th2 = new BillingServiceTimeout(a10, cmbBillingClient.f13908b.get());
                    break;
                case -2:
                    th2 = new BillingFeatureNotSupported(str);
                    break;
                case -1:
                    th2 = new BillingServiceDisconnected(str);
                    break;
                case 1:
                    th2 = new BillingUserCancelled(str);
                    break;
                case 2:
                    th2 = new BillingServiceUnavailable(str);
                    break;
                case 3:
                    th2 = new BillingUnavailable(str);
                    break;
                case 4:
                    th2 = new BillingItemUnavailable(str);
                    break;
                case 5:
                    th2 = new BillingDeveloperError(str);
                    break;
                case 7:
                    th2 = new BillingItemAlreadyOwned(str);
                    break;
                case 8:
                    th2 = new BillingItemNotOwned(str);
                    break;
                default:
                    th2 = new BillingError(str);
                    break;
            }
            a.C0491a aVar = fa.a.f40771d;
            String w10 = this.f13913a.f13909c;
            j.f(w10, "tag");
            aVar.c(w10, "Retry #" + this.f13913a.f13908b.get() + " failed.", th2);
            this.f13914b.onError(th2);
        }

        public void b() {
            a.C0491a aVar = fa.a.f40771d;
            String w10 = this.f13913a.f13909c;
            j.f(w10, "tag");
            aVar.a(w10, "BillingClient service disconnected.");
            this.f13914b.onComplete();
        }
    }

    public CmbBillingClient(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        PublishSubject<Pair<i, List<Purchase>>> C0 = PublishSubject.C0();
        j.f(C0, "create()");
        this.f13911e = C0;
        this.f13912f = b.b(new CmbBillingClient$billingClient$2(context, this));
        fa.a.f40771d.i("play_services_version", String.valueOf(com.google.android.gms.common.c.f38865d));
    }

    /* access modifiers changed from: private */
    public static final qj.f B(CmbBillingClient cmbBillingClient) {
        j.g(cmbBillingClient, "this$0");
        return cmbBillingClient.a0();
    }

    /* access modifiers changed from: private */
    public static final rn.a C(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (rn.a) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void E(CmbBillingClient cmbBillingClient, com.android.billingclient.api.j jVar, c cVar) {
        j.g(cmbBillingClient, "this$0");
        j.g(jVar, "$params");
        j.g(cVar, "emitter");
        cmbBillingClient.G().b(jVar, new a(cmbBillingClient, cVar));
    }

    /* access modifiers changed from: private */
    public static final void F(CmbBillingClient cmbBillingClient, c cVar, i iVar, String str) {
        Throwable th2;
        j.g(cmbBillingClient, "this$0");
        j.g(cVar, "$emitter");
        j.g(iVar, "billingResult");
        j.g(str, "<anonymous parameter 1>");
        if (cmbBillingClient.I(iVar)) {
            String str2 = '[' + iVar.b() + "] " + iVar.a();
            switch (iVar.b()) {
                case -3:
                    String a10 = iVar.a();
                    j.f(a10, "debugMessage");
                    th2 = new BillingServiceTimeout(a10, cmbBillingClient.f13908b.get());
                    break;
                case -2:
                    th2 = new BillingFeatureNotSupported(str2);
                    break;
                case -1:
                    th2 = new BillingServiceDisconnected(str2);
                    break;
                case 1:
                    th2 = new BillingUserCancelled(str2);
                    break;
                case 2:
                    th2 = new BillingServiceUnavailable(str2);
                    break;
                case 3:
                    th2 = new BillingUnavailable(str2);
                    break;
                case 4:
                    th2 = new BillingItemUnavailable(str2);
                    break;
                case 5:
                    th2 = new BillingDeveloperError(str2);
                    break;
                case 7:
                    th2 = new BillingItemAlreadyOwned(str2);
                    break;
                case 8:
                    th2 = new BillingItemNotOwned(str2);
                    break;
                default:
                    th2 = new BillingError(str2);
                    break;
            }
            cVar.onError(th2);
            return;
        }
        cVar.onComplete();
    }

    private final e G() {
        return (e) this.f13912f.getValue();
    }

    private final h H(o oVar, String str, String str2) {
        boolean z10;
        o.d dVar;
        String a10;
        h.a a11 = h.a();
        j.f(a11, "newBuilder()");
        if (str.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            h.c.a a12 = h.c.a();
            j.f(a12, "newBuilder()");
            a12.b(str);
            a12.e(2);
            a11.e(a12.a());
        }
        h.b.a c10 = h.b.a().c(oVar);
        j.f(c10, "newBuilder().setProductDetails(skuDetails)");
        List<o.d> d10 = oVar.d();
        if (!(d10 == null || (dVar = (o.d) CollectionsKt___CollectionsKt.N(d10)) == null || (a10 = dVar.a()) == null)) {
            c10.b(a10);
        }
        a11.d(p.e(c10.a()));
        a11.b(str2);
        a11.c(str2);
        h a13 = a11.a();
        j.f(a13, "builder.build()");
        return a13;
    }

    private final boolean I(i iVar) {
        return iVar.b() != 0;
    }

    /* access modifiers changed from: private */
    public static final boolean K(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final String L(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (String) function1.invoke(obj);
    }

    public static /* synthetic */ w N(CmbBillingClient cmbBillingClient, Activity activity, o oVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str = "";
        }
        return cmbBillingClient.M(activity, oVar, str, str2);
    }

    /* access modifiers changed from: private */
    public static final void O(CmbBillingClient cmbBillingClient, Activity activity, h hVar, y yVar) {
        Throwable th2;
        j.g(cmbBillingClient, "this$0");
        j.g(activity, "$activity");
        j.g(hVar, "$billingParams");
        j.g(yVar, "emitter");
        i e10 = cmbBillingClient.G().e(activity, hVar);
        j.f(e10, "billingClient.launchBill…(activity, billingParams)");
        if (cmbBillingClient.I(e10)) {
            String str = '[' + e10.b() + "] " + e10.a();
            switch (e10.b()) {
                case -3:
                    String a10 = e10.a();
                    j.f(a10, "debugMessage");
                    th2 = new BillingServiceTimeout(a10, cmbBillingClient.f13908b.get());
                    break;
                case -2:
                    th2 = new BillingFeatureNotSupported(str);
                    break;
                case -1:
                    th2 = new BillingServiceDisconnected(str);
                    break;
                case 1:
                    th2 = new BillingUserCancelled(str);
                    break;
                case 2:
                    th2 = new BillingServiceUnavailable(str);
                    break;
                case 3:
                    th2 = new BillingUnavailable(str);
                    break;
                case 4:
                    th2 = new BillingItemUnavailable(str);
                    break;
                case 5:
                    th2 = new BillingDeveloperError(str);
                    break;
                case 7:
                    th2 = new BillingItemAlreadyOwned(str);
                    break;
                case 8:
                    th2 = new BillingItemNotOwned(str);
                    break;
                default:
                    th2 = new BillingError(str);
                    break;
            }
            yVar.onError(th2);
            return;
        }
        yVar.onSuccess(e10);
    }

    /* access modifiers changed from: private */
    public static final Purchase P(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Purchase) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void Q(CmbBillingClient cmbBillingClient, i iVar, List list) {
        ArrayList arrayList;
        j.g(cmbBillingClient, "this$0");
        j.g(iVar, "billingResult");
        a.C0491a aVar = fa.a.f40771d;
        String str = cmbBillingClient.f13909c;
        j.f(str, "tag");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Got an update for: ");
        if (list != null) {
            arrayList = new ArrayList(r.t(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((Purchase) it.next()).b());
            }
        } else {
            arrayList = null;
        }
        sb2.append(arrayList);
        aVar.a(str, sb2.toString());
        cmbBillingClient.f13911e.d(new Pair(iVar, list));
    }

    /* access modifiers changed from: private */
    public static final void S(List list, CmbBillingClient cmbBillingClient, String str, y yVar) {
        j.g(list, "$skuList");
        j.g(cmbBillingClient, "this$0");
        j.g(str, "$skuType");
        j.g(yVar, "emitter");
        if (list.isEmpty()) {
            yVar.onSuccess(q.j());
            return;
        }
        e eVar = new e(cmbBillingClient, yVar);
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(t.b.a().b((String) it.next()).c(str).a());
        }
        t a10 = t.a().b(arrayList).a();
        j.f(a10, "newBuilder().setProductList(products).build()");
        cmbBillingClient.G().g(a10, eVar);
    }

    /* access modifiers changed from: private */
    public static final void T(CmbBillingClient cmbBillingClient, y yVar, i iVar, List list) {
        j.g(cmbBillingClient, "this$0");
        j.g(yVar, "$emitter");
        j.g(iVar, MamElements.MamResultExtension.ELEMENT);
        j.g(list, "list");
        if (cmbBillingClient.I(iVar)) {
            yVar.onError(new IOException(iVar.a() + ", code: " + iVar.b()));
            return;
        }
        yVar.onSuccess(list);
    }

    /* access modifiers changed from: private */
    public static final void V(CmbBillingClient cmbBillingClient, y yVar) {
        j.g(cmbBillingClient, "this$0");
        j.g(yVar, "emitter");
        k kVar = new k(cmbBillingClient, yVar);
        u a10 = u.a().b("subs").a();
        j.f(a10, "newBuilder()\n           …\n                .build()");
        cmbBillingClient.G().h(a10, kVar);
    }

    /* access modifiers changed from: private */
    public static final void W(CmbBillingClient cmbBillingClient, y yVar, i iVar, List list) {
        j.g(cmbBillingClient, "this$0");
        j.g(yVar, "$emitter");
        j.g(iVar, MamElements.MamResultExtension.ELEMENT);
        if (cmbBillingClient.I(iVar)) {
            yVar.onError(new IOException(iVar.a() + ", code: " + iVar.b()));
        } else if (list == null) {
            yVar.onSuccess(q.j());
        } else {
            yVar.onSuccess(list);
        }
    }

    /* access modifiers changed from: private */
    public static final void Y(String str, CmbBillingClient cmbBillingClient, y yVar) {
        j.g(str, "$type");
        j.g(cmbBillingClient, "this$0");
        j.g(yVar, "emitter");
        h hVar = new h(cmbBillingClient, yVar);
        v a10 = v.a().b(str).a();
        j.f(a10, "newBuilder().setProductType(type).build()");
        cmbBillingClient.G().i(a10, hVar);
    }

    /* access modifiers changed from: private */
    public static final void Z(CmbBillingClient cmbBillingClient, y yVar, i iVar, List list) {
        j.g(cmbBillingClient, "this$0");
        j.g(yVar, "$emitter");
        j.g(iVar, MamElements.MamResultExtension.ELEMENT);
        j.g(list, "list");
        if (cmbBillingClient.I(iVar)) {
            yVar.onError(new IOException(iVar.a() + ", code: " + iVar.b()));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (!((Purchase) next).g()) {
                arrayList.add(next);
            }
        }
        yVar.onSuccess(arrayList);
    }

    private final qj.a a0() {
        if (G().d()) {
            a.C0491a aVar = fa.a.f40771d;
            String str = this.f13909c;
            j.f(str, "tag");
            aVar.a(str, "Already connected.");
            qj.a m10 = qj.a.m();
            j.f(m10, "complete()");
            return m10;
        } else if (G().c() != 1) {
            qj.a n10 = qj.a.n(new g(this));
            j.f(n10, "create { emitter ->\n    …stener)\n                }");
            return n10;
        } else {
            a.C0491a aVar2 = fa.a.f40771d;
            String str2 = this.f13909c;
            j.f(str2, "tag");
            aVar2.a(str2, "Already connecting.");
            throw new Throwable("Already connecting.");
        }
    }

    /* access modifiers changed from: private */
    public static final void b0(CmbBillingClient cmbBillingClient, c cVar) {
        j.g(cmbBillingClient, "this$0");
        j.g(cVar, "emitter");
        a aVar = new a(cmbBillingClient, cVar);
        a.C0491a aVar2 = fa.a.f40771d;
        String str = cmbBillingClient.f13909c;
        j.f(str, "tag");
        aVar2.a(str, "Initiating connection.");
        cmbBillingClient.G().j(aVar);
    }

    /* access modifiers changed from: private */
    public static final void y(CmbBillingClient cmbBillingClient, com.android.billingclient.api.a aVar, c cVar) {
        j.g(cmbBillingClient, "this$0");
        j.g(aVar, "$params");
        j.g(cVar, "emitter");
        cmbBillingClient.G().a(aVar, new r(cmbBillingClient, cVar));
    }

    /* access modifiers changed from: private */
    public static final void z(CmbBillingClient cmbBillingClient, c cVar, i iVar) {
        Throwable th2;
        j.g(cmbBillingClient, "this$0");
        j.g(cVar, "$emitter");
        j.g(iVar, "billingResult");
        if (cmbBillingClient.I(iVar)) {
            String str = '[' + iVar.b() + "] " + iVar.a();
            switch (iVar.b()) {
                case -3:
                    String a10 = iVar.a();
                    j.f(a10, "debugMessage");
                    th2 = new BillingServiceTimeout(a10, cmbBillingClient.f13908b.get());
                    break;
                case -2:
                    th2 = new BillingFeatureNotSupported(str);
                    break;
                case -1:
                    th2 = new BillingServiceDisconnected(str);
                    break;
                case 1:
                    th2 = new BillingUserCancelled(str);
                    break;
                case 2:
                    th2 = new BillingServiceUnavailable(str);
                    break;
                case 3:
                    th2 = new BillingUnavailable(str);
                    break;
                case 4:
                    th2 = new BillingItemUnavailable(str);
                    break;
                case 5:
                    th2 = new BillingDeveloperError(str);
                    break;
                case 7:
                    th2 = new BillingItemAlreadyOwned(str);
                    break;
                case 8:
                    th2 = new BillingItemNotOwned(str);
                    break;
                default:
                    th2 = new BillingError(str);
                    break;
            }
            cVar.onError(th2);
            return;
        }
        cVar.onComplete();
    }

    public final qj.a A() {
        qj.a F = qj.a.o(new n(this)).D(new o(new CmbBillingClient$connect$2(this))).F(dk.a.c());
        j.f(F, "fun connect(): Completab…On(Schedulers.io())\n    }");
        return F;
    }

    public final qj.a D(Purchase purchase) {
        j.g(purchase, "purchase");
        com.android.billingclient.api.j a10 = com.android.billingclient.api.j.b().b(purchase.d()).a();
        j.f(a10, "newBuilder()\n           …\n                .build()");
        qj.a n10 = qj.a.n(new i(this, a10));
        j.f(n10, "create { emitter ->\n    …rams, listener)\n        }");
        return n10;
    }

    public final q<String> J() {
        q<R> P = this.f13911e.B(new c(CmbBillingClient$observeSubscriptions$1.f13916a)).W(new d(CmbBillingClient$observeSubscriptions$2.f13917a)).P();
        j.f(P, "purchaseUpdateStream\n   … */ }\n            .hide()");
        return P;
    }

    public final w<Purchase> M(Activity activity, o oVar, String str, String str2) {
        j.g(activity, "activity");
        j.g(oVar, "productDetails");
        j.g(str, "activePurchaseToken");
        j.g(str2, "purchasePayload");
        w k10 = w.k(new p(this, activity, H(oVar, str, str2)));
        j.f(k10, "create { emitter ->\n    …)\n            }\n        }");
        w<Purchase> D = A().c(k10).D(new q(new CmbBillingClient$purchase$1(this, oVar)));
        j.f(D, "fun purchase(\n        ac…)\n                }\n    }");
        return D;
    }

    public final w<List<o>> R(List<String> list, String str) {
        j.g(list, "skuList");
        j.g(str, "skuType");
        w k10 = w.k(new b(list, this, str));
        j.f(k10, "create { emitter ->\n    …)\n            }\n        }");
        w<List<o>> c10 = A().c(k10);
        j.f(c10, "connect().andThen(query)");
        return c10;
    }

    public final w<List<PurchaseHistoryRecord>> U() {
        w k10 = w.k(new j(this));
        j.f(k10, "create { emitter ->\n    …rams, listener)\n        }");
        w<List<PurchaseHistoryRecord>> K = A().c(k10).K(dk.a.c());
        j.f(K, "connect().andThen(query)…scribeOn(Schedulers.io())");
        return K;
    }

    public final w<List<Purchase>> X(String str) {
        j.g(str, "type");
        w k10 = w.k(new f(str, this));
        j.f(k10, "create { emitter ->\n    …rams, listener)\n        }");
        w<List<Purchase>> K = A().c(k10).K(dk.a.c());
        j.f(K, "connect().andThen(query)…scribeOn(Schedulers.io())");
        return K;
    }

    public final qj.a x(Purchase purchase) {
        j.g(purchase, "purchase");
        com.android.billingclient.api.a a10 = com.android.billingclient.api.a.b().b(purchase.d()).a();
        j.f(a10, "newBuilder()\n           …\n                .build()");
        qj.a n10 = qj.a.n(new m(this, a10));
        j.f(n10, "create { emitter ->\n    …rams, listener)\n        }");
        return n10;
    }
}
