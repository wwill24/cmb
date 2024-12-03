package com.coffeemeetsbagel.experiment;

import java.util.concurrent.Callable;

public final /* synthetic */ class n implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeatureFlagRepository f12658a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f12659b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f12660c;

    public /* synthetic */ n(FeatureFlagRepository featureFlagRepository, String str, boolean z10) {
        this.f12658a = featureFlagRepository;
        this.f12659b = str;
        this.f12660c = z10;
    }

    public final Object call() {
        return FeatureFlagRepository.C(this.f12658a, this.f12659b, this.f12660c);
    }
}
