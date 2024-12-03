package com.coffeemeetsbagel.domain.repository;

import cb.a;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.dto.Capability;
import com.coffeemeetsbagel.models.entities.CapabilityEntity;
import com.coffeemeetsbagel.models.entities.CapabilityType;
import java.util.List;
import kotlin.jvm.internal.j;
import qj.h;
import qj.w;
import u6.d;

public class m {

    /* renamed from: a  reason: collision with root package name */
    private final d f12539a;

    /* renamed from: b  reason: collision with root package name */
    private final a f12540b;

    public m(d dVar, a aVar) {
        j.g(dVar, "capabilityDao");
        j.g(aVar, "schedulerProvider");
        this.f12539a = dVar;
        this.f12540b = aVar;
    }

    /* access modifiers changed from: private */
    public static final List e(m mVar, CapabilityEntity capabilityEntity, CapabilityEntity capabilityEntity2) {
        j.g(mVar, "this$0");
        j.g(capabilityEntity, "$likesYouCapability");
        j.g(capabilityEntity2, "$premiumPrefsCapability");
        return mVar.f12539a.a(q.m(capabilityEntity, capabilityEntity2));
    }

    public final h<List<Capability>> b() {
        h<List<Capability>> o02 = this.f12539a.f().o0(this.f12540b.c());
        j.f(o02, "capabilityDao.getAllCapa…n(schedulerProvider.io())");
        return o02;
    }

    public final h<Boolean> c(CapabilityType capabilityType) {
        j.g(capabilityType, "capability");
        h<Boolean> o02 = this.f12539a.c(capabilityType).v().o0(this.f12540b.c());
        j.f(o02, "capabilityDao.getCapabil…n(schedulerProvider.io())");
        return o02;
    }

    public final w<List<Long>> d(NetworkProfile networkProfile) {
        j.g(networkProfile, "networkProfile");
        w<List<Long>> K = w.A(new l(this, new CapabilityEntity(CapabilityType.SEE_ALL_LIKES_YOU, networkProfile.hasLimelight()), new CapabilityEntity(CapabilityType.PREMIUM_PREFERENCES, networkProfile.hasPremiumPreferences()))).K(dk.a.c());
        j.f(K, "fromCallable {\n         …scribeOn(Schedulers.io())");
        return K;
    }
}
