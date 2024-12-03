package com.coffeemeetsbagel.store.alc;

import com.google.gson.d;
import com.google.gson.j;
import java.util.concurrent.Callable;

public final /* synthetic */ class g implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f36773a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PurchaseRepository f36774b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f36775c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Class f36776d;

    public /* synthetic */ g(j jVar, PurchaseRepository purchaseRepository, d dVar, Class cls) {
        this.f36773a = jVar;
        this.f36774b = purchaseRepository;
        this.f36775c = dVar;
        this.f36776d = cls;
    }

    public final Object call() {
        return PurchaseRepository$buyItem$1.d(this.f36773a, this.f36774b, this.f36775c, this.f36776d);
    }
}
