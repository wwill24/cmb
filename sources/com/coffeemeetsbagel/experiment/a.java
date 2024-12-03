package com.coffeemeetsbagel.experiment;

import c7.d;
import com.coffeemeetsbagel.bakery.Bakery;
import hb.c;
import kotlin.jvm.internal.j;
import lc.g;

public final class a {
    public final FeatureFlagRepository a(s sVar, c cVar, j7.a aVar) {
        j.g(sVar, "remote");
        j.g(cVar, "sharedPrefs");
        j.g(aVar, "cachePurgeManager");
        return new FeatureFlagRepository(sVar, cVar, aVar, g.c());
    }

    public final r b(Bakery bakery, FeatureFlagRepository featureFlagRepository) {
        j.g(bakery, "bakery");
        j.g(featureFlagRepository, "featureFlagRepository");
        return new r(bakery, featureFlagRepository, false);
    }

    public final s9.a c(r rVar) {
        j.g(rVar, "featureManager");
        return rVar;
    }

    public final s d(d dVar) {
        j.g(dVar, "retrofitManager");
        Object c10 = dVar.c(s.class);
        j.f(c10, "retrofitManager.getApiSe…atureService::class.java)");
        return (s) c10;
    }
}
