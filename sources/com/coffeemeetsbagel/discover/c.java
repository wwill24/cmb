package com.coffeemeetsbagel.discover;

import com.coffeemeetsbagel.models.responses.ResponseGiveTakes;
import com.coffeemeetsbagel.models.responses.ResponseRisingGiveTakes;
import java.util.concurrent.Callable;

public final /* synthetic */ class c implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiscoverMatchRepository f12171a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ResponseGiveTakes f12172b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ResponseRisingGiveTakes f12173c;

    public /* synthetic */ c(DiscoverMatchRepository discoverMatchRepository, ResponseGiveTakes responseGiveTakes, ResponseRisingGiveTakes responseRisingGiveTakes) {
        this.f12171a = discoverMatchRepository;
        this.f12172b = responseGiveTakes;
        this.f12173c = responseRisingGiveTakes;
    }

    public final Object call() {
        return DiscoverMatchRepository$refresh$2.d(this.f12171a, this.f12172b, this.f12173c);
    }
}
