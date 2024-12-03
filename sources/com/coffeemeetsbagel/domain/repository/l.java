package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.entities.CapabilityEntity;
import java.util.concurrent.Callable;

public final /* synthetic */ class l implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m f12533a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CapabilityEntity f12534b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CapabilityEntity f12535c;

    public /* synthetic */ l(m mVar, CapabilityEntity capabilityEntity, CapabilityEntity capabilityEntity2) {
        this.f12533a = mVar;
        this.f12534b = capabilityEntity;
        this.f12535c = capabilityEntity2;
    }

    public final Object call() {
        return m.e(this.f12533a, this.f12534b, this.f12535c);
    }
}
