package com.coffeemeetsbagel.feature.purchase;

import com.coffeemeetsbagel.store.k0;
import java.util.Map;

public final /* synthetic */ class f implements vj.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PurchaseManager f13384a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k0.b f13385b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f13386c;

    public /* synthetic */ f(PurchaseManager purchaseManager, k0.b bVar, Map map) {
        this.f13384a = purchaseManager;
        this.f13385b = bVar;
        this.f13386c = map;
    }

    public final void accept(Object obj) {
        this.f13384a.lambda$buyCmbItem$1(this.f13385b, this.f13386c, (Throwable) obj);
    }
}
