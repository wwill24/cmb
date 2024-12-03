package com.coffeemeetsbagel.store.premium_upsell;

import com.coffeemeetsbagel.store.GetSubscriptionBundlesUseCase;
import com.coffeemeetsbagel.store.PurchaseSource;
import fa.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import vb.c;

final class PremiumUpsellInteractor$didBecomeActive$1 extends Lambda implements Function1<GetSubscriptionBundlesUseCase.a, Unit> {
    final /* synthetic */ PremiumUpsellInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PremiumUpsellInteractor$didBecomeActive$1(PremiumUpsellInteractor premiumUpsellInteractor) {
        super(1);
        this.this$0 = premiumUpsellInteractor;
    }

    public final void a(GetSubscriptionBundlesUseCase.a aVar) {
        int i10;
        boolean z10;
        a.f40771d.a(this.this$0.f36850j, "getSubscriptionBundlesUseCase");
        this.this$0.f36857t = aVar.b().g();
        this.this$0.f36858w = aVar.a().g();
        vb.a J1 = this.this$0.f36857t;
        if (J1 != null) {
            i10 = J1.g();
        } else {
            i10 = -1;
        }
        PremiumUpsellInteractor premiumUpsellInteractor = this.this$0;
        List<c> c10 = aVar.c();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = c10.iterator();
        while (true) {
            z10 = false;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            c cVar = (c) next;
            if (i10 == -1 || cVar.i() < i10) {
                z10 = true;
            }
            if (z10) {
                arrayList.add(next);
            }
        }
        premiumUpsellInteractor.f36855p = premiumUpsellInteractor.Z1(arrayList);
        List L1 = this.this$0.f36855p;
        List list = null;
        if (L1 == null) {
            j.y("availableSubscriptions");
            L1 = null;
        }
        if (L1.size() >= 2 && (this.this$0.a2().a("MPUBenefitsScreenAndroid.Skip.Android") || this.this$0.a2().a("MPUS1.Remove.Android"))) {
            z10 = true;
        }
        if (z10) {
            PremiumUpsellRouter premiumUpsellRouter = (PremiumUpsellRouter) this.this$0.B1();
            PurchaseSource O1 = this.this$0.f36847f;
            List L12 = this.this$0.f36855p;
            if (L12 == null) {
                j.y("availableSubscriptions");
            } else {
                list = L12;
            }
            premiumUpsellRouter.s(O1, list, this.this$0.f36856q, this.this$0.Y1());
            return;
        }
        List L13 = this.this$0.f36855p;
        if (L13 == null) {
            j.y("availableSubscriptions");
        } else {
            list = L13;
        }
        c cVar2 = (c) CollectionsKt___CollectionsKt.Y(list);
        if (this.this$0.a2().a("MPUS1.Remove.Android")) {
            this.this$0.h2(cVar2);
        } else {
            ((PremiumUpsellRouter) this.this$0.B1()).t(this.this$0.f36847f, this.this$0.f36856q, cVar2);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((GetSubscriptionBundlesUseCase.a) obj);
        return Unit.f32013a;
    }
}
