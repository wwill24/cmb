package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.dto.ProfileDataContract;
import java.util.concurrent.Callable;

public final /* synthetic */ class m0 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfileRepository f12541a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProfileDataContract f12542b;

    public /* synthetic */ m0(ProfileRepository profileRepository, ProfileDataContract profileDataContract) {
        this.f12541a = profileRepository;
        this.f12542b = profileDataContract;
    }

    public final Object call() {
        return ProfileRepository$saveDeltaAndProfile$1.d(this.f12541a, this.f12542b);
    }
}
