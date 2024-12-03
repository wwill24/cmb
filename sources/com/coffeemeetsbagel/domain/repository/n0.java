package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.ProfileDtoImplementation;
import java.util.concurrent.Callable;

public final /* synthetic */ class n0 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfileRepository f12547a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProfileDtoImplementation f12548b;

    public /* synthetic */ n0(ProfileRepository profileRepository, ProfileDtoImplementation profileDtoImplementation) {
        this.f12547a = profileRepository;
        this.f12548b = profileDtoImplementation;
    }

    public final Object call() {
        return ProfileRepository$saveGender$1.d(this.f12547a, this.f12548b);
    }
}
