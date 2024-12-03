package com.coffeemeetsbagel.store;

import java.util.List;
import vj.a;

public final /* synthetic */ class c0 implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PriceRepository f36781a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f36782b;

    public /* synthetic */ c0(PriceRepository priceRepository, List list) {
        this.f36781a = priceRepository;
        this.f36782b = list;
    }

    public final void run() {
        PriceRepository.q(this.f36781a, this.f36782b);
    }
}
