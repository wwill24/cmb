package com.coffeemeetsbagel.experiment;

import java.util.concurrent.Callable;

public final /* synthetic */ class f implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeatureFlagRepository f12650a;

    public /* synthetic */ f(FeatureFlagRepository featureFlagRepository) {
        this.f12650a = featureFlagRepository;
    }

    public final Object call() {
        return FeatureFlagRepository.q(this.f12650a);
    }
}
