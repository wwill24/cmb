package com.coffeemeetsbagel.feature.purchase;

import com.coffeemeetsbagel.store.k0;
import java.util.Map;
import vj.f;

public final /* synthetic */ class b implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PurchaseManager f13373a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k0.b f13374b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f13375c;

    public /* synthetic */ b(PurchaseManager purchaseManager, k0.b bVar, Map map) {
        this.f13373a = purchaseManager;
        this.f13374b = bVar;
        this.f13375c = map;
    }

    public final void accept(Object obj) {
        this.f13373a.lambda$buyCmbItem$3(this.f13374b, this.f13375c, (Throwable) obj);
    }
}
