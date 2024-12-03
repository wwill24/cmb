package com.coffeemeetsbagel.experiment;

import java.util.concurrent.Callable;

public final /* synthetic */ class k implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeatureFlagRepository f12655a;

    public /* synthetic */ k(FeatureFlagRepository featureFlagRepository) {
        this.f12655a = featureFlagRepository;
    }

    public final Object call() {
        return FeatureFlagRepository.s(this.f12655a);
    }
}
