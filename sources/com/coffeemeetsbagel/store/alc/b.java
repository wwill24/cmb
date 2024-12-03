package com.coffeemeetsbagel.store.alc;

import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.store.alc.PurchaseRepository;
import kotlin.jvm.internal.j;
import qj.w;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final PurchaseRepository<Bagel> f36768a;

    public b(PurchaseRepository<Bagel> purchaseRepository) {
        j.g(purchaseRepository, "purchaseRepository");
        this.f36768a = purchaseRepository;
    }

    public static /* synthetic */ w b(b bVar, String str, long j10, int i10, String str2, PurchaseRepository.PurchaseRequestSource purchaseRequestSource, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            purchaseRequestSource = null;
        }
        return bVar.a(str, j10, i10, str2, purchaseRequestSource);
    }

    public final w<Bagel> a(String str, long j10, int i10, String str2, PurchaseRepository.PurchaseRequestSource purchaseRequestSource) {
        j.g(str, "itemName");
        String str3 = str2;
        j.g(str3, "matchId");
        return PurchaseRepository.f(this.f36768a, str, j10, i10, Bagel.class, purchaseRequestSource, str3, (String) null, (String) null, 192, (Object) null);
    }
}
