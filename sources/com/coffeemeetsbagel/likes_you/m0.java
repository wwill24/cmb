package com.coffeemeetsbagel.likes_you;

import a7.a;
import androidx.lifecycle.f0;
import androidx.lifecycle.i0;
import com.coffeemeetsbagel.domain.repository.LikesYouMatchRepository;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import kotlin.jvm.internal.j;

public final class m0 implements i0.b {

    /* renamed from: b  reason: collision with root package name */
    private final a f34237b;

    /* renamed from: c  reason: collision with root package name */
    private final a6.a f34238c;

    /* renamed from: d  reason: collision with root package name */
    private final l5.a f34239d;

    /* renamed from: e  reason: collision with root package name */
    private final bb.a f34240e;

    /* renamed from: f  reason: collision with root package name */
    private final LikesYouMatchRepository f34241f;

    /* renamed from: g  reason: collision with root package name */
    private final FeatureFlagRepository f34242g;

    public m0(a aVar, a6.a aVar2, l5.a aVar3, bb.a aVar4, LikesYouMatchRepository likesYouMatchRepository, FeatureFlagRepository featureFlagRepository) {
        j.g(aVar, "analyticsManager");
        j.g(aVar2, "coachmarkManager");
        j.g(aVar3, "capabilityUseCase");
        j.g(aVar4, "stringProvider");
        j.g(likesYouMatchRepository, "likesYouMatchRepository");
        j.g(featureFlagRepository, "featureManager");
        this.f34237b = aVar;
        this.f34238c = aVar2;
        this.f34239d = aVar3;
        this.f34240e = aVar4;
        this.f34241f = likesYouMatchRepository;
        this.f34242g = featureFlagRepository;
    }

    public <T extends f0> T a(Class<T> cls) {
        j.g(cls, "modelClass");
        return new LikesYouViewModel(this.f34237b, this.f34238c, this.f34239d, this.f34240e, this.f34241f, this.f34242g);
    }
}
