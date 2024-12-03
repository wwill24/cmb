package com.coffeemeetsbagel.store.alc;

import com.coffeemeetsbagel.store.alc.PurchaseRepository;
import kotlin.jvm.internal.j;
import qj.w;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final PurchaseRepository<Boolean> f36770a;

    public d(PurchaseRepository<Boolean> purchaseRepository) {
        j.g(purchaseRepository, "purchaseRepository");
        this.f36770a = purchaseRepository;
    }

    public static /* synthetic */ w b(d dVar, String str, int i10, int i11, String str2, String str3, PurchaseRepository.PurchaseRequestSource purchaseRequestSource, int i12, Object obj) {
        return dVar.a(str, i10, i11, (i12 & 8) != 0 ? null : str2, (i12 & 16) != 0 ? null : str3, (i12 & 32) != 0 ? null : purchaseRequestSource);
    }

    public final w<Boolean> a(String str, int i10, int i11, String str2, String str3, PurchaseRepository.PurchaseRequestSource purchaseRequestSource) {
        j.g(str, "itemName");
        return PurchaseRepository.f(this.f36770a, str, (long) i10, i11, Boolean.TYPE, purchaseRequestSource, (String) null, str2, str3, 32, (Object) null);
    }
}
