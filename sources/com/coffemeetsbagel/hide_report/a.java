package com.coffemeetsbagel.hide_report;

import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import kotlin.jvm.internal.j;
import qj.w;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final ProfileRepository f37665a;

    public a(ProfileRepository profileRepository) {
        j.g(profileRepository, "profileRepository");
        this.f37665a = profileRepository;
    }

    public final w<String> a(String str) {
        j.g(str, "profileId");
        return this.f37665a.e(str, (String) null, (String) null);
    }
}
