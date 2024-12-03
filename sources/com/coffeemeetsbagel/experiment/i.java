package com.coffeemeetsbagel.experiment;

import java.util.concurrent.Callable;

public final /* synthetic */ class i implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeatureFlagRepository f12653a;

    public /* synthetic */ i(FeatureFlagRepository featureFlagRepository) {
        this.f12653a = featureFlagRepository;
    }

    public final Object call() {
        return FeatureFlagRepository.F(this.f12653a);
    }
}
